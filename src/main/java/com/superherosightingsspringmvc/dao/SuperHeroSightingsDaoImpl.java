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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 4oaks
 */
public class SuperHeroSightingsDaoImpl implements SuperHeroSightingsDao {
    
    private static final String SQL_INSERT_SIGHTING
            = "insert into sightings (Date, SuperId, LocationId)"
            + " values (?, ?, ?)";
    
    private static final String SQL_SELECT_SIGHTING
            = "select * from sightings where SightingId = ?";
    
    private static final String SQL_SELECT_ALL_SIGHTINGS
            = "select * from sightings";
    
    private static final String SQL_SELECT_SIGHTINGS_BY_LOCATIONID
            = "select * from sightings where LocationId = ?";
    
    private static final String SQL_SELECT_SIGHTINGS_BY_DATE
            = "select * from sightings where Date = ?";
    
    private static final String SQL_SELECT_LATEST_SIGHTINGS
            = "select * from sightings by date Desc limit 0,10";
    
    private static final String SQL_UPDATE_SIGHTING
            = "update sightings"
            + " set Date = ?, SuperId = ?, LocationId = ?"
            + " where SightingId = ?";
    
    private static final String SQL_DELETE_SIGHTING
            = "delete from sightings where SightingId = ?";
    
    private static final String SQL_DELETE_ALL_SIGHTINGS
            = "delete from sightings";
    
    private static final String SQL_DELETE_SIGHTINGS_BY_SUPERID
            = "delete from sightings where SuperId = ?";
    
    private static final String SQL_DELETE_SIGHTINGS_BY_LOCATIONID
            = "delete from sightings where LocationId = ?";
    
    private static final String SQL_INSERT_SUPER
            = "insert into supers (Name, Description)"
            + " values (?, ?)";
    
    private static final String SQL_SELECT_SUPER
            = "select * from supers where SuperId = ?";
    
    private static final String SQL_SELECT_ALL_SUPERS
            = "select * from supers";
    
    private static final String SQL_UPDATE_SUPER
            = "update supers"
            + " set Name = ?, Description = ?"
            + " where SuperId = ?";
    
    private static final String SQL_DELETE_SUPER
            = "delete from supers where SuperId = ?";
    
    private static final String SQL_DELETE_ALL_SUPERS
            = "delete from supers";
    
    private static final String SQL_INSERT_POWER
            = "insert into powers (Name, Description)"
            + " values (?, ?)";
    
    private static final String SQL_SELECT_POWER
            = "select * from powers where PowerId = ?";
    
    private static final String SQL_SELECT_ALL_POWERS
            = "select * from powers";
    
    private static final String SQL_UPDATE_POWER
            = "update powers"
            + " set Name = ?, Description = ?"
            + " where PowerId = ?";
    
    private static final String SQL_DELETE_POWER
            = "delete from powers where PowerId = ?";
    
    private static final String SQL_DELETE_ALL_POWERS
            = "delete from powers";
    
    private static final String SQL_INSERT_LOCATION
            = "insert into locations (Name, Description, Address, Latitude, Longitude)"
            + " values (?, ?, ?, ?, ?)";
    
    private static final String SQL_SELECT_LOCATION
            = "select * from locations where LocationId = ?";
    
    private static final String SQL_SELECT_ALL_LOCATIONS
            = "select * from locations";
    
    private static final String SQL_SELECT_LOCATIONS_BY_SUPERID
            = "select locations.LocationId, locations.Name, locations.Description, "
            + "locations.Address, locations.Latitude, locations.Longitude "
            + "from sightings "
            + "inner join locations on sightings.LocationId = locations.LocationId "
            + "where sightings.SuperId = ?";
    
    private static final String SQL_UPDATE_LOCATION
            = "update locations"
            + " set Name = ?, Description = ?, Address = ?, Latitude = ?, Longitude = ?"
            + " where LocationId = ?";
    
    private static final String SQL_DELETE_LOCATION
            = "delete from locations where LocationId = ?";
    
    private static final String SQL_DELETE_ALL_LOCATIONS
            = "delete from locations";
    
    private static final String SQL_INSERT_ORGANIZATION
            = "insert into organizations (Name, Description, Address, PhoneNumber)"
            + " values (?, ?, ?, ?)";
    
