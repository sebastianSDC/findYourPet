package com.example.pilasnotebook.findyourpet.Model.DAO;

import com.example.pilasnotebook.findyourpet.Model.POJO.Pet;
import com.example.pilasnotebook.findyourpet.Utils.ResultListener;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PetDAORetrofit {


    private Retrofit retrofit;
    private ServicePet servicePet;

    public PetDAORetrofit() {
        /*OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://petstore.swagger.io/v2/").addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.client(httpClient.build()).build();
        servicePet = retrofit.create(ServicePet.class);

    }*/

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // con GSON convierto los objetos JASON en JAVA
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://petstore.swagger.io/v2/")
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.client(httpClient.build()).build();
        servicePet = retrofit.create(ServicePet.class);
    }

    public void getAvailablePets_DAO(String status, final ResultListener<List<Pet>> resultListener_Controller) {
        servicePet.getAvailablePets(status).enqueue(new Callback<List<Pet>>() {
            @Override
            public void onResponse(Call<List<Pet>> call, Response<List<Pet>> response) {
                List<Pet> petList = response.body();
                resultListener_Controller.finish(petList);
                }

            @Override
            public void onFailure(Call<List<Pet>> call, Throwable t) {
                resultListener_Controller.finish(new ArrayList<Pet>());
            }
        });
    }

    public void getPetClickedID_DAO(String id, final ResultListener<Pet>resultListener_Controller){
        servicePet.getIdPet(id).enqueue(new Callback<Pet>() {
            @Override
            public void onResponse(Call<Pet> call, Response<Pet> response) {
                Pet pet = response.body();
                resultListener_Controller.finish(pet);
            }

            @Override
            public void onFailure(Call<Pet> call, Throwable t) {
            }
        });
    }
}





