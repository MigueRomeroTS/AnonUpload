/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.curso.appuploadfiles;

import java.io.File;

/**
 *
 * @author miromero
 */
public class AppUploadFiles {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        AnonApi anon = new AnonApi("64afd48afef3e168");
        
        System.out.println(anon.upload(new File("C:\\Users\\miromero\\Desktop\\TestFile.txt")));
    }
}
