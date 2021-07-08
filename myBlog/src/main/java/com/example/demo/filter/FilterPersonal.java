package com.example.demo.filter;

import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "FilterPersonal", urlPatterns = "/logout")//TODO:这里的路径应该设置为访问个人主页
@Order(1)
public class FilterPersonal implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //log.debug("start to auth request validate...111");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res =  (HttpServletResponse) response;

        if (req.getSession().getAttribute("token") != null) {//如果存在token直接进入该用户主页
            chain.doFilter(request, response);//如果不存在token 证明没有登录就直接转向登录页面
        } else {
            res.sendRedirect("/login");//如果存在token 就证明已经登录了 所以直接转向主页
        }
    }
}
