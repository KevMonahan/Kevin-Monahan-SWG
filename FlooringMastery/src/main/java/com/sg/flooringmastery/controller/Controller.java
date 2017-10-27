/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Orders;
import com.sg.flooringmastery.dto.PartialOrder;
import com.sg.flooringmastery.service.OrderValidationException;
import com.sg.flooringmastery.service.ServiceLayer;
import com.sg.flooringmastery.ui.View;
import java.time.LocalDate;

/**
 *
 * @author user
 */
public class Controller {

    View view;
    ServiceLayer service;

    public Controller(View view, ServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        displayOrders();
                        break;
                    case 2:
                        try {
                            addAnOrder();
                            break;
                        } catch (OrderValidationException e) {
                            view.displayErrorMessage(e.getMessage());
                        }
                    case 3:
                        try {
                        editAnOrder();
                        break;
                        } catch (OrderValidationException e) {
                            view.displayErrorMessage(e.getMessage());
                        }
                    case 4:
                        removeAnOrder();
                        break;
                    case 5:
                        saveCurrentWork();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();

        } catch (FlooringPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void displayOrders() throws FlooringPersistenceException {

        view.displayDisplayAllOrders();
        view.displayOrders(service.displayOrders(view.getOrderDate()));

    }

    private void addAnOrder() throws FlooringPersistenceException, OrderValidationException {
        view.displayCreateOrderBanner();
        boolean hasErrors = false;
        do {
            PartialOrder currentOrder = view.getNewOrderInfo(service.getStateList(), service.getProductList());
            Orders newOrder = service.calculateOrder(service.createOrder(currentOrder));
            Boolean correctOrder = view.confirmOrder(newOrder);
            if (correctOrder == false) {
                hasErrors = true;
            } else if (correctOrder == true) {
                view.displayOrderSuccessBanner();
                service.saveOrderToMemory(newOrder);
            }
            hasErrors = false;

        } while (hasErrors);
    }

    private void editAnOrder() throws FlooringPersistenceException, OrderValidationException {
        view.displayEditOrderBanner();
        LocalDate date = view.getOrderDate();
        Integer orderNumber = view.getOrderNumber();
        
        
        Orders order = service.editSingleOrder(date, orderNumber);
        PartialOrder editedPartialOrder = view.editOrder(order);
        Orders editedOrder = service.createOrder(editedPartialOrder);
        service.removeOrder(date, orderNumber);
        Orders finalEditedOrder = service.calculateOrder(editedOrder);
        service.saveOrderToMemory(finalEditedOrder);
        
    }

    private void removeAnOrder() throws FlooringPersistenceException {
        view.displayRemoveOrderBanner();
        LocalDate date = view.getOrderDate();
        Integer orderNumber = view.getOrderNumber();
        service.removeOrder(date, orderNumber);
        view.displayRemoveSuccessBanner();
    }

    private void saveCurrentWork() throws FlooringPersistenceException {
        Boolean willSave = view.displaySaveConfirmation();
        Boolean productionMode = service.getMode();
        
        if (willSave == true && productionMode == true) {
            service.saveWork();
            view.displaySavedBanner();
        } else if (willSave == true && productionMode == false){
            view.displayTestModeBanner();
        } else if (willSave == false) {
            view.displaySaveAbortedBanner();
        }
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    public Controller(ServiceLayer service, View view) {
        this.service = service;
        this.view = view;
    }

}
