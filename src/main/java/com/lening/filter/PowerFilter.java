package com.lening.filter;

import com.lening.entity.UserBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 创作时间：2019/8/15 16:01
 * 作者：李增强
 */
public class PowerFilter implements Filter {
    Set notfilterurl = new HashSet();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String aa = filterConfig.getInitParameter("notfilterurl");
        for (String url : aa.split(",")) {
            notfilterurl.add(url.trim());
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String uri = request.getRequestURI();
        uri = uri.substring(uri.lastIndexOf("/") + 1);
        System.out.println("uri================"+uri);
        if(notfilterurl.contains(uri)){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            UserBean ub = (UserBean)request.getSession().getAttribute("ub");
            if(ub!=null){
                Set<String> urls = (Set<String>)request.getSession().getAttribute("urls");
                if(urls.contains(uri)){
                    filterChain.doFilter(servletRequest, servletResponse);
                }else{
                    request.setAttribute("msg", "非法访问！！！！！！！");
                    request.getRequestDispatcher("index.jsp").forward(request, servletResponse);
                }

            }else{
                request.setAttribute("msg", "请先登录");
                request.getRequestDispatcher("index.jsp").forward(request, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
