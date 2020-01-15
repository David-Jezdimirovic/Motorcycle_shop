/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.service;

import com.pz3.IT355PZ3.entities.Uloga;
import com.pz3.IT355PZ3.repository.UlogaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class UlogaServiceImpl implements UlogaService{
    
   @Autowired
  private UlogaRepository ulogaRepository;
        
    
//    @Autowired
//    public UlogaServiceImpl(UlogaRepository theUlogaRepository) {
//        this.ulogaRepository = theUlogaRepository;
//    }
    
    @Override
    public void addUloga(Uloga uloga) {
      ulogaRepository.save(uloga);
    }

    @Override
    public List<Uloga> getUloge() {
       return ulogaRepository.findAll();
    }

    
    @Override
    public Uloga getUlogaByUlogaNaziv(String ulogaNaziv) {
        return ulogaRepository.findByUlogaNaziv(ulogaNaziv);
    }
//    @Override
//    public Uloga getUlogaById(int id) {
//        return ulogaRepository.findByUlogaId(id);
//    }
//
//    @Override
//    public void updateUloga(Uloga uloga) {
//        ulogaRepository.save(uloga);
//    }
//
//    @Override
//    public int getUlogaId(String naziv) {
//      return  ulogaRepository.getUlogaId(naziv);
//    }
//
//    @Override
//    public void deleteUloga(Uloga uloga) {
//        ulogaRepository.delete(uloga);
//    }

    
    
}
