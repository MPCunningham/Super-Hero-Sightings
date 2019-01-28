/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superherosightingsspringmvc.controller;

import com.superherosightingsspringmvc.dto.Organization;
import com.superherosightingsspringmvc.dto.Power;
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
public class SuperController {
    
    ServiceLayer service;

    @Inject
    public SuperController(ServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/supers", method = RequestMethod.GET)
    public String displaySupersPage(Model model) {

        List<Super> superList = service.getAllSupers();
        
        List<Organization> organizationList = service.getAllOrganizations();
        
        List<Power> powerList = service.getAllPowers();

        model.addAttribute("superList", superList);
        
        model.addAttribute("organizationList", organizationList);
        
        model.addAttribute("powerList", powerList);

        return "supers";
    }

    @RequestMapping(value = "/createSuper", method = RequestMethod.POST)
    public String createSuper(HttpServletRequest request, Model model, String[] organizationIdList, String[] powerIdList) {
        
      Super superPerson = new Super();
      superPerson.setName(request.getParameter("name"));
      superPerson.setDescription(request.getParameter("description")); 
      
      List<Integer> organizationIdList2 = new ArrayList<>();
      
      if (organizationIdList != null) {
        for (String currentOrganizationId : organizationIdList) {
            int currentId = Integer.parseInt(currentOrganizationId);
            organizationIdList2.add(currentId);
        }
      }
      superPerson.setOrganizationIdList(organizationIdList2);
      
      List<Integer> powerIdList2 = new ArrayList<>();
      
      if (powerIdList != null) {
        for (String currentPowerId : powerIdList) {
            int currentId = Integer.parseInt(currentPowerId);
            powerIdList2.add(currentId);
        }
      }
      superPerson.setPowerIdList(powerIdList2);

      service.addSuper(superPerson);

      return "redirect:supers";
      
    }

    @RequestMapping(value = "/superDetails", method = RequestMethod.GET)
    public String displaySuperDetails(HttpServletRequest request, Model model) {
        String superIdParameter = request.getParameter("superId");

        int superId = Integer.parseInt(superIdParameter);

        Super superPerson = service.getSuper(superId);
        
        List<Integer> organizationIdList = superPerson.getOrganizationIdList();
        
        List<Organization> organizationList = new ArrayList<>();
        
        for (int currentId : organizationIdList) {
            Organization organization = service.getOrganization(currentId);
            organizationList.add(organization);
        }
        
        List<Integer> powerIdList = superPerson.getPowerIdList();
        
        List<Power> powerList = new ArrayList<>();
        
        for (int currentId : powerIdList) {
            Power power = service.getPower(currentId);
            powerList.add(power);
        }

        model.addAttribute("superPerson", superPerson);
        
        model.addAttribute("organizationList", organizationList);
        
        model.addAttribute("powerList", powerList);

        return "superDetails";
    }

    @RequestMapping(value = "/deleteSuper", method = RequestMethod.GET)
    public String deleteSuper(HttpServletRequest request) {
        String superIdParameter = request.getParameter("superId");

        int superId = Integer.parseInt(superIdParameter);

        service.deleteSuper(superId);

        return "redirect:supers";
    }

    @RequestMapping(value = "/displayEditSuper", method = RequestMethod.GET)
    public String displayEditSuper(HttpServletRequest request, Model model) {
        String superIdParameter = request.getParameter("superId");

        int superId = Integer.parseInt(superIdParameter);

        Super superPerson = service.getSuper(superId);
        
        List<Organization> organizationList = service.getAllOrganizations();
        
        List<Power> powerList = service.getAllPowers();

        model.addAttribute("super", superPerson);
        
        model.addAttribute("organizationList", organizationList);
        
        model.addAttribute("powerList", powerList);

        return "editSuper";
    }

    @RequestMapping(value = "/editSuper", method = RequestMethod.POST)
    public String editSuper(@ModelAttribute("super") Super superPerson) {
        service.updateSuper(superPerson);

        return "redirect:supers";
    }
    
}
