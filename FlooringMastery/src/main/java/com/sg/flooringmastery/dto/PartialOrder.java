/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

import java.math.BigDecimal;

/**
 *
 * @author user
 */
public class PartialOrder {
    private String customerName;
    private String orderState;
    private String productType;
    private BigDecimal area;
    
    public PartialOrder(String customerName, String orderState, String productType, BigDecimal area) {
        this.customerName = customerName;
        this.orderState = orderState;
        this.productType = productType;
        this.area = area;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the orderState
     */
    public String getOrderState() {
        return orderState;
    }

    /**
     * @param orderState the orderState to set
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the area
     */
    public BigDecimal getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(BigDecimal area) {
        this.area = area;
    }
}
