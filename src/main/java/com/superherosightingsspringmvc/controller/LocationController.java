/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superherosightingsspringmvc.controller;

import com.superherosightingsspringmvc.dto.Location;
import com.superherosightingsspringmvc.service.ServiceLayer;
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
public class LocationController {

    ServiceLayer service;

    @Inject
    public LocationController(ServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public String displayLocationsPage(Model model) {

        List<Location> locationList = service.getAllLocations();

        model.addAttribute("locationList", locationList);

        return "locations";
    }

    @RequestMapping(value = "/createLocation", method = RequestMethod.POST)
    public String createLocation(HttpServletRequest request, Model model) {
        Boolean errorFree = true;
        String errorMessage = "Please enter a valid number";
        
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String address = request.getParameter("address");
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        
        Location location = new Location();
        location.setName(name);
        location.setDescription(description);
        location.setAddress(address);

        try {
            location.setLatitude(Double.parseDouble(latitude));
        } catch (NumberFormatException e) {
            errorFree = false;
            model.addAttribute("latitude", errorMessage);
            latitude = errorMessage;
            model.addAttribute("name", name);
            model.addAttribute("description", description);
            model.addAttribute("address", address);
            model.addAttribute("longitude", longitude);
        }

        try {
            location.setLongitude(Double.parseDouble(longitude));
        } catch (NumberFormatException e) {
            errorFree = false;
            model.addAttribute("longitude", errorMessage);
            model.addAttribute("name", name);
            model.addAttribute("description", description);
            model.addAttribute("address", address);  
            model.addAttribute("latitude", latitude);
        }

        if (errorFree) {

            service.addLocation(location);

            return "redirect:locations";
        } else {
            List<Location> locationList = service.getAllLocations();

            model.addAttribute("locationList", locationList);

            return "locations";
        }
    }

    @RequestMapping(value = "/locationDetails", method = RequestMethod.GET)
    public String displayLocationDetails(HttpServletRequest request, Model model) {
        String locationIdParameter = request.getParameter("locationId");

        int locationId = Integer.parseInt(locationIdParameter);

        Location location = service.getLocation(locationId);

        model.addAttribute("location", location);

        return "locationDetails";
    }

    @RequestMapping(value = "/deleteLocation", method = RequestMethod.GET)
    public String deleteLocation(HttpServletRequest request) {
        String locationIdParameter = request.getParameter("locationId");

        int locationId = Integer.parseInt(locationIdParameter);

        service.deleteLocation(locationId);

        return "redirect:locations";
    }

    @RequestMapping(value = "/displayEditLocation", method = RequestMethod.GET)
    public String displayEditLocation(HttpServletRequest request, Model model) {
        String locationIdParameter = request.getParameter("locationId");

        int locationId = Integer.parseInt(locationIdParameter);

        Location location = service.getLocation(locationId);

        model.addAttribute("location", location);

        return "editLocation";
    }

    @RequestMapping(value = "/editLocation", method = RequestMethod.POST)
    public String editLocation(@ModelAttribute("location") Location location) {
        
        service.updateLocation(location);

        return "redirect:locations";
    }
}
