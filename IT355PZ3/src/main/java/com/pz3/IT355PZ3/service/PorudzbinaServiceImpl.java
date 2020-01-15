/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.service;

import com.pz3.IT355PZ3.entities.Porudzbina;
import com.pz3.IT355PZ3.repository.PorudzbinaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class PorudzbinaServiceImpl implements PorudzbinaService{

    @Autowired
    PorudzbinaRepository porudzbinaRepository;
    
    @Override
    public void addPorudzbina(Porudzbina porudzbina) {
        porudzbinaRepository.save(porudzbina);
    }

    @Override
    public List<Porudzbina> getPorudzbine() {
        return porudzbinaRepository.findAll();
    }
    
     @Override
    public void deleteById(int id) {
       porudzbinaRepository.deleteById(id);
    }

    @Override
    public List<Porudzbina> getPorudzbineByIdKorisnika(int korisnikId) {
     return   porudzbinaRepository.getAllPorudzbineByKorisnikId(korisnikId);
        
    }
    
}
