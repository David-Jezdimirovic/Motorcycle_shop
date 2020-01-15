/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.rest;


import com.pz3.IT355PZ3.entities.Korisnik;
import com.pz3.IT355PZ3.entities.Motor;
import com.pz3.IT355PZ3.entities.Porudzbina;
import com.pz3.IT355PZ3.service.KorisnikService;
import com.pz3.IT355PZ3.service.MotorService;
import com.pz3.IT355PZ3.service.PorudzbinaService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class PorudzbinaRestController {
    
     @Autowired
    PorudzbinaService porudzbinaService;
     
     @Autowired
    KorisnikService korisnikService;
     
      @Autowired
    MotorService motorService;
    
    //Return list of all motori
    @GetMapping("/porudzbine")
    public List<Porudzbina> getAllPorudzbine() {
        List<Porudzbina> porudzbine = porudzbinaService.getPorudzbine();
        return porudzbine;
    }
    
    //Return list of all motori
    @GetMapping("/mojeporudzbine/{korisnikId}")
    public List<Porudzbina> getAllPorudzbineByKorisnikId(@PathVariable int korisnikId) {
        List<Porudzbina> mojeporudzbine = porudzbinaService.getPorudzbineByIdKorisnika(korisnikId);
        return mojeporudzbine;
    }
    
//      //Saves new motor
//    @PostMapping("/addporudzbina")
//    public void savePorudzbina (HttpServletResponse response, Porudzbina porudzbina) throws IOException {
//       // List<City> cities = cityService.findAll();
//        porudzbinaService.addPorudzbina(porudzbina);
//        //return motor;
//        response.sendRedirect("/vozilo/dodajvozilo");
//    }
    
    
     //Delete motor based on ID
    @DeleteMapping("/deleteporudzbina/{porudzbinaId}")
    public String deleteMotor(HttpServletResponse response, @PathVariable int porudzbinaId) throws IOException {
        porudzbinaService.deleteById(porudzbinaId);
        return "Obrisan je";
       //response.sendRedirect("/vozilo/listamotora");
    }
    
    
     //Saves new porudzbina
    @PutMapping("/addporudzbina/{theMotorId}/{theKorisnikId}")
    public void savePorudzbina (HttpServletResponse response,@PathVariable int theMotorId,@PathVariable int theKorisnikId) throws IOException {
//         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		Korisnik korisnik = korisnikService.findKorisnikByEmail(auth.getName());
                Korisnik kor = korisnikService.getKorisnikById(theKorisnikId);
                Motor mot = motorService.getMotorById(theMotorId);
                Porudzbina p = new Porudzbina(kor,mot,new Date());
                porudzbinaService.addPorudzbina(p);
     
        response.sendRedirect("/vozila/listamotora");
       // System.out.println("add Poruzbina rest motor id" + theMotorId + " korisnik Id " + theKorisnikId);
    }
    
    
    
 
}
