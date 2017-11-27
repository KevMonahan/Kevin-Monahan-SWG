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
        
        assertEquals(3, dao.listItem().size());
        
        
    }

    /**
     * Test of getItems method, of class VendingMachineDaoImpl.
     */
    @Test
    public void testGetItems() throws Exception {
        VendingMachineItems fromfile = dao.getItems("A1");
        assertEquals("Twinkie", fromfile.getItemName());
        assertEquals(new BigDecimal("1.50"), fromfile.getItemPrice());
        assertEquals(30, fromfile.getItemQuantity());
        
    }
    
}
