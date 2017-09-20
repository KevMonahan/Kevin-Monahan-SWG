/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author user
 */
public class VendingMachineChange {
    private int quarters;
    private int dollars;
    private int nickels;
    private int dimes;
    private int pennies;
    
    public VendingMachineChange(int dollars, int quarters, int dimes, int nickels, int pennies){
    this.dollars = dollars;
    this.quarters = quarters;
    this.dimes = dimes;
    this.nickels = nickels;
    this.pennies = pennies;
    }

    /**
     * @return the quarters
     */
    public int getQuarters() {
        return quarters;
    }

    /**
     * @param quarters the quarters to set
     */
    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    /**
     * @return the dollars
     */
    public int getDollars() {
        return dollars;
    }

    /**
     * @param dollars the dollars to set
     */
    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    /**
     * @return the nickels
     */
    public int getNickels() {
        return nickels;
    }

    /**
     * @param nickels the nickels to set
     */
    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    /**
     * @return the dimes
     */
    public int getDimes() {
        return dimes;
    }

    /**
     * @param dimes the dimes to set
     */
    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    /**
     * @return the pennies
     */
    public int getPennies() {
        return pennies;
    }

    /**
     * @param pennies the pennies to set
     */
    public void setPennies(int pennies) {
        this.pennies = pennies;
    }
    @Override
    public String toString(){
        return "Dollars: " + dollars + " |Quarters: " + quarters + " |Dimes: " + dimes + " |Nickels: " + nickels + " |Pennies: " + pennies + " ";
    }
}
