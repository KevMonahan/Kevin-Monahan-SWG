/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author user
 */
public class JunkFoodDaoImpl implements JunkFoodDao {
    HashMap<Integer,JunkFood> junk;
    
    public JunkFoodDaoImpl() {
        junk = new HashMap<>();
        junk.put(1, new JunkFood(1,"Snickers",new BigDecimal("1.85"),30));
        junk.put(2, new JunkFood(2,"M & Ms",new BigDecimal("1.50"),18));
        junk.put(3, new JunkFood(3,"Pringles",new BigDecimal("2.10"),20));
        junk.put(4, new JunkFood(4,"Reese's",new BigDecimal("1.85"),15));
        junk.put(5, new JunkFood(5,"Pretzels",new BigDecimal("1.25"),24));
        junk.put(6, new JunkFood(6,"Twinkies",new BigDecimal("1.95"),10));
        junk.put(7, new JunkFood(7,"Doritos",new BigDecimal("1.75"),0));
        junk.put(8, new JunkFood(8,"Almond Joy",new BigDecimal("1.85"),12));
        junk.put(9, new JunkFood(9,"Trident",new BigDecimal("1.95"),11));        
    }

    @Override
    public JunkFood getJunkFoodById(int id) {
        return junk.get(id);
    }

    @Override
    public List<JunkFood> getJunkFood() {
        return new ArrayList<>(junk.values());
    }
    
}
