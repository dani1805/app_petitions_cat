package com.example.catapi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.catapi.models.Breed;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentStats#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentStats extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_BREED = "breed";


    // TODO: Rename and change types of parameters
    private Breed breed;


    public FragmentStats() {
        // Required empty public constructor
    }

    public static FragmentStats newInstance(Breed breed) {
        FragmentStats fragment = new FragmentStats();
        Bundle args = new Bundle();
        args.putParcelable(ARG_BREED, breed);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            breed = getArguments().getParcelable(ARG_BREED);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        setUpView(view);
        return view;
    }

    public void setUpView (View view) {

        TextView responseHairless = view.findViewById(R.id.responseHairless);
        TextView responseRex = view.findViewById(R.id.responseRex);
        TextView responseNatural = view.findViewById(R.id.responseNatural);
        TextView responseIntelligence = view.findViewById(R.id.responseIntelligence);
        TextView responseRare = view.findViewById(R.id.responseRare);

        responseHairless.setText(String.valueOf(breed.getHairless()));
        responseRex.setText(String.valueOf(breed.getRex()));
        responseNatural.setText(String.valueOf(breed.getNatural()));
        responseIntelligence.setText(String.valueOf(breed.getIntelligence()));
        responseRare.setText(String.valueOf(breed.getRare()));

    }
}