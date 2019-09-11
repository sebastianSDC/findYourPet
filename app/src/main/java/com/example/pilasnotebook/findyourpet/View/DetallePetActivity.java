package com.example.pilasnotebook.findyourpet.View;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.example.pilasnotebook.findyourpet.Controller.PetController;
import com.example.pilasnotebook.findyourpet.Model.POJO.Pet;
import com.example.pilasnotebook.findyourpet.R;
import com.example.pilasnotebook.findyourpet.Utils.ResultListener;
import com.example.pilasnotebook.findyourpet.View.Fragment.DetallePetFragment;
import com.example.pilasnotebook.findyourpet.View.Fragment.MapaFragment;


public class DetallePetActivity extends AppCompatActivity implements DetallePetFragment.OnFragmentInteractionListener, MapaFragment.OnFragmentInteractionListener {

    public static final String PET_ID = "pet_id";
    private PetController petController;
    private ProgressBar progressBar;
    private ImageButton backButton;
    private PlaceholderFragment.SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pet);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        backButton = findViewById(R.id.backButton);
        progressBar = findViewById(R.id.progressBar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new PlaceholderFragment.SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString(PET_ID);
        }
        petController = new PetController(this);
        petController.getPetClickedID_Controller(id, new ResultListener<Pet>() {
            @Override
            public void finish(Pet pet) {
                progressBar.setVisibility(View.GONE);
                DetallePetFragment detallePetFragment = new DetallePetFragment();
                detallePetFragment.newInstance(pet);

            }
        });
        setBack();


    }

    public void setBack() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle_pet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //@Override
    public void onFragmentInteraction(Uri uri) {
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment newInstance(int sectionNumber) {
            Fragment fragment = null;

            switch (sectionNumber) {
                case 1:
                    fragment = new DetallePetFragment();
                    break;
                case 2:
                    fragment = new MapaFragment();
                    break;
            }
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            View view = inflater.inflate(R.layout.fragment_detalle_pet, container, false);
            return view;
        }


        /**
         * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
         * one of the sections/tabs/pages.
         */
        public static class SectionsPagerAdapter extends FragmentPagerAdapter {

            public SectionsPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int position) {
                // getItem is called to instantiate the fragment for the given page.
                // Return a PlaceholderFragment (defined as a static inner class below).
                return PlaceholderFragment.newInstance(position + 1);
            }

            @Override
            public int getCount() {
                // Show 3 total pages.
                return 2;
            }


            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "Datos";
                    case 1:
                        return "Mapa";
                }
                return null;
            }
        }
    }
}

