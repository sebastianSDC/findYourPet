package com.example.pilasnotebook.findyourpet.View;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.pilasnotebook.findyourpet.Model.POJO.Pet;
import com.example.pilasnotebook.findyourpet.View.Fragment.DetallePetFragment;
import com.example.pilasnotebook.findyourpet.View.Fragment.MapaFragment;

import java.util.ArrayList;
import java.util.List;

public class AdapterViewPager extends FragmentPagerAdapter {

    private Context context;
    private Pet pet;
    private final List<Fragment> fragments;
    private List<String> tabs;

    public AdapterViewPager(FragmentManager fm, Context context) {
        super(fm);
        fragments = new ArrayList<>();
        tabs = new ArrayList<>();

        tabs.add("Datos");
        tabs.add("Donde Estamos");
    }

    public void cargarFragments(Pet pet) {
        fragments.add(DetallePetFragment.newInstanceDetails(pet));
        fragments.add(MapaFragment.newInstanceMap());
        this.notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle (int position){
        return tabs.get(position);
    }
}




