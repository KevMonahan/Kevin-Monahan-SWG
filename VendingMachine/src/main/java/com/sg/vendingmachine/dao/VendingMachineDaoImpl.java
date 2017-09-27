/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingMachineInsertedMoney;
import com.sg.vendingmachine.dto.VendingMachineItems;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class VendingMachineDaoImpl implements VendingMachineDao {

    public static final String VENDINGMACHINE_FILE = "VendingMachineItems.txt";
    public static final String DELIMITER = "::";

    private Map<String, VendingMachineItems> items = new HashMap<>();

    @Override
    public List<VendingMachineItems> listItem() throws VendingMachinePersistenceException {
        loadVendingMachine();
        return new ArrayList<VendingMachineItems>(items.values());
    }

    @Override
    public VendingMachineItems getItems(String itemId) throws VendingMachinePersistenceException {
        loadVendingMachine();
        return items.get(itemId);
    }
    @Override
    public void updateItems(String itemId) throws VendingMachinePersistenceException {
        VendingMachineItems currentItem = getItems(itemId);

        if (currentItem.getItemQuantity() > 0) {
            currentItem.setItemQuantity(currentItem.getItemQuantity() - 1);
            writeVendingMachine();
        }
    }

    private void loadVendingMachine() throws VendingMachinePersistenceException {
        Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(VENDINGMACHINE_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            VendingMachineItems currentItem = new VendingMachineItems(currentTokens[0]);

            currentItem.setItemName(currentTokens[1]);
            currentItem.setItemPrice(new BigDecimal(currentTokens[2]));
            currentItem.setItemQuantity(new Integer(currentTokens[3]));

            items.put(currentItem.getItemId(), currentItem);
        }

        scanner.close();
    }
    private void writeVendingMachine() throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(VENDINGMACHINE_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save student data.", e);
        }
        List<VendingMachineItems> itemList = this.listItem();
        for (VendingMachineItems currentItem : itemList) {
            out.println(currentItem.getItemId() + DELIMITER
                    + currentItem.getItemName() + DELIMITER
                    + currentItem.getItemPrice() + DELIMITER
                    + currentItem.getItemQuantity());
            out.flush();
        }
        out.close();
    }

}
