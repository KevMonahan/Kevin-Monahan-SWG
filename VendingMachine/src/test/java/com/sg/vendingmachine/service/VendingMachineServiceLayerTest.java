/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.sg.vendingmachine.dto.VendingMachineChange;
import com.sg.vendingmachine.dto.VendingMachineItems;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author user
 */
public class VendingMachineServiceLayerTest {
    private VendingMachineServiceLayer service;
    BigDecimal totalStoredAmount = new BigDecimal("5.00");
    BigDecimal change;
    BigDecimal currencyLeftOver;
    BigDecimal currentAmount = new BigDecimal("2.50");
    
    public VendingMachineServiceLayerTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        
        service = new VendingMachineServiceImpl(dao);
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
     * Test of getAllItems method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetAllItems() throws Exception {
        assertEquals(2, service.getAllItems().size());
    }

    /**
     * Test of getItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetItem() throws Exception {
        VendingMachineItems item = service.getItem("A1");
        assertNotNull(item);
        item = service.getItem("A20");
        assertNull(item);
    }

    /**
     * Test of getChange method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetChange() throws Exception {
        VendingMachineItems item = service.getItem("A1");
        BigDecimal bd = item.getItemPrice();
        if(totalStoredAmount.compareTo(bd) >= 0) {
        change = totalStoredAmount.subtract(bd);
        assertNull(change);
        } else {
            fail("Insufficient funds exception expected!");
        }
    }

    /**
     * Test of calculateCoins method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testCalculateCoins() throws Exception {
        int dollars = change.divideToIntegralValue(BigDecimal.ONE).intValueExact();
        currencyLeftOver = change.remainder(BigDecimal.ONE);
        int quarters = currencyLeftOver.divideToIntegralValue(new BigDecimal("0.25")).intValueExact();
        currencyLeftOver = currencyLeftOver.remainder(new BigDecimal("0.25"));
        int dimes = currencyLeftOver.divideToIntegralValue(new BigDecimal("0.10")).intValueExact();
        currencyLeftOver = currencyLeftOver.remainder(new BigDecimal("0.10"));
        int nickels = currencyLeftOver.divideToIntegralValue(new BigDecimal("0.05")).intValueExact();
        currencyLeftOver = currencyLeftOver.remainder(new BigDecimal("0.05"));
        int pennies = currencyLeftOver.divideToIntegralValue(new BigDecimal("0.01")).intValueExact();
        currencyLeftOver = currencyLeftOver.remainder(new BigDecimal("0.01"));
        
        VendingMachineChange coinsReturned = new VendingMachineChange(dollars, quarters, dimes, nickels, pennies);
        assertNull(coinsReturned);
    }

    /**
     * Test of insertedMoney method, of class VendingMachineServiceLayer.
     * @param currentAmount
     */
    @Test
    public void testInsertedMoney() {
        this.totalStoredAmount = totalStoredAmount.add(currentAmount);
        assertTrue(totalStoredAmount);
        
    }

}