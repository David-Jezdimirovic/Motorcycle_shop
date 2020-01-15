/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.rest;

import com.pz3.IT355PZ3.entities.Uloga;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/api")
public class UlogaRestController {
    
    @Autowired
   private UlogaService ulogaService;
    
    
//     @Autowired
//    public UlogaRestController(UlogaService theUlogaService) {
//        this.ulogaService = theUlogaService;
//    }
    
    
//    @RequestMapping(value = "/adduloga", method = RequestMethod.POST)
//    //@PostMapping("/adduloga")
//    public ResponseEntity<Void> addUloga(  Uloga u) { //  @RequestBody      @Valid
//        System.out.println("Adding uloga " + u.toString());
//        ulogaService.addUloga(u);
//
//        HttpHeaders headers = new HttpHeaders();
//        
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//       
//    }
    
     @PostMapping("/adduloga")
    public void addUloga(HttpServletResponse response, Uloga uloga) throws IOException {
      
         ulogaService.addUloga(uloga);
        //return uloga;
        response.sendRedirect("/dodajulogu");
    }
    
     @RequestMapping(value = "/uloge", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Uloga>> getUloge() {
        System.out.println("Fetching uloge");
        List<Uloga> uloge = ulogaService.getUloge();
        if (uloge.size() == 0) {
            System.out.println("Marke list empty");
            return new ResponseEntity<List<Uloga>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Uloga>>(uloge, HttpStatus.OK);
    }
    
}
