# About
Unofficial rest client for Fusion Solar written in Java. To obtain an API customer account, you must write a mail with the SN of the inverter.
After receiving, technical support should send API documentation along with login data. 

Source: https://forum.huawei.com/enterprise/en/communicate-with-fusionsolar-through-an-openapi-account/thread/591478-100027

Creating a FusionSolar client requires the use of a factory static method that will create the client instances.
![](../../CreateFusionSolarClient.png)

The basic thing is to log in to get a <b>XSRF-TOKEN</b> token. After obtaining the token, get code/codes of the stations from which you want to get data,
you can do it using the getStationList -> stationCode method or just from FusionSolar panel. Subsequent methods provide the target data.