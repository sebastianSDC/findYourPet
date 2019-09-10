package com.example.pilasnotebook.findyourpet.Model.POJO;

public class Pet {

    private String id;
    private String name;
    private String status;

    public Pet(String nombre, String status, String id) {
        this.name = nombre;
        this.status = status;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
