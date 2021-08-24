package com.example.catapi.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.catapi.FragmentInfo;
import com.example.catapi.FragmentStats;
import com.example.catapi.models.Breed;

import java.util.ArrayList;

public class AdapterTabDetail extends FragmentStateAdapter {

   ArrayList<String> options;
   private Breed breed;

    public AdapterTabDetail(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public AdapterTabDetail(@NonNull Fragment fragment) {
        super(fragment);
    }

    public AdapterTabDetail(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, Breed breed, ArrayList<String> options) {
        super(fragmentManager, lifecycle);
        this.options = options;
        this.breed = breed;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (options.get(position) == "Información") {
            FragmentInfo fragmentInfo = FragmentInfo.newInstance(breed);
            return fragmentInfo;
        } else {
            FragmentStats fragmentStats = FragmentStats.newInstance(breed);
            return fragmentStats;
        }
    }

    @Override
    public int getItemCount() {
        return options.size();
    }
}
