package com.xoste.leon.service;

import com.xoste.leon.pojo.Airplane;

import java.util.List;

public interface AirplaneService {
    /*
    * 显示所有的航班
    * */
    List<Airplane> showAllAirplane(int takeid, int landid);
}
