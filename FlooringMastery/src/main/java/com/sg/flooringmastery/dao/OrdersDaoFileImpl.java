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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class OrdersDaoFileImpl implements OrdersDao {

    public static final String ORDERNUMBER_FILE = "LatestOrderNumber.txt";
    public static final String ORDER_FILE = "orders.txt";
    public static final String DELIMITER = ",";

    private Map<LocalDate, List<Orders>> orders = new HashMap<>();

    @Override
    public Orders addOrder(LocalDate date, Orders order) throws FlooringPersistenceException {
        if (orders.containsKey(date)) {
            List<Orders> OrderList = orders.get(date);
            order.setOrderNumber(loadOrderNumber());

            OrderList.add(order);
        } else {
            List<Orders> orderList = new ArrayList();
            orders.put(date, orderList);
            order.setOrderNumber(loadOrderNumber());

            orderList.add(order);
        }
//        writeOrders();

        return order;
    }
    @Override
    public List<Orders> getOrdersByDate(LocalDate date) throws FlooringPersistenceException {
        loadLibrary(date);
        if (!orders.containsKey(date)) {
            throw new FlooringPersistenceException ("Date does not exist");
        }
        return orders.get(date);
        
    }

    @Override
    public Orders editOrder(LocalDate date, Orders orderNumber) throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders removeOrder(LocalDate date, Orders orderNumber) throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadLibrary(LocalDate ld) throws FlooringPersistenceException {
        Scanner scanner;
        List<Orders> orderList = new ArrayList();
        String fileName = "Orders_" + ld + ".txt";
        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(fileName)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException(
                    "-_- Could not load order data into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            Orders currentOrder = new Orders(Integer.parseInt(currentTokens[0]));

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

            orderList.add(currentOrder);

            orders.put(ld, orderList);
        }

        scanner.close();
    }
    @Override
    public Integer loadOrderNumber() throws FlooringPersistenceException {

            Scanner scanner;
            try {
                scanner = new Scanner(
                        new BufferedReader(
                                new FileReader(ORDERNUMBER_FILE)));
            } catch (FileNotFoundException e) {
                throw new FlooringPersistenceException(" -_- Could not load the order number into memory.", e);
            }

        String currentLine = scanner.nextLine();
        Integer orderNumber = Integer.parseInt(currentLine);

        orderNumber += 1;

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ORDERNUMBER_FILE));
        } catch (IOException e) {
            throw new FlooringPersistenceException(
                    "Could not save new Order Number.", e);
        }
        out.println(orderNumber);
        out.flush();
        out.close();
        return orderNumber;
    }

}