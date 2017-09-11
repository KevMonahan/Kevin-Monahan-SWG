/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.VendingMachineItems;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author user
 */
public class VendingMachineView {
    DecimalFormat format = new DecimalFormat();
    UserIO io;

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Vending Machine Items");
        io.print("2. Insert money");
        io.print("3. Make Item Selection");
        io.print("4. Exit");
        
        return io.readInt("Please select from the above choices.", 1, 5);
    }
    
    public BigDecimal getVendingMachineInsertedAmount() {
        String amount = io.readString("Please enter an amount into the vending machine");
                BigDecimal insertedMoney = new BigDecimal(amount);
        return insertedMoney;
    }
    
    public void displayDisplayItemSelectionBanner() {
        io.print("=== Vending Machine Item List ===");
    }
    
    public void displayDisplayAllBanner(){
        
    }
    
    public void displayItemList(List<VendingMachineItems> itemList) {
        itemList.forEach((currentItem) -> {
            io.print(currentItem);
        });
    }
    
    public void displayInsertMoneyBanner() {
        io.print("===Please Insert Money===");
    }
    
    public void getInsertedAmount() {
        io.print("You have entered ");
    }
    
    public void displayItem() {
        
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    
}
