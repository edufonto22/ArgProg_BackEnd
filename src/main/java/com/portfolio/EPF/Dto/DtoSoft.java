
package com.portfolio.EPF.Dto;

import javax.validation.constraints.NotBlank;


public class DtoSoft {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    @NotBlank
    private String imgSkill;

    public DtoSoft() {
    }

    public DtoSoft(String nombre, int porcentaje, String imgSkill) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.imgSkill = imgSkill;
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