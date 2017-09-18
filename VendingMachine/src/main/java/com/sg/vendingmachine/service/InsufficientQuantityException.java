/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

/**
 *
 * @author user
 */
public class InsufficientQuantityException extends Exception {
    public InsufficientQuantityException(String message) {
        super(message);
    }

    public InsufficientQuantityException(String message,
            Throwable cause) {
        super(message, cause);
    }
}
