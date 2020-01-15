/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.repository;

import com.pz3.IT355PZ3.entities.Uloga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenovo
 */
@Repository("ulogaRepository")
public interface UlogaRepository extends JpaRepository<Uloga, Integer> {
    
//    public Uloga findByUlogaId(Integer uloga_id);
      public Uloga findByUlogaNaziv(String ulogaNaziv);
//    public int getUlogaId(String naziv);
}
