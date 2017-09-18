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
    public VendingMachineItems getItem(String itemId) throws VendingMachinePersistenceException, InsufficientQuantityException{
        currentItem = dao.getItems(itemId);
        if (currentItem.getItemQuantity() > 0){
            currentItem.setItemQuantity(currentItem.getItemQuantity()-1);
            return currentItem;
        }
        else {
            throw new InsufficientQuantityException("Error: Your Item Selection Is Out Of Stock! Please Make Another Selection!");
        }
    }

    @Override
    public BigDecimal getChange(VendingMachineItems currentItem) throws VendingMachinePersistenceException, InsufficientFundsException {
        BigDecimal bd = currentItem.getItemPrice();
        if(totalStoredAmount.compareTo(bd) >= 0) {
        change = totalStoredAmount.subtract(bd);
        return change;
        } else {
            throw new InsufficientFundsException ("Error: Insufficient Funds. Please Insert More Money");
        }
        
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
