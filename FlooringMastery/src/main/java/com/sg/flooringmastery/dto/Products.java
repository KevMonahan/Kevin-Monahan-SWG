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
public class Products {

    private String productType;
    private BigDecimal costPerSqFt;
    private BigDecimal laborCostPerSqFt;

    
    public Products(String productType) {
        this.productType = productType;
    }
    /**
     * @return the ProductType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the ProductType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the CostPerSqFt
     */
    public BigDecimal getCostPerSqFt() {
        return costPerSqFt;
    }

    /**
     * @param costPerSqFt the costPerSqFt to set
     */
    public void setCostPerSqFt(BigDecimal costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    /**
     * @return the laborCostPerSqFt
     */
    public BigDecimal getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }

    /**
     * @param laborCostPerSqFt the LaborCostPerSqFt to set
     */
    public void setLaborCostPerSqFt(BigDecimal laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }
}
