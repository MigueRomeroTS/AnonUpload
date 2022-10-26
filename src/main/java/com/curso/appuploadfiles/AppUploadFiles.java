/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.curso.appuploadfiles;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miromero
 */
public class AppUploadFiles {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        AnonApi anon = new AnonApi("64afd48afef3e168");
        FileAnon file = new FileAnon("C:\\Users\\miromero\\Desktop\\pruebaxd.txt");

        
        try {
            System.out.println(anon.upload(file.getZippedFile()));
        } catch (NoSuchAlgorithmException | IOException ex) {
            Logger.getLogger(AppUploadFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
