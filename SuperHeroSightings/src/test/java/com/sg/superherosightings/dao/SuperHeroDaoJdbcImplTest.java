/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.dto.Hero;
import com.sg.superherosightings.dto.Location;
import com.sg.superherosightings.dto.Organization;
import com.sg.superherosightings.dto.Sightings;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author user
 */
public class SuperHeroDaoJdbcImplTest {

    SuperHeroDao dao;

    public SuperHeroDaoJdbcImplTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        dao = ctx.getBean("superHeroDao", SuperHeroDao.class);

        //delete all heros
        List<Hero> heros = dao.getAllHeros();
        for (Hero currentHero : heros) {
            dao.deleteHero(currentHero.getHeroId());
        }
        //delete all locations
        List<Location> locations = dao.getAllLocations();
        for (Location currentLocation : locations) {
            dao.deleteLocation(currentLocation.getLocationId());
        }
        //delte all organizations
        List<Organization> organizations = dao.getAllOrganizations();
        for (Organization currentOrganization : organizations) {
            dao.deleteOrganization(currentOrganization.getOrganizationId());
        }
        //delete all sightings
        List<Sightings> sightings = dao.getAllSightings();
        for (Sightings currentSighting : sightings) {
            dao.deleteSighting(currentSighting.getSightingId());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setJdbcTemplate method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testSetJdbcTemplate() {
    }

    /**
     * Test of addHero method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testAddHero() {
    }

    /**
     * Test of deleteHero method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testDeleteHero() {
    }

    /**
     * Test of updateHero method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testUpdateHero() {
    }

    /**
     * Test of getHeroById method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetHeroById() {
    }

    /**
     * Test of getAllHeros method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetAllHeros() {
    }

    /**
     * Test of getAllHerosBySighting method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetAllHerosBySighting() {
    }

    /**
     * Test of getAllHerosByOrganization method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetAllHerosByOrganization() {
    }

    /**
     * Test of getAllHerosByLocation method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetAllHerosByLocation() {
    }

    /**
     * Test of addLocation method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testAddLocation() {
    }

    /**
     * Test of deleteLocation method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testDeleteLocation() {
    }

    /**
     * Test of updateLocation method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testUpdateLocation() {
    }

    /**
     * Test of getLocationById method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetLocationById() {
    }

    /**
     * Test of getAllLocations method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetAllLocations() {
    }

    /**
     * Test of getAllLocationsByHero method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetAllLocationsByHero() {
    }

    /**
     * Test of deleteOrganization method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testDeleteOrganization() {
    }

    /**
     * Test of updateOrganization method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testUpdateOrganization() {
    }

    /**
     * Test of getOrganizationById method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetOrganizationById() {
    }

    /**
     * Test of getAllOrganizations method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetAllOrganizations() {
    }

    /**
     * Test of getOrganizationByHero method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetOrganizationByHero() {
    }

    /**
     * Test of addSighting method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testAddSighting() {
    }

    /**
     * Test of deleteSighting method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testDeleteSighting() {
    }

    /**
     * Test of updateSighting method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testUpdateSighting() {
    }

    /**
     * Test of getSightingById method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetSightingById() {
    }

    /**
     * Test of getAllSightings method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetAllSightings() {
    }

    /**
     * Test of getAllSightingByHeroId method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetAllSightingByHeroId() {
    }

    /**
     * Test of getAllSightingByLocationId method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetAllSightingByLocationId() {
    }

    /**
     * Test of getAllSightingsByDate method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetAllSightingsByDate() {
    }

    /**
     * Test of getHeroBySighting method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetHeroBySighting() {
    }

    /**
     * Test of getHeroByLocation method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetHeroByLocation() {
    }

    /**
     * Test of getLocationByHero method, of class SuperHeroDaoJdbcImpl.
     */
    @Test
    public void testGetLocationByHero() {
    }

}
