/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Location {

    private int locationId;
    private String locationName;
    private String address;
    private String state;
    private String zipCode;
    private String locationDescription;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private List<Sightings> sightings;

    public void setState(String state) {
        this.state = state;
    }

    public Location(String locationName, String address, String state, String zipCode, String locationDescription, BigDecimal latitude, BigDecimal longitude) {
        if (locationName != null && locationName.trim().length() > 0) {
            this.locationName = locationName;
        }
        if (address != null && address.trim().length() > 0) {
            this.address = address;
        }
        if (state != null && state.trim().length() > 0) {
            this.state = state;
        }
        if (zipCode != null && zipCode.trim().length() > 0) {

            this.zipCode = zipCode;
        }
        if (locationDescription != null && locationDescription.trim().length() > 0) {
            this.locationDescription = locationDescription;
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public Location() {
        
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setSightings(List<Sightings> sightings) {
        this.sightings = sightings;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public List<Sightings> getSightings() {
        return sightings;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getAddress() {
        return address;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.locationId;
        hash = 73 * hash + Objects.hashCode(this.locationName);
        hash = 73 * hash + Objects.hashCode(this.address);
        hash = 73 * hash + Objects.hashCode(this.state);
        hash = 73 * hash + Objects.hashCode(this.zipCode);
        hash = 73 * hash + Objects.hashCode(this.locationDescription);
        hash = 73 * hash + Objects.hashCode(this.latitude);
        hash = 73 * hash + Objects.hashCode(this.longitude);
        hash = 73 * hash + Objects.hashCode(this.sightings);
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
        final Location other = (Location) obj;
        if (this.locationId != other.locationId) {
            return false;
        }
        if (!Objects.equals(this.locationName, other.locationName)) {
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
        if (!Objects.equals(this.locationDescription, other.locationDescription)) {
            return false;
        }
        if (!Objects.equals(this.latitude, other.latitude)) {
            return false;
        }
        if (!Objects.equals(this.longitude, other.longitude)) {
            return false;
        }
        if (!Objects.equals(this.sightings, other.sightings)) {
            return false;
        }
        return true;
    }

}
