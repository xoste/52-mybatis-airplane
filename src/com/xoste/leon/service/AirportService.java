package com.xoste.leon.service;

import com.xoste.leon.pojo.Airport;

import java.util.List;

public interface AirportService {
    /*
    * 显示出所有的起飞机场
    * */
    List<Airport> showAllTakeAirport();
    /*
     * 显示出所有的降落机场
     * */
    List<Airport> showAllLandAirport();
}
