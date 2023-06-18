package com.fusionSolarUnofficialClient.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DevList extends BaseResponse{
    private List<DevItem> data;
}
