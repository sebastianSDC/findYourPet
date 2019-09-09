package com.example.pilasnotebook.findyourpet.Controller;


import android.widget.Toast;

import com.example.pilasnotebook.findyourpet.Model.DAO.PetDAORetrofit;
import com.example.pilasnotebook.findyourpet.Model.POJO.Pet;
import com.example.pilasnotebook.findyourpet.Utils.ResultListener;

import java.util.List;

public class PetController {

    public void getAvailablePets_Controller(String status, final ResultListener<List<Pet>> resultListener_View){
        if(hayInternet()){
            PetDAORetrofit petDAORetrofit= new PetDAORetrofit();
            petDAORetrofit.getAvailablePets_DAO(status, new ResultListener<List<Pet>>(){

                @Override
                public void finish(List<Pet> petList) {
                    for(int i=0; i<5;i++){
                    Pet petAPut = new Pet("dogiier", "available");
                    petList.add(petAPut);
                    Pet petAPot = new Pet("magger", "available");
                    petList.add(petAPot);
                    Pet petAPit = new Pet("pituf", "sold");
                    petList.add(petAPit);}
                    resultListener_View.finish(petList);
                }
            });
        }
    }

    private boolean hayInternet() {
        return true;
    }

}
