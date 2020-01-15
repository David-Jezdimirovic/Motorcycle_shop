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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lenovo
 */
@Controller
public class PocetnaController {
    
    @GetMapping("/index")
    public String indeks() {
        return "index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
//    @RequestMapping(value="/registracija", method = RequestMethod.GET)
//	public ModelAndView registration(){
//		ModelAndView modelAndView = new ModelAndView();
//		Korisnik korisnik = new Korisnik();
//		modelAndView.addObject("korisnik", korisnik);
//		modelAndView.setViewName("registracija");
//		return modelAndView;
//	}
//	
//   @Autowired
//   private KorisnikService korisnikService;
//        
//	@RequestMapping(value = "/addkorisnik2", method = RequestMethod.POST)
//	public ModelAndView createNewUser(@Valid Korisnik korisnik, BindingResult bindingResult) {
//		ModelAndView modelAndView = new ModelAndView();
////		Korisnik userExists = korisnikService.findUserByEmail(korisnik.getEmail());
////		if (userExists != null) {
////			bindingResult
////					.rejectValue("email", "error.user",
////							"There is already a user registered with the email provided");
////		}
//		if (bindingResult.hasErrors()) {
//			modelAndView.setViewName("registracija");
//		} else {
//                   
//                    korisnik.setAktivan(1);
//                    korisnik.setUloga(new Uloga(1,"ADMIN"));
//			korisnikService.addKorisnik(korisnik);
//			modelAndView.addObject("successMessage", "User has been registered successfully");
//			modelAndView.addObject("korisnik", new Korisnik());
//			modelAndView.setViewName("registration");
//			
//		}
//		return modelAndView;
//	}
//        
    
    @Autowired 
    private KorisnikService korisnikService;
    
        //@RequestMapping(value={"/", "/dodajulogu"}, method = RequestMethod.GET)
        @RequestMapping(value="/dodajulogu", method = RequestMethod.GET)
	public ModelAndView dodajulogu(){
		ModelAndView modelAndView = new ModelAndView();
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Korisnik korisnik = korisnikService.findKorisnikByEmail(auth.getName());
                System.out.println(korisnik.getIme() + " " + korisnik.getPrezime());
                System.out.println(korisnik.toString());
//		modelAndView.addObject("userName", "Welcome " + korisnik.getIme() + " " + korisnik.getPrezime() + " (" + korisnik.getEmail() + ")");
		Uloga uloga = new Uloga();
		modelAndView.addObject("uloga", uloga);
		modelAndView.setViewName("dodajulogu");
		return modelAndView;
	}
        
        
        @Autowired
        private UlogaService ulogaService;
        
        @RequestMapping(value = "/saveuloga", method = RequestMethod.POST)
	public ModelAndView createNewUloga(@Valid Uloga uloga, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
//		Korisnik userExists = korisnikService.findUserByEmail(korisnik.getEmail());
//		if (userExists != null) {
//			bindingResult
//					.rejectValue("email", "error.user",
//							"There is already a user registered with the email provided");
//		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("dodajulogu");
		} else {
//                    uloga.setUloga_id(3);
//                    String nz = uloga.getUlogaNaziv();
//                    System.out.println(uloga.toString());
//                    uloga.setUlogaNaziv("fgh");
			//ulogaService.addUloga(uloga);
			modelAndView.addObject("successMessage", "Uloga has been added successfully");
			//modelAndView.addObject("uloga", new Uloga());
			modelAndView.setViewName("dodajulogu");
			
		}
		return modelAndView;
	}
        
        
}
