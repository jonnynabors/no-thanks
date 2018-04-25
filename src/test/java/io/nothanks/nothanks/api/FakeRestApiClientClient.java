package io.nothanks.nothanks.api;

import retrofit2.Call;
import retrofit2.mock.Calls;

public class FakeRestApiClientClient implements RestApiClient {

    @Override
    public Call<Integer> createGame() {
        return Calls.response(1);
    }
}
