package com.fusionSolarUnofficialClient;

import com.fusionSolarUnofficialClient.response.DevList;
import com.fusionSolarUnofficialClient.response.StationKpiList;
import com.fusionSolarUnofficialClient.response.StationList;
import com.fusionSolarUnofficialClient.response.StationRealKpiList;

public interface FusionSolarClient {

    /**
     * Returns <b>XSRF-TOKEN</b> after successful login. Token is set as variable in instance of client.
     *
     * @param userName Username of user
     * @param password Password of user (System code)
     * @return XSRF-TOKEN as {@link String}
     */
    String login(final String userName, final String password);

    /**
     * Set url for fusionSolar server. Default is <b>https://eu5.fusionsolar.huawei.com</b>
     * @param baseUrl Url to set
     */
    void setBaseUrl(final String baseUrl);

    /**
     * Get stations that are associated with account. We need it to get
     * <b>stationCode</b> from selected station that we want get data.
     *
     * @return All stations that associated with account, as array of {@link com.fusionSolarUnofficialClient.response.Station}
     */
    StationList getStationList();

    /**
     * Get real KPI for chosen stations
     *
     * @param stationCodes For the list of power station numbers, multiple stations are separated by comma symbols
     * @return Real KPI for chosen stations, represented by array of {@link com.fusionSolarUnofficialClient.response.StationRealKpi}
     */
    StationRealKpiList getStationRealKpi(final String stationCodes);

    /**
     * Get hourly KPI for chosen stations
     *
     * @param stationCodes For the list of power station numbers, multiple stations are separated by comma symbols
     * @param collectTime Milliseconds in time. It hourly queries the hour KPI data for one day (the background processes milliseconds
     *                    based on the time zone where the power station is located)
     * @return Hourly KPI for chosen stations, represented by array of {@link StationKpiList}
     */
    StationKpiList getStationHourKpi( final String stationCodes, final Long collectTime);

    /**
     * Get daily KPI for chosen stations
     *
     * @param stationCodes For the list of power station numbers, multiple stations are separated by comma symbols
     * @param collectTime Milliseconds in time. It hourly queries the hour KPI data for one day (the background processes milliseconds
     *                    based on the time zone where the power station is located)
     * @return Daily KPI for chosen stations, represented by array of {@link StationKpiList}
     */
    StationKpiList getStationDayKpi( final String stationCodes, final Long collectTime);

    /**
     * Get monthly KPI for chosen stations
     *
     * @param stationCodes For the list of power station numbers, multiple stations are separated by comma symbols
     * @param collectTime Milliseconds in time. It hourly queries the hour KPI data for one day (the background processes milliseconds
     *                    based on the time zone where the power station is located)
     * @return Monthly KPI for chosen stations, represented by array of {@link StationKpiList}
     */
    StationKpiList getStationMonthKpi(final String stationCodes, final Long collectTime);

    /**
     * Get yearly KPI for chosen stations
     *
     * @param stationCodes For the list of power station numbers, multiple stations are separated by comma symbols
     * @param collectTime Milliseconds in time. It hourly queries the hour KPI data for one day (the background processes milliseconds
     *                    based on the time zone where the power station is located)
     * @return Yearly KPI for chosen stations, represented by array of {@link StationKpiList}
     */
    StationKpiList getStationYearKpi(final String stationCodes, final Long collectTime);

    /**
     *
     * @param stationCodes For the list of power station numbers, multiple stations are separated by comma symbols
     * @return Dev list, represented b {@link com.fusionSolarUnofficialClient.response.DevList}
     */
    DevList getDevList(final String stationCodes);
}
