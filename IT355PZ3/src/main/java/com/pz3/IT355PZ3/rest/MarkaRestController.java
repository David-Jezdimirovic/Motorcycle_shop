/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.rest;

import com.pz3.IT355PZ3.entities.Marka;
import com.pz3.IT355PZ3.service.MarkaService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class MarkaRestController {
    
    @Autowired
    MarkaService markaService;
    
    //Return list of all marki
    @GetMapping("/marke")
    public List<Marka> getAllMarke() {
        List<Marka> marke = markaService.getMarke();
        return marke;
    }
    
    //Saves new marka
   // @PostMapping("/addmarka")
    @RequestMapping(value = "/addmarka", method = RequestMethod.POST)
    public void saveMarka(HttpServletResponse response,@Valid Marka marka) throws IOException {
       // List<City> cities = cityService.findAll();
        
        markaService.addMarka(marka);
        response.sendRedirect("/vozilo/dodajvozilo");
       // return marka;
    }
    
    
     //Delete motor based on ID
    @DeleteMapping("/deletemarka/{markaId}")
    public String deleteMarka(HttpServletResponse response, @PathVariable int markaId) throws IOException {
        markaService.deleteById(markaId);
        return "Obrisan je";
       //response.sendRedirect("/vozilo/listamotora");
    }
    
    
}
