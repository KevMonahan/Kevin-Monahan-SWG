/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.VendingMachineChange;
import com.sg.vendingmachine.dto.VendingMachineItems;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class VendingMachineView {

    Scanner sc = new Scanner(System.in);
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

    public void displayDisplayAllBanner() {

    }

    public void displayItemList(List<VendingMachineItems> itemList) {
        for (VendingMachineItems currentItem : itemList) {
            io.print(currentItem.getItemId() + ": "
                    + currentItem.getItemName() + " "
                    + currentItem.getItemPrice());
        }
    }

    public void displayInsertMoneyBanner() {
        io.print("===Please Insert Money===");
    }

    public void displayItem(VendingMachineItems item) {
        if (item != null) {
            io.print("You have successfully purchased : ");
            io.print(item.getItemName());
            io.print("");
        } else {
            io.print("No such Item");
        }
    }
    
    public void displayChange (VendingMachineChange coinsReturned) {
    if (coinsReturned != null) {
        io.print("Your change is : " + " Dollars: "
                + coinsReturned.getDollars() + " Quarters: " 
                + coinsReturned.getQuarters() + " Dimes: " 
                + coinsReturned.getDimes() + " Nickels: "  
                + coinsReturned.getNickels() + " Pennies: " 
                + coinsReturned.getPennies());
    }
}

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public String getItemIdSelection() {
        return io.readString("Please enter your Item Selector ID");
    }

}
