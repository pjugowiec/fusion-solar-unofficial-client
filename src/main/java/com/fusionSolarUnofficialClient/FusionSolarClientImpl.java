package com.fusionSolarUnofficialClient;

import com.fusionSolarUnofficialClient.response.*;
import lombok.NoArgsConstructor;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
final class FusionSolarClientImpl implements FusionSolarClient {

    private final FusionSolarRestClient restClient = FusionSolarRestClientFactory.getRestClient();
    private String token;

    public static FusionSolarClientImpl createInstance() {
        return new FusionSolarClientImpl();
    }
    
    @Override
    public String login(final String userName, final String password) {
        final LoginFusionSolar login = LoginFusionSolar.builder()
                .userName(userName)
                .systemCode(password)
                .build();
       Response<BaseResponse> response = executeCall(restClient.login(login));
       final String tokenFromResponse = FusionSolarUtil.getXsrfTokenFromHeaders(response.headers());
       token = tokenFromResponse;
       return tokenFromResponse;
    }

    @Override
    public void setBaseUrl(final String baseUrl) {
        FusionSolarRestClientFactory.setBaseUrl(baseUrl);
    }

    @Override
    public StationList getStationList() {
       return executeCall(restClient.getStationList(token)).body();
    }

    @Override
    public StationRealKpiList getStationRealKpi(final String stationCodes) {
        final BaseRequest request = BaseRequest.builder()
                .stationCodes(stationCodes)
                .build();
        return executeCall(restClient.getStationRealKpi(token, request)).body();
    }

    @Override
    public StationKpiList getStationHourKpi(final String stationCodes, final Long collectTime) {
        final BaseRequest request = BaseRequest.builder()
                .stationCodes(stationCodes)
                .collectTime(collectTime)
                .build();
        return executeCall(restClient.getStationHourKpi(token, request)).body();
    }

    @Override
    public StationKpiList getStationDayKpi(final String stationCodes, final Long collectTime) {
        final BaseRequest request = BaseRequest.builder()
                .stationCodes(stationCodes)
                .collectTime(collectTime)
                .build();
        return executeCall(restClient.getStationDayKpi(token, request)).body();
    }

    @Override
    public StationKpiList getStationMonthKpi(final String stationCodes, final Long collectTime) {
        final BaseRequest request = BaseRequest.builder()
                .stationCodes(stationCodes)
                .collectTime(collectTime)
                .build();
        return executeCall(restClient.getStationMonthKpi(token, request)).body();
    }

    @Override
    public StationKpiList getStationYearKpi(final String stationCodes, final Long collectTime) {
        final BaseRequest request = BaseRequest.builder()
                .stationCodes(stationCodes)
                .collectTime(collectTime)
                .build();
        return executeCall(restClient.getStationYearKpi(token, request)).body();
    }

    @Override
    public DevList getDevList(final String stationCodes) {
        final BaseRequest request = BaseRequest.builder()
                .stationCodes(stationCodes)
                .build();
        return executeCall(restClient.getDevList(token, request)).body();
    }

    private <T> Response<T> executeCall(final Call<T> call) {
        try {
            final Response<T> response = call.execute();
            if(response.isSuccessful()) {
                return response;
            }
            throw new FusionSolarException("Problem with execute call: " + response.message());
        } catch (IOException e) {
            throw new FusionSolarException("Internal error: " + e.getMessage());
        }
    }
}
