package com.uniftec.petmatchprojeto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.uniftec.petmatchprojeto.Models.Animal;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    private int[] imageIds = {
            R.drawable.gato_tcc,
            R.drawable.cachrro_app,
            R.drawable.cachorro_dois_app,
            R.drawable.gato_doisi,
            R.drawable.gato_quatro,
            R.drawable.cachorro_tres_app,
            R.drawable.gato_tres
    };
    private int currentIndex = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        Button nextButton = view.findViewById(R.id.nextAnimal);
        Button backButton = view.findViewById(R.id.backAnimal);
        Button loveButton = view.findViewById(R.id.loveAnimal);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Incrementa o índice
                currentIndex++;
                // Reinicia o índice se passar do último
                if (currentIndex >= imageIds.length) {
                    currentIndex = 0;
                }
                // Define a imagem atual
                imageView.setImageResource(imageIds[currentIndex]);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Incrementa o índice
                currentIndex--;
                // Reinicia o índice se passar do último
                if (currentIndex >= imageIds.length) {
                    currentIndex = 0;
                }
                // Define a imagem atual
                imageView.setImageResource(imageIds[currentIndex]);
            }
        });

        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adiciona o animal atual aos favoritos

            }
        });

        return view;
    }

  //  @Override
  //  public View onCreateView(LayoutInflater inflater, ViewGroup container,
  //                          Bundle savedInstanceState) {
  //      // Inflate the layout for this fragment
  //      return inflater.inflate(R.layout.fragment_home, container, false);
  //  }
}