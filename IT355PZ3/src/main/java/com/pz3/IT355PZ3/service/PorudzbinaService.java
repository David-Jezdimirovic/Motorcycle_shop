/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.service;

import com.pz3.IT355PZ3.entities.Porudzbina;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface PorudzbinaService {
    
    public void addPorudzbina(Porudzbina porudzbina);
    
    public List<Porudzbina> getPorudzbine();
    
    public List<Porudzbina> getPorudzbineByIdKorisnika(int korisnikId);
    
    public void deleteById(int id);
}