    private static final String SQL_SELECT_ORGANIZATION
            = "select * from organizations where OrganizationId = ?";
    
    private static final String SQL_SELECT_ALL_ORGANIZATIONS
            = "select * from organizations";
    
    private static final String SQL_UPDATE_ORGANIZATION
            = "update organizations"
            + " set Name = ?, Description = ?, Address = ?, PhoneNumber = ?"
            + " where OrganizationId = ?";
    
    private static final String SQL_DELETE_ORGANIZATION
            = "delete from organizations where OrganizationId = ?";
    
    private static final String SQL_DELETE_ALL_ORGANIZATIONS
            = "delete from organizations";
    
    private static final String SQL_INSERT_SUPER_POWERS
            = "insert into super_powers (SuperId, PowerId)"
            + " values (?, ?)";
    
    private static final String SQL_DELETE_ALL_SUPER_POWERS
            = "delete from super_powers";
    
    private static final String SQL_DELETE_ALL_SUPER_ORGANIZATIONS
            = "delete from super_organizations";
    
    private static final String SQL_INSERT_SUPER_ORGANIZATIONS
            = "insert into super_organizations (SuperId, OrganizationId)"
            + " values (?, ?)";
    
    private static final String SQL_DELETE_SUPER_POWERS_BY_SUPERID
            = "delete from super_powers where superId = ?";
    
    private static final String SQL_DELETE_SUPER_ORGANIZATIONS_BY_SUPERID
            = "delete from super_organizations where superId = ?";
    
    private static final String SQL_DELETE_SUPER_POWERS_BY_POWERID
            = "delete from super_powers where powerId = ?";
    
    private static final String SQL_DELETE_SUPER_ORGANIZATIONS_BY_ORGANIZATIONID
            = "delete from super_organizations where organizationId = ?";
    
    private static final String SQL_SELECT_POWERS_BY_SUPERID
            = "select * from super_powers where SuperId = ?";
    
    private static final String SQL_SELECT_ORGANIZATIONS_BY_SUPERID
            = "select * from super_organizations where SuperId = ?";
    
    private static final String SQL_SELECT_SUPERS_BY_POWERID
            = "select * from super_powers where PowerId = ?";
    
    private static final String SQL_SELECT_SUPERS_BY_ORGANIZATIONID
            = "select * from super_organizations where OrganizationId = ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    //          *** SIGHTING METHODS ***

    @Override
    public void addSighting(Sighting sighting) {
        jdbcTemplate.update(
                SQL_INSERT_SIGHTING, 
                java.sql.Date.valueOf(sighting.getDate()), 
                sighting.getSuperId(), 
                sighting.getLocationId());
        
        int sightingId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        
        sighting.setId(sightingId);
    }
    
