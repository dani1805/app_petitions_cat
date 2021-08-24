package com.example.catapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.catapi.Utils.CustomItemClick;
import com.example.catapi.adapter.AdapterBreed;
import com.example.catapi.adapter.AdapterVote;
import com.example.catapi.models.Breed;
import com.example.catapi.models.ResponseVote;
import com.example.catapi.webServiceClient.WebServiceClient;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListVotesActivity extends AppCompatActivity {

    private RecyclerView rvVotes;
    private AdapterVote adapterVote;
    private WebServiceClient webServiceClient;
    private LinearLayoutManager layoutManager;
    private List<ResponseVote> votes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_votes);


        setupView( );
        initRetrofit();
        throwPetition();
    }

    private void setupView() {
        rvVotes = findViewById(R.id.rvVotes);
        adapterVote = new AdapterVote(this, new CustomItemClick() {
            @Override
            public void onItemClick(int position) {
                int id = votes.get(position).getId();

                Call<com.example.catapi.models.Response> petition = webServiceClient.deleteVote(id);
                petition.enqueue(new Callback<com.example.catapi.models.Response>() {
                    @Override
                    public void onResponse(Call<com.example.catapi.models.Response> call, Response<com.example.catapi.models.Response> response) {
                        Log.i("tag", String.valueOf(response.code()));
                        if (response.isSuccessful()) {
                            throwPetition();
                            Toast.makeText(ListVotesActivity.this, "Voto eliminado con éxito", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<com.example.catapi.models.Response> call, Throwable t) {
                        showErrorMessage();

                    }
                });
            }
        });
        layoutManager = new LinearLayoutManager(this);
        rvVotes.setLayoutManager(layoutManager);
        rvVotes.setAdapter(adapterVote);
    }

    private void initRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WebServiceClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        webServiceClient = retrofit.create(WebServiceClient.class);
    }

    private void throwPetition() {
        Call<List<ResponseVote>> petition = webServiceClient.getVotes();
        petition.enqueue(new Callback<List<ResponseVote>>() {
            @Override
            public void onResponse(@NotNull Call<List<ResponseVote>> call, @NotNull Response<List<ResponseVote>> response) {
                Log.i("tag", response.body().toString());
                if (response.isSuccessful()) {
                    int code = response.code();

                    votes = response.body();
                    Log.i("tag", votes.toString());
                    adapterVote.setList(votes);
                } else {
                    int code = response.code();
                    showErrorMessage();
                }
            }
            @Override
            public void onFailure(@NotNull Call<List<ResponseVote>> call, @NotNull Throwable t) {
                Log.d("RETROFIT", "Error: " + t.getMessage());
            }
        });
    }

    private void showErrorMessage() {
        Toast.makeText(this, "Ha ocurrido un error desconocido. Por favor, vuelve a intentarlo más tarde.", Toast.LENGTH_SHORT).show();
    }

}