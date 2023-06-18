package com.fusionSolarUnofficialClient.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public final class StationRealKpiList extends BaseResponse{
    private List<StationRealKpi> data;
}
