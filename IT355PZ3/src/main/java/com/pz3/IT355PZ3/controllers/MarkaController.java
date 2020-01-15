/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.controllers;

import com.pz3.IT355PZ3.entities.Korisnik;
import com.pz3.IT355PZ3.entities.Marka;
import com.pz3.IT355PZ3.entities.Model;
import com.pz3.IT355PZ3.entities.Motor;
import com.pz3.IT355PZ3.service.KorisnikService;
import com.pz3.IT355PZ3.service.MarkaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping(value="/vozilo")
public class MarkaController {
    
    @Autowired
   private MarkaService markaService;
    
    @RequestMapping(value="/dodajvozilo", method = RequestMethod.GET)
	public ModelAndView dodavanje(){
		ModelAndView modelAndView = new ModelAndView();
                RestTemplate restTemplate = new RestTemplate();
                final String uri = "http://localhost:8080/api/marke";
                final String uri2 = "http://localhost:8080/api/modeli";
                List<Marka> marke = restTemplate.getForObject(uri, List.class);
                List<Model> modeli = restTemplate.getForObject(uri2, List.class);
		Marka marka = new Marka();
                Model model = new Model();
                Motor motor = new Motor();
                modelAndView.addObject("marke", marke);
                modelAndView.addObject("modeli", modeli);
		modelAndView.addObject("marka", marka);
                modelAndView.addObject("model", model);
                modelAndView.addObject("motor", motor);
		modelAndView.setViewName("dodajvozilo");
               
		return modelAndView;
	}
        
         //Save new marka
    @PostMapping("/savemarka")
    public String saveMarka(@Valid Marka theMarka) {
       // markaService.addMarka(marka);
        final String uri = "http://localhost:8080/api/addmarka";
        RestTemplate restTemplate = new RestTemplate();
        
        restTemplate.postForEntity(uri, theMarka, Marka.class);
       // restTemplate.postForObject(uri, marka, Marka.class);
        //restTemplate.
        return "redirect:/vozilo/dodajvozilo";
    }
        
    
    //Delete marka by id - poziva REST
    @GetMapping("/deleteMarka")
    public String delete(@RequestParam("markaId") int theMarkaId) {
        final String uri = "http://localhost:8080/api/deletemarka";
         RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri + "/" + theMarkaId);
        return "redirect:/vozila/listamotora";
    }
    
    
    
    
    
//        @GetMapping("/showCities")
//        public String showCityAddForm(Model theModel) {
//        final String uri = "http://localhost:8080/api/cities";
//        RestTemplate restTemplate = new RestTemplate();
//        List<City> cities = restTemplate.getForObject(uri, List.class);
//        City city = new City();
//        theModel.addAttribute("city", city);
//        theModel.addAttribute("cities", cities);
//        return "city/addCity";
//    }
        
        
        
//         @GetMapping("/showCities")
//    public String showCityAddForm(Model theModel) {
//        final String uri = "http://localhost:8080/api/cities";
//        RestTemplate restTemplate = new RestTemplate();
//        List<City> cities = restTemplate.getForObject(uri, List.class);
//        City city = new City();
//        theModel.addAttribute("city", city);
//        theModel.addAttribute("cities", cities);
//        return "city/addCity";
//    }
}
