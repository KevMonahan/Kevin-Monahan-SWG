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
    VendingMachineItems currentItem;
    List<VendingMachineItems> itemList = new ArrayList<>();
    
    public VendingMachineDaoStubImpl () {
        item = new VendingMachineItems("A1");
        item.setItemName("Candy");
        item.setItemPrice(new BigDecimal("1.50"));
        item.setItemQuantity(5);
        itemList.add(item);
        item2 = new VendingMachineItems("A2");
        item2.setItemName("Chips");
        item2.setItemPrice(new BigDecimal("1.75"));
        item2.setItemQuantity(0);    
        itemList.add(item2);
    }

    @Override
    public List<VendingMachineItems> listItem() throws VendingMachinePersistenceException {
        return itemList;
    }

    @Override
    public VendingMachineItems getItems(String itemId) throws VendingMachinePersistenceException {
        if (itemId.equals(item2.getItemId())) {
            return item2;
        } else if(itemId.equals(item.getItemId())) {
            return item;
        }
        else {
            return null;
        }
    }

    @Override
    public void updateItems(String itemId) throws VendingMachinePersistenceException {
        currentItem = getItems(itemId);
        if (currentItem.getItemQuantity() > 0) {
            currentItem.setItemQuantity(currentItem.getItemQuantity() - 1);
        }
    }
    
}
