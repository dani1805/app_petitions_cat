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
 * Use the {@link FragmentInfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentInfo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_BREED = "breed";

    // TODO: Rename and change types of parameters
    private Breed breed;

    public FragmentInfo() {
        // Required empty public constructor
    }

    public static FragmentInfo newInstance(Breed breed) {
        FragmentInfo fragment = new FragmentInfo();
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
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        setUpView(view);
        return view;
    }

    public void setUpView (View view) {

        TextView responseWeight = view.findViewById(R.id.responseWeight);
        TextView responseTemperament = view.findViewById(R.id.responseTemperament);
        TextView responseOrigin = view.findViewById(R.id.responseOrigin);
        TextView responseLife = view.findViewById(R.id.responseLife);
        TextView responseDescription = view.findViewById(R.id.responseDescription);

        responseWeight.setText(breed.getWeight().getImperial());
        responseTemperament.setText(breed.getTemperament());
        responseOrigin.setText(breed.getOrigin());
        responseLife.setText(breed.getLifeSpan());
        responseDescription.setText(breed.getDescription());

    }


}