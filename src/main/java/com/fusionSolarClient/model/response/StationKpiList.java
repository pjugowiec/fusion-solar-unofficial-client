package com.fusionSolarClient.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StationKpiList extends BaseResponse{
    private List<StationKpi> data;
}
