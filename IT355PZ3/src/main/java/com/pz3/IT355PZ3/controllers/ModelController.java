/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.controllers;

import com.pz3.IT355PZ3.entities.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping(value="/vozilo")
public class ModelController {
    
       //Save new model
    @PostMapping("/savemodel")
    public String saveMarka( Model model) {
        final String uri = "http://localhost:8080/api/addmodel";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(uri, model, Model.class);
        return "redirect:/vozilo/dodajvozilo";
    }
    
    
    //Delete model by id - poziva REST
    @GetMapping("/deleteModel")
    public String delete(@RequestParam("modelId") int theModelId) {
        final String uri = "http://localhost:8080/api/deletemodel";
         RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri + "/" + theModelId);
         return "redirect:/vozila/listamotora";
    }
    
    
}
