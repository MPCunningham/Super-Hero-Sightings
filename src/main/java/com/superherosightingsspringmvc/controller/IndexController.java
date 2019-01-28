/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superherosightingsspringmvc.controller;

import com.superherosightingsspringmvc.dto.Sighting;
import com.superherosightingsspringmvc.service.ServiceLayer;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 4oaks
 */
@Controller
public class IndexController {
    
    ServiceLayer service;
    
    public IndexController(ServiceLayer service) {
        this.service = service;
    } 
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String displayIndexPage(Model model) {
        //List<Sighting> sightingList = service.getLatestSightings();
        
        //model.addAttribute("sightingList", sightingList);
        
        return "index";
    }
    
}
