/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.service;

import com.pz3.IT355PZ3.entities.Marka;
import com.pz3.IT355PZ3.repository.MarkaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class MarkaServiceImpl implements MarkaService{
    
    @Autowired
   private MarkaRepository markaRepository;

    @Override
    public void addMarka(Marka marka) {
        markaRepository.save(marka);
        
    }

    @Override
    public List<Marka> getMarke() {
      return  markaRepository.findAll();
    }
    
    @Override
    public void deleteById(int id) {
        markaRepository.deleteById(id);
    }
    
}
