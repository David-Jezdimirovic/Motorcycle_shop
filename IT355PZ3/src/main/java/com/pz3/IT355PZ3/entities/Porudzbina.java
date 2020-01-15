/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "porudzbine")
public class Porudzbina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "porudzbina_id")
    private Integer porudzbinaId;

    @ManyToOne
    @JoinColumn(name = "korisnik_id", referencedColumnName = "korisnik_id")
    private Korisnik korisnik;

    @ManyToOne
    @JoinColumn(name = "motor_id", referencedColumnName = "motor_id")
    private Motor motor;
    
    @Column(name = "datum")
    private Date datum;
   
//    @ManyToOne
//    @JoinColumn(name = "stanje_id", referencedColumnName = "stanje_id")
//    private Stanje stanje;

    public Porudzbina() {
    }

    public Porudzbina(Korisnik korisnik, Motor motor, Date datum) {
        this.korisnik = korisnik;
        this.motor = motor;
        this.datum = datum;
    }

    
    
    public Integer getPorudzbinaId() {
        return porudzbinaId;
    }

    public void setPorudzbinaId(Integer porudzbinaId) {
        this.porudzbinaId = porudzbinaId;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Porudzbina{" + "porudzbinaId=" + porudzbinaId + ", korisnik=" + korisnik + ", motor=" + motor + ", datum=" + datum + '}';
    }

    
   
    
}

