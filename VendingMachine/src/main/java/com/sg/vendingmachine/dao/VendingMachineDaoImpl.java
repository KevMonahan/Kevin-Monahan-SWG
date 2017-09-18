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

    /**
     * Writes all students in the roster out to a ROSTER_FILE. See loadRoster
     * for file format.
     *
     * @throws ClassRosterPersistenceException if an error occurs writing to the
     * file
     */
    private void writeVendingMachine() throws VendingMachinePersistenceException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(VENDINGMACHINE_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save student data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        List<VendingMachineItems> itemList = this.listItem();
        for (VendingMachineItems currentItem : itemList) {
            // write the Student object to the file
            out.println(currentItem.getItemId() + DELIMITER
                    + currentItem.getItemName() + DELIMITER
                    + currentItem.getItemPrice() + DELIMITER
                    + currentItem.getItemQuantity());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

}
