package com.fusionSolarClient.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class DevItem {
    private String devName;
    private Double devTypeId;
    private String esnCode;
    private Double id;
    private String invType;
    private Double latitude;
    private Double longitude;
    private Double optimizerNumber;
    private String softwareVersion;
    private String stationCode;

}
