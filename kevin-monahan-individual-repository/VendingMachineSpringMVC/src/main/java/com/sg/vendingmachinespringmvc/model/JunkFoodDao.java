/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.util.List;

/**
 *
 * @author user
 */
public interface JunkFoodDao {
    public JunkFood getJunkFoodById(int id);
    public List<JunkFood> getJunkFood();
}
