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
    private BigDecimal change;
    private double quarters;
    private double dollars;
    private double nickels;
    private double dimes;

    /**
     * @return the change
     */
    public BigDecimal getChange() {
        return change;
    }

    /**
     * @param change the change to set
     */
    public void setChange(BigDecimal change) {
        this.change = change;
    }

    /**
     * @return the quarters
     */
    public double getQuarters() {
        return quarters;
    }

    /**
     * @param quarters the quarters to set
     */
    public void setQuarters(double quarters) {
        this.quarters = quarters;
    }

    /**
     * @return the dollars
     */
    public double getDollars() {
        return dollars;
    }

    /**
     * @param dollars the dollars to set
     */
    public void setDollars(double dollars) {
        this.dollars = dollars;
    }

    /**
     * @return the nickels
     */
    public double getNickels() {
        return nickels;
    }

    /**
     * @param nickels the nickels to set
     */
    public void setNickels(double nickels) {
        this.nickels = nickels;
    }

    /**
     * @return the dimes
     */
    public double getDimes() {
        return dimes;
    }

    /**
     * @param dimes the dimes to set
     */
    public void setDimes(double dimes) {
        this.dimes = dimes;
    }
    
}
