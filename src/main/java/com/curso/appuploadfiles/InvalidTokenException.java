/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.appuploadfiles;

/**
 *
 * @author miromero
 */
public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException() {
        super("The token you provided was invalid and failed to respond with AnonFile!");
    }
}
