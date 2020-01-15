/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.service;

import com.pz3.IT355PZ3.entities.Marka;
import java.util.List;
/**
 *
 * @author Lenovo
 */
public interface MarkaService {
    
    public void addMarka(Marka marka);
    
    public List<Marka> getMarke();
    
    public void deleteById(int id);
}
