package com.dante.studentmanage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class EncodingFilter implements Filter {
    private  String characterEncoding;
	public EncodingFilter() {
    }
	public void destroy() {
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		characterEncoding=fConfig.getInitParameter("encoding");
		if(characterEncoding==null||characterEncoding.isEmpty()){
//			throw new ServletException("字符编码设置为空");
			characterEncoding="UTF-8";  
			
		}
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)  
            throws IOException, ServletException {  
        // TODO Auto-generated method stub  
        resp.setContentType("text/html;charset="+characterEncoding);  
        req.setCharacterEncoding(characterEncoding);
        resp.setCharacterEncoding(characterEncoding);
        EnCodeRequest request = new EnCodeRequest((HttpServletRequest) req,characterEncoding);  
        System.out.println("diFilter()");  
        chain.doFilter(request, resp);  
    }  

	

}
