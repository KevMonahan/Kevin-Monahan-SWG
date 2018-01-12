/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SuperHeroDao;
import com.sg.superherosightings.dto.Hero;
import com.sg.superherosightings.dto.Location;
import com.sg.superherosightings.dto.Sightings;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author user
 */
@Controller
public class SightingController {
    
    SuperHeroDao dao;
    
    @Inject
    public SightingController(SuperHeroDao dao) {
        this.dao = dao;
    }
    public static final String DELIMITER = ",";
    
    @RequestMapping(value = "/displaySightingPage", method = RequestMethod.GET)
    public String displaySightingPage(Model model) {
        List<Sightings> sightingList = dao.getAllSightings();
        List<Hero> heroList = dao.getAllHeros();
        List<Location> locationList = dao.getAllLocations();
        model.addAttribute("sightingList", sightingList);
        model.addAttribute("heroList", heroList);
        model.addAttribute("locationList", locationList);
        
        return "sighting";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Sightings> sightings = dao.getTenRecentSightings();
        model.addAttribute("sightings", sightings);
        return "/index";
    }
    
    @RequestMapping(value = "/createSighting", method = RequestMethod.POST)
    public String createSighting(HttpServletRequest request) {
        Sightings sighting = new Sightings();
        List<Hero> heroList = new ArrayList<>();
        List<Integer> heroIdList = new ArrayList<>();
        String[] heroIds = request.getParameterValues("hero");
        int[] heroIds2 = new int[heroIds.length];
        
        for (int i = 0; i < heroIds.length; i++) {
            heroIds2[i] = Integer.parseInt(heroIds[i]);
            heroIdList.add(heroIds2[i]);
        }
        
        for (int heroId : heroIdList) {
            Hero hero = dao.getHeroById(heroId);
            heroList.add(hero);
        }
        
        sighting.setHerosSighted(heroList);

        sighting.setSightingLocation(dao.getLocationById(Integer.parseInt(request.getParameter("location"))));
        sighting.setDateSighted(LocalDate.parse(request.getParameter("sightingDate")));
        
        dao.addSighting(sighting);
        
        return "redirect:displaySightingPage";
    }
    
    @RequestMapping(value = "/deleteSighting", method = RequestMethod.GET)
    public String deleteSighting(HttpServletRequest request) {
        int sightingId = Integer.parseInt(request.getParameter("sightingId"));
        dao.deleteSighting(sightingId);
        return "redirect:displaySightingPage";
    }
    
    @RequestMapping(value = "/displaySightingEdit", method = RequestMethod.GET)
    public String displaySightingEdit(HttpServletRequest request, Model model) {
        int sightingId = Integer.parseInt(request.getParameter("sightingId"));
        Sightings sighting = dao.getSightingById(sightingId);
        List<Location> locations = dao.getAllLocations();
        model.addAttribute("sighting", sighting);
        model.addAttribute("locations", locations);
        return "sightingEdit";
    }
    
    @RequestMapping(value="updateSighting", method=RequestMethod.POST)
    public String updateSighting(HttpServletRequest rq) {
        Sightings sighting = new Sightings();
       
        List<Hero> heroList = new ArrayList<>();
        List<Integer> heroIdList = new ArrayList<>();
        String[] heroIds = rq.getParameterValues("hero");
        int[] heroIds2 = new int[heroIds.length];
        
        for (int i = 0; i < heroIds.length; i++) {
            heroIds2[i] = Integer.parseInt(heroIds[i]);
            heroIdList.add(heroIds2[i]);
        }
        
        for (int heroId : heroIdList) {
            Hero hero = dao.getHeroById(heroId);
            heroList.add(hero);
        }
        sighting.setDateSighted(LocalDate.parse(rq.getParameter("sightingDate")));
        sighting.setHerosSighted(heroList);
        sighting.setSightingId(Integer.parseInt(rq.getParameter("sightingId")));
        sighting.setSightingLocation(dao.getLocationById(Integer.parseInt(rq.getParameter("location"))));
        dao.updateSighting(sighting);
        return "redirect:displaySightingPage";
    }

}