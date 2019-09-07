package com.example.pilasnotebook.findyourpet.Model.POJO;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Categoria implements Serializable {
    private Integer id;
    @SerializedName("name")
    private String nombre;

    public Categoria(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
