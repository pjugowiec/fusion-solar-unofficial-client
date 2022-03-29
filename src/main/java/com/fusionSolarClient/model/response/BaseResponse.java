package com.fusionSolarClient.model.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseResponse {
    private boolean success;
    private BaseParamsResponse params;
    private String message;
    private Integer failCode;
    private String buildCode;
}
