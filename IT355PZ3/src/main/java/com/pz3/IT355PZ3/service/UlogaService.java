/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.service;

import com.pz3.IT355PZ3.entities.Uloga;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface UlogaService {
   
     public void addUloga(Uloga uloga);
    
    public List<Uloga> getUloge();
    
    public Uloga getUlogaByUlogaNaziv(String ulogaNaziv);
//    
//     public void updateUloga(Uloga uloga);
//     
//     public int getUlogaId(String naziv);
//     
//      public void deleteUloga(Uloga uloga);


}
