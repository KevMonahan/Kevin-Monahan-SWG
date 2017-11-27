/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Orders;
import com.sg.flooringmastery.dto.PartialOrder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class OrdersDaoStubImpl implements OrdersDao{
    
    PartialOrder order1;
    PartialOrder order2;
    PartialOrder currentOrder;

    
    public OrdersDaoStubImpl () {
        order1 = new PartialOrder("Kevin", "OH", "Carpet", new BigDecimal("100"));
        order2 = new PartialOrder("Chris", "PA", "Laminate", new BigDecimal("80"));
        
    }



    @Override
    public Integer loadOrderNumber() throws FlooringPersistenceException {
        return 1;
    }

    @Override
    public Orders addOrder(LocalDate date, Orders orderNumber) throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Orders> getOrdersByDate(LocalDate date) throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders getOrder(LocalDate date, Integer orderNumber) throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders removeOrder(LocalDate date, Integer orderNumber) throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveWork() throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean getMode() throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
