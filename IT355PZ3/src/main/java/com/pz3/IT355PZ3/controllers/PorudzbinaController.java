/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.controllers;

import com.pz3.IT355PZ3.entities.Korisnik;
import com.pz3.IT355PZ3.entities.Porudzbina;
import com.pz3.IT355PZ3.service.KorisnikService;
import com.pz3.IT355PZ3.service.PorudzbinaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
public class PorudzbinaController {
    
     @Autowired 
     private PorudzbinaService porudzbinaService;
    
     @Autowired 
     private KorisnikService korisnikService;
    
     //@RequestMapping(value={"/", "/dodajulogu"}, method = RequestMethod.GET)
        @RequestMapping(value="/listaporudzbina", method = RequestMethod.GET)
	public ModelAndView pregledPorudzbina(){
		ModelAndView modelAndView = new ModelAndView();
                 RestTemplate restTemplate = new RestTemplate();
                final String uri = "http://localhost:8080/api/porudzbine";
                
                List<Porudzbina> porudzbine = restTemplate.getForObject(uri, List.class);
                
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Korisnik korisnik = korisnikService.findKorisnikByEmail(auth.getName());
                int korisnikId = korisnik.getKorisnikId();
                final String uri2 = "http://localhost:8080/api/mojeporudzbine/"+korisnikId;
                 List<Porudzbina> mojeporudzbine = restTemplate.getForObject(uri2, List.class);
//                System.out.println(korisnik.getIme() + " " + korisnik.getPrezime());
//                System.out.println(korisnik.toString());
//		modelAndView.addObject("userName", "Welcome " + korisnik.getIme() + " " + korisnik.getPrezime() + " (" + korisnik.getEmail() + ")");
//		Uloga uloga = new Uloga();
                modelAndView.addObject("korisnik", korisnik);
		modelAndView.addObject("porudzbine", porudzbine);
                modelAndView.addObject("mojeporudzbine", mojeporudzbine);
		modelAndView.setViewName("listaporudzbina");
		return modelAndView;
	}
        
        
        
        
         //Delete porudzbina by id - poziva REST
    @GetMapping("/deleteporudzbina")
    public String delete(@RequestParam("porudzbinaId") int thePorudzbinaId) {
        final String uri = "http://localhost:8080/api/deleteporudzbina";
         RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri + "/" + thePorudzbinaId);
        return "redirect:/listaporudzbina";
        
    }
    
    
    @GetMapping("/naruciMotor")
    public String naruci(@RequestParam("motorId") int theMotorId) {
                 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Korisnik korisnik = korisnikService.findKorisnikByEmail(auth.getName());
                int theKorisnikId = korisnik.getKorisnikId();
//                Korisnik korisnik2 = korisnikService.getKorisnikById(theKorisnikId);
//                System.out.println(korisnik2.toString());
                System.out.println("Controler id motora " + theMotorId);
        final String uri = "http://localhost:8080/api/addporudzbina";
         RestTemplate restTemplate = new RestTemplate();
       // restTemplate.delete(uri + "/" + theMotorId + "/" + theKorisnikId);
        restTemplate.put(uri + "/" + theMotorId + "/" + theKorisnikId,uri);
     
        return "redirect:/vozila/listamotora";
      
    }
}
