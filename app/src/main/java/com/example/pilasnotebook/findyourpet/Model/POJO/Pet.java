package com.example.pilasnotebook.findyourpet.Model.POJO;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class Pet implements Serializable {

    private Integer id;
    @SerializedName("category")
    private Categoria categoria;
    @SerializedName("name")
    private String nombre;
    @SerializedName("photoUrls")
    private String foto;
    private List<Tag> tags;
    private String status;

    public Pet(){
    }

    public Pet(String nombre, String status){
        this.nombre = nombre;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
