package com.example.pilasnotebook.findyourpet.Controller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.pilasnotebook.findyourpet.Model.DAO.PetDAORetrofit;
import com.example.pilasnotebook.findyourpet.Model.POJO.Pet;
import com.example.pilasnotebook.findyourpet.Utils.ResultListener;

import java.util.List;

public class PetController {
    private Context context;

    public PetController(Context context) {
        this.context = context;
    }

    public void getAvailablePets_Controller(String status, final ResultListener<List<Pet>> resultListener_View){

        if(hayInternet(context)){
            PetDAORetrofit petDAORetrofit= new PetDAORetrofit();
            petDAORetrofit.getAvailablePets_DAO(status, new ResultListener<List<Pet>>(){
                @Override
                public void finish(List<Pet> petList) {

                    //por si no trae datos, los harcodeo.
                    if(petList.isEmpty()) {
                        for (int i = 0; i < 5; i++) {
                            Pet petAPut = new Pet("dogiier", "available", "12");
                            petList.add(petAPut);
                            Pet petAPot = new Pet("magger", "available", "24");
                            petList.add(petAPot);
                            Pet petAPit = new Pet("pituf", "available", "35");
                            petList.add(petAPit);
                        }
                    }
                    resultListener_View.finish(petList);
                }
            });
        }else{
            Toast.makeText(context, "Sin Internet", Toast.LENGTH_SHORT).show();
        }
    }

    public void getPetClickedID_Controller(String id,  final ResultListener<Pet> resultListener_View) {
        PetDAORetrofit petDAORetrofit = new PetDAORetrofit();
        petDAORetrofit.getPetClickedID_DAO(id, new ResultListener<Pet>() {
            @Override
            public void finish(Pet pet) {
               resultListener_View.finish(pet);
            }
        });
    }

    public static boolean hayInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

}
