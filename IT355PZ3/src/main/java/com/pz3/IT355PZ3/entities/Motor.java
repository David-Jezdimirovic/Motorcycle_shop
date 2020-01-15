/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.entities;

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
@Table(name = "motori")
public class Motor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "motor_id")
    private Integer motorId;
  
    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "model_id")
    private Model model;

    @Column(name = "godiste")
    private int godiste;

    @Column(name = "opis")
    private String opis;

    @Column(name = "cena")
    private int cena;

//    @Column(name = "kolicina")
//    private int kolicina;
    
     public Motor() {
    }

    public Integer getMotorId() {
        return motorId;
    }

    public void setMotorId(Integer motorId) {
        this.motorId = motorId;
    }

    

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    public int getGodiste() {
        return godiste;
    }

    public void setgodiste(int godiste) {
        this.godiste = godiste;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

//    public int getKolicina() {
//        return kolicina;
//    }
//
//    public void setKolicina(int kolicina) {
//        this.kolicina = kolicina;
//    }
    

    @Override
    public String toString() {
        return "Motor{" + "motor_id=" + motorId + ", model=" + model + ", godiste=" + godiste + ", opis=" + opis + ", cena=" + cena +  ", kolicina=" + '}';
    }
}

