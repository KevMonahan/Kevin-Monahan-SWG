/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.VendingMachineItems;
import java.util.List;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.VendingMachineChange;
import java.math.BigDecimal;

/**
 *
 * @author user
 */
public interface VendingMachineServiceLayer {
    List<VendingMachineItems> getAllItems() throws VendingMachinePersistenceException;
            
    VendingMachineItems getItem (String itemId) throws VendingMachinePersistenceException, InsufficientQuantityException;
    
    BigDecimal getChange(VendingMachineItems currentItem) throws VendingMachinePersistenceException, InsufficientFundsException;
    
    VendingMachineChange calculateCoins(BigDecimal change) throws VendingMachinePersistenceException;
    
    void insertedMoney(BigDecimal currentAmount);
    
    public BigDecimal getTotalStoredAmount();
}


