/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SuperHeroDao;
import com.sg.superherosightings.dto.Hero;
import com.sg.superherosightings.dto.Organization;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author user
 */
@Controller
public class HeroController {

    

    SuperHeroDao dao;

    @Inject
    public HeroController(SuperHeroDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/displayHeroPage", method = RequestMethod.GET)
    public String displayHeroPage(Model model) {
        // Get all the Contacts from the DAO
        List<Hero> heroList = dao.getAllHeros();
        List<Organization> organizationList = dao.getAllOrganizations();
        
        model.addAttribute("heroList", heroList);
        model.addAttribute("organizationList", organizationList);

        return "hero";
    }

    @RequestMapping(value = "/deleteHero", method = RequestMethod.GET)
    public String deleteHero(HttpServletRequest request) {
        String heroIdParameter = request.getParameter("heroId");
        int heroId = Integer.parseInt(heroIdParameter);
        dao.deleteHero(heroId);
        return "redirect:displayHeroPage";
    }

    @RequestMapping(value = "/displayHeroEdit", method = RequestMethod.GET)
    public String displayHeroEdit(HttpServletRequest request, Model model) {
        String heroIdParameter = request.getParameter("heroId");
        int heroId = Integer.parseInt(heroIdParameter);
        Hero hero = dao.getHeroById(heroId);
        model.addAttribute("hero", hero);

        return "heroEdit";
    }

    @RequestMapping(value = "updateHero", method = RequestMethod.POST)
    public String updateHero(HttpServletRequest request) {
        Hero hero = new Hero(request.getParameter("name"), request.getParameter("description"), request.getParameter("superPower"));
        hero.setHeroId(Integer.parseInt(request.getParameter("heroId")));

        List<Organization> organizationList = new ArrayList<>();
        List<Integer> orgIdList = new ArrayList<>();

        String[] organizationIds = request.getParameterValues("organization");
        int[] orgIds = new int[organizationIds.length];
        for (int i = 0; i < organizationIds.length; i++) {
            orgIds[i] = Integer.parseInt(organizationIds[i]);
            orgIdList.add(orgIds[i]);
        }

        for (int orgId : orgIdList) {
            Organization organization = dao.getOrganizationById(orgId);
            organizationList.add(organization);
        }

        hero.setOrganizations(organizationList);
        dao.updateHero(hero);
        return "redirect:displayHeroPage";
    }

   
    @RequestMapping(value = "/createHero", method = RequestMethod.POST)
    public String createHero(HttpServletRequest request) {

        Hero hero = new Hero();
        hero.setName(request.getParameter("name"));

        hero.setSuperPower(request.getParameter("superpower"));
        hero.setDescription(request.getParameter("description"));
       
        List<Organization> organizationList = new ArrayList<>();
        List<Integer> orgIdList = new ArrayList<>();

        String[] organizationIds = request.getParameterValues("organization");
        int[] orgIds = new int[organizationIds.length];
        for (int i = 0; i < organizationIds.length; i++) {
            orgIds[i] = Integer.parseInt(organizationIds[i]);
            orgIdList.add(orgIds[i]);
        }

        for (int orgId : orgIdList) {
            Organization organization = dao.getOrganizationById(orgId);
            organizationList.add(organization);
        }

        hero.setOrganizations(organizationList);

        dao.addHero(hero);

        return "redirect:displayHeroPage";
    }
}
