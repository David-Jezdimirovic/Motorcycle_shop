/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.controllers;

import com.pz3.IT355PZ3.entities.Marka;
import com.pz3.IT355PZ3.entities.Motor;
import com.pz3.IT355PZ3.service.MotorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping(value="/vozilo")
public class UpdateMotorController {
    
    @Autowired
    MotorService motorService;
    
    @GetMapping("/updatemotor/{motorId}")
    public String showFormForUpdate(@PathVariable int motorId,
            Model theModel) {

        RestTemplate restTemplate = new RestTemplate();
               // final String uri = "http://localhost:8080/api/marke";
                final String uri2 = "http://localhost:8080/api/modeli";
                //List<Marka> marke = restTemplate.getForObject(uri, List.class);
                List<com.pz3.IT355PZ3.entities.Model> modeli = restTemplate.getForObject(uri2, List.class);
        Motor motor = motorService.getMotorById(motorId);
        

        //theModel.addAttribute("marke", marke);
        theModel.addAttribute("modeli", modeli);
        theModel.addAttribute("motor", motor);

        return "updatemotor";
    }
    
}
