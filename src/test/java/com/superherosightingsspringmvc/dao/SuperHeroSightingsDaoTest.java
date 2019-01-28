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
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author 4oaks
 */
public class SuperHeroSightingsDaoTest {
    
    SuperHeroSightingsDao dao;
    int locationId;
    int superId;
    int sightingId;
    int powerId;
    int orgId;
    
    public SuperHeroSightingsDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        dao = ctx.getBean("SuperHeroSightingsDao", SuperHeroSightingsDao.class);
        
        dao.resetDatabase();
        
        Location location = new Location();
        location.setName("Park");
        location.setDescription("A Park");
        location.setAddress("123 Park Ave");
        location.setLatitude(1.1);
        location.setLongitude(2.2);
        dao.addLocation(location);
        locationId = location.getId();
        
        Power power = new Power();
        power.setName("Super Strength");
        power.setDescription("Really Strong");
        List<Integer> superIdList1 = new ArrayList<>();
        Super superTest1 = new Super();
        superTest1.setName("SuperMan");
        superTest1.setDescription("SuperHero");
        dao.addSuper(superTest1);
        superId = superTest1.getId();
        superIdList1.add(superId);
        power.setSuperIdList(superIdList1);
        dao.addPower(power);
        powerId = power.getId();
        dao.deleteSuper(superId);
        
        Organization org = new Organization();
        org.setName("X-Men");
        org.setDescription("Mutants");
        org.setAddress("123 X-Men Way");
        org.setPhoneNumber("555-5555");
        List<Integer> superIdList2 = new ArrayList<>();
        Super superTest2 = new Super();
        superTest2.setName("SuperMan");
        superTest2.setDescription("SuperHero");
        dao.addSuper(superTest2);
        superId = superTest2.getId();
        superIdList2.add(superId);
        org.setSuperIdList(superIdList2);
        dao.addOrganization(org);
        orgId = org.getId();
        dao.deleteSuper(superId);
        
