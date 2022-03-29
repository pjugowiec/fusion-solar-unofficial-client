package com.fusionSolarClient;

import com.fusionSolarClient.model.response.DevList;
import com.fusionSolarClient.model.response.StationKpiList;
import com.fusionSolarClient.model.response.StationList;
import com.fusionSolarClient.model.response.StationRealKpiList;

public interface FusionSolarClient {

    /**
     * Returns <b>XSRF-TOKEN</b> after successful login
     *
     * @param userName Username of user
     * @param systemCode Password of user
     * @return XSRF-TOKEN as {@link String}
     */
    String login(final String userName, final String systemCode);

    /**
     * Get stations that are associated with account. We need it to get
     * <b>stationCode</b> from selected station that we want get data.
     *
     * @param token XSRF-TOKEN
     * @return All stations that associated with account, as array of {@link com.fusionSolarClient.model.response.Station}
     */
    StationList getStationList(final String token);

    /**
     * Get real KPI for chosen stations
     *
     * @param token XSRF-TOKEN
     * @param stationCodes For the list of power station numbers, multiple stations are separated by comma symbols
     * @return Real KPI for chosen stations, represented by array of {@link com.fusionSolarClient.model.response.StationRealKpi}
     */
    StationRealKpiList getStationRealKpi(final String token, final String stationCodes);

    /**
     * Get hourly KPI for chosen stations
     *
     * @param token XSRF-TOKEN
     * @param stationCodes For the list of power station numbers, multiple stations are separated by comma symbols
     * @param collectTime Milliseconds in time. It hourly queries the hour KPI data for one day (the background processes milliseconds
     *                    based on the time zone where the power station is located)
     * @return Hourly KPI for chosen stations, represented by array of {@link StationKpiList}
     */
    StationKpiList getStationHourKpi(final String token, final String stationCodes, final Long collectTime);

    /**
     * Get daily KPI for chosen stations
     *
     * @param token XSRF-TOKEN
     * @param stationCodes For the list of power station numbers, multiple stations are separated by comma symbols
     * @param collectTime Milliseconds in time. It hourly queries the hour KPI data for one day (the background processes milliseconds
     *                    based on the time zone where the power station is located)
     * @return Daily KPI for chosen stations, represented by array of {@link StationKpiList}
     */
    StationKpiList getStationDayKpi(final String token, final String stationCodes, final Long collectTime);

    /**
     * Get monthly KPI for chosen stations
     *
     * @param token XSRF-TOKEN
     * @param stationCodes For the list of power station numbers, multiple stations are separated by comma symbols
     * @param collectTime Milliseconds in time. It hourly queries the hour KPI data for one day (the background processes milliseconds
     *                    based on the time zone where the power station is located)
     * @return Monthly KPI for chosen stations, represented by array of {@link StationKpiList}
     */
    StationKpiList getStationMonthKpi(final String token, final String stationCodes, final Long collectTime);

    /**
     * Get yearly KPI for chosen stations
     *
     * @param token XSRF-TOKEN
     * @param stationCodes For the list of power station numbers, multiple stations are separated by comma symbols
     * @param collectTime Milliseconds in time. It hourly queries the hour KPI data for one day (the background processes milliseconds
     *                    based on the time zone where the power station is located)
     * @return Yearly KPI for chosen stations, represented by array of {@link StationKpiList}
     */
    StationKpiList getStationYearKpi(final String token, final String stationCodes, final Long collectTime);

    /**
     *
     * @param token XSRF-TOKEN
     * @param stationCodes For the list of power station numbers, multiple stations are separated by comma symbols
     * @return Dev list, represented b {@link com.fusionSolarClient.model.response.DevList}
     */
    DevList getDevList(final String token, final String stationCodes);
}
