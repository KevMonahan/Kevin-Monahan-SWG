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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
public class SuperHeroDaoJdbcImpl implements SuperHeroDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
//HERO STATEMENTS

    private static final String SQL_INSERT_HERO = "insert into hero (name, description, superPower) values ( ?, ?, ?)";

    private static final String SQL_DELETE_HERO = "delete from hero where heroId = ?";

    private static final String SQL_UPDATE_HERO = "update hero set heroId, name, description, superPower, (?, ?, ?, ?)";

    private static final String SQL_SELECT_HERO = "select * from hero where heroId = ?";

    private static final String SQL_SELECT_HERO_BY_SIGHTING_ID = "select * from hero_sightings where sighting_sightingId = ?";

    private static final String SQL_SELECT_HERO_BY_ORGANIZATION_ID = "select * from hero_organization where organizationId = ?";
    
    private static final String SQL_SELECT_HERO_BY_LOCATION_ID = "select * from hero where";

    private static final String SQL_DELETE_HERO_ORGANIZATION = "delete from hero_organization where hero_heroId = ?";

    private static final String SQL_DELETE_HERO_SIGHTING = "delete from hero_sightings where hero_heroId = ?";

    private static final String SQL_DELETE_ORGANIZATION = "delete from organization where organizationId = ?";

    private static final String SQL_DELETE_LOCATION = "delete from location where locationId = ?";

    private static final String SQL_DELETE_SIGHTING = "delete from sighting where sightingId = ?";

    //SELECT ALL STATEMENTS FOR ALL OBJECTS IN PROGRAM
    private static final String SQL_SELECT_ALL_HEROS = "select * from hero";

    private static final String SQL_SELECT_ALL_LOCATION = "select * from location";

    private static final String SQL_SELECT_ALL_ORGANIZATION = "select * from organization";

    private static final String SQL_SELECT_ALL_SIGHTINGS = "select * from sightings";

    private static final String SQL_SELECT_SIGHTINGS_BY_HERO_ID = "select s.sightingId, s.sightingDate, from sightings s join hero_sightings hs on s.sightingId = hs.sighting_sightingId where hs.hero_heroId = ?";

    private static final String SQL_SELECT_ORGANIZATIONS_BY_HERO_ID = "select o.organizationId, o.setName, o.setDescription, o.setAddress, o.setState, o.setZipCode from organization o join hero_organization ho on o.organizationId = ho.organization_organizationId where ho.hero_heroId = ?";

