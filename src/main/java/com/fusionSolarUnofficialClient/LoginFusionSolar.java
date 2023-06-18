package com.fusionSolarUnofficialClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class LoginFusionSolar {
    private String userName;
    private String systemCode;
}
