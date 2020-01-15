/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.service;

import com.pz3.IT355PZ3.entities.Motor;
import com.pz3.IT355PZ3.repository.MotorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class MotorServiceImpl implements MotorService{
    
     @Autowired
   private MotorRepository motorRepository;

    @Override
    public void addMotor(Motor motor) {
        motorRepository.save(motor);
    }

    @Override
    public List<Motor> getMotori() {
      return  motorRepository.findAll();
    }
    
    

    @Override
    public void deleteById(int id) {
       motorRepository.deleteById(id);
    }

    @Override
    public Motor getMotorById(int motorId) {
        return motorRepository.getOne(motorId);
    }
    
}
