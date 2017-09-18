/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.sg.vendingmachine.dto.VendingMachineChange;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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
    BigDecimal totalStoredAmount;
    BigDecimal change;
    BigDecimal currencyLeftOver;
    BigDecimal currentAmount;

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
        try {
            service.getItem("A2");
            fail("expected InsufficientQuantityException to be thrown.");
        } catch (InsufficientQuantityException e) {

        }
    }
    
    @Test
    public void testGetItemPasses() throws Exception {
        try {
            service.getItem("A1");
        } catch (InsufficientQuantityException e) {
            
        }
    }

    /**
     * Test of getChange method, of class VendingMachineServiceLayer.
     */
//    @Test
//    public void testGetChange() throws Exception {
//        VendingMachineItems currentItem = new VendingMachineItems("A1");
//        VendingMachineInsertedMoney totalStoredAmount;
//        service.getChange(currentItem);  
//    }
    /**
     * Test of calculateCoins method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testCalculateCoins() throws Exception {
        VendingMachineChange coinsReturned = service.calculateCoins(new BigDecimal("1.94"));
        assertTrue(coinsReturned.getDollars() == 1 && coinsReturned.getQuarters() == 3
                && coinsReturned.getDimes() == 1 && coinsReturned.getNickels() == 1
                && coinsReturned.getPennies() == 4);
    }

    /**
     * Test of insertedMoney method, of class VendingMachineServiceLayer.
     *
     */
    @Test
    public void testInsertedMoney() {
        currentAmount = new BigDecimal("1.00");
        service.insertedMoney(currentAmount);
        assertEquals(new BigDecimal("1.00"), service.getTotalStoredAmount());     
    }

}
