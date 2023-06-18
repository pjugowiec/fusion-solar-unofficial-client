package com.fusionSolarUnofficialClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NoArgsConstructor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static lombok.AccessLevel.PRIVATE;


@NoArgsConstructor(access = PRIVATE)
final class FusionSolarRestClientFactory {

    private static String BASE_URL = "https://eu5.fusionsolar.huawei.com";
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private static FusionSolarRestClient restClient;

    public static synchronized FusionSolarRestClient getRestClient() {
        return restClient == null ? createRestClient() : restClient;
    }

    public static void setBaseUrl(final String baseUrl) {
        BASE_URL = baseUrl;
        createRestClient();
    }

    private static FusionSolarRestClient createRestClient() {
        final Gson gson = new GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .create();
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final FusionSolarRestClient fusionSolarRestClient = retrofit.create(FusionSolarRestClient.class);
        restClient = fusionSolarRestClient;

        return fusionSolarRestClient;
    }
}
