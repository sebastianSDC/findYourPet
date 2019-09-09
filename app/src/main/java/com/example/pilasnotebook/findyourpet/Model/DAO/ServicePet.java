package com.example.pilasnotebook.findyourpet.Model.DAO;
import com.example.pilasnotebook.findyourpet.Model.POJO.PetContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ServicePet {

    @Headers({"accept: application/json"})
    @GET("pet/findByStatus?")
    Call<PetContainer> getAvailablePets(@Query("status") String status);


    //TODO: la silencio hasta usarla
//    @GET("pet/{petId}")
//    Call<PetContainer> getIdPet(@Query("id") Integer id);

}
