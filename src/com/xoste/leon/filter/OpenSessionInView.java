package com.xoste.leon.filter;

import com.xoste.leon.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


public class OpenSessionInView implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SqlSession session = MybatisUtils.getSqlSession();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            session.commit();
        } catch (IOException e) {
            session.rollback();
        } finally {
            MybatisUtils.closeSqlSession();
        }

    }

    @Override
    public void destroy() {

    }
}
