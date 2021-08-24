package com.example.catapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catapi.adapter.AdapterTabDetail;
import com.example.catapi.models.Breed;
import com.example.catapi.models.Vote;
import com.example.catapi.webServiceClient.WebServiceClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.squareup.picasso.Picasso;

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

public class BreedDetailActivity extends AppCompatActivity {

    private Breed breed;
    private TabLayout tab;
    private ViewPager2 vpDetail;

    private WebServiceClient webServiceClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_detail);

        FloatingActionButton faVotes = findViewById(R.id.faVotes);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("breed")) {
            breed = bundle.getParcelable("breed");

            setUpView();
        }

        faVotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(BreedDetailActivity.this);
                View view = getLayoutInflater().inflate(R.layout.alertdialog, null);
                EditText etVote = view.findViewById(R.id.etVote);
                TextView tvVote = view.findViewById(R.id.tvVote);
                builder.setView(view);

                builder.setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int vote = Integer.parseInt(String.valueOf(etVote.getText()));
                        Vote otherVote = new Vote(breed.getReferenceImageId(), "my-user-1234", vote);

                        initRetrofit();
                        throwPetition(otherVote);

                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();



            }
        });


    }

    public void setUpView() {
        TextView tvNameDetail = findViewById(R.id.tvNameDetail);
        ImageView myImage = findViewById(R.id.myImage);
        Picasso.get().load(Uri.parse(breed.getImage().getUrl())).into(myImage);

        tab = findViewById(R.id.tab);
        vpDetail = findViewById(R.id.vpDetail);

        ArrayList<String> options = new ArrayList<>();

        options.add("Información");
        options.add("Stats");

        AdapterTabDetail adapterTabDetail = new AdapterTabDetail(getSupportFragmentManager(), getLifecycle(), breed, options);
        vpDetail.setAdapter(adapterTabDetail);

        TabLayoutMediator mediator = new TabLayoutMediator(tab, vpDetail, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                tab.setText(options.get(position));
            }
        });
        mediator.attach();

        tvNameDetail.setText(breed.getName());

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

    private void throwPetition(Vote vote) {
        Call<com.example.catapi.models.Response> petition = webServiceClient.postVote(vote);
        petition.enqueue(new Callback<com.example.catapi.models.Response>() {
            @Override
            public void onResponse(Call<com.example.catapi.models.Response> call, Response<com.example.catapi.models.Response> response) {
                if (response.code() == 200) {
                    Log.i("tag", String.valueOf(response.code()));
                    showVoteSuccess();
                } else {
                    showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<com.example.catapi.models.Response> call, Throwable t) {
                showErrorMessage();

            }
        });
    }

    private void showErrorMessage() {
        Toast.makeText(BreedDetailActivity.this, "Ha ocurrido un error desconocido. Por favor, vuelve a intentarlo más tarde.", Toast.LENGTH_SHORT).show();
    }

    private void showVoteSuccess() {
        Toast.makeText(BreedDetailActivity.this, "Voto emitido con éxito", Toast.LENGTH_SHORT).show();
    }
}