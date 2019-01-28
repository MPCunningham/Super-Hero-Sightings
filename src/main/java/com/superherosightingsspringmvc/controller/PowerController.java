/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superherosightingsspringmvc.controller;

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
public class PowerController {
    
   ServiceLayer service;

    @Inject
    public PowerController(ServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/powers", method = RequestMethod.GET)
    public String displayPowersPage(Model model) {

        List<Power> powerList = service.getAllPowers();
        
        List<Super> superList = service.getAllSupers();

        model.addAttribute("powerList", powerList);
        
        model.addAttribute("superList", superList);

        return "powers";
    }

    @RequestMapping(value = "/createPower", method = RequestMethod.POST)
    public String createPower(HttpServletRequest request, Model model, String[] superIdList) {
        
      Power power = new Power();
      power.setName(request.getParameter("name"));
      power.setDescription(request.getParameter("description"));
      
      List<Integer> superIdList2 = new ArrayList<>();
      
      if (superIdList != null) {
        for (String currentSuperId : superIdList) {
            int currentId = Integer.parseInt(currentSuperId);
            superIdList2.add(currentId);
        }
      }
      power.setSuperIdList(superIdList2);

      service.addPower(power);

      return "redirect:powers";
      
    }

    @RequestMapping(value = "/powerDetails", method = RequestMethod.GET)
    public String displayPowerDetails(HttpServletRequest request, Model model) {
        String powerIdParameter = request.getParameter("powerId");

        int powerId = Integer.parseInt(powerIdParameter);

        Power power = service.getPower(powerId);
        
        List<Integer> superIdList = power.getSuperIdList();
        
        List<Super> superList = new ArrayList<>();
        
        for (int currentId : superIdList) {
            Super superPerson = service.getSuper(currentId);
            superList.add(superPerson);
        }

        model.addAttribute("power", power);
        
        model.addAttribute("superList", superList);

        return "powerDetails";
    }

    @RequestMapping(value = "/deletePower", method = RequestMethod.GET)
    public String deletePower(HttpServletRequest request) {
        String powerIdParameter = request.getParameter("powerId");

        int powerId = Integer.parseInt(powerIdParameter);

        service.deletePower(powerId);

        return "redirect:powers";
    }

    @RequestMapping(value = "/displayEditPower", method = RequestMethod.GET)
    public String displayEditPower(HttpServletRequest request, Model model) {
        String powerIdParameter = request.getParameter("powerId");

        int powerId = Integer.parseInt(powerIdParameter);

        Power power = service.getPower(powerId);
        
        List<Super> superList = service.getAllSupers();
        
        model.addAttribute("superList", superList);

        model.addAttribute("power", power);

        return "editPower";
    }

    @RequestMapping(value = "/editPower", method = RequestMethod.POST)
    public String editPower(@ModelAttribute("power") Power power) {
        
        service.updatePower(power);

        return "redirect:powers";
    }
    
}
