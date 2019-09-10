package com.example.pilasnotebook.findyourpet.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pilasnotebook.findyourpet.Model.POJO.Pet;
import com.example.pilasnotebook.findyourpet.R;
import com.example.pilasnotebook.findyourpet.Utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

class PetAdapter extends RecyclerView.Adapter {

    private List<Pet> petList;
    private PetClicked interfacePetClick;
    public Context context;

    public PetAdapter(PetClicked interfacePetClick, Context context) {
        petList = new ArrayList<>();
        this.interfacePetClick = interfacePetClick;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.celda_available_pet, parent, false);
        PetViewHolder viewHolder = new PetViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Pet petAPasar = petList.get(position);
        PetViewHolder petViewHolder = (PetViewHolder) holder;
        petViewHolder.cargarPet(petAPasar);
    }

    @Override
    public int getItemCount() {
        return petList.size();
    }

    public void pullToRefresh(List<Pet> availablePets) {
        if (availablePets != null) {
            petList.clear();
            petList.addAll(availablePets);
            notifyDataSetChanged();
        }
    }

public class PetViewHolder extends RecyclerView.ViewHolder {

    private ImageView fotoPetCelda;
    private ImageView iconitoPetCelda;
    private TextView nombrePetCelda;
    private TextView statusPetCelda;
    //private TextView idPetCelda;

    public PetViewHolder(final View itemView) {
        super(itemView);
        fotoPetCelda = itemView.findViewById(R.id.foto_pet);
        nombrePetCelda = itemView.findViewById(R.id.nombre_pet);
        statusPetCelda = itemView.findViewById(R.id.status_pet);
        //idPetCelda = itemView.findViewById(R.id.id_pet);
        iconitoPetCelda = itemView.findViewById(R.id.iconito_pet);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfacePetClick.petSelected(petList.get(getAdapterPosition()));
            }
        });
    }

    public void cargarPet(Pet pet) {
        nombrePetCelda.setText(pet.getName());
        statusPetCelda.setText(pet.getStatus());
        //idPetCelda.setText(pet.getId());

        GlideApp.with(itemView.getContext())
                .load(R.drawable.paw)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.dog_1)
                .into(iconitoPetCelda);
    }
}

public interface PetClicked {
    void petSelected(Pet pet);
}
}
