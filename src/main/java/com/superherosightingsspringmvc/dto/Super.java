/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superherosightingsspringmvc.dto;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author 4oaks
 */
public class Super {
    
    private int id;
    private String name;
    private String description;
    private List<Integer> powerIdList;
    private List<Integer> organizationIdList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getPowerIdList() {
        return powerIdList;
    }

    public void setPowerIdList(List<Integer> powerIdList) {
        this.powerIdList = powerIdList;
    }

    public List<Integer> getOrganizationIdList() {
        return organizationIdList;
    }

    public void setOrganizationIdList(List<Integer> organizationIdList) {
        this.organizationIdList = organizationIdList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.description);
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
        final Super other = (Super) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
      
}