    @Override
    public Sighting getSighting(int sightingId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SIGHTING, new SightingMapper(), sightingId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Sighting> getAllSightings() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SIGHTINGS, new SightingMapper());
    }

    @Override
    public void updateSighting(Sighting sighting) {
        jdbcTemplate.update(SQL_UPDATE_SIGHTING, 
                java.sql.Date.valueOf(sighting.getDate()),
                sighting.getSuperId(),
                sighting.getLocationId(),
                sighting.getId());
    }

    @Override
    public void deleteSighting(int sightingId) {
        jdbcTemplate.update(SQL_DELETE_SIGHTING, sightingId);
    }
    
    @Override
    public List<Sighting> getSightingsAtLocation(int locationId) {
        return jdbcTemplate.query(SQL_SELECT_SIGHTINGS_BY_LOCATIONID, new SightingMapper(), locationId);
    }
    
    @Override
    public List<Sighting> getSightingsOnDate(LocalDate date) {
        return jdbcTemplate.query(SQL_SELECT_SIGHTINGS_BY_DATE, new SightingMapper(), java.sql.Date.valueOf(date));
    }
    
    //          *** SUPER METHODS ***
    
    @Override
    public void addSuper(Super superPerson) {
        List<Integer> powerList = superPerson.getPowerIdList();
        List<Integer> organizationList = superPerson.getOrganizationIdList();
        
        jdbcTemplate.update(SQL_INSERT_SUPER, superPerson.getName(), superPerson.getDescription());
        
        int superPersonId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        
        superPerson.setId(superPersonId);
        
        if (powerList != null) {
            for (int powerId : powerList) {
                jdbcTemplate.update(SQL_INSERT_SUPER_POWERS, superPerson.getId(), powerId);
            }
        }
        
        if (organizationList != null) {
            for (int organizationId : superPerson.getOrganizationIdList()) {
                jdbcTemplate.update(SQL_INSERT_SUPER_ORGANIZATIONS, superPerson.getId(), organizationId);
            }
        }    
    }

    @Override
    public Super getSuper(int superId) {
        try {
            Super superPerson = jdbcTemplate.queryForObject(SQL_SELECT_SUPER, new SuperMapper(), superId);
            superPerson.setPowerIdList(jdbcTemplate.query(SQL_SELECT_POWERS_BY_SUPERID, new PowerIdMapper(), superPerson.getId()));
            superPerson.setOrganizationIdList(jdbcTemplate.query(SQL_SELECT_ORGANIZATIONS_BY_SUPERID, new OrganizationIdMapper(), superPerson.getId()));
            return superPerson;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Super> getAllSupers() {
        List<Super> superList = jdbcTemplate.query(SQL_SELECT_ALL_SUPERS, new SuperMapper());
        
        for (Super superPerson : superList) {
            superPerson.setPowerIdList(jdbcTemplate.query(SQL_SELECT_POWERS_BY_SUPERID, new PowerIdMapper(), superPerson.getId()));
            superPerson.setOrganizationIdList(jdbcTemplate.query(SQL_SELECT_ORGANIZATIONS_BY_SUPERID, new OrganizationIdMapper(), superPerson.getId()));
        }
        return superList;
    }

    @Override
    public void updateSuper(Super superPerson) {
        List<Integer> powerIdList = superPerson.getPowerIdList();
        List<Integer> organizationIdList = superPerson.getOrganizationIdList();
        
        jdbcTemplate.update(SQL_UPDATE_SUPER, superPerson.getName(), superPerson.getDescription(), superPerson.getId());
        jdbcTemplate.update(SQL_DELETE_SUPER_POWERS_BY_SUPERID, superPerson.getId());
        jdbcTemplate.update(SQL_DELETE_SUPER_ORGANIZATIONS_BY_SUPERID, superPerson.getId());
        
        if (powerIdList != null) {
            for (int powerId : powerIdList) {
                jdbcTemplate.update(SQL_INSERT_SUPER_POWERS, superPerson.getId(), powerId);
            }
        }
        
        if (organizationIdList != null) {
            for (int organizationId : organizationIdList) {
                jdbcTemplate.update(SQL_INSERT_SUPER_ORGANIZATIONS, superPerson.getId(), organizationId);
            }
        }    
    }

    @Override
    public void deleteSuper(int superId) {
        jdbcTemplate.update(SQL_DELETE_SUPER_POWERS_BY_SUPERID, superId);
        jdbcTemplate.update(SQL_DELETE_SUPER_ORGANIZATIONS_BY_SUPERID, superId);
        jdbcTemplate.update(SQL_DELETE_SIGHTINGS_BY_SUPERID, superId);
        jdbcTemplate.update(SQL_DELETE_SUPER, superId);
    }

    @Override
    public List<Super> getSupersInOrganization(Organization org) {
        List<Integer> superIdList = org.getSuperIdList();
        List<Super> superList = new ArrayList<>();
        
        for (int superId : superIdList) {
            superList.add(getSuper(superId));
        }
        return superList;
    }
    
    //          *** POWER METHODS ***
    
    @Override
    public void addPower(Power power) {
        List<Integer> superList = power.getSuperIdList();
        
        jdbcTemplate.update(SQL_INSERT_POWER, power.getName(), power.getDescription());
        
        int powerId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        
        power.setId(powerId);
        
        if (superList != null) {
            for (int superId : power.getSuperIdList()) {
                jdbcTemplate.update(SQL_INSERT_SUPER_POWERS, superId, power.getId());
            }
        }    
    }

    @Override
    public Power getPower(int powerId) {
        try {
            Power power = jdbcTemplate.queryForObject(SQL_SELECT_POWER, new PowerMapper(), powerId);
            power.setSuperIdList(jdbcTemplate.query(SQL_SELECT_SUPERS_BY_POWERID, new SuperIdMapper(), power.getId()));
            return power;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Power> getAllPowers() {
        List<Power> powerList = jdbcTemplate.query(SQL_SELECT_ALL_POWERS, new PowerMapper());
        
        for (Power power : powerList) {
            power.setSuperIdList(jdbcTemplate.query(SQL_SELECT_SUPERS_BY_POWERID, new SuperIdMapper(), power.getId()));
        }
        return powerList;
    }

    @Override
    public void updatePower(Power power) {
        List<Integer> superIdList = power.getSuperIdList();
        
        jdbcTemplate.update(SQL_UPDATE_POWER, power.getName(), power.getDescription(), power.getId());
        jdbcTemplate.update(SQL_DELETE_SUPER_POWERS_BY_POWERID, power.getId());
        
        if (superIdList != null) {
            for (int superId : superIdList) {
                jdbcTemplate.update(SQL_INSERT_SUPER_POWERS, superId, power.getId());
            }
        }    
    }

    @Override
    public void deletePower(int powerId) {
        jdbcTemplate.update(SQL_DELETE_SUPER_POWERS_BY_POWERID, powerId);
        jdbcTemplate.update(SQL_DELETE_POWER, powerId);
    }
    
    //          *** LOCATION METHODS ***

    @Override
    public void addLocation(Location location) {
        jdbcTemplate.update(SQL_INSERT_LOCATION, location.getName(), location.getDescription(), location.getAddress(), location.getLatitude(), location.getLongitude());
        
        int locationId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        
        location.setId(locationId);
    }

    @Override
    public Location getLocation(int locationId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_LOCATION, new LocationMapper(), locationId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Location> getAllLocations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_LOCATIONS, new LocationMapper());
    }

    @Override
    public void updateLocation(Location location) {
        jdbcTemplate.update(SQL_UPDATE_LOCATION,
                location.getName(),
                location.getDescription(),
                location.getAddress(),
                location.getLatitude(),
                location.getLongitude(),
                location.getId());
    }

    @Override
    public void deleteLocation(int locationId) {
        jdbcTemplate.update(SQL_DELETE_SIGHTINGS_BY_LOCATIONID, locationId);
        jdbcTemplate.update(SQL_DELETE_LOCATION, locationId);
    }
    
    @Override
    public List<Location> getLocationsOfSuper(int superId) {
        return jdbcTemplate.query(SQL_SELECT_LOCATIONS_BY_SUPERID, new LocationMapper(), superId);
    }
    
    //          *** ORGANIZATION METHODS ***

    @Override
    public void addOrganization(Organization organization) {
        List<Integer> superList = organization.getSuperIdList();
        
        jdbcTemplate.update(SQL_INSERT_ORGANIZATION, organization.getName(), organization.getDescription(), organization.getAddress(), organization.getPhoneNumber());
        
        int organizationId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        
        organization.setId(organizationId);
        
        if (superList != null) {
            for (int superId : organization.getSuperIdList()) {
                jdbcTemplate.update(SQL_INSERT_SUPER_ORGANIZATIONS, superId, organization.getId());
            }
        }    
    }

    @Override
    public Organization getOrganization(int organizationId) {
        try {
            Organization organization = jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATION, new OrganizationMapper(), organizationId);
            organization.setSuperIdList(jdbcTemplate.query(SQL_SELECT_SUPERS_BY_ORGANIZATIONID, new SuperIdMapper(), organization.getId()));
            return organization;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Organization> getAllOrganizations() {
        List<Organization> organizationList = jdbcTemplate.query(SQL_SELECT_ALL_ORGANIZATIONS, new OrganizationMapper());
        
        for (Organization organization : organizationList) {
            organization.setSuperIdList(jdbcTemplate.query(SQL_SELECT_SUPERS_BY_ORGANIZATIONID, new SuperIdMapper(), organization.getId()));
        }
        return organizationList;
    }

    @Override
    public void updateOrganization(Organization organization) {
        List<Integer> superIdList = organization.getSuperIdList();
        
        jdbcTemplate.update(SQL_UPDATE_ORGANIZATION,
                organization.getName(),
                organization.getDescription(),
                organization.getAddress(),
                organization.getPhoneNumber(),
                organization.getId());
        jdbcTemplate.update(SQL_DELETE_SUPER_ORGANIZATIONS_BY_ORGANIZATIONID, organization.getId());
        
        if (superIdList != null) {
            for (int superId : superIdList) {
                jdbcTemplate.update(SQL_INSERT_SUPER_ORGANIZATIONS, superId, organization.getId());
            }
        }    
    }

    @Override
    public void deleteOrganization(int organizationId) {
        jdbcTemplate.update(SQL_DELETE_SUPER_ORGANIZATIONS_BY_ORGANIZATIONID, organizationId);
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION, organizationId);
    }
    
    @Override
    public List<Organization> getOrganizationsBySuper(Super superPerson) {
        List<Integer> orgIdList = superPerson.getOrganizationIdList();
        List<Organization> orgList = new ArrayList<>();
        for (int orgId : orgIdList) {
            orgList.add(getOrganization(orgId));
        }
        return orgList;
    }
    
    public void resetDatabase() {
        jdbcTemplate.update(SQL_DELETE_ALL_SIGHTINGS);
        jdbcTemplate.update(SQL_DELETE_ALL_SUPER_POWERS);
        jdbcTemplate.update(SQL_DELETE_ALL_SUPER_ORGANIZATIONS);
        jdbcTemplate.update(SQL_DELETE_ALL_SUPERS);
        jdbcTemplate.update(SQL_DELETE_ALL_POWERS);
        jdbcTemplate.update(SQL_DELETE_ALL_LOCATIONS);
        jdbcTemplate.update(SQL_DELETE_ALL_ORGANIZATIONS);
    }

    @Override
    public List<Sighting> getLatestSightings() {
        return new ArrayList<>();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //          *** MAPPER CLASSES ***
    
    private static final class SightingMapper implements RowMapper<Sighting> {
        
        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting sighting = new Sighting();
            sighting.setId(rs.getInt("SightingId"));
            sighting.setDate(rs.getTimestamp("Date").toLocalDateTime().toLocalDate());
            sighting.setSuperId(rs.getInt("superId"));
            sighting.setLocationId(rs.getInt("locationId"));
            return sighting;
        }
    }
    
    private static final class SuperMapper implements RowMapper<Super> {
        
        @Override
        public Super mapRow(ResultSet rs, int i) throws SQLException {
            Super superPerson = new Super();
            superPerson.setId(rs.getInt("SuperId"));
            superPerson.setName(rs.getString("Name"));
            superPerson.setDescription(rs.getString("Description"));
            return superPerson;
        }
    }
    
    private static final class PowerMapper implements RowMapper<Power> {
        
        @Override
        public Power mapRow(ResultSet rs, int i) throws SQLException {
            Power power = new Power();
            power.setId(rs.getInt("PowerId"));
            power.setName(rs.getString("Name"));
            power.setDescription(rs.getString("Description"));
            return power;
        }
    }
    
    private static final class LocationMapper implements RowMapper<Location> {
        
        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location location = new Location();
            location.setId(rs.getInt("LocationId"));
            location.setName(rs.getString("Name"));
            location.setDescription(rs.getString("Description"));
            location.setAddress(rs.getString("Address"));
            location.setLatitude(rs.getDouble("Latitude"));
            location.setLongitude(rs.getDouble("Longitude"));
            return location;
        }
    }
    
    private static final class OrganizationMapper implements RowMapper<Organization> {
        
        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization organization = new Organization();
            organization.setId(rs.getInt("OrganizationId"));
            organization.setName(rs.getString("Name"));
            organization.setDescription(rs.getString("Description"));
            organization.setAddress(rs.getString("Address"));
            organization.setPhoneNumber(rs.getString("PhoneNumber"));
            return organization;
        } 
    }
    
    private static final class PowerIdMapper implements RowMapper<Integer> {
        
        @Override
        public Integer mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getInt("PowerId");
        }
    }
    
    private static final class OrganizationIdMapper implements RowMapper<Integer> {
        
        @Override
        public Integer mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getInt("OrganizationId");
        }
    }
    
    private static final class SuperIdMapper implements RowMapper<Integer> {
        
        @Override
        public Integer mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getInt("SuperId");
        }
    }
  
}
