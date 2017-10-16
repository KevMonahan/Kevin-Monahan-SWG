/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Orders;
import com.sg.flooringmastery.dto.PartialOrder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
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

    public LocalDate getOrderDate() {
        LocalDate orderDate = io.readLocalDate("What date would you like to access? Please input it as MMDDYYYY");
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
        io.print("~~=~~=~~ What floor would you like to order? Please choose Carpet, Laminate, Tile, or Wood. ~~=~~=~~");
    }

    public PartialOrder getNewOrderInfo() {
        String customerName = io.readString("Please enter your name.");
        String orderState = io.readString("Please enter OH, PA, MI, or IN for which state this order is for");
        String productType = io.readString("Please enter which product you would like");
        BigDecimal area = io.readBigDecimal("Please enter the the area in SqFt you would like to purchase");
        PartialOrder partialOrder = new PartialOrder(customerName, orderState, productType, area);
        io.print("" + partialOrder);
        String confirmOrder = io.readString("Is the information for this order correct? Please enter Y for yes, or N for no.");
        if (confirmOrder.equals("Y")) {
            return partialOrder;
        } else {

            return null;
        }
    }

    public void displayOrderSuccessBanner() {
        io.print("Your order has been added successfully");
    }

    public void displayOrders(List<Orders> orderList) {
        for (Orders order : orderList) {
            io.print("order Number = " + order.getOrderNumber());
            io.print("Customer Name = " + order.getCustomerName());
            io.print("order State = " + order.getOrderState());
            io.print("product type = " + order.getProductType());
            io.print("area of product = " + order.getArea());
            io.print("labor Cost = " + order.getLaborCost());
            io.print("material Cost + " + order.getMaterialCost());
            io.print("Sales Tax = " + order.getTax());
            io.print("Final Total = " + order.getTotal());

        }
    }
}
