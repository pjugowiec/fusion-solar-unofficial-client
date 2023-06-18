package com.fusionSolarUnofficialClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class BaseRequest {
    private String stationCodes;
    private Long collectTime;
}