//    private static final String SQL_SELECT_HERO_BY_LOCATION_ID = "select * from heros where locationId = ?";
    private static final String SQL_INSERT_LOCATIONS = "insert into location (name, address, state, zipCode, description, latitude, longitude) values (?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_INSERT_ORGANIZATIONS = "insert into organization (name, description, address, state, zipCode) values (?, ?, ?, ?, ?)";

    private static final String SQL_INSERT_SIGHTINGS = "insert into sighting (hero_heroId, location_locationId, date) values (?, ?, ?)";
    
    private static final String SQL_INSERT_HERO_ORGANIZATIONS = "insert into hero_organization (hero_heroId, organization_organizationId) values (?, ?)";
    
    private static final String SQL_INSERT_HERO_SIGHTINGS = "insert into hero_sightings (hero_heroId, sighting_sightingId) values (?, ?)";
    
    private static final String SQL_SELECT_ORGANIZATION = "select * from organization where organizationId = ?";
    
    private static final String SQL_SELECT_SIGHTING = "select * from sighting where sightingId = ?";
    
    private static final String SQL_SELECT_LOCATION = "select * from location where locationId = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addHero(Hero hero) {
        jdbcTemplate.update(SQL_INSERT_HERO, hero.getName(), hero.getDescription(), hero.getSuperPower());

        int heroId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        hero.setHeroId(heroId);
        
        insertHeroOrganizations(hero);
        
    }

    @Override
    public void deleteHero(int heroId) {
        jdbcTemplate.update(SQL_DELETE_HERO_ORGANIZATION, heroId);
        jdbcTemplate.update(SQL_DELETE_HERO_SIGHTING, heroId);
        jdbcTemplate.update(SQL_DELETE_HERO, heroId);
    }

    @Override
    public void updateHero(Hero hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hero getHeroById(int heroId) {
        try { 
            
            Hero hero = jdbcTemplate.queryForObject(SQL_SELECT_HERO, new HeroMapper(), heroId);
            
            hero.setOrganizations(findOrganizationsForHero(hero));
            
            return hero;
        } catch (EmptyResultDataAccessException ex) {
            return null;            
        }                
    }

    @Override
    public List<Hero> getAllHeros() {
        List<Hero> heroList = jdbcTemplate.query(SQL_SELECT_ALL_HEROS,
                new HeroMapper());

        return associateOrganizationsWithHeros(heroList);
    }

    @Override
    public List<Hero> getAllHerosBySighting(int sightingId) {
        List<Hero> heroList = jdbcTemplate.query(SQL_SELECT_HERO_BY_SIGHTING_ID, new HeroMapper(), sightingId);
        
        return associateOrganizationsWithHeros(heroList);
    }

    @Override
    public List<Hero> getAllHerosByOrganization(int organizationId) {
        List<Hero> heroList = jdbcTemplate.query(SQL_SELECT_HERO_BY_ORGANIZATION_ID, new HeroMapper(), organizationId);
        
        return associateOrganizationsWithHeros(heroList);
    }

    @Override
    public List<Hero> getAllHerosByLocation(int locationId) {
        List<Hero> heroList = jdbcTemplate.query(SQL_SELECT_HERO_BY_LOCATION_ID, new HeroMapper(), locationId);
        
        return associateOrganizationsWithHeros(heroList);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addLocation(Location location) {
        jdbcTemplate.update(SQL_INSERT_LOCATIONS, location.getLocationName(),
                location.getAddress(), location.getState(), location.getZipCode(),
                location.getLocationDescription(), location.getLatitude(), location.getLongitude());
    }

    @Override
    public void deleteLocation(int locationId) {
        jdbcTemplate.update(SQL_DELETE_LOCATION, locationId);
    }

    @Override
    public void updateLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Location getLocationById(int locationId) {
        try { 
            return jdbcTemplate.queryForObject(SQL_SELECT_LOCATION, new LocationMapper(), locationId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Location> getAllLocations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_LOCATION, new LocationMapper());
    }

    @Override
    public List<Location> getAllLocationsByHero(int heroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addOrganization(Organization organization) {
        jdbcTemplate.update(SQL_INSERT_ORGANIZATIONS,
                organization.getOrganizationName(),
                organization.getDescription(),
                organization.getAddress(),
                organization.getState(),
                organization.getZipCode());
        
        int organizationId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        
        organization.setOrganizationId(organizationId);
    }

    @Override
    public void deleteOrganization(int organizationId) {
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION, organizationId);
    }

    @Override
    public void updateOrganization(Organization organization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organization getOrganizationById(int organizationId) {
        try { 
            return jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATION, new OrganizationMapper(), organizationId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ORGANIZATION, new OrganizationMapper());
    }

    @Override
    public List<Organization> getOrganizationByHero(int heroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSighting(Sightings sighting) {
        jdbcTemplate.update(SQL_INSERT_SIGHTINGS, sighting.getSightingLocation().getLocationId(), sighting.getDateSighted());
        
        insertHeroSightings(sighting);
    }

    @Override
    public void deleteSighting(int sightingId) {
        jdbcTemplate.update(SQL_DELETE_SIGHTING, sightingId);
    }

    @Override
    public void updateSighting(Sightings sighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sightings getSightingById(int sightingId) {
        try { 
            return jdbcTemplate.queryForObject(SQL_SELECT_SIGHTING, new SightingMapper(), sightingId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Sightings> getAllSightings() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SIGHTINGS, new SightingMapper());
    }

    @Override
    public List<Sightings> getAllSightingByHeroId(int heroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sightings> getAllSightingByLocationId(int locationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sightings> getAllSightingsByDate(LocalDate date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getHeroBySighting() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getHeroByLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getLocationByHero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<Sightings> findSightingsForHero(Hero hero) {
        return jdbcTemplate.query(SQL_SELECT_SIGHTINGS_BY_HERO_ID, new SightingMapper(), hero.getHeroId());
    }

    private List<Organization> findOrganizationsForHero(Hero hero) {
        return jdbcTemplate.query(SQL_SELECT_ORGANIZATIONS_BY_HERO_ID, new OrganizationMapper(), hero.getHeroId());
    }

    private List<Hero> associateOrganizationsWithHeros(List<Hero> heroList) {
        for (Hero currentHero : heroList) {
//            currentHero.setSightings(findSightingsForHero(currentHero));

            currentHero.setOrganizations(findOrganizationsForHero(currentHero));

        }
        return heroList;
    }

    private void insertHeroOrganizations(Hero hero) {
        final int heroId = hero.getHeroId();
        final List<Organization> organizations = hero.getOrganizations();
        
        for (Organization currentOrganization : organizations) {
            jdbcTemplate.update(SQL_INSERT_HERO_ORGANIZATIONS, heroId, currentOrganization.getOrganizationId());
        }
    }

    private void insertHeroSightings(Sightings sighting) {
        final int sightingId = sighting.getSightingId();
        final List<Hero> heroes = sighting.getHerosSighted();
                
        for (Hero currentHero : heroes) {
            jdbcTemplate.update(SQL_INSERT_HERO_SIGHTINGS, sightingId, currentHero.getHeroId());
        }
    }

    private static class HeroMapper implements RowMapper<Hero> {

        @Override
        public Hero mapRow(ResultSet rs, int i) throws SQLException {
            Hero h = new Hero();

            h.setHeroId(rs.getInt("heroId"));
            h.setName(rs.getString("name"));
            h.setDescription(rs.getString("description"));
            h.setSuperPower(rs.getString("superPower"));

            return h;
        }
    }

    private static class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location l = new Location();

            l.setLocationId(rs.getInt("locationId"));
            l.setLocationName(rs.getString("name"));
            l.setAddress(rs.getString("address"));
            l.setState(rs.getString("state"));
            l.setZipCode(rs.getString("zipCode"));
            l.setLocationDescription(rs.getString("description"));
            l.setLatitude(rs.getBigDecimal("latitude"));
            l.setLongitude(rs.getBigDecimal("longitude"));

            return l;
        }
    }

    private static class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization o = new Organization();

            o.setOrganizationId(rs.getInt("organizationId"));
            o.setOrganizationName(rs.getString("name"));
            o.setDescription(rs.getString("description"));
            o.setAddress(rs.getString("address"));
            o.setState(rs.getString("state"));
            o.setZipCode(rs.getString("zipCode"));

            return o;
        }

    }

    private static class SightingMapper implements RowMapper<Sightings> {

        @Override
        public Sightings mapRow(ResultSet rs, int i) throws SQLException {
            Sightings s = new Sightings();

            s.setSightingId(rs.getInt("sightingId"));
            s.setDateSighted(LocalDate.parse(rs.getDate("date").toString()));
            return s;
        }

    }
}
