/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Orders;

/**
 *
 * @author user
 */
public interface ServiceLayer {
    void createOrder(Orders order) throws DuplicateOrderNumberException, FlooringPersistenceException, OrderValidationException;
    
}
