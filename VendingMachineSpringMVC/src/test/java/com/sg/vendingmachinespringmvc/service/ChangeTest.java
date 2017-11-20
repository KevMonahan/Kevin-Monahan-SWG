/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

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
public class ChangeTest {
    Change change = new Change(new BigDecimal("4.49"));
    public ChangeTest() {
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
     * Test of getQuarters method, of class Change.
     */
    @Test
    public void testGetQuarters() {
        assertEquals(17, change.getQuarters());
    }

    /**
     * Test of getDimes method, of class Change.
     */
    @Test
    public void testGetDimes() {
        assertEquals(2, change.getDimes());
    }

    /**
     * Test of getNickels method, of class Change.
     */
    @Test
    public void testGetNickels() {
        assertEquals(0, change.getNickels());
    }

    /**
     * Test of getPennies method, of class Change.
     */
    @Test
    public void testGetPennies() {
        assertEquals(4, change.getPennies());
    }
    
}
