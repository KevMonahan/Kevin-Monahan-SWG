/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.model.JunkFoodDao;
import com.sg.vendingmachinespringmvc.model.JunkFoodDaoImpl;
import com.sg.vendingmachinespringmvc.model.JunkFoodDaoStubImpl;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class ServiceLayerImplTest {
    
    public ServiceLayerImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addMoney method, of class ServiceLayerImpl.
     */
    @Test
    public void testAddMoney() {
        JunkFoodDao dao = new JunkFoodDaoStubImpl();
        ServiceLayer service = new ServiceLayerImpl(dao);
        service.setWallet(new BigDecimal("0.00"));
        service.addMoney("dollar");
        assertEquals( new BigDecimal("1.00"), service.getWallet());
        
        service.setWallet(new BigDecimal("0.00"));
        service.addMoney("quarter");
        assertEquals(new BigDecimal("0.25"), service.getWallet());
        
        service.setWallet(new BigDecimal("0.00"));
        service.addMoney("dime");
        assertEquals( new BigDecimal("0.10"), service.getWallet());
        
        service.setWallet(new BigDecimal("0.00"));
        service.addMoney("nickel");
        assertEquals( new BigDecimal("0.05"), service.getWallet());
        
        service.setWallet(new BigDecimal("0.00"));
        
        service.addMoney("dollar");
        service.addMoney("dollar");
        service.addMoney("nickel");
        assertEquals(new BigDecimal("2.05"), service.getWallet());
    }

    /**
     * Test of makePurchase method, of class ServiceLayerImpl.
     */
    @Test
    public void testMakePurchase() throws Exception {
        JunkFoodDao dao = new JunkFoodDaoStubImpl();
        ServiceLayer service = new ServiceLayerImpl(dao);
        
        service.setSelection(7);
        service.setWallet(new BigDecimal("4.00"));
        service.makePurchase();
        assertEquals(2, service.getJunkFoodById(7).getQuantity());
        
        service.setSelection(4);
        service.setWallet(new BigDecimal("1.30"));
        service.makePurchase();
        assertEquals("This item is sold out", "Please Deposit: $0.55", service.getMessage());
        
        service.setSelection(1);
        service.setWallet(new BigDecimal("3.30"));
        service.makePurchase();
        assertEquals(new BigDecimal("0.00"), service.getWallet());
        assertEquals("Thank You!!!", service.getMessage());
        assertEquals(0, dao.getJunkFoodById(1).getQuantity());
        
        Change change = service.getCurrentChange();
        assertEquals(5, change.getQuarters());
        assertEquals(2, change.getDimes());
        assertEquals(0, change.getNickels());
        assertEquals(0, change.getPennies());
        
    }

    /**
     * Test of changeReturn method, of class ServiceLayerImpl.
     */
    @Test
    public void testChangeReturn() {
        JunkFoodDao dao = new JunkFoodDaoStubImpl();
        ServiceLayer service = new ServiceLayerImpl(dao);
        service.setSelection(9);
        service.setWallet(new BigDecimal("3.44"));
        service.changeReturn();
        assertEquals(new BigDecimal("0.00"), service.getWallet());
        assertEquals(0, service.getSelection());
        assertEquals(null, service.getMessage());
        Change change = service.getCurrentChange();
        assertEquals(13, change.getQuarters());
        assertEquals(1, change.getDimes());
        assertEquals(1, change.getNickels());
        assertEquals(4, change.getPennies());
    }
}
