package com.fusionSolarClient.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginFusionSolar {
    private String userName;
    private String systemCode;
}
