/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.EPF.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int porcentaje;
    private String imgSkill;

    public Hard() {
    }

    public Hard(String nombre, int porcentaje, String imgSkill) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.imgSkill = imgSkill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
     public String getImgSkill() {
        return imgSkill;
    }

    public void setImgSkill(String imgSkill) {
        this.imgSkill = imgSkill;
    }

    
    
    
}
