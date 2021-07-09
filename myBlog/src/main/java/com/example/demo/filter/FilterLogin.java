package com.example.demo.filter;

import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "filter", urlPatterns = "/login")//TODO:这里的路径应该设置为访问登录页面的时候 检测是否已经登录
@Order(1)
public class FilterLogin implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //log.debug("start to auth request validate...111");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res =  (HttpServletResponse) response;
        String userID = req.getHeader("ID");

        if (req.getSession().getAttribute("token") != null) {
            res.sendRedirect("/mainpage");//如果存在token 就证明已经登录了 所以直接转向主页
        } else {
            chain.doFilter(request, response);//如果不存在 直接访问主页
        }
    }
}
