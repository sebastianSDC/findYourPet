package com.example.pilasnotebook.findyourpet.Model.DAO;

import com.example.pilasnotebook.findyourpet.Model.POJO.Pet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServicePet {

    @Headers({"Accept: application/json"})
    @GET("pet/findByStatus?")
    Call<List<Pet>> getAvailablePets(@Query("status") String status);


    //TODO: la silencio hasta usarla
    @GET("pet/{petId}")
    Call<Pet> getIdPet(@Path("id") String id);
}
