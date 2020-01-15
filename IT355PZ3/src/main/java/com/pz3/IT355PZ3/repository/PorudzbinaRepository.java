/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.repository;

import com.pz3.IT355PZ3.entities.Porudzbina;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenovo
 */
@Repository
public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Integer>{
 
    @Modifying
    //@Transactional(rollbackFor=Exception.class)
    @Query(value = "SELECT * FROM porudzbine WHERE korisnik_id = ?1", nativeQuery = true)
    public List<Porudzbina> getAllPorudzbineByKorisnikId(int korisnikId);
    
}
