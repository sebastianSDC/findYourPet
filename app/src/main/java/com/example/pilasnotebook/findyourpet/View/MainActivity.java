package com.example.pilasnotebook.findyourpet.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.List;

import com.example.pilasnotebook.findyourpet.Controller.PetController;
import com.example.pilasnotebook.findyourpet.Model.POJO.Pet;
import com.example.pilasnotebook.findyourpet.R;
import com.example.pilasnotebook.findyourpet.Utils.ResultListener;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PetAdapter adapter;
    private PetController petController;
    private String status="available";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_available_pets);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        adapter = new PetAdapter();
        recyclerView.setAdapter(adapter);
        petController = new PetController(this);
        obtenerMascotas();
    }

    private void obtenerMascotas() {
        petController.getAvailablePets_Controller(status, new ResultListener<List<Pet>>() {
            @Override
            public void finish(List<Pet> petList) {

                adapter.setAvailablePets(petList);
            }
        });
    }
}




