package com.fusionSolarClient.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StationKpi {
    private Long collectTime;
    private DataItem dataItemMap;
}
