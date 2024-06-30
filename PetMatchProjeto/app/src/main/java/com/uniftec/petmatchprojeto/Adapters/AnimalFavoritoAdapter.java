package com.uniftec.petmatchprojeto.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uniftec.petmatchprojeto.Models.Animal;
import com.uniftec.petmatchprojeto.Models.AnimalFavorito;
import com.uniftec.petmatchprojeto.R;

import java.util.List;



public class AnimalFavoritoAdapter extends RecyclerView.Adapter<AnimalFavoritoAdapter.AnimalViewHolder> {

    private List<AnimalFavorito> listaAnimaisFavoritos;

    public AnimalFavoritoAdapter(List<AnimalFavorito> listaAnimaisFavoritos) {
        this.listaAnimaisFavoritos = listaAnimaisFavoritos;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_animal_favorito, parent, false);
        return new AnimalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        AnimalFavorito animal = listaAnimaisFavoritos.get(position);
        holder.bind(animal);
    }

    @Override
    public int getItemCount() {
        return listaAnimaisFavoritos.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAnimal;
        private TextView txtCor;
        private TextView txtRaca;
        private TextView txtIdade;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAnimal = itemView.findViewById(R.id.imageViewAnimal);
            txtCor = itemView.findViewById(R.id.textViewCor);
            txtRaca = itemView.findViewById(R.id.textViewRaca);
            txtIdade = itemView.findViewById(R.id.textViewIdade);
        }

        public void bind(AnimalFavorito animal) {
            imgAnimal.setImageResource(animal.getImagemResourceId());
            txtCor.setText(animal.getCor());
            txtRaca.setText(animal.getRaca());
            txtIdade.setText(String.valueOf(animal.getIdade()));
        }
    }
}

