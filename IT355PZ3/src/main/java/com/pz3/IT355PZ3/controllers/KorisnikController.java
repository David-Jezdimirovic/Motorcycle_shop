/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.controllers;

import com.pz3.IT355PZ3.entities.Korisnik;
import com.pz3.IT355PZ3.entities.Uloga;
import com.pz3.IT355PZ3.service.KorisnikService;
import com.pz3.IT355PZ3.service.UlogaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping(value="/korisnik")
public class KorisnikController {
    
     @RequestMapping(value="/registracija", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		Korisnik korisnik = new Korisnik();
		modelAndView.addObject("korisnik", korisnik);
		modelAndView.setViewName("registracija");
		return modelAndView;
	}
	
   @Autowired
   private KorisnikService korisnikService;
   
   @Autowired
   private UlogaService ulogaService;
        
   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;
   
   //enkripcija sifre
//   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
   
	@RequestMapping(value = "/savekorisnik", method = RequestMethod.POST)
	public String createNewUser(@Valid Korisnik korisnik, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
//		Korisnik userExists = korisnikService.findUserByEmail(korisnik.getEmail());
//		if (userExists != null) {
//			bindingResult
//					.rejectValue("email", "error.user",
//							"There is already a user registered with the email provided");
//		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registracija");
		} else {
                    
                        String pass = bCryptPasswordEncoder.encode(korisnik.getSifra());
                        korisnik.setSifra(pass);
                        korisnik.setAktivan(1);
                        Uloga uloga = ulogaService.getUlogaByUlogaNaziv("ADMIN");
                        //korisnik.setUloga(new Uloga(1,"ADMIN"));
                        korisnik.setUloga(uloga);
			korisnikService.addKorisnik(korisnik);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("korisnik", new Korisnik());
			modelAndView.setViewName("registracija");
			
		}
		return "redirect:/korisnik/registracija";
                //return modelAndView;
	}
        
        
        
//    @PostMapping("/savekorisnik")
//    @RequestMapping(value = "/savekorisnik", method = RequestMethod.POST)
//    public ModelAndView createNewUser(@Valid Korisnik korisnik, BindingResult bindingResult) {
//        final String uri = "http://localhost:8080/korisnik/addkorisnik";
//        RestTemplate restTemplate = new RestTemplate();
//        ModelAndView modelAndView = new ModelAndView();
//          String pass = passwordEncoder.encode(korisnik.getSifra());
//                        korisnik.setSifra(pass);
//                        korisnik.setAktivan(1);
//                        korisnik.setUloga(new Uloga(1,"ADMIN"));
//        restTemplate.postForEntity(uri, korisnik, Korisnik.class);
//        modelAndView.addObject("successMessage", "User has been registered successfully");
//	modelAndView.addObject("korisnik", new Korisnik());
//	modelAndView.setViewName("registracija");
//        //return "redirect:/korisnik/registracija";
//        return modelAndView;
//    }
        
}
