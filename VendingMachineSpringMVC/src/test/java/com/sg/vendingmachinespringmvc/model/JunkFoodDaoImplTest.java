/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.util.List;
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
public class JunkFoodDaoImplTest {
    
    public JunkFoodDaoImplTest() {
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
     * Test of getJunkFoodById method, of class JunkFoodDaoImpl.
     */
    @Test
    public void testGetJunkFoodById() {
        JunkFoodDaoImpl instance = new JunkFoodDaoImpl();
        JunkFood junkFood = instance.getJunkFoodById(1);
        assertEquals("Snickers", junkFood.getName());
        JunkFood junkFood2 = instance.getJunkFoodById(1000000);
        assertTrue(junkFood2 == null);
    }

    /**
     * Test of getJunkFood method, of class JunkFoodDaoImpl.
     */
    @Test
    public void testGetJunkFood() {
        JunkFoodDaoImpl instance = new JunkFoodDaoImpl();
        List<JunkFood> junk = instance.getJunkFood();
        assertTrue(junk.size() == 9);
    }
    
}
