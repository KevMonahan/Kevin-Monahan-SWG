/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SuperHeroDao;
import com.sg.superherosightings.dto.Location;
import java.math.BigDecimal;
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
public class LocationController {

    SuperHeroDao dao;

    @Inject
    public LocationController(SuperHeroDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/displayLocationPage", method = RequestMethod.GET)
    public String displayLocationPage(Model model) {
        List<Location> locationList = dao.getAllLocations();

        model.addAttribute("locationList", locationList);
        return "location";
    }

    @RequestMapping(value = "/createLocation", method = RequestMethod.POST)
    public String createLocation(HttpServletRequest request) {
        Location location = new Location();
        location.setLocationName(request.getParameter("name"));
        location.setAddress(request.getParameter("address"));
        location.setState(request.getParameter("state"));
        location.setZipCode(request.getParameter("zipCode"));
        location.setLocationDescription(request.getParameter("description"));
        location.setLatitude(new BigDecimal(request.getParameter("latitude")));
        location.setLongitude(new BigDecimal(request.getParameter("longitude")));

        dao.addLocation(location);

        return "redirect:displayLocationPage";

    }

    @RequestMapping(value = "/displayLocationEdit", method = RequestMethod.GET)
    public String displayLocationEdit(HttpServletRequest request, Model model) {
        String locationIdParameter = request.getParameter("locationId");
        int locationId = Integer.parseInt(locationIdParameter);
        Location location = dao.getLocationById(locationId);
        model.addAttribute("location", location);

        return "locationEdit";
    }
    
    @RequestMapping(value="updateLocation", method=RequestMethod.POST)
    public String updateLocation(HttpServletRequest rq) {
        Location location = new Location(rq.getParameter("name"),
                rq.getParameter("address"),
                rq.getParameter("state"),
                rq.getParameter("zipCode"),
                rq.getParameter("description"),
                new BigDecimal(rq.getParameter("latitude")),
                new BigDecimal(rq.getParameter("longitude")));
        location.setLocationId(Integer.parseInt(rq.getParameter("locationId")));
        
        dao.updateLocation(location);
        return "redirect:displayLocationPage";
        
    }
    
    @RequestMapping(value = "/deleteLocation", method = RequestMethod.GET) 
    public String deleteLocation(HttpServletRequest request) {
        String locationIdParameter = request.getParameter("locationId");
        int locationId = Integer.parseInt(locationIdParameter);
        dao.deleteLocation(locationId);
        return "redirect:displayLocationPage";
    }
}