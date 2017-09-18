/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingMachineItems;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author user
 */
public class VendingMachineDaoImplTest {
    
    private static VendingMachineDao dao = new VendingMachineDaoImpl();
    
    public VendingMachineDaoImplTest() {
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
     * Test of listItem method, of class VendingMachineDaoImpl.
     */
    @Test
    public void testListItem() throws Exception {
        
        VendingMachineItems item = new VendingMachineItems("A1");
        item.setItemName("Candy");
        item.setItemPrice(new BigDecimal("1.50"));
        item.setItemQuantity(5);
        
        VendingMachineItems item2 = new VendingMachineItems("A2");
        item2.setItemName("Chips");
        item2.setItemPrice(new BigDecimal("1.75"));
        item2.setItemQuantity(10);
        
        assertEquals(2, dao.listItem().size());
        
        
    }

    /**
     * Test of getItems method, of class VendingMachineDaoImpl.
     */
    @Test
    public void testGetItems() throws Exception {
        
        VendingMachineItems item = new VendingMachineItems("A1");
        item.setItemName("Candy");
        item.setItemPrice(new BigDecimal("1.50"));
        item.setItemQuantity(5);
        
        
        VendingMachineItems fromDao = dao.getItems("A1");
        
        assertEquals(item, fromDao);
    }
    
}
