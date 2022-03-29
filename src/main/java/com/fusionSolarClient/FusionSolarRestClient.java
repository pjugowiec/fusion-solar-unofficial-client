package com.fusionSolarClient;

import com.fusionSolarClient.model.request.BaseRequest;
import com.fusionSolarClient.model.request.LoginFusionSolar;
import com.fusionSolarClient.model.response.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

interface FusionSolarRestClient {
    String XSRF_TOKEN = "xsrf-token";

    @POST("/thirdData/login")
    Call<BaseResponse> login(@Body LoginFusionSolar login);

    @POST("/thirdData/getStationList")
    Call<StationList> getStationList(@Header(XSRF_TOKEN) String token);

    @POST("/thirdData/getStationRealKpi")
    Call<StationRealKpiList> getStationRealKpi(@Header(XSRF_TOKEN) String token, @Body BaseRequest request);

    @POST("/thirdData/getKpiStationHour")
    Call<StationKpiList> getStationHourKpi(@Header(XSRF_TOKEN) String token, @Body BaseRequest request);

    @POST("/thirdData/getKpiStationDay")
    Call<StationKpiList> getStationDayKpi(@Header(XSRF_TOKEN) String token, @Body BaseRequest request);

    @POST("/thirdData/getKpiStationMonth")
    Call<StationKpiList> getStationMonthKpi(@Header(XSRF_TOKEN) String token, @Body BaseRequest request);

    @POST("/thirdData/getKpiStationYear")
    Call<StationKpiList> getStationYearKpi(@Header(XSRF_TOKEN) String token, @Body BaseRequest request);

    @POST("/thirdData/getDevList")
    Call<DevList> getDevList(@Header(XSRF_TOKEN) String token, @Body BaseRequest request);
}
