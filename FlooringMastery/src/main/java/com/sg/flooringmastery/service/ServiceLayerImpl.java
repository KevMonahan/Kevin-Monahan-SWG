/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.Dao;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Orders;

/**
 *
 * @author user
 */
public class ServiceLayerImpl implements ServiceLayer {

    Dao dao;

    @Override
    public void createOrder(Orders order) throws DuplicateOrderNumberException, FlooringPersistenceException, OrderValidationException {
        if (dao.getOrder(order.getOrderNumber()) != null) {
            throw new DuplicateOrderNumberException(
                    "Error: Could not create order. Order ID "
                            + order.getOrderNumber()
                            + " already exists");
        }
    }

}
