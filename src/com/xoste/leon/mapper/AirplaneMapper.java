package com.xoste.leon.mapper;

import com.xoste.leon.pojo.Airplane;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AirplaneMapper {
    List<Airplane> selectAllAirplaneById(@Param("takeid") int takeid, @Param("landid") int landid);
}
