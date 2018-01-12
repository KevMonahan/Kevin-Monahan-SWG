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
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author user
 */
public interface SuperHeroDao {
    //tested
    public void addHero(Hero hero);

    public void deleteHero(int heroId);

    public void updateHero(Hero hero);

    public void addLocation(Location location);

    public void deleteLocation(int locationId);

    public void updateLocation(Location location);

    public void addOrganization(Organization organization);

    public void deleteOrganization(int OrganizationId);

    public void updateOrganization(Organization organization);

    public void addSighting(Sightings sighting);

    public void deleteSighting(int sightingId);

    public void updateSighting(Sightings sighting);
    
    public Location getLocationById(int locationId);
    
    public Organization getOrganizationById(int organizationId);
    
    public Sightings getSightingById(int sightingId);

    public Hero getHeroById(int heroId);
    
    public List<Location> getAllLocations();
    
    public List<Sightings> getAllSightings();

    public List<Hero> getAllHeros();
    
    public List<Organization> getAllOrganizations();     
    
    public List<Location> getAllLocationsByHero(int heroId);
    
    public List<Sightings> getAllSightingByLocationId(int locationId);

    public List<Sightings> getAllSightingsByDate(LocalDate date);
    
    public List<Hero> getAllHerosBySighting(int sightingId);    
    
    public List<Hero> getAllHerosByOrganization(int organizationId);    
    
    public List<Hero> getAllHerosByLocation(int locationId);    
    
    public List<Sightings> getTenRecentSightings();
//untested
}
