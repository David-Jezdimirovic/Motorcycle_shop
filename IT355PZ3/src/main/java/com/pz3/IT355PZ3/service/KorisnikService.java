/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.service;

import com.pz3.IT355PZ3.entities.Korisnik;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public interface KorisnikService {
    
     public void addKorisnik(Korisnik korisnik);
    
    public List<Korisnik> getKorisnici();
    
    public Korisnik findKorisnikByEmail(String email);
    
    public Korisnik getKorisnikById(int korisnikId);
    
//    
//     public void updateKorisnik(Korisnik korisnik);
//     
//    public void deleteKorisnik(Korisnik korisnik);
    
}

