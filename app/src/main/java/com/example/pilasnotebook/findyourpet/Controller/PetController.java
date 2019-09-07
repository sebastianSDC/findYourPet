package com.example.pilasnotebook.findyourpet.Controller;


import android.widget.Toast;

import com.example.pilasnotebook.findyourpet.Model.DAO.PetDAORetrofit;
import com.example.pilasnotebook.findyourpet.Model.POJO.Pet;
import com.example.pilasnotebook.findyourpet.Utils.ResultListener;

import java.util.List;

public class PetController {

    public void getAvailablePets_Controller(final ResultListener<List<Pet>> resultListener_View){
        if(hayInternet()){
            PetDAORetrofit petDAORetrofit= new PetDAORetrofit();
            petDAORetrofit.getAvailablePets_DAO(new ResultListener<List<Pet>>(){

                @Override
                public void finish(List<Pet> petList) {
                    resultListener_View.finish(petList);
                }
            });
        }
    }

    private boolean hayInternet() {
        return true;
    }

}
