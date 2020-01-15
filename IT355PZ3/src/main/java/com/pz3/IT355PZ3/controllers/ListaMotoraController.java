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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping(value="/vozila")
public class ListaMotoraController {
    
    @Autowired
    KorisnikService korisnikService;
    
     @RequestMapping(value="/listamotora", method = RequestMethod.GET)
	public ModelAndView dodavanje(){
		ModelAndView modelAndView = new ModelAndView();
                RestTemplate restTemplate = new RestTemplate();
                final String uri = "http://localhost:8080/api/marke";
                final String uri2 = "http://localhost:8080/api/modeli";
                final String uri3 = "http://localhost:8080/api/motori";
                List<Marka> marke = restTemplate.getForObject(uri, List.class);
                List<Model> modeli = restTemplate.getForObject(uri2, List.class);
                List<Motor> motori = restTemplate.getForObject(uri3, List.class);
                
                
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Korisnik korisnik = korisnikService.findKorisnikByEmail(auth.getName());
              
//                System.out.println(korisnik.getIme() + " " + korisnik.getPrezime());
//                System.out.println(korisnik.toString());
		modelAndView.addObject("userInfo", "Pozdrav " + korisnik.getIme() + " " + korisnik.getPrezime() + " (" + korisnik.getEmail() + ")");
                modelAndView.addObject("korisnik", korisnik);
                
//		Marka marka = new Marka();
//                Model model = new Model();
//                Motor motor = new Motor();
                modelAndView.addObject("marke", marke);
                modelAndView.addObject("modeli", modeli);
                modelAndView.addObject("motori", motori);
//		modelAndView.addObject("marka", marka);
//                modelAndView.addObject("model", model);
//                modelAndView.addObject("motor", motor);
		modelAndView.setViewName("listamotora");
               
		return modelAndView;
	}
}
