package com.example.catapi.webServiceClient;

import com.example.catapi.models.Breed;
import com.example.catapi.models.Data;
import com.example.catapi.models.Response;
import com.example.catapi.models.ResponseVote;
import com.example.catapi.models.Vote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WebServiceClient {
    String BASE_URL = "https://api.thecatapi.com/v1/";
    String TOKEN = "x-api-key: 6a119e4b-753e-42ca-aff1-20623d40ec90";

    @Headers(TOKEN)
    @GET("breeds")
    Call<List<Breed>> getBreeds();

    @Headers({TOKEN, "Content-Type: application/json"})
    @POST("votes")
    Call<Response> postVote(@Body Vote vote);

    @Headers(TOKEN)
    @GET("votes")
    Call<List<ResponseVote>> getVotes();

    @Headers(TOKEN)
    @DELETE("votes/{vote_id}")
    Call<Response> deleteVote(@Path("vote_id") int id);
}
