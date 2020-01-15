/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.rest;

import com.pz3.IT355PZ3.entities.Korisnik;
import com.pz3.IT355PZ3.entities.Uloga;
import com.pz3.IT355PZ3.service.KorisnikService;
import com.pz3.IT355PZ3.service.UlogaService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lenovo
 */
@CrossOrigin
@RestController
public class KorisnikRestController {
    

   
    @Autowired
   private KorisnikService korisnikService;
    
    @Autowired
   private UlogaService ulogaService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;    
    
      //enkripcija sifre
    //BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    
//     @Autowired
//    public KorisnikRestController(KorisnikService theKorisnikService) {
//        this.korisnikService = theKorisnikService;
//    }
    
    
  
    
    
     // uzima korisnika na osnovu id-ija
//    @RequestMapping(value = "/korisnik/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Korisnik> getKorisnikById(@PathVariable("id") int id) {
//        System.out.println("Fetching korisnik with id " + id);
//        Korisnik c = korisnikService.getKorisnikById(id);
//        if (c == null) {
//            System.out.println("Korisnik with " + id + " not found");
//            return new ResponseEntity<Korisnik>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Korisnik>(c, HttpStatus.OK);
//    }
    
    //vrsi update korisnika
//     @RequestMapping(value = "/korisnik/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Korisnik> updateKorisnik(@PathVariable("id") int id, @RequestBody Korisnik c) {
//        System.out.println("Updating korisnik " + id);
//
//        //c.setId(id);
//        korisnikDao.updateKorisnik(c);
//        return new ResponseEntity<Korisnik>(c, HttpStatus.OK);
//    }
    
    
     // dodvanje korisnika
    // @PostMapping("addkorisnik")
    @RequestMapping(value = "/korisnik/addkorisnik", method = RequestMethod.POST)
    public void addKorisnik(HttpServletResponse response, @Valid Korisnik k) throws IOException { //  @RequestBody  @Valid
        String pass = bCryptPasswordEncoder.encode(k.getSifra());
        Uloga uloga = ulogaService.getUlogaByUlogaNaziv("USER");
        //Uloga u = new Uloga(2,"USER");
        k.setSifra(pass);
        k.setAktivan(1);
        k.setUloga(uloga);
        System.out.println("Adding korisnik " + k.toString());
        korisnikService.addKorisnik(k);

        HttpHeaders headers = new HttpHeaders();
        
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//      return "redirect:/korisnik/registracija";
       // return k;
       response.sendRedirect("/korisnik/registracija");
    }
    
//     @PostMapping("/korisnik/addkorisnik")
//    public Korisnik addKorisnik(@RequestBody Korisnik k) {
//       // ulogaService.saveOrUpdate(uloga);
//         korisnikService.addKorisnik(k);
//        return k;
//    }
    
//    @RequestMapping(value = "/korisnik/addkorisnik", method = RequestMethod.POST)
//    public ModelAndView addKorisnik(@RequestBody Korisnik k) {
//       // ulogaService.saveOrUpdate(uloga);
//       ModelAndView modelAndView = new ModelAndView();
//       modelAndView.addObject("korisnik", new Korisnik());
//	String pass = passwordEncoder.encode(k.getSifra());
//        Uloga u = new Uloga(2,"USER");
//        k.setSifra(pass);
//        k.setAktivan(1);
//        k.setUloga(u);
//         korisnikService.addKorisnik(k);
//         modelAndView.setViewName("registracija");
//         return modelAndView;
//    }
    
     @RequestMapping(value = "/korisnici", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Korisnik>> getKorisnici() {
        System.out.println("Fetching korisnici");
        List<Korisnik> korisnici = korisnikService.getKorisnici();
        if (korisnici.size() == 0) {
            System.out.println("Korisnici list empty");
            return new ResponseEntity<List<Korisnik>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Korisnik>>(korisnici, HttpStatus.OK);
    }
    
    
    
    
      //metoda koja po id-u nalazi i brise produkt iz baze
   // @CrossOrigin
//    @RequestMapping(value = "/korisnik/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Korisnik> deleteKorisnik(@PathVariable("id") int id) {
//        System.out.println("Fetching & Deleting product with id " + id);
//
//        Korisnik korisnik = korisnikDao.getKorisnikById(id);
//        if (korisnik == null) {
//            System.out.println("Unable to delete. Product with id " + id + " not found");
//            return new ResponseEntity<Korisnik>(HttpStatus.NOT_FOUND);
//        }
//
//        korisnikDao.deleteKorisnik(korisnik);
//        return new ResponseEntity<Korisnik>(HttpStatus.OK);
//    }
}


