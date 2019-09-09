package com.example.pilasnotebook.findyourpet.Model.DAO;

import com.example.pilasnotebook.findyourpet.Model.POJO.Pet;
import com.example.pilasnotebook.findyourpet.Model.POJO.PetContainer;
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

    private static final String BASE_URL = " http://petstore.swagger.io/v2/";
    private Retrofit retrofit;
    private ServicePet servicePet;

    public PetDAORetrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.client(httpClient.build()).build();
        servicePet = retrofit.create(ServicePet.class);

    }

    public void getAvailablePets_DAO(String status, final ResultListener<List<Pet>> resultListener_Controller) {
        servicePet.getAvailablePets(status).enqueue(new Callback<PetContainer>() {
            @Override
            public void onResponse(Call<PetContainer> call, Response<PetContainer> response) {
                PetContainer petContainer = response.body();
                if (petContainer != null && petContainer.getPetsList() != null) {
                    List<Pet> pets = petContainer.getPetsList();
                    resultListener_Controller.finish(pets);
                }
            }

            @Override
            public void onFailure(Call<PetContainer> call, Throwable t) {
                resultListener_Controller.finish(new ArrayList<Pet>());
            }
        });
    }
}





