/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.service;

import com.pz3.IT355PZ3.entities.Motor;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface MotorService {
    
    public void addMotor(Motor motor);
    
    public List<Motor> getMotori();
    
    public void deleteById(int id);
    
    public Motor getMotorById(int motorId);
    
}
