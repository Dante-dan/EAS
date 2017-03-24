package com.dante.studentmanage.filter;


import java.io.UnsupportedEncodingException;  
import javax.servlet.ServletRequest;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletRequestWrapper;  
  
public class EnCodeRequest extends HttpServletRequestWrapper{  
    private String charset;  
  
    public EnCodeRequest(HttpServletRequest request,String charset) {  
        super(request);  
        this.charset=charset;  
    }  
      
    public String getParameter(String str){  
        HttpServletRequest request = (HttpServletRequest) getRequest();  
        String method = getMethod();  
        if(method.equalsIgnoreCase("post")){  
            try {  
                request.setCharacterEncoding(charset);  
            } catch (UnsupportedEncodingException e) {  
                // TODO Auto-generated catch block  
                throw new RuntimeException("Unsupport CharacterEncoding");  
            }  
        }  
        else if(method.equalsIgnoreCase("get")){  
            String value = request.getParameter(str);  
            try {  
                value= new String(value.getBytes("ISO-8859-1"),charset);  
            } catch (UnsupportedEncodingException e) {  
                // TODO Auto-generated catch block  
                throw new RuntimeException("Unsupport CharacterEncoding");  
            }  
            return value;  
        }  
        return request.getParameter(str);  
    }  
}  