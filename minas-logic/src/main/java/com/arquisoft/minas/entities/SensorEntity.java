/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquisoft.minas.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author alejandro
 */
@Entity
public class SensorEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PodamExclude
    long id;
    int valor;
    String tipo;
    
    public long getId(){return id;}
    public void setId(long it){this.id=id;}
    
    public int getValor(){return valor;}
    public void setValor(int valor){this.valor = valor;}
    
    public String getTipo(){return tipo;}
    public void setTipo(String tipo){this.tipo = tipo;}
}
