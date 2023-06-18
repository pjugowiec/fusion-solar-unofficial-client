package com.fusionSolarUnofficialClient.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataItem {
    private Double radiation_intensity;
    private Double theory_power;
    private Double inverter_power;
    private Double ongrid_power;
    private Double power_profit;
    private Double installed_capacity;
    private Double performance_ratio;
    private Double use_power;
    private Double perpower_ratio;
    private Double reduction_total_co2;
    private Double reduction_total_coal;
    private Double reduction_total_tree;

}
