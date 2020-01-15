/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.service;

import com.pz3.IT355PZ3.entities.Korisnik;
import com.pz3.IT355PZ3.repository.KorisnikRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lenovo
 */
@Service
public class KorisnikServiceImpl implements KorisnikService{

    @Autowired
   private KorisnikRepository korisnikRepository;
    
//    @Autowired
//    public KorisnikServiceImpl(KorisnikRepository theKorisnikRepository) {
//        this.korisnikRepository = theKorisnikRepository;
//    }
    
   // @Transactional
    @Override
    public void addKorisnik(Korisnik korisnik) {
        korisnikRepository.save(korisnik);
    }

    @Override
    public List<Korisnik> getKorisnici() {
        return korisnikRepository.findAll();
    }
    
    @Override
    public Korisnik findKorisnikByEmail(String email) {
        return korisnikRepository.findByEmail(email);
    }

    @Override
    public Korisnik getKorisnikById(int korisnikId) {
        return korisnikRepository.getOne(korisnikId);
    }
    
}

