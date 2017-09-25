/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Orders;
import com.sg.flooringmastery.dto.PartialOrder;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class View {

    Scanner sc = new Scanner(System.in);
    userIO io;
    String orderDate;

    public int printMenuAndGetSelection() {
        

        io.print("********************************************************");
        io.print("*  <<Flooring Program>>");
        io.print("* 1. Display Orders");
        io.print("* 2. Add an Order");
        io.print("* 3. Edit an Order");
        io.print("* 4. Remove an Order");
        io.print("* 5. Save Current Work");
        io.print("* 6. Exit");
        io.print("* ");
        io.print("********************************************************");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public String getOrderDate() {
        orderDate = io.readString("What is the date of the order you would? Please input it as MMDDYY");
        return orderDate;
    }
    public int getOrderNumber() {
        int orderNumber = io.readInt("What is the order number?");
        return orderNumber;
    }

    public void displayExitBanner() {
        io.print("Good Bye! Til next time");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("~~~~~ERROR!!!~~~~~");
        io.print(errorMsg);
    }
    
    public View(userIO io) {
        this.io = io;
    }
    
    public void displayDisplayAllOrders() {
        io.print("~~~~~ List of All Orders for " + orderDate + " ~~~~~");
    }
    
    public void displayCreateOrderBanner() {
        io.print("~~=~~=~~ What would you like to order? ~~=~~=~~");
    }
    
    public PartialOrder getNewOrderInfo() {
        Integer orderNumber = io.readInt("Please enter the order Number.");
        String customerName = io.readString("Please enter your name.");
        String orderState = io.readString("Please enter OH, PA, MI, or IN for which state this order is for");
        String productType = io.readString("Please enter which product you would like");
        BigDecimal area = io.readBigDecimal("Please enter the the area in SqFt you would like to purchase");
        PartialOrder partialOrder = new PartialOrder(orderNumber);
        partialOrder.setCustomerName(customerName);
        
    }
    
    
    public void displayOrderSuccessBanner() {
        
    }
}
