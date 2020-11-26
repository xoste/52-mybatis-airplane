package com.xoste.leon.mapper;

import com.xoste.leon.pojo.Airport;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AirportMapper {
    @Select("select * from airport where id in (select distinct takeid from airplane)")
    List<Airport> selectAllTakeAirport();
    @Select("select * from airport where id in (select distinct landid from airplane)")
    List<Airport> selectAllLandAirport();
}
