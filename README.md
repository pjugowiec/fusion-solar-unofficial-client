# About
Unofficial rest client for Fusion Solar written in Java. To obtain an API customer account, you must write a mail with the SN of the inverter.
After receiving, technical support should send API documentation along with login data. 

Source: https://forum.huawei.com/enterprise/en/communicate-with-fusionsolar-through-an-openapi-account/thread/591478-100027

Creating a FusionSolar client requires the use of a factory static method that will create the client instances.
![](../../CreateFusionSolarClient.png)

The basic thing is to log in to get a **XSRF-TOKEN** token. After obtaining the token, get code/codes of the stations from which you want to get data,
you can do it using the **getStationList** -> **stationCode** method or just from FusionSolar panel. Subsequent methods provide the target data.

If you have any questions, please create an issue.

**Github package:**  
https://github.com/pjugowiec/fusion-solar-unofficial-client/packages/1882766


# FusionSolarClient Interface - Methods

## Login

`String login(final String userName, final String password);`

This method logs you into the FusionSolar system with a given username and password (System Code). If the login is successful, it sets the XSRF-TOKEN as a variable in the instance of the client and returns it as a String.

**Parameters:**  
- userName: Username for the account.    
- password: System code (password) for the account.    

**Returns:**  
XSRF-TOKEN as a String.

## Set base url  
`void setBaseUrl(final String baseUrl);`   
This method allows you to set a custom base URL for the FusionSolar server. By default, the base URL is https://eu5.fusionsolar.huawei.com.   

**Parameters:**  
- baseUrl: The URL to set as the base URL.

## Get station list  
`StationList getStationList();`    
This method retrieves all the power stations associated with the logged-in account. This is usually needed to get the stationCode for a specific station you want to fetch data from.   

**Returns:**
An array of **Station** objects.

## Get station real kpi

`StationRealKpiList getStationRealKpi(final String stationCodes);`    
This method retrieves real-time KPIs (Key Performance Indicators) for the specified power stations.

**Parameters:**  
- stationCodes: A comma-separated list of power station codes for which to retrieve the KPIs.  

**Returns:**  
An array of **StationRealKpi** objects.  

## Get station hour kpi

`StationKpiList getStationHourKpi(final String stationCodes, final Long collectTime);`   
Fetches hourly KPI data for the chosen stations.   

**Parameters:**   
- stationCodes: A comma-separated list of power station codes.
- collectTime: The timestamp in milliseconds. The method queries hourly KPI data for one day based on the provided timestamp.  

**Returns:**  
An array of **StationKpi** objects.

## Get station day kpi

`StationKpiList getStationDayKpi(final String stationCodes, final Long collectTime);`   
Fetches daily KPI data for the chosen stations.  

**Parameters:**   
- stationCodes: A comma-separated list of power station codes.  
- collectTime: The timestamp in milliseconds.  

**Returns:**  
An array of **StationKpi** objects.

## Get station month kpi

`StationKpiList getStationMonthKpi(final String stationCodes, final Long collectTime);`   
Fetches monthly KPI data for the chosen stations.   

**Parameters:**    
- stationCodes: A comma-separated list of power station codes.   
- collectTime: The timestamp in milliseconds.   

**Returns:**   
An array of **StationKpi** objects.   

## Get station year kpi

`StationKpiList getStationYearKpi(final String stationCodes, final Long collectTime);`   
Fetches yearly KPI data for the chosen stations.   

**Parameters:**    
- stationCodes: A comma-separated list of power station codes.   
- collectTime: The timestamp in milliseconds.
  
**Returns:**    
An array of **StationKpi** objects.  

## Get dev list

`DevList getDevList(final String stationCodes);`   
Fetches a list of devices for the specified power stations.   

**Parameters:**   
- stationCodes: A comma-separated list of power station codes.
  
**Returns:**   
A **DevList** object.
