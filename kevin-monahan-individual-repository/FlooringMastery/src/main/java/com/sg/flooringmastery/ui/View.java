/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Orders;
import com.sg.flooringmastery.dto.PartialOrder;
import com.sg.flooringmastery.dto.Products;
import com.sg.flooringmastery.dto.State;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
    LocalDate orderDate;

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
        io.print("~~=~~=~~ Create a new flooring order! ~~=~~=~~");
    }

    public PartialOrder getNewOrderInfo(List<State> stateList, List<Products> productList) {
        String stateStrings = "";
        for (State state : stateList){
            stateStrings += state.toString() + " ";
        }
        String productStrings = "";
        for (Products product : productList) {
            productStrings += product.toString() + " ";
        }
        
        String customerName = io.readString("Please enter the name on the order");
        String orderState = io.readString("Please enter what state " + customerName + "'s order is in : " + stateStrings);
        String productType = io.readString("Please enter which product " + customerName + " would like, please enter " + productStrings);
        BigDecimal area = io.readBigDecimal("Please enter the SqFt Area of " + productType + " you would like to purchase");
        PartialOrder partialOrder = new PartialOrder(customerName, orderState, productType, area);
        return partialOrder;
    }

    public void displayEditOrderBanner() {
        io.print("~~~~~~~ Edit an Order ~~~~~~~");
    }

    public void displayOrderSuccessBanner() {
        io.print("~~~~~~~ Your order has been added successfully ~~~~~~~~");
    }

    public void displayOrders(List<Orders> orderList) {
        for (Orders order : orderList) {
            io.print("order Number = " + order.getOrderNumber());
            io.print("Customer Name = " + order.getCustomerName());
            io.print("order State = " + order.getOrderState());
            io.print("product type = " + order.getProductType());
            io.print("area of product = " + order.getArea());
            io.print("Product cost per sqft = " + order.getCostPerSqFt());
            io.print("Labor cost per sqft = " + order.getLaborCostPerSqFt());
            io.print("labor Cost = " + order.getLaborCost());
            io.print("material Cost + " + order.getMaterialCost());
            io.print("Sales Tax = " + order.getTax());
            io.print("Final Total = " + order.getTotal());
            io.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        }
    }

    public boolean confirmOrder(Orders newOrder) {
        BigDecimal taxedAmount = newOrder.getTax();
        taxedAmount = taxedAmount.setScale(2, RoundingMode.CEILING);
        BigDecimal finalTotal = newOrder.getTotal();
        finalTotal = finalTotal.setScale(2, RoundingMode.CEILING);

        io.print("The Order Number is : " + newOrder.getOrderNumber());
        io.print("The customer's name is : " + newOrder.getCustomerName());
        io.print("The order's state is : " + newOrder.getOrderState());
        io.print("The product type is : " + newOrder.getProductType());
        io.print("The area of the order is : " + newOrder.getArea());
        io.print("The Material Cost per Sq. Ft. is : " + newOrder.getCostPerSqFt());
        io.print("The Labor Cost per Sq. Ft. is : " + newOrder.getLaborCostPerSqFt());
        io.print("The total material cost is : " + newOrder.getMaterialCost());;
        io.print("The total labor cost is : " + newOrder.getLaborCost());
        io.print("The sales tax on the order is : " + taxedAmount);
        io.print("The total for this order is : " + finalTotal);

        String isCorrect = io.readString("Does the order appear to be correct? Please type Y for yes. or N for no.");
        if (isCorrect.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public void displayRemoveOrderBanner() {
        io.print("=== Remove an Order ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Order successfully removed. Please hit enter to continue.");
    }

    public PartialOrder editOrder(Orders order) {

        PartialOrder editedOrder = new PartialOrder(order.getCustomerName(), order.getOrderState(), order.getProductType(), order.getArea(), order.getOrderNumber());

        io.print("The customers name is " + order.getCustomerName());
        String changeName = io.readString("Would you like to change the Name on the Order? Y for Yes, or press Enter to keep it the same");
        if (changeName.equals("Y")) {
            editedOrder.setCustomerName(io.readString("What would you like to change the name to?"));
        } else {
            editedOrder.setCustomerName(order.getCustomerName());
        }
        io.print("The order's state is set to " + order.getOrderState());

        String changeState = io.readString("Would you like to change the State on the order? Y for Yes, or press Enter to keep it the same");
        if (changeState.equals("Y")) {
            editedOrder.setOrderState(io.readString("What would you like to change the State to? OH, PA, MI, or IN."));
        } else {
            editedOrder.setOrderState(order.getOrderState());
        }

        io.print("The product on the order is set as " + order.getProductType());

        String changeProduct = io.readString("Would you like to change the product type set for the order? Y for Yes, or press Enter to keep it the same");
        if (changeProduct.equals("Y")) {
            editedOrder.setProductType(io.readString("What would you like to change the product type to? Carpet, Laminate, Tile, or Wood"));
        } else {
            editedOrder.setProductType(order.getProductType());
        }

        io.print("The order's area is currently " + order.getArea());
        String changeArea = io.readString("Would you like to change the area on the order? Y for Yes, or press Enter to keep it the same");
        if (changeArea.equals("Y")) {
            editedOrder.setArea(io.readBigDecimal("What would you like to change the area to?"));
        } else {
            editedOrder.setArea(order.getArea());
        }
        return editedOrder;
    }
    
    public void displaySaveAbortedBanner() {
        io.print("You have elected not to save your data.");
    }

    public Boolean displaySaveConfirmation() {
        Boolean willSave = false;
        String confirmSave = io.readString("This will save all changes made during this session."
                + " All committed saves are final, Would you like to continue?"
                + " Y for Yes, press Enter for No");
        
        if (confirmSave.equals("Y")) {
            willSave = true;
        } else if (confirmSave.equals("")) {
            willSave = false;
        }
        return willSave;
    }
    
    public void displaySavedBanner() {
        io.print("~~~~~~You have successfully saved your changes~~~~~~");
    }

    public void displayTestModeBanner() {
        io.print("The program is currently set to Test Mode, and this function is currently disabled.");
    }
}
