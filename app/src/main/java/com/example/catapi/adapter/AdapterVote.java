package com.example.catapi.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catapi.R;
import com.example.catapi.Utils.CustomItemClick;
import com.example.catapi.models.Breed;
import com.example.catapi.models.ResponseVote;

import java.util.ArrayList;
import java.util.List;

public class AdapterVote extends RecyclerView.Adapter<AdapterVote.HolderVotes> {

    private List<ResponseVote> votes;
    private final Context context;
    private final CustomItemClick listener;

    public AdapterVote(Context context, CustomItemClick listener) {
        this.context = context;
        this.votes = new ArrayList<>();
        this.listener = listener;
    }


    @NonNull
    @Override
    public AdapterVote.HolderVotes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.holdervote, parent, false);
        return new AdapterVote.HolderVotes(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVote.HolderVotes holder, int position) {

        ResponseVote responseVote = votes.get(position);
        holder.tvIdImage.setText(responseVote.getImageId());
        holder.tvIdVoter.setText(String.valueOf(responseVote.getId()));
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return votes.size();
    }

    static class HolderVotes extends RecyclerView.ViewHolder {

        private final TextView tvIdVoter;
        private final TextView tvIdImage;
        private final ImageView imgDelete;

        public HolderVotes(@NonNull View v) {
            super(v);

            tvIdImage = v.findViewById(R.id.tvIdImage);
            tvIdVoter = v.findViewById(R.id.tvIdVoter);
            imgDelete = v.findViewById(R.id.imgDelete);


        }
    }

    public void setList(List<ResponseVote> list) {

        this.votes = list;
        notifyDataSetChanged();
    }
}
