package com.example.pilasnotebook.findyourpet.Model.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PetContainer {
    @SerializedName("pets")
    private List<Pet> petsList;

    public PetContainer(List<Pet> petsList) {
        this.petsList = petsList;
    }

    public List<Pet> getPetsList() {
        return petsList;
    }

}
