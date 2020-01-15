/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.service;

import com.pz3.IT355PZ3.entities.Model;
import com.pz3.IT355PZ3.repository.ModelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class ModelServiceImpl implements ModelService{
    
     @Autowired
   private ModelRepository modelRepository;

    @Override
    public void addModel(Model model) {
        modelRepository.save(model);
    }

    @Override
    public List<Model> getModeli() {
      return  modelRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
       modelRepository.deleteById(id);
    }
    
}
