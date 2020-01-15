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
import javax.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "uloge")
public class Uloga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uloga_id")
    private Integer ulogaId;

    @Column(name = "uloga_naziv")
    private String ulogaNaziv;

   
    
    // @OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    //  private List<Product> products;

    public Uloga() {
        // this.products = new ArrayList<Product>();
    }

    public Uloga(Integer ulogaId, String ulogaNaziv) {
        this.ulogaId = ulogaId;
        this.ulogaNaziv = ulogaNaziv;
    }

    
    
    public Integer getUlogaId() {
        return ulogaId;
    }

    public void setUlogaId(Integer ulogaId) {
        this.ulogaId = ulogaId;
    }

    public String getUlogaNaziv() {
        return ulogaNaziv;
    }

    public void setUlogaNaziv(String ulogaNaziv) {
        this.ulogaNaziv = ulogaNaziv;
    }

   
    

    // public List<Product> getProducts() {
    //    return products;
    //}
    //public void setProducts(List<Product> products) {
    //   this.products = products;
    // }

    @Override
    public String toString() {
        return "Uloga{" + "ulogaId=" + ulogaId + ", ulogaNaziv=" + ulogaNaziv + '}';
    }

   
    
}


