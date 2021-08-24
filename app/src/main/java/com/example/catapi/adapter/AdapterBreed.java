package com.example.catapi.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catapi.R;
import com.example.catapi.Utils.CustomItemClick;
import com.example.catapi.models.Breed;

import java.util.ArrayList;
import java.util.List;

public class AdapterBreed extends RecyclerView.Adapter<AdapterBreed.HolderBreeds> implements Filterable {

    private List<Breed> breeds;
    private List<Breed> copyBreeds;
    private final Context context;
    private final CustomItemClick listener;

    public AdapterBreed(Context context, CustomItemClick listener) {
        this.context = context;
        this.breeds = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdapterBreed.HolderBreeds onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.holderbreeds, parent, false);
        return new HolderBreeds(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBreed.HolderBreeds holder, int position) {

        Breed breed = breeds.get(position);
        holder.tvName.setText(breed.getName());
        holder.tvAffectionLevel.setText(String.valueOf(breed.getAffectionLevel()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return breeds.size();
    }


    static class HolderBreeds extends RecyclerView.ViewHolder {

        private final TextView tvName;
        private final TextView tvAffectionLevel;

        public HolderBreeds(@NonNull View v) {
            super(v);

            tvName = v.findViewById(R.id.tvName);
            tvAffectionLevel = v.findViewById(R.id.tvAfecctionLevel);
        }
    }

    public void setList(List<Breed> list) {
        this.copyBreeds = list;
        this.breeds = list;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String texto_a_buscar = constraint.toString();

                if (texto_a_buscar.isEmpty()) {
                    breeds = copyBreeds;
                } else {
                    List<Breed> listAux = new ArrayList<>();

                    for (Breed breed : copyBreeds) {

                        String nameBreed = breed.getName().toLowerCase();
                        String textSearchMinus = texto_a_buscar.toLowerCase();

                        if (nameBreed.contains(textSearchMinus)) {
                            listAux.add(breed);
                        }
                    }

                    breeds = listAux;

                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = breeds;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                breeds = (List<Breed>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }


}
