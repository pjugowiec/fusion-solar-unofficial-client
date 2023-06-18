package com.fusionSolarUnofficialClient;

import lombok.NoArgsConstructor;
import okhttp3.Headers;

import static com.fusionSolarUnofficialClient.FusionSolarRestClient.XSRF_TOKEN;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
class FusionSolarUtil {

    public static String getXsrfTokenFromHeaders(final Headers headers) {
        final String token = headers.get(XSRF_TOKEN);

        if(token == null || token.isBlank()) {
            throw new FusionSolarException("Token not exists in header");
        }

        return token;
    }
}
