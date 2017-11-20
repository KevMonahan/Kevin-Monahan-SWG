/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.model.JunkFood;
import com.sg.vendingmachinespringmvc.model.JunkFoodDao;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author user
 */
public class ServiceLayerImpl implements ServiceLayer{
    private JunkFoodDao junkFoodDao;
    private BigDecimal wallet;
    private int selection;
    private Change currentChange;
    private String message;
    
    @Inject
    public ServiceLayerImpl(JunkFoodDao junkFoodDao) {
        this.junkFoodDao = junkFoodDao;
        wallet = new BigDecimal("0.00");
        selection = 0;
        currentChange = null;
        message = null;
    }

    @Override
    public void addMoney(String amount) {
        switch (amount) {
            case "dollar":
                wallet = wallet.add(new BigDecimal("1.00"));
                break;
            case "quarter":
                wallet = wallet.add(new BigDecimal("0.25"));
                break;
            case "dime":
                wallet = wallet.add(new BigDecimal("0.10"));
                break;
            case "nickel":
                wallet = wallet.add(new BigDecimal("0.05"));
                break;
            default:
        }
    }
    @Override
    public void makePurchase() {
        if (selection != 0) {

            JunkFood junkFood = junkFoodDao.getJunkFoodById(selection);
            BigDecimal selectionPrice = junkFood.getPrice();
            if (junkFood.getQuantity() <= 0) {
                message = "SOLD OUT!!!";
            } else if (wallet.compareTo(selectionPrice) < 0) {
                BigDecimal difference = selectionPrice.subtract(wallet);
                message = "Please Deposit: $" + difference;
            } else {
                BigDecimal newWallet = wallet.subtract(selectionPrice);
                Change change = new Change(newWallet);
                currentChange = change;
                wallet = new BigDecimal("0.00");
                int newJunkFoodQuantity = junkFood.getQuantity() - 1;
                junkFood.setQuantity(newJunkFoodQuantity);
                message = "Thank You!!!";
            }
        }
    }
    @Override
    public void changeReturn() {
        Change change = new Change(wallet);
        currentChange = change;
        wallet = new BigDecimal("0.00");
        selection = 0;
        message = null;
    }
    
    @Override
    public List<JunkFood> getJunkFood() {
        return junkFoodDao.getJunkFood();
    }
    @Override
    public JunkFood getJunkFoodById(int id) {
        return junkFoodDao.getJunkFoodById(id);
    }

    @Override
    public BigDecimal getWallet() {
        return wallet;
    }
    @Override
    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }
    @Override
    public int getSelection() {
        return selection;
    }
    @Override
    public void setSelection(int Selection) {
        this.selection = Selection;
    }
    @Override
    public Change getCurrentChange() {
        return currentChange;
    }
    @Override
    public void setCurrentChange(Change currentChange) {
        this.currentChange = currentChange;
    }      
    @Override
    public String getMessage() {
        return message;
    }
    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
