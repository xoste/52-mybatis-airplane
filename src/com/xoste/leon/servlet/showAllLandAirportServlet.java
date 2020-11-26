package com.xoste.leon.servlet;

import com.xoste.leon.pojo.Airport;
import com.xoste.leon.service.AirportService;
import com.xoste.leon.service.impl.AirportServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showAllLandAirport")
public class showAllLandAirportServlet extends HttpServlet {
    private AirportService airportService = new AirportServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airport> landportList = airportService.showAllLandAirport();
        req.setAttribute("landportList", landportList);
        req.getRequestDispatcher("showAirplane").forward(req, resp);
    }
}
