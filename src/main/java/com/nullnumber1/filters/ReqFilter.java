package com.nullnumber1.filters;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "ReqFilter", value = "/*")
public class ReqFilter implements Filter {
    @Override

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long elapsed = System.currentTimeMillis() - startTime;
        String name = "Servlet";
        if (servletRequest instanceof HttpServletRequest) {
            name = ((HttpServletRequest) servletRequest).getRequestURI();
        }
        log.info("{} took {} ms to execute", name, elapsed);
    }
}
