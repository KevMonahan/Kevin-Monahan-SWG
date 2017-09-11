/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import com.sg.vendingmachine.dto.VendingMachineInsertedMoney;
import com.sg.vendingmachine.dto.VendingMachineItems;
import java.util.List;

/**
 *
 * @author user
 */
public class VendingMachineController {
    
    VendingMachineView view;
    VendingMachineServiceLayer service;
    private UserIO io = new UserIOConsoleImpl();
    
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
            VendingMachineInsertedMoney currentAmount = view.getInsertedAmount();

                service.insertMoney(amounts);
                view.displayInsertedMoneySuccessBanner();
                hasErrors = false;
        } while (hasErrors);
    }
    
    private void listVendingMachineItems() throws VendingMachinePersistenceException {
        view.displayDisplayAllBanner();
        List<VendingMachineItems> itemList = service.getAllItems();
        view.displayItemList (itemList);
    }
    
    private void makeItemSelection() throws VendingMachinePersistenceException {
        view.displayDisplayItemSelectionBanner();
        String itemSelection = view.getItemIdSelection();
        VendingMachineItems item = service.getItemSelection(itemId);
        view.displayItem (item);
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
