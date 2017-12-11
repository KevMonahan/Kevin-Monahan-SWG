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

    public void addHero(Hero hero);

    public void deleteHero(int heroId);
    
    public void updateHero(Hero hero);
    
    public Hero getHeroById(int heroId);
    
    public List<Hero> getAllHeros();
    
    public List<Hero> getAllHerosBySighting(int sightingId);
    
    public List<Hero> getAllHerosByOrganization(int organizationId);
    
    public List<Hero> getAllHerosByLocation(int locationId);
    
    
    public void addLocation(Location location);
    
    public void deleteLocation(int locationId);
    
    public void updateLocation(Location location);
    
    public Location getLocationById(int locationId);
    
    public List<Location> getAllLocations();
    
    public List<Location> getAllLocationsByHero(int heroId);
    
    public void addOrganization(Organization organization);
    
    public void deleteOrganization(int OrganizationId);
    
    public void updateOrganization(Organization organization);
    
    public Organization getOrganizationById (int organizationId);
    
    public List<Organization> getAllOrganizations();    
    
    public void addSighting(Sightings sighting);
    
    public void deleteSighting(int sightingId);
    
    public void updateSighting(Sightings sighting);
    
    public Sightings getSightingById(int sightingId);
    
    public List<Sightings> getAllSightings();
    
    public List<Sightings> getAllSightingByLocationId (int locationId);
    
    public List<Sightings> getAllSightingsByDate(LocalDate date);
            
            
    
    public void getHeroBySighting();
    
    public void getHeroByLocation();
    
    public void getLocationByHero();
    
    
    
}
