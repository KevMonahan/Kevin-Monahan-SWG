/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
/**
 *
 * @author user
 */
public class Sightings {
    private int sightingId;
    private Location sightingLocation;
    private List<Hero> herosSighted;
    private LocalDate dateSighted;

    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
    }

    public void setSightingLocation(Location sightingLocation) {
        this.sightingLocation = sightingLocation;
    }

    public void setHerosSighted(List<Hero> herosSighted) {
        this.herosSighted = herosSighted;
    }

    public void setDateSighted(LocalDate dateSighted) {
        this.dateSighted = dateSighted;
    }

    public int getSightingId() {
        return sightingId;
    }

    public Location getSightingLocation() {
        return sightingLocation;
    }

    public List<Hero> getHerosSighted() {
        return herosSighted;
    }

    public LocalDate getDateSighted() {
        return dateSighted;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.sightingId;
        hash = 79 * hash + Objects.hashCode(this.sightingLocation);
        hash = 79 * hash + Objects.hashCode(this.herosSighted);
        hash = 79 * hash + Objects.hashCode(this.dateSighted);
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
        final Sightings other = (Sightings) obj;
        if (this.sightingId != other.sightingId) {
            return false;
        }
        if (!Objects.equals(this.sightingLocation, other.sightingLocation)) {
            return false;
        }
        if (!Objects.equals(this.herosSighted, other.herosSighted)) {
            return false;
        }
        if (!Objects.equals(this.dateSighted, other.dateSighted)) {
            return false;
        }
        return true;
    }
    
}
