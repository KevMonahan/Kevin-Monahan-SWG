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
import java.time.LocalDate;
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
    public void updateOrganization() {

        Organization organization = new Organization();

        organization.setOrganizationName("Justice League");
        organization.setDescription("A collection of DC superheroes");
        organization.setAddress("12345 Justice Avenue");
        organization.setState("New York");
        organization.setZipCode("55454");

        dao.addOrganization(organization);
        Organization fromDao = dao.getOrganizationById(organization.getOrganizationId());
        assertEquals(fromDao, organization);

        organization.setDescription("A sorry collection of DC heroes");

        dao.updateOrganization(organization);
        Organization fromDao2 = dao.getOrganizationById(organization.getOrganizationId());
        assertEquals(fromDao2, organization);
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
    public void updateLocation() {

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

        location.setZipCode("77396");
        dao.updateLocation(location);
        Location fromDao2 = dao.getLocationById(location.getLocationId());

        assertEquals(fromDao2, location);

    }

    @Test
    public void addGetAndDeleteHero() {
        Organization organization = new Organization();

        organization.setOrganizationName("Justice League");
        organization.setDescription("A collection of DC superheroes");
        organization.setAddress("12345 Justice Avenue");
        organization.setState("New York");
        organization.setZipCode("55454");

        dao.addOrganization(organization);
        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(organization);
        
        Hero hero = new Hero();
        hero.setName("AquaMan");
        hero.setDescription("The most useless Hero, until played by Jason Mamoa");
        hero.setSuperPower("Ability to talk with fish");
        hero.setOrganizations(organizationList);
        
        dao.addHero(hero);
        Hero fromDao = dao.getHeroById(hero.getHeroId());

        assertEquals(fromDao, hero);
        dao.deleteHero(hero.getHeroId());
        assertNull(dao.getHeroById(hero.getHeroId()));
    }

    @Test
    public void updateHero() {
        Organization organization = new Organization();

        organization.setOrganizationName("Justice League");
        organization.setDescription("A collection of DC superheroes");
        organization.setAddress("12345 Justice Avenue");
        organization.setState("New York");
        organization.setZipCode("55454");

        dao.addOrganization(organization);
        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(organization);
        
        Hero hero = new Hero();
        hero.setName("AquaMan");
        hero.setDescription("The most useless Hero, until played by Jason Mamoa");
        hero.setSuperPower("Ability to talk with fish");
        hero.setOrganizations(organizationList);
        dao.addHero(hero);
        Hero fromDao = dao.getHeroById(hero.getHeroId());

        assertEquals(fromDao, hero);

        hero.setSuperPower("The panziest one of all");

        dao.updateHero(hero);
        Hero fromDao2 = dao.getHeroById(hero.getHeroId());
        assertEquals(fromDao2, hero);
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

//        dao.addLocation(location);
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

    @Test
    public void updateSighting() {
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

//        dao.addLocation(location);
        Sightings sighting = new Sightings();
        sighting.setSightingLocation(location);
        sighting.setDateSighted(LocalDate.now());
        sighting.setHerosSighted(herosSighted);

        dao.addSighting(sighting);

        Sightings fromDao = dao.getSightingById(sighting.getSightingId());
        assertEquals(fromDao, sighting);
        LocalDate dateSighted = LocalDate.of(2017, 05, 22);

        sighting.setDateSighted(dateSighted);

        dao.updateSighting(sighting);

        Sightings fromDao2 = dao.getSightingById(sighting.getSightingId());

        assertEquals(fromDao2, sighting);
    }

    @Test
    public void getAllLocations() {
        Location location = new Location();
        location.setLocationName("movie theater");
        location.setAddress("1800 S Washington Ave");
        location.setState("Minnesota");
        location.setZipCode("55454");
        location.setLocationDescription("Actually an apartment Complex");
        location.setLatitude(new BigDecimal("35.483724"));
        location.setLongitude(new BigDecimal("112.23945"));

        dao.addLocation(location);

        Location location2 = new Location();
        location2.setLocationName("Mall");
        location2.setAddress("2200 FM 1960");
        location2.setState("Texas");
        location2.setZipCode("77396");
        location2.setLocationDescription("The mall in Humble");
        location2.setLatitude(new BigDecimal("56.437724"));
        location2.setLongitude(new BigDecimal("101.24345"));

        dao.addLocation(location2);

        List<Location> fromDao = dao.getAllLocations();
        assertEquals(fromDao.size(), 2);
    }

    @Test
    public void getAllOrganizations() {
        Organization organization = new Organization();

        organization.setOrganizationName("Justice League");
        organization.setDescription("A collection of DC superheroes");
        organization.setAddress("12345 Justice Avenue");
        organization.setState("New York");
        organization.setZipCode("55454");

        dao.addOrganization(organization);

        Organization organization2 = new Organization();

        organization2.setOrganizationName("Avengers");
        organization2.setDescription("A collection of Marvel superheroes");
        organization2.setAddress("12345 Avenger St");
        organization2.setState("New York");
        organization2.setZipCode("48342");

        dao.addOrganization(organization2);

        List<Organization> fromDao = dao.getAllOrganizations();

        assertEquals(fromDao.size(), 2);
    }

    @Test
    public void getAllHeros() {
        Hero hero = new Hero();
        hero.setName("AquaMan");
        hero.setDescription("The most useless Hero, until played by Jason Mamoa");
        hero.setSuperPower("Ability to talk with fish");
        hero.setOrganizations(new ArrayList<>());
        dao.addHero(hero);

        Hero hero2 = new Hero();
        hero2.setName("SuperMan");
        hero2.setDescription("The Mightiest of All SuperHeros");
        hero2.setSuperPower("Flying & Super Strength");
        hero2.setOrganizations(new ArrayList<>());
        dao.addHero(hero2);

        List<Hero> fromDao = dao.getAllHeros();

        assertEquals(fromDao.size(), 2);
    }

    @Test
    public void getAllSightings() {

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

//        dao.addLocation(location);
        Sightings sighting = new Sightings();
        sighting.setSightingLocation(location);
        sighting.setDateSighted(LocalDate.now());
        sighting.setHerosSighted(herosSighted);

        dao.addSighting(sighting);

        Location location2 = new Location();
        location2.setLocationName("Mall");
        location2.setAddress("2200 FM 1960");
        location2.setState("Texas");
        location2.setZipCode("77396");
        location2.setLocationDescription("The mall in Humble");
        location2.setLatitude(new BigDecimal("56.437724"));
        location2.setLongitude(new BigDecimal("101.24345"));

        dao.addLocation(location2);

        Hero hero2 = new Hero();
        hero2.setName("SuperMan");
        hero2.setDescription("The Mightiest of All SuperHeros");
        hero2.setSuperPower("Flying & Super Strength");
        hero2.setOrganizations(new ArrayList<>());
        dao.addHero(hero2);

        List<Hero> herosSighted2 = new ArrayList<>();
        herosSighted2.add(hero2);

//        dao.addLocation(location);
        Sightings sighting2 = new Sightings();
        sighting2.setSightingLocation(location2);
        sighting2.setDateSighted(LocalDate.now());
        sighting2.setHerosSighted(herosSighted2);

        dao.addSighting(sighting2);

        List<Sightings> fromDao = dao.getAllSightings();
        assertEquals(fromDao.size(), 2);

    }

    @Test
    public void getAllLocationsByHero() {
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

//        dao.addLocation(location);
        Sightings sighting = new Sightings();
        sighting.setSightingLocation(location);
        sighting.setDateSighted(LocalDate.now());
        sighting.setHerosSighted(herosSighted);

        dao.addSighting(sighting);

        Location location2 = new Location();
        location2.setLocationName("Mall");
        location2.setAddress("2200 FM 1960");
        location2.setState("Texas");
        location2.setZipCode("77396");
        location2.setLocationDescription("The mall in Humble");
        location2.setLatitude(new BigDecimal("56.437724"));
        location2.setLongitude(new BigDecimal("101.24345"));

        dao.addLocation(location2);

        List<Hero> herosSighted2 = new ArrayList<>();
        herosSighted2.add(hero);

        Sightings sighting2 = new Sightings();
        sighting2.setSightingLocation(location2);
        sighting2.setDateSighted(LocalDate.now());
        sighting2.setHerosSighted(herosSighted2);

        dao.addSighting(sighting2);

        List<Location> fromDao = dao.getAllLocationsByHero(hero.getHeroId());

        assertEquals(fromDao.size(), 2);

    }

    @Test
    public void getAllSightingsByLocationId() {
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

//        dao.addLocation(location);
        Sightings sighting = new Sightings();
        sighting.setSightingLocation(location);
        sighting.setDateSighted(LocalDate.now());
        sighting.setHerosSighted(herosSighted);

        dao.addSighting(sighting);

        Location location2 = new Location();
        location2.setLocationName("Mall");
        location2.setAddress("2200 FM 1960");
        location2.setState("Texas");
        location2.setZipCode("77396");
        location2.setLocationDescription("The mall in Humble");
        location2.setLatitude(new BigDecimal("56.437724"));
        location2.setLongitude(new BigDecimal("101.24345"));

        dao.addLocation(location2);

        Hero hero2 = new Hero();
        hero2.setName("SuperMan");
        hero2.setDescription("The Mightiest of All SuperHeros");
        hero2.setSuperPower("Flying & Super Strength");
        hero2.setOrganizations(new ArrayList<>());
        dao.addHero(hero2);

        List<Hero> herosSighted2 = new ArrayList<>();
        herosSighted2.add(hero2);

        Sightings sighting2 = new Sightings();
        sighting2.setSightingLocation(location);
        sighting2.setDateSighted(LocalDate.now());
        sighting2.setHerosSighted(herosSighted2);

        dao.addSighting(sighting2);

        List<Sightings> fromDao = dao.getAllSightingByLocationId(location.getLocationId());

        assertEquals(fromDao.size(), 2);
    }

    @Test
    public void getAllSightingsByDate() {
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

//        dao.addLocation(location);
        Sightings sighting = new Sightings();
        sighting.setSightingLocation(location);
        sighting.setDateSighted(LocalDate.now());
        sighting.setHerosSighted(herosSighted);

        dao.addSighting(sighting);

        Location location2 = new Location();
        location2.setLocationName("Mall");
        location2.setAddress("2200 FM 1960");
        location2.setState("Texas");
        location2.setZipCode("77396");
        location2.setLocationDescription("The mall in Humble");
        location2.setLatitude(new BigDecimal("56.437724"));
        location2.setLongitude(new BigDecimal("101.24345"));

        dao.addLocation(location2);

        Hero hero2 = new Hero();
        hero2.setName("SuperMan");
        hero2.setDescription("The Mightiest of All SuperHeros");
        hero2.setSuperPower("Flying & Super Strength");
        hero2.setOrganizations(new ArrayList<>());
        dao.addHero(hero2);

        List<Hero> herosSighted2 = new ArrayList<>();
        herosSighted2.add(hero2);

        Sightings sighting2 = new Sightings();
        sighting2.setSightingLocation(location2);
        sighting2.setDateSighted(LocalDate.now());
        sighting2.setHerosSighted(herosSighted2);

        dao.addSighting(sighting2);

        List<Sightings> fromDao = dao.getAllSightingsByDate(LocalDate.now());

        assertEquals(fromDao.size(), 2);

    }

    @Test
    public void getAllHerosBySighting() {
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
        
        Hero hero2 = new Hero();
        hero2.setName("SuperMan");
        hero2.setDescription("The Mightiest of All SuperHeros");
        hero2.setSuperPower("Flying & Super Strength");
        hero2.setOrganizations(new ArrayList<>());
        
        dao.addHero(hero);        
        dao.addHero(hero2);

        List<Hero> herosSighted = new ArrayList<>();
        herosSighted.add(hero);
        herosSighted.add(hero2);

        Sightings sighting = new Sightings();
        sighting.setSightingLocation(location);
        sighting.setDateSighted(LocalDate.now());
        sighting.setHerosSighted(herosSighted);
        dao.addSighting(sighting);
        
        List<Hero> fromDao = dao.getAllHerosBySighting(sighting.getSightingId());
        assertEquals(fromDao.size(), 2);
    }

    @Test
    public void getAllHerosByOrganization() {
        Organization organization = new Organization();

        organization.setOrganizationName("Justice League");
        organization.setDescription("A collection of DC superheroes");
        organization.setAddress("12345 Justice Avenue");
        organization.setState("New York");
        organization.setZipCode("55454");

        dao.addOrganization(organization);
        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(organization);
        
        Hero hero = new Hero();
        hero.setName("AquaMan");
        hero.setDescription("The most useless Hero, until played by Jason Mamoa");
        hero.setSuperPower("Ability to talk with fish");
        hero.setOrganizations(organizationList);
        
        Hero hero2 = new Hero();
        hero2.setName("SuperMan");
        hero2.setDescription("The Mightiest of All SuperHeros");
        hero2.setSuperPower("Flying & Super Strength");
        hero2.setOrganizations(organizationList);
        
        dao.addHero(hero);
        dao.addHero(hero2);
        
        List<Hero> fromDao = dao.getAllHerosByOrganization(organization.getOrganizationId());
        
        assertEquals(fromDao.size(), 2);
        

    }

    @Test
    public void getAllHerosByLocation() {
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
        
        Hero hero2 = new Hero();
        hero2.setName("SuperMan");
        hero2.setDescription("The Mightiest of All SuperHeros");
        hero2.setSuperPower("Flying & Super Strength");
        hero2.setOrganizations(new ArrayList<>());
        
        dao.addHero(hero);        
        dao.addHero(hero2);
        List<Hero> herosSighted = new ArrayList<>();
        herosSighted.add(hero);
        herosSighted.add(hero2);
        
        Sightings sighting = new Sightings();
        sighting.setSightingLocation(location);
        sighting.setDateSighted(LocalDate.now());
        sighting.setHerosSighted(herosSighted);
        dao.addSighting(sighting);
        
        List<Hero> fromDao = dao.getAllHerosByLocation(location.getLocationId());
        
        assertEquals(fromDao.size(), 2);
        
        
    }
}
