/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import java.math.BigDecimal;

/**
 *
 * @author user
 */
public class Change {

    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    public Change(BigDecimal balance) {
        pennies = Integer.parseInt(balance.toString().replace(".", ""));
        quarters = pennies / 25;
        pennies %= 25;
        dimes = pennies / 10;
        pennies %= 10;
        nickels = pennies / 5;
        pennies %= 5;
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public int getPennies() {
        return pennies;
    }

}
