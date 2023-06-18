package com.fusionSolarUnofficialClient.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StationList extends BaseResponse {
    private List<Station> data;
}
