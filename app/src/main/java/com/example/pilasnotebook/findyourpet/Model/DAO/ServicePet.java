package com.example.pilasnotebook.findyourpet.Model.DAO;
import com.example.pilasnotebook.findyourpet.Model.POJO.PetContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServicePet {

    @GET("pet/findByStatus")
    Call<PetContainer> getAvailablePets(@Query("status") String status);

    @GET("pet/{petId}")
    Call<PetContainer> getIdPet(@Query("id") Integer id);

}
