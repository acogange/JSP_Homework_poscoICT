
<%@page import="sample01.YouClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
//java 영역
 --%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- html 주석문 -->

<%-- jsp 주석문 --%>
<%--
	jsp :  java server page
			server를 통해 client form을 만들어내는 코드

	spring framework - 대기업
	spring boot -스타트업 /setting 할게 덜 함 확장성 떨어짐/개발속도 빠름
	
	내장객체 : new 생성하지 않고 바로 사용가능한 class
			request
			HttpServletRequest
			
		Servlet : java(html)
		JSP : html (java)
		
 --%>
<h3>hello jsp</h3>
<%--
//java 영역
//scriptlet= script + applet
 --%>
 <%
 	String str="hello jsp";
 	System.out.println("hello hyjeo");
 %>
 
 <p>str:<%=str %></p>
 <input type-"text" size="20 value="<%=str %>">
 <br>
 <%
 	out.println("<h3>str: "+str+"</h3>");
 %>
 
 <%
 	for(int i=0;i<5;i++)
 	{
  %>
 		  <p>p tag<%=i%></p>
 <%
 	}
 %>
 <%--script영역 
 <%= %>:값
 <%! %>:선언부( 전역변수,class, function
 <%  %>:코드부
 --%>
<%!
int glnum=0;

%>

<%
glnum++;
out.println(glnum);%>

<p><%=glnum %></p>

<%
int num=0;

%>
<p><%=num %></p>
<%! 

class MyClass{
	private int number;
	public MyClass(int number){
		this.number=number;
	}
	public String toString(){
		return number+"";
	}
}

%>

<%
MyClass mycls=new MyClass(123);
out.println(mycls.toString());

//YouClass ycls=new YouClass("Tom");
//out.println(ycls.toString());

%>
</body>
</html>
