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
import com.sg.flooringmastery.dto.Products;
import com.sg.flooringmastery.dto.State;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author user
 */
public class ServiceLayerImpl implements ServiceLayer {
    Orders newOrder;
    OrdersDao orderDao;
    StateDao stateDao;
    ProductsDao productDao;

    public ServiceLayerImpl(OrdersDao orderDao, StateDao stateDao, ProductsDao productDao) {
        this.orderDao = orderDao;
        this.stateDao = stateDao;
        this.productDao = productDao;
    }
    

    @Override
    public Orders createOrder(PartialOrder currentOrder) throws FlooringPersistenceException, OrderValidationException {
        newOrder = new Orders(currentOrder);
        State orderState = stateDao.getStateTax(newOrder.getOrderState());
        if (orderState==null) {
            throw new OrderValidationException ("Error: Order state does not exist.");
        }
        Products orderProduct = productDao.getProduct(newOrder.getProductType());
        if (orderProduct == null) {
            throw new OrderValidationException ("Error: Could not find the product type.");
        }
        newOrder.setDate(LocalDate.now());
        newOrder.setTaxRate(orderState.getStateTax());
        newOrder.setCostPerSqFt(orderProduct.getCostPerSqFt());
        newOrder.setLaborCostPerSqFt(orderProduct.getLaborCostPerSqFt());
        if (currentOrder.getOrderNumber() != null) {
            newOrder.setOrderNumber(currentOrder.getOrderNumber());
        }
        return newOrder;
        }
    
    

    @Override
    public List<Orders> displayOrders(LocalDate date) throws FlooringPersistenceException {
        return orderDao.getOrdersByDate(date);
    }

    @Override
    public Orders calculateOrder(Orders newOrder) throws FlooringPersistenceException, OrderValidationException {
        
        newOrder.setLaborCost((newOrder.getArea().multiply(newOrder.getLaborCostPerSqFt())));
        newOrder.setMaterialCost((newOrder.getArea().multiply(newOrder.getCostPerSqFt())));
        BigDecimal subTotal = newOrder.getLaborCost().add(newOrder.getMaterialCost());
        BigDecimal taxDecimal = newOrder.getTaxRate().multiply(new BigDecimal(".01"));
        
        newOrder.setTax(subTotal.multiply(taxDecimal));
        newOrder.setTotal(subTotal.add(newOrder.getTax()).setScale(2, RoundingMode.CEILING));
       if (newOrder.getOrderNumber() <= 0) { 
        newOrder.setOrderNumber(orderDao.loadOrderNumber());
       }
        return newOrder;
    }

    @Override
    public void saveOrderToMemory(Orders newOrder) throws FlooringPersistenceException, OrderValidationException {
        orderDao.addOrder(newOrder.getDate(), newOrder);
    }

    @Override
    public Orders removeOrder(LocalDate date, Integer orderNum) throws FlooringPersistenceException {
        Orders removedOrder = orderDao.removeOrder(date, orderNum);
        return removedOrder;
    }

    @Override
    public Orders editSingleOrder(LocalDate date, Integer orderNum) throws FlooringPersistenceException, OrderValidationException {
       return orderDao.getOrder(date, orderNum);
       
    }

    @Override
    public void saveWork() throws FlooringPersistenceException {
        orderDao.saveWork();
    }

    @Override
    public Boolean getMode() throws FlooringPersistenceException {
        Boolean productionMode = orderDao.getMode();
        return productionMode;
    }
    
    public List<Products> getProductList() throws FlooringPersistenceException {
        List<Products> productList = productDao.getProductList();
        return productList;
    }
    
    public List<State> getStateList() throws FlooringPersistenceException {
        List<State> stateList = stateDao.getStateList();
        return stateList;
    }
}