package com.fusionSolarUnofficialClient.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class BaseParamsResponse {
    private Long currentTime;
    private Long collectTime;
    private String stationCodes;
}
