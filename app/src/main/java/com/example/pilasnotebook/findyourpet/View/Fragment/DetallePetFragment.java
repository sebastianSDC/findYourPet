package com.example.pilasnotebook.findyourpet.View.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pilasnotebook.findyourpet.Model.POJO.Pet;
import com.example.pilasnotebook.findyourpet.R;

public class DetallePetFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private String name;
    private String status;
    private String id;
    private TextView namePet;
    private TextView statusPet;
    private TextView idPet;


    public DetallePetFragment() {
        // Required empty public constructor
    }


    public static DetallePetFragment newInstanceDetails(Pet pet) {
        DetallePetFragment fragment = new DetallePetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, pet.getName());
        args.putString(ARG_PARAM2, pet.getStatus());
        args.putString(ARG_PARAM3, pet.getId());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_pet, container, false);

        namePet = view.findViewById(R.id.nombre_pet);
        statusPet = view.findViewById(R.id.status_pet);
        idPet = view.findViewById(R.id.id_pet);

        Bundle bundle = getArguments();
        if (bundle != null) {
            name = bundle.getString(ARG_PARAM1);
            status = bundle.getString(ARG_PARAM2);
            id = bundle.getString(ARG_PARAM3);

            namePet.setText(name);
            statusPet.setText(status);
            idPet.setText(id);
        }
        return view;
    }
}
