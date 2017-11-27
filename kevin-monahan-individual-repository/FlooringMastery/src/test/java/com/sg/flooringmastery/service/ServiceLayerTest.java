/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dto.Orders;
import com.sg.flooringmastery.dto.PartialOrder;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author user
 */
public class ServiceLayerTest {
    PartialOrder order1 = new PartialOrder("Kevin", "OH", "Carpet", new BigDecimal("100"), 1);
    PartialOrder order2 = order2 = new PartialOrder("Chris", "PA", "Laminate", new BigDecimal("80"), 1);
    private ServiceLayer service;
    public ServiceLayerTest() {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("TestApplicationContext.xml");
        service = ctx.getBean("serviceLayer", ServiceLayer.class);
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
     * Test of createOrder method, of class ServiceLayer.
     */
    @Test
    public void testCreateOrder() throws Exception {
        Orders newOrder = service.createOrder(order1);
        
        assertEquals(new BigDecimal("6.25"),newOrder.getTaxRate());
        assertEquals(LocalDate.now(), newOrder.getDate());
        assertEquals(new BigDecimal("2.25"), newOrder.getCostPerSqFt());
        assertEquals(new BigDecimal("2.10"), newOrder.getLaborCostPerSqFt());
    }

    /**
     * Test of calculateOrder method, of class ServiceLayer.
     */
    @Test
    public void testCalculateOrder() throws Exception {
        Orders newOrder = service.createOrder(order1);
        service.calculateOrder(newOrder);
        
        assertEquals(new BigDecimal("210.00"), newOrder.getLaborCost());
        assertEquals(new BigDecimal("225.00"), newOrder.getMaterialCost());
        assertEquals(new BigDecimal("27.19"), (newOrder.getTax()).setScale(2, RoundingMode.CEILING));
        assertEquals(new BigDecimal("462.19"), newOrder.getTotal());
        assertEquals(1, newOrder.getOrderNumber());
    }

    /**
     * Test of saveOrderToMemory method, of class ServiceLayer.
     */
    
    
}
