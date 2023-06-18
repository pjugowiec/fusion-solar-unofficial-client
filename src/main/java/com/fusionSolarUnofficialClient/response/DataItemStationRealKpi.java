package com.fusionSolarUnofficialClient.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class DataItemStationRealKpi {

    private String day_power;
    private String month_power;
    private String total_power;
    private String day_income;
    private String total_income;
    private String real_health_state;
}
