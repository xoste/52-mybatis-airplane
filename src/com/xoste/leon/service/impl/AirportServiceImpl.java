package com.xoste.leon.service.impl;

import com.xoste.leon.mapper.AirportMapper;
import com.xoste.leon.pojo.Airport;
import com.xoste.leon.service.AirportService;
import com.xoste.leon.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AirportServiceImpl implements AirportService {
    private SqlSession session = MybatisUtils.getSqlSession();
    private  AirportMapper airportMapper = session.getMapper(AirportMapper.class);
    @Override
    public List<Airport> showAllTakeAirport() {
        return airportMapper.selectAllTakeAirport();
    }

    @Override
    public List<Airport> showAllLandAirport() {
        return airportMapper.selectAllLandAirport();
    }
}
