/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.repository;

import com.pz3.IT355PZ3.entities.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenovo
 */
@Repository("korisnikRepository")
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer>{
    
     public Korisnik findByEmail(String email);
//     public Korisnik findByKorisnikId(Integer korisnik_id);
}
