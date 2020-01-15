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
@Table(name = "korisnici")
public class Korisnik {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "korisnik_id")
    private Integer korisnikId;
       
    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "sifra")
    private String sifra;
    
    @Column(name = "aktivan")
    private int aktivan;
    
    @ManyToOne
    @JoinColumn(name = "uloga_id", referencedColumnName = "uloga_id")
    private Uloga uloga;
    
    // @OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    //  private List<Product> products;

    public Korisnik() {
        // this.products = new ArrayList<Product>();
    }

    public Integer getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public int getAktivan() {
        return aktivan;
    }

    public void setAktivan(int aktivan) {
        this.aktivan = aktivan;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "korisnik_id=" + korisnikId + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", sifra=" + sifra + ", aktivan=" + aktivan + ", uloga=" + uloga + '}';
    }

   
    
}

