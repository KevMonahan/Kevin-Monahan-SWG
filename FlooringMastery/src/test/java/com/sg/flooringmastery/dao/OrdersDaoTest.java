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
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author user
 */
public class OrdersDaoTest {

    private OrdersDao dao = new OrdersDaoFileImpl();

    public OrdersDaoTest() {
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
     * Test of addOrder method, of class OrdersDao.
     */
    @Test
    public void testAddAndGetOrder() throws Exception {
        PartialOrder order1 = new PartialOrder("Kevin", "OH", "Carpet", new BigDecimal("100"));
        Orders newOrder = new Orders(order1);
        newOrder.setOrderNumber(1);
        newOrder.setTaxRate(new BigDecimal("6.25"));
        newOrder.setDate(LocalDate.of(2017, 10, 10));
        newOrder.setCostPerSqFt(new BigDecimal("2.25"));
        newOrder.setLaborCostPerSqFt(new BigDecimal("2.10"));
        newOrder.setMaterialCost(new BigDecimal("225.00"));
        newOrder.setLaborCost(new BigDecimal("210.00"));
        newOrder.setTax(new BigDecimal("27.19"));
        newOrder.setTotal(new BigDecimal("462.19"));
        dao.addOrder(newOrder.getDate(), newOrder);
        assertEquals(newOrder, dao.getOrder(LocalDate.of(2017, 10, 10), 1));
    }

    /**
     * Test of getOrdersByDate method, of class OrdersDao.
     */
    @Test
    public void testGetOrdersByDate() throws Exception {
        PartialOrder order1 = new PartialOrder("Kevin", "OH", "Carpet", new BigDecimal("100"));
        Orders newOrder = new Orders(order1);
        newOrder.setOrderNumber(1);
        newOrder.setTaxRate(new BigDecimal("6.25"));
        newOrder.setDate(LocalDate.of(2017, 10, 10));
        newOrder.setCostPerSqFt(new BigDecimal("2.25"));
        newOrder.setLaborCostPerSqFt(new BigDecimal("2.10"));
        newOrder.setMaterialCost(new BigDecimal("225.00"));
        newOrder.setLaborCost(new BigDecimal("210.00"));
        newOrder.setTax(new BigDecimal("27.19"));
        newOrder.setTotal(new BigDecimal("462.19"));
        dao.addOrder(LocalDate.of(2017,10,10), newOrder);
        
        assertEquals(1, dao.getOrdersByDate(LocalDate.of(2017,10,10)).size());
    }

    /**
     * Test of getOrder method, of class OrdersDao.
     */
    @Test
    public void testGetOrder() throws Exception {
        //done up above in testAddOrderAndGetOrder()
    }

    /**
     * Test of removeOrder method, of class OrdersDao.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        PartialOrder order1 = new PartialOrder("Kevin", "OH", "Carpet", new BigDecimal("100"));
        Orders newOrder = new Orders(order1);
        newOrder.setOrderNumber(1);
        newOrder.setTaxRate(new BigDecimal("6.25"));
        newOrder.setDate(LocalDate.of(2017, 10, 10));
        newOrder.setCostPerSqFt(new BigDecimal("2.25"));
        newOrder.setLaborCostPerSqFt(new BigDecimal("2.10"));
        newOrder.setMaterialCost(new BigDecimal("225.00"));
        newOrder.setLaborCost(new BigDecimal("210.00"));
        newOrder.setTax(new BigDecimal("27.19"));
        newOrder.setTotal(new BigDecimal("462.19"));
        dao.addOrder(newOrder.getDate(), newOrder);
        dao.removeOrder(newOrder.getDate(), 1);
        try {
            dao.getOrder(newOrder.getDate(), 1);
            fail();
        } catch (Exception e) {
            
        }
    }

        /**
         * Test of loadOrderNumber method, of class OrdersDao.
         */
        @Test
        public void testLoadOrderNumber() throws Exception {
        }

        /**
         * Test of saveWork method, of class OrdersDao.
         */
        @Test
        public void testSaveWork() throws Exception {
        }

        /**
         * Test of getMode method, of class OrdersDao.
         */
        @Test
        public void testGetMode() throws Exception {
            dao.getMode();
            assertEquals(true, dao.getMode());
        }

}
