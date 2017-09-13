/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.VendingMachineChange;
import com.sg.vendingmachine.dto.VendingMachineItems;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author user
 */
public class VendingMachineServiceImpl implements VendingMachineServiceLayer {

    VendingMachineDao dao;
    VendingMachineItems currentItem;
    BigDecimal change = new BigDecimal("0");
    BigDecimal currencyLeftOver = new BigDecimal("0");
    int quarters = 0;
    int dollars = 0;
    int dimes = 0;
    int nickels = 0;
    int pennies = 0;
    BigDecimal totalStoredAmount = BigDecimal.ZERO;

    public VendingMachineServiceImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public List<VendingMachineItems> getAllItems() throws VendingMachinePersistenceException {
        return dao.listItem();
    }

    @Override
    public VendingMachineItems getItem(String itemId) throws VendingMachinePersistenceException {
        currentItem = dao.getItems(itemId);
        return currentItem;
    }

    @Override
    public BigDecimal getChange(VendingMachineItems currentItem) throws VendingMachinePersistenceException {
        BigDecimal bd = currentItem.getItemPrice();
        change = totalStoredAmount.subtract(bd);
        return change;
    }

    @Override
    public VendingMachineChange calculateCoins(BigDecimal change) {
        int dollars = change.divideToIntegralValue(BigDecimal.ONE).intValueExact();
        currencyLeftOver = change.remainder(BigDecimal.ONE);
        int quarters = currencyLeftOver.divideToIntegralValue(new BigDecimal("0.25")).intValueExact();
        currencyLeftOver = currencyLeftOver.remainder(new BigDecimal("0.25"));
        int dimes = currencyLeftOver.divideToIntegralValue(new BigDecimal("0.10")).intValueExact();
        currencyLeftOver = currencyLeftOver.remainder(new BigDecimal("0.10"));
        int nickels = currencyLeftOver.divideToIntegralValue(new BigDecimal("0.05")).intValueExact();
        currencyLeftOver = currencyLeftOver.remainder(new BigDecimal("0.05"));
        int pennies = currencyLeftOver.divideToIntegralValue(new BigDecimal("0.01")).intValueExact();
        currencyLeftOver = currencyLeftOver.remainder(new BigDecimal("0.01"));
        
        VendingMachineChange coinsReturned = new VendingMachineChange(dollars, quarters, dimes, nickels, pennies);
        return coinsReturned;

    }

    @Override
    public void insertedMoney(BigDecimal currentAmount) {
        this.totalStoredAmount = totalStoredAmount.add(currentAmount);
    }

}
