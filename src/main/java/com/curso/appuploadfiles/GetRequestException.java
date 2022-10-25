/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.appuploadfiles;

/**
 *
 * @author miromero
 */
public class GetRequestException extends RuntimeException {
    public GetRequestException() {
        super("Failed to respond with a 'get' request!");
    }
}
