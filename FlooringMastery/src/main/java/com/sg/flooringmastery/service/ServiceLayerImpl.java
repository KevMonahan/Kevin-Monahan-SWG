/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.PartialOrder;
import com.sg.flooringmastery.dao.OrdersDao;
import com.sg.flooringmastery.dao.ProductsDao;
import com.sg.flooringmastery.dao.StateDao;
import com.sg.flooringmastery.dto.Orders;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author user
 */
public class ServiceLayerImpl implements ServiceLayer {

    OrdersDao orderDao;
    StateDao stateDao;
    ProductsDao productDao;

    public ServiceLayerImpl(OrdersDao orderDao, StateDao stateDao, ProductsDao productDao) {
        this.orderDao = orderDao;
        this.stateDao = stateDao;
        this.productDao = productDao;
    }
    

    @Override
    public void createOrder(PartialOrder currentOrder) throws DuplicateOrderNumberException, FlooringPersistenceException, OrderValidationException {
        Orders newOrder = new Orders(currentOrder);
        newOrder.setOrderNumber(orderDao.loadOrderNumber());
        newOrder.
        }

    @Override
    public List<Orders> displayOrders(LocalDate date) throws FlooringPersistenceException {
        return orderDao.getOrdersByDate(date);
    }
}