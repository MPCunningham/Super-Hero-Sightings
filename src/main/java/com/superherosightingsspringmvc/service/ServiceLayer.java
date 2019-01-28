/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superherosightingsspringmvc.service;

import com.superherosightingsspringmvc.dto.Location;
import com.superherosightingsspringmvc.dto.Organization;
import com.superherosightingsspringmvc.dto.Power;
import com.superherosightingsspringmvc.dto.Sighting;
import com.superherosightingsspringmvc.dto.Super;
import java.util.List;

/**
 *
 * @author 4oaks
 */
public interface ServiceLayer {
    
    public List<Location> getAllLocations();
    
    public List<Power> getAllPowers();
    
    public List<Organization> getAllOrganizations();
    
    public List<Super> getAllSupers();
    
    public List<Sighting> getAllSightings();

    public void addLocation(Location location);
    
    public void addPower(Power power);
    
    public void addOrganization(Organization org);
    
    public void addSuper(Super superPerson);
    
    public void addSighting(Sighting sighting);

    public Location getLocation(int locationId);
    
    public Organization getOrganization(int orgId);
    
    public Power getPower(int powerId);
    
    public Super getSuper(int superId);
    
    public Sighting getSighting(int sightingId);

    public void deleteLocation(int locationId);
    
    public void deleteOrganization(int orgId);
    
    public void deletePower(int powerId);
    
    public void deleteSuper(int superId);
    
    public void deleteSighting(int sightingId);

    public void updateLocation(Location location);
    
    public void updateOrganization(Organization org);
    
    public void updatePower(Power power);
    
    public void updateSuper(Super superPerson);
    
    public void updateSighting(Sighting sighting);

    public List<Sighting> getLatestSightings();
    
}
