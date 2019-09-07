package com.example.pilasnotebook.findyourpet.Model.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PetContainer {
    @SerializedName("pets")
    private List<Pet> petsList;


    public List<Pet> getPetsList() {
        return petsList;
    }

    public void setPetsList(List<Pet> petsList) {
        this.petsList = petsList;
    }
}
