/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superherosightingsspringmvc.controller;

import com.superherosightingsspringmvc.dto.Location;
import com.superherosightingsspringmvc.dto.Sighting;
import com.superherosightingsspringmvc.dto.Super;
import com.superherosightingsspringmvc.service.ServiceLayer;
import java.time.LocalDate;
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
public class SightingController {
    
    ServiceLayer service;

    @Inject
    public SightingController(ServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/sightings", method = RequestMethod.GET)
    public String displaySightingsPage(Model model) {

        List<Sighting> sightingList = service.getAllSightings();
        
        List<Super> superList = service.getAllSupers();
        
        List<Location> locationList = service.getAllLocations();

        model.addAttribute("sightingList", sightingList);
        
        model.addAttribute("superList", superList);
        
        model.addAttribute("locationList", locationList);

        return "sightings";
    }

    @RequestMapping(value = "/createSighting", method = RequestMethod.POST)
    public String createSighting(HttpServletRequest request, Model model, String superId, String locationId) {
        
      Sighting sighting = new Sighting();
      LocalDate date = LocalDate.parse(request.getParameter("date"));
      sighting.setDate(LocalDate.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth()));
           
      int superId2 = Integer.parseInt(superId);
                 
      sighting.setSuperId(superId2);
      
      int locationId2 = Integer.parseInt(locationId);
                 
      sighting.setLocationId(locationId2);

      service.addSighting(sighting);

      return "redirect:sightings";
      
    }

    @RequestMapping(value = "/sightingDetails", method = RequestMethod.GET)
    public String displaySightingDetails(HttpServletRequest request, Model model) {
        String sightingIdParameter = request.getParameter("sightingId");

        int sightingId = Integer.parseInt(sightingIdParameter);

        Sighting sighting = service.getSighting(sightingId);
        
        int superId = sighting.getSuperId();
        
        Super superPerson = service.getSuper(superId);
        
        int locationId = sighting.getLocationId();
        
        Location location = service.getLocation(locationId);

        model.addAttribute("sighting", sighting);
        
        model.addAttribute("superPerson", superPerson);
        
        model.addAttribute("location", location);

        return "sightingDetails";
    }

    @RequestMapping(value = "/deleteSighting", method = RequestMethod.GET)
    public String deleteSighting(HttpServletRequest request) {
        String sightingIdParameter = request.getParameter("sightingId");

        int sightingId = Integer.parseInt(sightingIdParameter);

        service.deleteSighting(sightingId);

        return "redirect:sightings";
    }

    @RequestMapping(value = "/displayEditSighting", method = RequestMethod.GET)
    public String displayEditSighting(HttpServletRequest request, Model model) {
        
        String sightingIdParameter = request.getParameter("sightingId");

        int sightingId = Integer.parseInt(sightingIdParameter);

        Sighting sighting = service.getSighting(sightingId);
        
        List<Super> superList = service.getAllSupers();
        
        List<Location> locationList = service.getAllLocations();

        model.addAttribute("sighting", sighting);
        
        model.addAttribute("superList", superList);
        
        model.addAttribute("locationList", locationList);

        return "editSighting";
    }

    @RequestMapping(value = "/editSighting", method = RequestMethod.POST)
    public String editSighting(@ModelAttribute("sighting") Sighting sighting) {
        
        service.updateSighting(sighting);

        return "redirect:sightings";
    }
    
}
