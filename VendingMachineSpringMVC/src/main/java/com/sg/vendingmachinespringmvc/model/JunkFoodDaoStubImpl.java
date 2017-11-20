/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class JunkFoodDaoStubImpl extends JunkFoodDaoImpl{
    public JunkFoodDaoStubImpl() {
        junk = new HashMap<>();
        junk.put(1, new JunkFood(1,"Snickers",new BigDecimal("1.85"),1));
        junk.put(2, new JunkFood(2,"M & Ms",new BigDecimal("1.50"),9));
        junk.put(3, new JunkFood(3,"Pringles",new BigDecimal("2.10"),2));
        junk.put(4, new JunkFood(4,"Reese's",new BigDecimal("1.85"),5));
        junk.put(5, new JunkFood(5,"Pretzels",new BigDecimal("1.25"),4));
        junk.put(6, new JunkFood(6,"Twinkies",new BigDecimal("1.95"),0));
        junk.put(7, new JunkFood(7,"Doritos",new BigDecimal("1.75"),3));
        junk.put(8, new JunkFood(8,"Almond Joy",new BigDecimal("1.85"),11));
        junk.put(9, new JunkFood(9,"Trident",new BigDecimal("1.95"),1));        
    }
}
