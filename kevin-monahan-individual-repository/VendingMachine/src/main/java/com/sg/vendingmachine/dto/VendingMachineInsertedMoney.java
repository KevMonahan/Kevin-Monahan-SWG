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
public class VendingMachineInsertedMoney {
    private BigDecimal insertedMoney;

    /**
     * @return the insertedMoney
     */
    public BigDecimal getInsertedMoney() {
        return insertedMoney;
    }

    /**
     * @param insertedMoney the insertedMoney to set
     */
    public void setInsertedMoney(BigDecimal insertedMoney) {
        this.insertedMoney = insertedMoney;
    }
}
