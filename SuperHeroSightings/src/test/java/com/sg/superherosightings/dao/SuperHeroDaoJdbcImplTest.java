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
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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

    @Test
    public void addGetAndDeleteOrganization() {
        Organization organization = new Organization();

        organization.setOrganizationName("Justice League");
        organization.setDescription("A collection of DC superheroes");
        organization.setAddress("12345 Justice Avenue");
        organization.setState("New York");
        organization.setZipCode("55454");

        dao.addOrganization(organization);

        Organization fromDao = dao.getOrganizationById(organization.getOrganizationId());
        assertEquals(fromDao, organization);
        dao.deleteOrganization(organization.getOrganizationId());
        assertNull(dao.getOrganizationById(organization.getOrganizationId()));
    }

    @Test
    public void addGetAndDeleteLocation() {
        Location location = new Location();
        location.setLocationName("movie theater");
        location.setAddress("1800 S Washington Ave");
        location.setState("Minnesota");
        location.setZipCode("55454");
        location.setLocationDescription("Actually an apartment Complex");
        location.setLatitude(new BigDecimal("35.483724"));
        location.setLongitude(new BigDecimal("112.23945"));

        dao.addLocation(location);

        Location fromDao = dao.getLocationById(location.getLocationId());
        assertEquals(fromDao, location);
        dao.deleteLocation(location.getLocationId());
        assertNull(dao.getLocationById(location.getLocationId()));

    }
    
    @Test
    public void addGetAndDeleteHero() {
        Hero hero = new Hero();
        hero.setName("AquaMan");
        hero.setDescription("The most useless Hero, until played by Jason Mamoa");
        hero.setSuperPower("Ability to talk with fish");
        hero.setOrganizations(new ArrayList<>());
        dao.addHero(hero);
        Hero fromDao = dao.getHeroById(hero.getHeroId());
        
        assertEquals(fromDao, hero);
        dao.deleteHero(hero.getHeroId());
        assertNull(dao.getHeroById(hero.getHeroId()));
    }

    @Test
    public void addGetAndDeleteSighting() {
        Location location = new Location();
        location.setLocationName("movie theater");
        location.setAddress("1800 S Washington Ave");
        location.setState("Minnesota");
        location.setZipCode("55454");
        location.setLocationDescription("Actually an apartment Complex");
        location.setLatitude(new BigDecimal("35.483724"));
        location.setLongitude(new BigDecimal("112.23945"));
        
        dao.addLocation(location);
        
        Hero hero = new Hero();
        hero.setName("AquaMan");
        hero.setDescription("The most useless Hero, until played by Jason Mamoa");
        hero.setSuperPower("Ability to talk with fish");
        hero.setOrganizations(new ArrayList<>());
        dao.addHero(hero);
        List<Hero> herosSighted = new ArrayList<>();
        herosSighted.add(hero);

        dao.addLocation(location);
        Sightings sighting = new Sightings();
        sighting.setSightingLocation(location);
        sighting.setDateSighted(LocalDate.now());
        sighting.setHerosSighted(herosSighted);
        
        dao.addSighting(sighting);
        
        Sightings fromDao = dao.getSightingById(sighting.getSightingId());
        assertEquals(fromDao, sighting);
        dao.deleteSighting(sighting.getSightingId());
        assertNull(dao.getSightingById(sighting.getSightingId()));
    }

}
