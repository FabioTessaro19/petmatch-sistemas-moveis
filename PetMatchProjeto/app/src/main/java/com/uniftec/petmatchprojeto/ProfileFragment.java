package com.uniftec.petmatchprojeto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniftec.petmatchprojeto.Adapters.AnimalFavoritoAdapter;
import com.uniftec.petmatchprojeto.Models.Animal;
import com.uniftec.petmatchprojeto.Models.AnimalFavorito;
import com.uniftec.petmatchprojeto.Repository.AnimalRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private AnimalFavoritoAdapter adapter;
    private List<AnimalFavorito> listaAnimaisFavoritos = new ArrayList<>();
    private AnimalRepository animalRepository;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animalRepository = new AnimalRepository(requireActivity());
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Inicializar RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewAnimaisFavoritados);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        // Carregar dados de animais favoritados (exemplo)
        carregarAnimaisFavoritados();

        return view;
    }

    private void carregarAnimaisFavoritados() {
        // Simulação de dados de animais favoritados (substitua com seus próprios dados do banco de dados)
       // listaAnimaisFavoritos.add(new AnimalFavorito("Marrom", "Labrador", 5, R.drawable.gato_tres));
       // listaAnimaisFavoritos.add(new AnimalFavorito("Preto", "Poodle", 3, R.drawable.cachorro_dois_app));
        //listaAnimaisFavoritos.add(new AnimalFavorito("Branco", "Vira-lata", 2, R.drawable.cachrro_app));

        // Configurar o adapter
        //adapter = new AnimalFavoritoAdapter(listaAnimaisFavoritos);
        //recyclerView.setAdapter(adapter);

        // Limpar lista anterior
        listaAnimaisFavoritos.clear();

        // Substitua pelo seu método de consulta ao banco de dados favoritos
        listaAnimaisFavoritos = animalRepository.getFavoritos(1); // Substitua '1' pelo ID do usuário atual

        // Configurar o adapter com a lista atualizada
        adapter = new AnimalFavoritoAdapter(listaAnimaisFavoritos);
        recyclerView.setAdapter(adapter);

    }
}