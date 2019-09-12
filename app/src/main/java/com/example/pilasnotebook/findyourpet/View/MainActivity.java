package com.example.pilasnotebook.findyourpet.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.example.pilasnotebook.findyourpet.Controller.PetController;
import com.example.pilasnotebook.findyourpet.Model.POJO.Pet;
import com.example.pilasnotebook.findyourpet.R;
import com.example.pilasnotebook.findyourpet.Utils.ResultListener;
import com.example.pilasnotebook.findyourpet.View.Fragment.DetallePetFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PetAdapter.PetClicked {

    private RecyclerView recyclerView;
    private PetAdapter adapter;
    private PetController petController;
    private String status = "available";
    private View snackView;
    private Toolbar toolbar;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeToRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        snackView = findViewById(android.R.id.content);
        progressBar = findViewById(R.id.progressBar);
        swipeToRefresh = findViewById(R.id.swipeToRefresh);
        recyclerView = findViewById(R.id.recycler_available_pets);

        //adapter y recycler
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        adapter = new PetAdapter(this,getApplicationContext());
        recyclerView.setAdapter(adapter);

        petController = new PetController(this);
        progressBar.setVisibility(View.VISIBLE);
        //metodos
        obtenerMascotas();
        iniciarToolbar();
        actualizarDatos();
    }

    private void actualizarDatos() {
        swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                obtenerMascotas();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeToRefresh.setRefreshing(false);
                    }
                },3000);
            }
        });
    }

    private void iniciarToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" FindYourPet");
        getSupportActionBar().setIcon(R.drawable.dog_2);

    }

    private void obtenerMascotas() {
        petController.getAvailablePets_Controller(status, new ResultListener<List<Pet>>() {
            @Override
            public void finish(List<Pet> petList) {
                if(petList != null){
                    adapter.pullToRefresh(petList);
                    progressBar.setVisibility(View.GONE);
                    Snackbar.make(snackView, "Congratulations!... Carga Exitosa", Snackbar.LENGTH_SHORT).show();
                }else{
                    progressBar.setVisibility(View.GONE);
                    Snackbar.make(snackView, "Error... No se cargo la lista", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void petSelected(Pet pet) {
        Intent intent = new Intent(this,DetallePetActivity.class );
        Bundle bundle = new Bundle();
        bundle.putString(DetallePetActivity.PET_ID,pet.getId());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}




