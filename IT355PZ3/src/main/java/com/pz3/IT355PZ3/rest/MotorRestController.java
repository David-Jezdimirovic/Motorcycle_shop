/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.rest;


import com.pz3.IT355PZ3.entities.Motor;
import com.pz3.IT355PZ3.service.MotorService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class MotorRestController {
    
     @Autowired
    MotorService motorService;
    
    //Return list of all motori
    @GetMapping("/motori")
    public List<Motor> getAllMotori() {
        List<Motor> motori = motorService.getMotori();
        return motori;
    }
    
      //Saves new motor
    @PostMapping("/addmotor")
    public void saveMotor (HttpServletResponse response, Motor motor) throws IOException {
       // List<City> cities = cityService.findAll();
        motorService.addMotor(motor);
        //return motor;
        response.sendRedirect("/vozila/listamotora");
    }
    
    
     //Delete motor based on ID
    @DeleteMapping("/deletemotor/{motorId}")
    public void deleteMotor(HttpServletResponse response, @PathVariable int motorId) throws IOException {
        motorService.deleteById(motorId);
        //return "Obrisan je";
       response.sendRedirect("/vozila/listamotora");
    }
    
    
     //Delete motor based on ID
//    @DeleteMapping("/deletemotor")
//    public void deleteCity(HttpServletResponse response, @RequestParam("motorId") int theMotorId) throws IOException {
//        motorService.deleteById(theMotorId);
//       // return "Obrisan je";
//       response.sendRedirect("/vozilo/listamotora");
//    }
    
}
