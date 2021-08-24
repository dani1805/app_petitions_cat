package com.example.catapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.catapi.Utils.CustomItemClick;
import com.example.catapi.adapter.AdapterBreed;
import com.example.catapi.models.Breed;
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

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvListOfBreeds;
    private AdapterBreed adapterBreed;
    private WebServiceClient webServiceClient;
    private LinearLayoutManager layoutManager;
    private SwipeRefreshLayout layout;
    private List<Breed> list = new ArrayList<>();
    private List<Breed> listBreed = new ArrayList<>();
    private CustomItemClick listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvListOfBreeds = findViewById(R.id.rvListOfBreeds);
        layout = findViewById(R.id.swipeRefreshLayout);

        setupView();
        initRetrofit();
        throwPetition();

    }

    private void setView() {

        listBreed = new ArrayList<>();
        rvListOfBreeds = findViewById(R.id.rvListOfBreeds);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        adapterBreed = new AdapterBreed(MainActivity.this, listener);

        rvListOfBreeds.setLayoutManager(layoutManager);
        rvListOfBreeds.setAdapter(adapterBreed);

    }

    private void setupView() {
        rvListOfBreeds = findViewById(R.id.rvListOfBreeds);
        adapterBreed = new AdapterBreed(this, new CustomItemClick() {

            @Override
            public void onItemClick(int position) {
                Breed breed = list.get(position);
                Intent intent = new Intent(MainActivity.this, BreedDetailActivity.class);
                intent.putExtra("breed", breed);

                startActivity(intent);
            }
        });
        layoutManager = new LinearLayoutManager(this);
        rvListOfBreeds.setLayoutManager(layoutManager);
        rvListOfBreeds.setAdapter(adapterBreed);


        layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // realiza este codigo cuando hace el gesto de actualizar

                throwPetition();


            }
        });


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
        Call<List<Breed>> petition = webServiceClient.getBreeds();
        petition.enqueue(new Callback<List<Breed>>() {
            @Override
            public void onResponse(@NotNull Call<List<Breed>> call, @NotNull Response<List<Breed>> response) {

                layout.setRefreshing(false);
                layout.setColorSchemeResources(R.color.white, R.color.teal_700);

                if (response.isSuccessful()) {
                    int code = response.code();

                    list = response.body(); //data.getBreeds();
                    adapterBreed.setList(list);
                } else {
                    int code = response.code();
                    showErrorMessage();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Breed>> call, @NotNull Throwable t) {
                layout.setRefreshing(false);
                Log.d("RETROFIT", "Error: " + t.getMessage());
            }
        });
    }

    private void showErrorMessage() {
        Toast.makeText(this, "Ha ocurrido un error desconocido. Por favor, vuelve a intentarlo más tarde.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapterBreed.getFilter().filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterBreed.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_search:
                return true;

            case R.id.menu_listVotes:
                Intent intent = new Intent(MainActivity.this, ListVotesActivity.class);
                startActivity(intent);

                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
