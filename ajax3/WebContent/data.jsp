<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%String name="성춘향";
    int age=16;
    String birth="08/12/22";
    
    String json="{ \"name\":\""+name+"\", \"age\":\""+age+"\", \"birth\":\""+birth+"\"}";
    out.println(json);
    %>
