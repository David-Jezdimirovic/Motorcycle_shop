/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.controllers;

import com.pz3.IT355PZ3.entities.Korisnik;
import com.pz3.IT355PZ3.entities.Motor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class MotorController {
    
    
    
    
      //Save new motor
    @PostMapping("/savemotor")
    public String saveMotor( Motor motor) {
        final String uri = "http://localhost:8080/api/addmotor";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(uri, motor, Motor.class);
        return "redirect:/vozilo/dodajvozilo";
    }
    
    //Delete motor by id - poziva REST
    @GetMapping("/deleteMotor")
    public String delete(@RequestParam("motorId") int theMotorId) {
        final String uri = "http://localhost:8080/api/deletemotor";
         RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri + "/" + theMotorId);
        return "redirect:/vozila/listamotora";
    }
    
    
}
