package com.example.pilasnotebook.findyourpet.View;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pilasnotebook.findyourpet.Model.POJO.Pet;

import com.example.pilasnotebook.findyourpet.R;
import com.example.pilasnotebook.findyourpet.Utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

class PetAdapter extends RecyclerView.Adapter {

    private List<Pet> petList;

    public PetAdapter(List<Pet> list) {
        petList = list;
        if(list == null){
            petList = new ArrayList<>();
        }
    }

    public PetAdapter(){
        petList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view= layoutInflater.inflate(R.layout.celda_available_pet, parent, false);
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

    public void setAvailablePets(List<Pet> availablePets){
        for (Pet petAvailable : availablePets){
            if (!petList.contains(petAvailable)){
                petList.add(petAvailable);
            }
        }
        notifyDataSetChanged();
    }

    public class PetViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoPetCelda;
        private ImageView iconitoPetCelda;
        private TextView nombrePetCelda;
        private TextView categoriaPetCelda;
        private TextView idPetCelda;

        public PetViewHolder(View itemView) {
            super(itemView);
            fotoPetCelda = itemView.findViewById(R.id.foto_pet);
            nombrePetCelda = itemView.findViewById(R.id.nombre_pet);
            categoriaPetCelda = itemView.findViewById(R.id.categoria_pet);
            idPetCelda = itemView.findViewById(R.id.id_pet);
            iconitoPetCelda = itemView.findViewById(R.id.iconito_pet);
        }

        public void cargarPet (Pet pet){
            nombrePetCelda.setText(pet.getNombre());
            categoriaPetCelda.setText(pet.getCategoria().getNombre());
            idPetCelda.setText(pet.getId());

            GlideApp.with(itemView.getContext())
                    .load(R.drawable.paw)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.dog_1)
                    .into(iconitoPetCelda);

            GlideApp.with(itemView.getContext())
                    .load(pet.getFoto())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.dog_1)
                    .into(fotoPetCelda);
        }
    }
}
