package com.fusionSolarClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NoArgsConstructor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static lombok.AccessLevel.PRIVATE;


@NoArgsConstructor(access = PRIVATE)
class FusionSolarRestClientFactory {

    private static final String BASE_URL = "https://eu5.fusionsolar.huawei.com";
    private static FusionSolarRestClient restClient;

    protected static synchronized FusionSolarRestClient getRestClient() {
        return restClient == null ? createRestClient() : restClient;
    }

    private static FusionSolarRestClient createRestClient() {
        final Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
                .create();
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(FusionSolarRestClient.class);
    }
}
