/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Orders;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class DaoFileImpl implements Dao{

    public static final String ORDER_FILE = "orders.txt";
    public static final String DELIMITER = ",";

    private Map<LocalDate, Orders> orders = new HashMap<>();
    @Override
    public Orders addOrder(LocalDate date, Orders orderNumber) throws FlooringPersistenceException {
        Orders newOrder = orders.put(date,orderNumber);
//        writeOrders();
        return newOrder;
    }

    @Override
    public List<Orders> getOrdersByDate() throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders editOrder(LocalDate date, Orders orderNumber) throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders removeOrder(LocalDate date, Orders orderNumber) throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void loadLibrary() throws FlooringPersistenceException {
        Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ORDER_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException(
                    "-_- Could not load order data into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            Orders currentOrder = new Orders(currentTokens[0]);

            currentOrder.setCustomerName(currentTokens[1]);
            currentOrder.setOrderState(currentTokens[2]);
            currentOrder.setTaxRate(new BigDecimal(currentTokens[3]));
            currentOrder.setProductType(currentTokens[4]);
            currentOrder.setArea(new BigDecimal(currentTokens[5]));
            currentOrder.setCostPerSqFt(new BigDecimal(currentTokens[6]));
            currentOrder.setLaborCostPerSqFt(new BigDecimal(currentTokens[7]));
            currentOrder.setMaterialCost(new BigDecimal(currentTokens[8]));
            currentOrder.setLaborCost(new BigDecimal(currentTokens[9]));
            currentOrder.setTax(new BigDecimal(currentTokens[10]));
            currentOrder.setTotal(new BigDecimal(currentTokens[11]));
            

            orders.put(currentOrder.getOrderNumber(), currentOrder);
        }

        scanner.close();
    }
    
}
