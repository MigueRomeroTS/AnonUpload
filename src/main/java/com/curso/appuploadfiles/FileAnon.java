/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.appuploadfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author miromero
 */
public class FileAnon {

    private File file;

    public FileAnon(String path) {
        this.file = new File(path);
    }

    public File getFile() {
        return file;
    }

    public File getZippedFile() throws NoSuchAlgorithmException, IOException {
        
        File zipFile = new File(this.file.getParent()+ "\\newzip.zip");

        String[] srcFiles = {this.file.getPath(), createFileChecksum().getPath()};
        try {

            // create byte buffer
            byte[] buffer = new byte[1024];

            FileOutputStream fos = new FileOutputStream(zipFile);

            ZipOutputStream zos = new ZipOutputStream(fos);

            for (int i = 0; i < srcFiles.length; i++) {

                File srcFile = new File(srcFiles[i]);

                FileInputStream fis = new FileInputStream(srcFile);

                // begin writing a new ZIP entry, positions the stream to the start of the entry data
                zos.putNextEntry(new ZipEntry(srcFile.getName()));

                int length;

                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }

                zos.closeEntry();
                // close the InputStream
                fis.close();
            }
            // close the ZipOutputStream
            zos.close();
            
            return zipFile;

        } catch (IOException ioe) {
            System.out.println("Error creating zip file: " + ioe);
        }
        return null;
    }

    public File createFileChecksum() throws FileNotFoundException, NoSuchAlgorithmException, IOException {
        String checksum;
        try {
            checksum = hashFileString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FileAnon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileAnon.class.getName()).log(Level.SEVERE, null, ex);
        }
        String pathname = file.getAbsoluteFile().getParent();

        try ( PrintWriter out = new PrintWriter(pathname + "\\checksum.txt")) {
            out.print(hashFileString());
        }

        return new File(pathname + "\\checksum.txt");
    }

    public String hashFileString() throws NoSuchAlgorithmException, IOException {
        //Use MD5 algorithm
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");

        //Get the checksum
        String checksum = getFileChecksum(md5Digest, this.file);

        try ( PrintWriter out = new PrintWriter("checksum.txt")) {
            out.println(checksum);
            System.out.println("File created");
        }

        //see checksum
        return checksum;
    }

    private static String getFileChecksum(MessageDigest digest, File file) throws IOException {
        //Get file input stream for reading the file content
        FileInputStream fis = new FileInputStream(file);

        //Create byte array to read data in chunks
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        //Read file data and update in message digest
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };

        //close the stream; We don't need it now.
        fis.close();

        //Get the hash's bytes
        byte[] bytes = digest.digest();

        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        //return complete hash
        return sb.toString();
    }

}
