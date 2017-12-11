/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dto;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Organization {
    private int organizationId;
    private String organizationName;
    private String description;
    private String address;
    private String state;
    private String zipCode;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getDescription() {
        return description;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.organizationId;
        hash = 79 * hash + Objects.hashCode(this.organizationName);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + Objects.hashCode(this.address);
        hash = 79 * hash + Objects.hashCode(this.state);
        hash = 79 * hash + Objects.hashCode(this.zipCode);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Organization other = (Organization) obj;
        if (this.organizationId != other.organizationId) {
            return false;
        }
        if (!Objects.equals(this.organizationName, other.organizationName)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.zipCode, other.zipCode)) {
            return false;
        }
        return true;
    }
    
    
    
}
