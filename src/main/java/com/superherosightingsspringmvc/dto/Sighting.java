/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superherosightingsspringmvc.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author 4oaks
 */
public class Sighting {
    
    private int id;
    private  LocalDate date;
    private int superId;
    private int locationId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getSuperId() {
        return superId;
    }

    public void setSuperId(int superId) {
        this.superId = superId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.date);
        hash = 83 * hash + this.superId;
        hash = 83 * hash + this.locationId;
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
        final Sighting other = (Sighting) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.superId != other.superId) {
            return false;
        }
        if (this.locationId != other.locationId) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
    
}
