/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.PartialOrder;
import com.sg.flooringmastery.service.DuplicateOrderNumberException;
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
                        addAnOrder();
                        break;
                    case 3:
                        editAnOrder();
                        break;
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

    private void displayOrders() throws FlooringPersistenceException{
        
        view.displayDisplayAllOrders();
        view.displayOrders(service.displayOrders(view.getOrderDate()));
        

    }

    private void addAnOrder() throws FlooringPersistenceException{
        view.displayCreateOrderBanner();
        boolean hasErrors = false;
        do {
            PartialOrder currentOrder = view.getNewOrderInfo();
            try {
                service.createOrder(currentOrder);
                view.displayOrderSuccessBanner();
                hasErrors = false;
            } catch (DuplicateOrderNumberException | OrderValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void editAnOrder() throws FlooringPersistenceException{
        view.getOrderDate();
        view.getOrderNumber();
    }

    private void removeAnOrder() throws FlooringPersistenceException{
        view.getOrderDate();
        view.getOrderNumber();
    }

    private void saveCurrentWork() throws FlooringPersistenceException{

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
