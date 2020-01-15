/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.rest;

import com.pz3.IT355PZ3.entities.Model;
import com.pz3.IT355PZ3.service.ModelService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class ModelRestController {
    
    @Autowired
    ModelService modelService;
    
    //Return list of all modeli
    @GetMapping("/modeli")
    public List<Model> getAllMarke() {
        List<Model> modeli = modelService.getModeli();
        return modeli;
    }
    
      //Saves new marka
    @PostMapping("/addmodel")
    public void saveMarka(HttpServletResponse response, Model model) throws IOException {
       // List<City> cities = cityService.findAll();
        modelService.addModel(model);
        
            //return model;
            response.sendRedirect("/vozilo/dodajvozilo");
       
    }
    
    
    
      //Delete model based on ID
    @DeleteMapping("/deletemodel/{modelId}")
    public void deleteModel(HttpServletResponse response, @PathVariable int modelId) throws IOException {
        modelService.deleteById(modelId);
        //return "Obrisan je";
       //response.sendRedirect("/vozilo/listamotora");
    }
    
    
    
    
}
