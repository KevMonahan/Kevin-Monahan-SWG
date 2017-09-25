/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Orders;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author user
 */
public interface Dao {
    Orders addOrder(LocalDate date, Orders orderNumber) 
            throws FlooringPersistenceException;
    
    List<Orders> getOrdersByDate() throws FlooringPersistenceException;
    
    Orders editOrder(LocalDate date, Orders orderNumber) throws FlooringPersistenceException;
    
    Orders removeOrder(LocalDate date, Orders orderNumber) throws FlooringPersistenceException;
}
