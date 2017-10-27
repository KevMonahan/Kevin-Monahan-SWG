/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Orders;
import com.sg.flooringmastery.dto.PartialOrder;
import com.sg.flooringmastery.dto.Products;
import com.sg.flooringmastery.dto.State;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author user
 */
public interface ServiceLayer {

    Orders createOrder(PartialOrder currentOrder) throws FlooringPersistenceException, OrderValidationException;

    Orders calculateOrder(Orders newOrder) throws FlooringPersistenceException, OrderValidationException;

    void saveOrderToMemory(Orders newOrder) throws FlooringPersistenceException, OrderValidationException;

    List<Orders> displayOrders(LocalDate date) throws FlooringPersistenceException;

    Orders removeOrder(LocalDate date, Integer orderNum) throws FlooringPersistenceException;

    Orders editSingleOrder(LocalDate date, Integer orderNum) throws FlooringPersistenceException, OrderValidationException;

    public void saveWork() throws FlooringPersistenceException;

    public Boolean getMode() throws FlooringPersistenceException;

    public List<Products> getProductList() throws FlooringPersistenceException;

    public List<State> getStateList() throws FlooringPersistenceException;
}
