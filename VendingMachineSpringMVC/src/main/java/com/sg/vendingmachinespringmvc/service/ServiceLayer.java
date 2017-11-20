/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.model.JunkFood;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author user
 */
public interface ServiceLayer {
    public void addMoney(String amount);
    
    public void makePurchase();
    
    public void changeReturn();

    BigDecimal getWallet();

    String getMessage();

    Change getCurrentChange();

    int getSelection();

    JunkFood getJunkFoodById(int id);

    List<JunkFood> getJunkFood();

    void setWallet(BigDecimal balance);

    void setMessage(String message);

    void setCurrentChange(Change change);

    void setSelection(int Selection);
}
