/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superherosightingsspringmvc.service;

import com.superherosightingsspringmvc.dao.SuperHeroSightingsDao;
import com.superherosightingsspringmvc.dto.Location;
import com.superherosightingsspringmvc.dto.Organization;
import com.superherosightingsspringmvc.dto.Power;
import com.superherosightingsspringmvc.dto.Sighting;
import com.superherosightingsspringmvc.dto.Super;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author 4oaks
 */
@Service
public class ServiceLayerImpl implements ServiceLayer {
    
    SuperHeroSightingsDao dao;
    
    @Inject
    public ServiceLayerImpl(SuperHeroSightingsDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Location> getAllLocations() {
        return dao.getAllLocations();
    }

    @Override
    public List<Power> getAllPowers() {
        return dao.getAllPowers();
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return dao.getAllOrganizations();
    }

    @Override
    public List<Super> getAllSupers() {
        return dao.getAllSupers();
    }

    @Override
    public List<Sighting> getAllSightings() {
        return dao.getAllSightings();
    }

    @Override
    public void addLocation(Location location) {
        dao.addLocation(location);
    }

    @Override
    public void addPower(Power power) {
        dao.addPower(power);
    }

    @Override
    public void addOrganization(Organization org) {
        dao.addOrganization(org);
    }

    @Override
    public void addSuper(Super superPerson) {
        dao.addSuper(superPerson);
    }

    @Override
    public void addSighting(Sighting sighting) {
        dao.addSighting(sighting);
    }

    @Override
    public Location getLocation(int locationId) {
        return dao.getLocation(locationId);
    }

    @Override
    public Organization getOrganization(int orgId) {
        return dao.getOrganization(orgId);
    }

    @Override
    public Power getPower(int powerId) {
        return dao.getPower(powerId);
    }

    @Override
    public Super getSuper(int superId) {
        return dao.getSuper(superId);
    }

    @Override
    public Sighting getSighting(int sightingId) {
        return dao.getSighting(sightingId);
    }

    @Override
    public void deleteLocation(int locationId) {
        dao.deleteLocation(locationId);
    }

    @Override
    public void deleteOrganization(int orgId) {
        dao.deleteOrganization(orgId);
    }

    @Override
    public void deletePower(int powerId) {
        dao.deletePower(powerId);
    }

    @Override
    public void deleteSuper(int superId) {
        dao.deleteSuper(superId);
    }

    @Override
    public void deleteSighting(int sightingId) {
        dao.deleteSighting(sightingId);
    }

    @Override
    public void updateLocation(Location location) {
        dao.updateLocation(location);
    }

    @Override
    public void updateOrganization(Organization org) {
        dao.updateOrganization(org);
    }

    @Override
    public void updatePower(Power power) {
        dao.updatePower(power);
    }

    @Override
    public void updateSuper(Super superPerson) {
        dao.updateSuper(superPerson);
    }

    @Override
    public void updateSighting(Sighting sighting) {
        dao.updateSighting(sighting);
    }

    @Override
    public List<Sighting> getLatestSightings() {
        return dao.getLatestSightings();
    }
    
}
