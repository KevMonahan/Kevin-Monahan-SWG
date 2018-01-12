/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SuperHeroDao;
import com.sg.superherosightings.dto.Organization;
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
public class OrganizationController {

    SuperHeroDao dao;
    
    @Inject
    public OrganizationController(SuperHeroDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/displayOrganizationPage", method = RequestMethod.GET)
    public String displayOrganizationPage(Model model) {
        List<Organization> organizationList = dao.getAllOrganizations();
        model.addAttribute("organizationList", organizationList);
        return "organization";
    }

    @RequestMapping(value = "/createOrganization", method = RequestMethod.POST)
    public String createOrganization(HttpServletRequest request) {
        Organization organization = new Organization();
        organization.setOrganizationName(request.getParameter("name"));
        organization.setAddress(request.getParameter("address"));
        organization.setState(request.getParameter("state"));
        organization.setZipCode(request.getParameter("zipCode"));
        organization.setDescription(request.getParameter("description"));
        dao.addOrganization(organization);
        
        return "redirect:displayOrganizationPage";
    }
    
    
    
    @RequestMapping(value = "/deleteOrganization", method = RequestMethod.GET)
    public String deleteOrganization(HttpServletRequest request) {
        String orgIdParameter = request.getParameter("organizationId");
        int orgId = Integer.parseInt(orgIdParameter);
        dao.deleteOrganization(orgId);
        return "redirect:displayOrganizationPage";
    }
    
    @RequestMapping(value = "/displayOrganizationEdit", method = RequestMethod.GET)
    public String displayOrganizationEdit(HttpServletRequest request, Model model) {
        int orgId = Integer.parseInt(request.getParameter("organizationId"));
        Organization organization = dao.getOrganizationById(orgId);
        model.addAttribute("organization", organization);
        
        return "organizationEdit";
    }
    
    @RequestMapping(value="updateOrganization", method=RequestMethod.POST)
    public String updateOrganization(HttpServletRequest rq) {
        Organization organization = new Organization(rq.getParameter("name"),
                rq.getParameter("address"),
                rq.getParameter("state"),
                rq.getParameter("zipCode"),
                rq.getParameter("description"));
        organization.setOrganizationId(Integer.parseInt(rq.getParameter("organizationId")));
        dao.updateOrganization(organization);
        return "redirect:displayOrganizationPage";
    }
}
