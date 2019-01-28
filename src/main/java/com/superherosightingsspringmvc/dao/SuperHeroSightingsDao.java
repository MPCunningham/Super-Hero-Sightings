/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superherosightingsspringmvc.dao;

import com.superherosightingsspringmvc.dto.Location;
import com.superherosightingsspringmvc.dto.Organization;
import com.superherosightingsspringmvc.dto.Power;
import com.superherosightingsspringmvc.dto.Sighting;
import com.superherosightingsspringmvc.dto.Super;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author 4oaks
 */
public interface SuperHeroSightingsDao {
    
    public void addSighting(Sighting sighting);
    
    public Sighting getSighting(int sightingId);
    
    public List<Sighting> getAllSightings();
    
    public void updateSighting(Sighting sighting);
    
    public void deleteSighting(int sightingId);
    
    public List<Sighting> getSightingsAtLocation(int locationId);
    
    public List<Sighting> getSightingsOnDate(LocalDate date);
    
    public void addSuper(Super superPerson);
    
    public Super getSuper(int superId);
    
    public List<Super> getAllSupers();
    
    public void updateSuper(Super superPerson);
    
    public void deleteSuper(int superId);
    
    public List<Super> getSupersInOrganization(Organization org);
    
    public void addPower(Power power);
    
    public Power getPower(int powerId);
    
    public List<Power> getAllPowers();
    
    public void updatePower(Power power);
    
    public void deletePower(int powerId);
    
    public void addLocation(Location location);
    
    public Location getLocation(int locationId);
    
    public List<Location> getAllLocations();
    
    public void updateLocation(Location location);
    
    public void deleteLocation(int locationId);
    
    public List<Location> getLocationsOfSuper(int superId);
    
    public void addOrganization(Organization organization);
    
    public Organization getOrganization(int organizationId);
    
    public List<Organization> getAllOrganizations();
    
    public void updateOrganization(Organization organization);
    
    public void deleteOrganization(int organizationId);
    
    public List<Organization> getOrganizationsBySuper(Super superPerson);
    
    public void resetDatabase();

    public List<Sighting> getLatestSightings();
       
}
