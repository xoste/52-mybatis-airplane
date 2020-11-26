package com.xoste.leon.service.impl;

import com.xoste.leon.mapper.AirplaneMapper;
import com.xoste.leon.pojo.Airplane;
import com.xoste.leon.service.AirplaneService;
import com.xoste.leon.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AirplaneServiceImpl implements AirplaneService {
    private SqlSession session = MybatisUtils.getSqlSession();
    private AirplaneMapper airplaneMapper = session.getMapper(AirplaneMapper.class);
    @Override
    public List<Airplane> showAllAirplane(int takeid, int landid) {
        return airplaneMapper.selectAllAirplaneById(takeid, landid);
    }
}
