package com.fusionSolarClient;

import com.fusionSolarClient.model.request.BaseRequest;
import com.fusionSolarClient.model.request.LoginFusionSolar;
import com.fusionSolarClient.model.response.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static lombok.AccessLevel.PROTECTED;

@Builder
@NoArgsConstructor(access = PROTECTED)
class FusionSolarClientImpl implements FusionSolarClient {

    private final FusionSolarRestClient restClient = FusionSolarRestClientFactory.getRestClient();

    @Override
    public String login(final String userName, final String systemCode) {
        final LoginFusionSolar login = LoginFusionSolar.builder()
                .userName(userName)
                .systemCode(systemCode)
                .build();
       Response<BaseResponse> response = executeCall(restClient.login(login));
       return FusionSolarUtil.getXsrfTokenFromHeaders(response.headers());
    }

    @Override
    public StationList getStationList(final String token) {
       return executeCall(restClient.getStationList(token)).body();
    }

    @Override
    public StationRealKpiList getStationRealKpi(final String token, final String stationCodes) {
        final BaseRequest request = BaseRequest.builder()
                .stationCodes(stationCodes)
                .build();
        return executeCall(restClient.getStationRealKpi(token, request)).body();
    }

    @Override
    public StationKpiList getStationHourKpi(final String token, final String stationCodes, final Long collectTime) {
        final BaseRequest request = BaseRequest.builder()
                .stationCodes(stationCodes)
                .collectTime(collectTime)
                .build();
        return executeCall(restClient.getStationHourKpi(token, request)).body();
    }

    @Override
    public StationKpiList getStationDayKpi(final String token,final String stationCodes, final Long collectTime) {
        final BaseRequest request = BaseRequest.builder()
                .stationCodes(stationCodes)
                .collectTime(collectTime)
                .build();
        return executeCall(restClient.getStationDayKpi(token, request)).body();
    }

    @Override
    public StationKpiList getStationMonthKpi(final String token,final String stationCodes, final Long collectTime) {
        final BaseRequest request = BaseRequest.builder()
                .stationCodes(stationCodes)
                .collectTime(collectTime)
                .build();
        return executeCall(restClient.getStationMonthKpi(token, request)).body();
    }

    @Override
    public StationKpiList getStationYearKpi(final String token,final String stationCodes, final Long collectTime) {
        final BaseRequest request = BaseRequest.builder()
                .stationCodes(stationCodes)
                .collectTime(collectTime)
                .build();
        return executeCall(restClient.getStationYearKpi(token, request)).body();
    }

    @Override
    public DevList getDevList(final String token, final String stationCodes) {
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
