/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingMachineItems;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {
    VendingMachineItems item;
    VendingMachineItems item2;
    List<VendingMachineItems> itemList = new ArrayList<>();
    
    public VendingMachineDaoStubImpl () {
        item.setItemId("A1");
        item.setItemName("Candy");
        item.setItemPrice(new BigDecimal("1.50"));
        item.setItemQuantity(5);
        
        item2.setItemId("A2");
        item2.setItemName("Chips");
        item2.setItemPrice(new BigDecimal("1.75"));
        item2.setItemQuantity(10);
        
    }

    @Override
    public List<VendingMachineItems> listItem() throws VendingMachinePersistenceException {
        return itemList;
    }

    @Override
    public VendingMachineItems getItems(String itemId) throws VendingMachinePersistenceException {
        if (itemId.equals(item.getItemId())) {
            return item;
        }
        else {
            return null;
        }
    }
    
}
