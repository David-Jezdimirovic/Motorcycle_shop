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
@Table(name = "modeli")
public class Model {
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Integer modelId;

    @ManyToOne
    @JoinColumn(name = "marka_id", referencedColumnName = "marka_id")
    private Marka marka;
       
    @Column(name = "model_naziv")
    private String modelNaziv;

   
    
    // @OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    //  private List<Product> products;

    public Model() {
        // this.products = new ArrayList<Product>();
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Marka getMarka() {
        return marka;
    }

    public void setMarka(Marka marka) {
        this.marka = marka;
    }

    public String getModelNaziv() {
        return modelNaziv;
    }

    public void setModelNaziv(String modelNaziv) {
        this.modelNaziv = modelNaziv;
    }

    @Override
    public String toString() {
        return "Model{" + "modelId=" + modelId + ", marka=" + marka + ", modelNaziv=" + modelNaziv + '}';
    }

    
    
}