        Super superPerson = new Super();
        superPerson.setName("SuperMan");
        superPerson.setDescription("SuperHero");
        List<Integer> orgIdList = new ArrayList<>();
        List<Integer> powerIdList = new ArrayList<>();
        orgIdList.add(orgId);
        powerIdList.add(powerId);
        superPerson.setOrganizationIdList(orgIdList);
        superPerson.setPowerIdList(powerIdList);
        dao.addSuper(superPerson);
        superId = superPerson.getId();
    
        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.of(2010, 01, 01));
        sighting.setLocationId(locationId);
        sighting.setSuperId(superId);
        dao.addSighting(sighting);
        sightingId = sighting.getId();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addSighting method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testAddGetSighting() {        
        
        Sighting test = dao.getSighting(sightingId);
        
        assertEquals(java.time.LocalDate.parse("2010-01-01"), test.getDate());
        assertEquals(superId, test.getSuperId());
        assertEquals(locationId, test.getLocationId());
    
    }

    /**
     * Test of getAllSightings method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testGetAllSightings() {
        
        List<Sighting> sightingList = dao.getAllSightings();
        
        assertEquals(1, sightingList.size());
        
        Sighting test = sightingList.get(0);
        
        assertEquals(java.time.LocalDate.parse("2010-01-01"), test.getDate());
        assertEquals(superId, test.getSuperId());
        assertEquals(locationId, test.getLocationId());
    }

    /**
     * Test of updateSighting method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testUpdateSighting() {
        
        Sighting test = dao.getSighting(sightingId);
        
        test.setDate(LocalDate.of(2011, 01, 01));
        
        dao.updateSighting(test);
        
        test = dao.getSighting(sightingId);
        
        LocalDate testDate = LocalDate.of(2011, 01, 01);
        
        assertEquals(testDate, test.getDate()); 
        assertEquals(superId, test.getSuperId());
        assertEquals(locationId, test.getLocationId());
   
    }

    /**
     * Test of deleteSighting method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testDeleteSighting() {
        
        dao.deleteSighting(sightingId);
        
        Sighting test = dao.getSighting(sightingId);
        
        assertNull(test);
    }

    /**
     * Test of getSightingsAtLocation method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testGetSightingsAtLocation() {
        List<Sighting> sightingList = dao.getSightingsAtLocation(locationId);
        
        assertEquals(1, sightingList.size());
        
        Sighting test = sightingList.get(0);
        
        LocalDate testDate = LocalDate.of(2010, 01, 01);
        
        assertEquals(testDate, test.getDate()); 
        assertEquals(superId, test.getSuperId());
        assertEquals(locationId, test.getLocationId());
    }

    /**
     * Test of getSightingsOnDate method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testGetSightingsOnDate() {
        LocalDate testDate = LocalDate.of(2010, 01, 01);
        
        List<Sighting> sightingList = dao.getSightingsOnDate(testDate);
        
        assertEquals(1, sightingList.size());
        
        Sighting test = sightingList.get(0);
        
        assertEquals(testDate, test.getDate()); 
        assertEquals(superId, test.getSuperId());
        assertEquals(locationId, test.getLocationId());
    }

    /**
     * Test of addSuper method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testAddGetSuper() {
        Super test = dao.getSuper(superId);
        
        assertEquals("SuperMan", test.getName());
        assertEquals("SuperHero", test.getDescription());
        assertEquals(1, test.getOrganizationIdList().size());
        assertEquals(1, test.getPowerIdList().size());
        
        powerId = test.getPowerIdList().get(0);
        Power power = dao.getPower(powerId);
        assertEquals("Super Strength", power.getName());
        assertEquals("Really Strong", power.getDescription());
        
        orgId = test.getOrganizationIdList().get(0);
        Organization org = dao.getOrganization(orgId);
        assertEquals("X-Men", org.getName());
        assertEquals("Mutants", org.getDescription());
        assertEquals("123 X-Men Way", org.getAddress());
        assertEquals("555-5555", org.getPhoneNumber());
    }

    /**
     * Test of getAllSupers method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testGetAllSupers() {
        List<Super> superList = dao.getAllSupers();
        
        assertEquals(1, superList.size());
        
        Super test = superList.get(0);
        
        assertEquals("SuperMan", test.getName());
        assertEquals("SuperHero", test.getDescription());
        assertEquals(1, test.getOrganizationIdList().size());
        assertEquals(1, test.getPowerIdList().size()); 
        
        powerId = test.getPowerIdList().get(0);
        Power power = dao.getPower(powerId);
        assertEquals("Super Strength", power.getName());
        assertEquals("Really Strong", power.getDescription());
        
        orgId = test.getOrganizationIdList().get(0);
        Organization org = dao.getOrganization(orgId);
        assertEquals("X-Men", org.getName());
        assertEquals("Mutants", org.getDescription());
        assertEquals("123 X-Men Way", org.getAddress());
        assertEquals("555-5555", org.getPhoneNumber());      
    }

    /**
     * Test of updateSuper method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testUpdateSuper() {
        Super test = dao.getSuper(superId);
        List<Integer> orgIdList = test.getOrganizationIdList();
        List<Integer> powerIdList = test.getPowerIdList();
        
        Power power = new Power();
        power.setName("Flight");
        power.setDescription("Flying");
        dao.addPower(power);
        powerId = power.getId();
        powerIdList.add(powerId);
        
        Organization org = new Organization();
        org.setName("League of Legends");
        org.setDescription("Heros");
        org.setAddress("123 Hero Way");
        org.setPhoneNumber("111-1111");
        dao.addOrganization(org);
        orgId = org.getId();
        orgIdList.add(orgId);
        
        test.setName("Hulk");
        test.setDescription("Big Green Guy");
        test.setOrganizationIdList(orgIdList);
        test.setPowerIdList(powerIdList);
        
        dao.updateSuper(test);
        
        test = dao.getSuper(superId);
        
        assertEquals("Hulk", test.getName());
        assertEquals("Big Green Guy", test.getDescription());
        assertEquals(2, test.getOrganizationIdList().size());
        assertEquals(2, test.getPowerIdList().size());
    }

    /**
     * Test of deleteSuper method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testDeleteSuper() {
        dao.deleteSuper(superId);
        
        Super test = dao.getSuper(superId);
        
        assertNull(test);
    }
    
    /**
     * Test of getSupersInOrganization method, of class SuperHeroSightingsDao.
     */
    @Test
    public void getSupersInOrganization() {
        Organization org = dao.getOrganization(orgId);
        List<Super> superList = dao.getSupersInOrganization(org);
        
        assertEquals(1, superList.size());
        
        Super test = superList.get(0);
        
        assertEquals("SuperMan", test.getName());
        assertEquals("SuperHero", test.getDescription());
        assertEquals(1, test.getPowerIdList().size());
        assertEquals(1, test.getOrganizationIdList().size());
    }

    /**
     * Test of addPower method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testAddGetPower() {
        Power test = dao.getPower(powerId);
        
        assertEquals("Super Strength", test.getName());
        assertEquals("Really Strong", test.getDescription());
        assertEquals(1, test.getSuperIdList().size());
        
        superId = test.getSuperIdList().get(0);
        Super superPerson = dao.getSuper(superId);
        assertEquals("SuperMan", superPerson.getName());
        assertEquals("SuperHero", superPerson.getDescription());
    }

    /**
     * Test of getAllPowers method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testGetAllPowers() {
        List<Power> powerList = dao.getAllPowers();
        
        assertEquals(1, powerList.size());
        
        Power power = powerList.get(0);
        
        assertEquals("Super Strength", power.getName());
        assertEquals("Really Strong", power.getDescription());
        assertEquals(1, power.getSuperIdList().size());
        
        superId = power.getSuperIdList().get(0);
        Super superPerson = dao.getSuper(superId);
        assertEquals("SuperMan", superPerson.getName());
        assertEquals("SuperHero", superPerson.getDescription());
    }

    /**
     * Test of updatePower method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testUpdatePower() {
        Power test = dao.getPower(powerId);
        
        List<Integer> superIdList = new ArrayList<>();
        Super superPerson = new Super();
        superPerson.setName("Hulk");
        superPerson.setDescription("Big Green Guy");
        dao.addSuper(superPerson);
        superId = superPerson.getId();
        superIdList.add(superId);
        
        test.setName("Flight");
        test.setDescription("Flying");
        test.setSuperIdList(superIdList);
        
        dao.updatePower(test);
        
        test = dao.getPower(powerId);
        
        assertEquals("Flight", test.getName());
        assertEquals("Flying", test.getDescription());
        assertEquals(1, test.getSuperIdList().size());
        
    }

    /**
     * Test of deletePower method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testDeletePower() {
        dao.deletePower(powerId);
        
        Power test = dao.getPower(powerId);
        
        assertNull(test);
    }

    /**
     * Test of addLocation method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testAddGetLocation() {
        Location test = dao.getLocation(locationId);
        
        assertEquals("Park", test.getName());
        assertEquals("A Park", test.getDescription());
        assertEquals("123 Park Ave", test.getAddress());  
    }

    /**
     * Test of getAllLocations method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testGetAllLocations() {
     
        List<Location> locationList = dao.getAllLocations();
        
        assertEquals(1, locationList.size());
        
        Location test = locationList.get(0);
        
        assertEquals("Park", test.getName());
        assertEquals("A Park", test.getDescription());
        assertEquals("123 Park Ave", test.getAddress());  
    }

    /**
     * Test of updateLocation method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testUpdateLocation() {
        Location test = dao.getLocation(locationId);
   
        test.setName("Work");
        test.setDescription("From Window");
        test.setAddress("123 Some Street");
        test.setLatitude(1.1);
        test.setLongitude(2.2);
        
        dao.updateLocation(test);
        
        test = dao.getLocation(locationId);
        
        assertEquals("Work", test.getName());
        assertEquals("From Window", test.getDescription());
        assertEquals("123 Some Street", test.getAddress());
           
    }

    /**
     * Test of deleteLocation method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testDeleteLocation() {
        
        dao.deleteLocation(locationId);
        
        Location test = dao.getLocation(locationId);
        
        assertNull(test);
    }

    /**
     * Test of getLocationsOfSuper method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testGetLocationsOfSuper() {
        List<Location> locationList = dao.getLocationsOfSuper(superId);
        
        assertEquals(1, locationList.size());
        
        Location test = locationList.get(0);
        
        assertEquals("Park", test.getName());
        assertEquals("A Park", test.getDescription());
        assertEquals("123 Park Ave", test.getAddress());
    }

    /**
     * Test of addOrganization method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testAddGetOrganization() {
        Organization test = dao.getOrganization(orgId);
        
        assertEquals("X-Men", test.getName());
        assertEquals("Mutants", test.getDescription());
        assertEquals("123 X-Men Way", test.getAddress());
        assertEquals("555-5555", test.getPhoneNumber());
        assertEquals(1, test.getSuperIdList().size());
        
        superId = test.getSuperIdList().get(0);
        Super superPerson = dao.getSuper(superId);
        assertEquals("SuperMan", superPerson.getName());
        assertEquals("SuperHero", superPerson.getDescription());
    }

    /**
     * Test of getAllOrganizations method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testGetAllOrganizations() {
        List<Organization> orgList = dao.getAllOrganizations();
        
        assertEquals(1, orgList.size());
        
        Organization test = orgList.get(0);
        
        assertEquals("X-Men", test.getName());
        assertEquals("Mutants", test.getDescription());
        assertEquals("123 X-Men Way", test.getAddress());
        assertEquals("555-5555", test.getPhoneNumber());
        assertEquals(1, test.getSuperIdList().size());
        
        superId = test.getSuperIdList().get(0);
        Super superPerson = dao.getSuper(superId);
        assertEquals("SuperMan", superPerson.getName());
        assertEquals("SuperHero", superPerson.getDescription());
    }

    /**
     * Test of updateOrganization method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testUpdateOrganization() {
        Organization test = dao.getOrganization(orgId);
        
        List<Integer> superIdList = new ArrayList<>();
        Super superPerson = new Super();
        superPerson.setName("Hulk");
        superPerson.setDescription("Big Green Guy");
        dao.addSuper(superPerson);
        superId = superPerson.getId();
        superIdList.add(superId);
        
        test.setName("League Of Legends");
        test.setDescription("Heros");
        test.setAddress("123 Hero Way");
        test.setPhoneNumber("111-1111");
        test.setSuperIdList(superIdList);
        
        dao.updateOrganization(test);
        
        test = dao.getOrganization(orgId);
        
        assertEquals("League Of Legends", test.getName());
        assertEquals("Heros", test.getDescription());
        assertEquals("123 Hero Way", test.getAddress());
        assertEquals("111-1111", test.getPhoneNumber());
        assertEquals(1, test.getSuperIdList().size());
    }

    /**
     * Test of deleteOrganization method, of class SuperHeroSightingsDao.
     */
    @Test
    public void testDeleteOrganization() {
        dao.deleteOrganization(orgId);
        
        Organization test = dao.getOrganization(orgId);
        
        assertNull(test);
    }
    
    /**
     * Test of getOrganizationsBySuper method, of class SuperHeroSightingsDao.
     */
    @Test
    public void getOrganizationsBySuper() {
        Super superPerson = dao.getSuper(superId);
        List<Organization> orgList = dao.getOrganizationsBySuper(superPerson);
        
        assertEquals(1, orgList.size());
        
        Organization test = orgList.get(0);
        
        assertEquals("X-Men", test.getName());
        assertEquals("Mutants", test.getDescription());
        assertEquals("123 X-Men Way", test.getAddress());
        assertEquals("555-5555", test.getPhoneNumber());
        assertEquals(1, test.getSuperIdList().size());     
    }
    
}
