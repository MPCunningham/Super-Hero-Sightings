/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superherosightingsspringmvc.controller;

import com.superherosightingsspringmvc.dto.Organization;
import com.superherosightingsspringmvc.dto.Super;
import com.superherosightingsspringmvc.service.ServiceLayer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 4oaks
 */
@Controller
public class OrganizationController {
    
    ServiceLayer service;

    @Inject
    public OrganizationController(ServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/organizations", method = RequestMethod.GET)
    public String displayOrganizationsPage(Model model) {

        List<Organization> organizationList = service.getAllOrganizations();
        
        List<Super> superList = service.getAllSupers();

        model.addAttribute("organizationList", organizationList);
        
        model.addAttribute("superList", superList);

        return "organizations";
    }

    @RequestMapping(value = "/createOrganization", method = RequestMethod.POST)
    public String createOrganization(HttpServletRequest request, Model model, String[] superIdList) {
        
      Organization organization = new Organization();
      organization.setName(request.getParameter("name"));
      organization.setDescription(request.getParameter("description"));
      organization.setAddress(request.getParameter("address"));
      organization.setPhoneNumber(request.getParameter("phoneNumber"));
      
      List<Integer> superIdList2 = new ArrayList<>();
      
      if (superIdList != null) {
        for (String currentSuperId : superIdList) {
            int currentId = Integer.parseInt(currentSuperId);
            superIdList2.add(currentId);
        }
      }
      
      organization.setSuperIdList(superIdList2);

      service.addOrganization(organization);

      return "redirect:organizations";
      
    }

    @RequestMapping(value = "/organizationDetails", method = RequestMethod.GET)
    public String displayOrganizationDetails(HttpServletRequest request, Model model) {
        String organizationIdParameter = request.getParameter("organizationId");

        int organizationId = Integer.parseInt(organizationIdParameter);

        Organization organization = service.getOrganization(organizationId);
        
        List<Integer> superIdList = organization.getSuperIdList();
        
        List<Super> superList = new ArrayList<>();
        
        for (int currentId : superIdList) {
            Super superPerson = service.getSuper(currentId);
            superList.add(superPerson);
        }

        model.addAttribute("organization", organization);
        
        model.addAttribute(superList);

        return "organizationDetails";
    }

    @RequestMapping(value = "/deleteOrganization", method = RequestMethod.GET)
    public String deleteOrganization(HttpServletRequest request) {
        String organizationIdParameter = request.getParameter("organizationId");

        int organizationId = Integer.parseInt(organizationIdParameter);

        service.deleteOrganization(organizationId);

        return "redirect:organizations";
    }

    @RequestMapping(value = "/displayEditOrganization", method = RequestMethod.GET)
    public String displayEditOrganization(HttpServletRequest request, Model model) {
        String organizationIdParameter = request.getParameter("organizationId");

        int organizationId = Integer.parseInt(organizationIdParameter);

        Organization organization = service.getOrganization(organizationId);
        
        List<Super> superList = service.getAllSupers();
        
        model.addAttribute("superList", superList);

        model.addAttribute("organization", organization);

        return "editOrganization";
    }

    @RequestMapping(value = "/editOrganization", method = RequestMethod.POST)
    public String editOrganization(@ModelAttribute("organization") Organization organization) {
        
        service.updateOrganization(organization);

        return "redirect:organizations";
    }
    
}
