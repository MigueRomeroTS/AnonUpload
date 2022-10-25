/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.appuploadfiles;

/**
 *
 * @author miromero
 */
public class PostRequestException extends RuntimeException {
    public PostRequestException() {
        super("Failed to respond with a 'post' request! (File doesn't exist? I dont know.)");
    }
}