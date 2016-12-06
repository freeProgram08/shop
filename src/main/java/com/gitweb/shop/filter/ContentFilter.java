package com.gitweb.shop.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器  是个接口  过滤字符编码
 */
public class ContentFilter  implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //过滤器的作用
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //放行  进入servlet
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
