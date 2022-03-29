package com.fusionSolarClient.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseRequest {
    private String stationCodes;
    private Long collectTime;
}
