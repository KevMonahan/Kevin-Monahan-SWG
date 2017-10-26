/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Orders;
import com.sg.flooringmastery.dto.PartialOrder;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author user
 */
public interface OrdersDao {
    public Orders addOrder(LocalDate date, Orders order) 
            throws FlooringPersistenceException;
    
    public List<Orders> getOrdersByDate(LocalDate date) throws FlooringPersistenceException;
    
    public Orders getOrder(LocalDate date, Integer orderNumber) throws FlooringPersistenceException;
    
    public Orders removeOrder(LocalDate date, Integer orderNumber) throws FlooringPersistenceException;
    
    public Integer loadOrderNumber() throws FlooringPersistenceException;
    
    public void saveWork() throws FlooringPersistenceException;

    public Boolean getMode() throws FlooringPersistenceException;
}
