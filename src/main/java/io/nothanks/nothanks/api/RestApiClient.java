package io.nothanks.nothanks.api;

import retrofit2.Call;
import retrofit2.http.POST;

public interface RestApiClient {

    @POST("game/create")
    Call<Integer> createGame();

}
