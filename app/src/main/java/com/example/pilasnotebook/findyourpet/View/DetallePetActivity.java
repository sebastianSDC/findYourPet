package com.example.pilasnotebook.findyourpet.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.example.pilasnotebook.findyourpet.Controller.PetController;
import com.example.pilasnotebook.findyourpet.Model.POJO.Pet;
import com.example.pilasnotebook.findyourpet.R;
import com.example.pilasnotebook.findyourpet.Utils.ResultListener;

public class DetallePetActivity extends AppCompatActivity {

    public static final String PET_ID = "pet_id";
    private String id;
    private PetController petController;
    private FragmentManager fm;
    private ViewPager vp;
    private AdapterViewPager adapter;
    private ProgressBar progressBar;
    private Toolbar toolbar;
    private TabLayout tab;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pet);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        backButton = findViewById(R.id.backButton);
        progressBar = findViewById(R.id.progressBar);

        vp = (ViewPager) findViewById(R.id.container);
        vp.setAdapter(adapter);
         tab = (TabLayout) findViewById(R.id.tabs);

        setVpTabs();

        progressBar.setVisibility(View.VISIBLE);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString(PET_ID);
        }
        petController = new PetController(this);
        petController.getPetClickedID_Controller(id, new ResultListener<Pet>() {
            @Override
            public void finish(Pet pet) {
                adapter.cargarFragments(pet);
                progressBar.setVisibility(View.GONE);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setVpTabs() {
        fm = getSupportFragmentManager();
        adapter = new AdapterViewPager(fm, getApplicationContext());
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }

}

