/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.VendingMachineChange;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.VendingMachineView;
import com.sg.vendingmachine.dto.VendingMachineItems;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author user
 */
public class VendingMachineController {
    BigDecimal currentAmount;
    
    
    VendingMachineView view;
    VendingMachineServiceLayer service;

    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                
                menuSelection = getMenuSelection();
                
                switch (menuSelection) {
                    case 1:
                        listVendingMachineItems();
                        break;
                    case 2:
                        insertMoney();
                        break;
                    case 3:
                        makeItemSelection();
                    case 4:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void insertMoney() throws VendingMachinePersistenceException {
        view.displayInsertMoneyBanner();
        boolean hasErrors = false;
        do {
            BigDecimal currentAmount = view.getVendingMachineInsertedAmount();
            service.insertedMoney(currentAmount);
                hasErrors = false;
        } while (hasErrors);
    }
    
    private void listVendingMachineItems() throws VendingMachinePersistenceException {
        view.displayDisplayAllBanner();
        List<VendingMachineItems> itemList = service.getAllItems();
        view.displayItemList (itemList);
    }
    
    private void makeItemSelection() throws VendingMachinePersistenceException {
        String itemId = view.getItemIdSelection();
        VendingMachineItems item = service.getItem(itemId);
        BigDecimal change = service.getChange(item);
        VendingMachineChange coinsReturned = service.calculateCoins(change);
        view.displayItem(item);
        view.displayChange(coinsReturned);             
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    
    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }
    
    
}
