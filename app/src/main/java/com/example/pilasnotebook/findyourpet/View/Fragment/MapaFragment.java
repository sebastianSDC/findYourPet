package com.example.pilasnotebook.findyourpet.View.Fragment;

import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.pilasnotebook.findyourpet.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MapaFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mGoogleMap;
    private MapView mapView;
    private LinearLayout contenedorDeMapview;
    private Geocoder geocoder;
    private LatLng suc1;
    private LatLng suc2;
    public static final Locale LOCALE_ARGENTINA = new Locale("es", "ARG");


    public MapaFragment() {
    }


    public static MapaFragment newInstanceMap() {
        MapaFragment fragment = new MapaFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);
        mapView = view.findViewById(R.id.GoogleMap_container);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        } else {
            Toast.makeText(getActivity(), "mapView es null", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;

        suc1 = new LatLng( -34.6188126, -58.3677217);
        suc2 = new LatLng( -34.9208142, -57.9518059);

        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            mGoogleMap.setMinZoomPreference(10);
            mGoogleMap.addMarker(new MarkerOptions().position(suc1).title("findYourPet. Suc 1"));
            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(suc1));

        mGoogleMap.addMarker(new MarkerOptions().position(suc2).title("findYourPet. Suc 2"));
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(suc2));
    }

}
