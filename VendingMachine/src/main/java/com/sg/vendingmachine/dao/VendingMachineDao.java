/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingMachineInsertedMoney;
import com.sg.vendingmachine.dto.VendingMachineItems;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author user
 */
public interface VendingMachineDao {
    public List<VendingMachineItems> listItem() throws VendingMachinePersistenceException;
    
    public VendingMachineItems getItems(String itemId) throws VendingMachinePersistenceException;
    
}
