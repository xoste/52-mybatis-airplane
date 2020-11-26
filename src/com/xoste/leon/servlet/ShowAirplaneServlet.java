package com.xoste.leon.servlet;

import com.xoste.leon.pojo.Airplane;
import com.xoste.leon.pojo.Airport;
import com.xoste.leon.service.AirplaneService;
import com.xoste.leon.service.impl.AirplaneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showAirplane")
public class ShowAirplaneServlet extends HttpServlet {
    private AirplaneService airplaneService = new AirplaneServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int takeid = 0;
        String takeidStr = req.getParameter("takeid");
        System.out.println("takeidStr....." + takeidStr);
        if (takeidStr != null && !"".equals(takeidStr)) {
            takeid = Integer.parseInt(takeidStr);
        }
        int landid = 0;
        String landidStr = req.getParameter("landid");
        if (landidStr != null && !"".equals(landidStr)) {
            landid = Integer.parseInt(landidStr);
        }
        List<Airplane> airplaneList = airplaneService.showAllAirplane(takeid, landid);
        req.setAttribute("airplaneList", airplaneList);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
