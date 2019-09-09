package com.example.pilasnotebook.findyourpet.Model.POJO;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Pet implements Serializable {

    private Integer id;
    @SerializedName("category")
    private Categoria categoria = null;
    @SerializedName("name")
    private String nombre;
    @SerializedName("photoUrls")
    private String foto;
    private List<Tag> tags = null;
    private String status;

    public Pet() {
    }

    public Pet(String nombre, String status, Integer id) {
        this.nombre = nombre;
        this.status = status;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getStatus() {
        return status;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFoto() {
        return foto;
    }

    public List<Tag> getTags() {
        return tags;
    }

}
