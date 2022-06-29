<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!int num=0; %>
<%num++; %>
<table align="center" border="1">
        
         <tr>    
            <%
                for (int i = 0; i < num; i++) {
                	for (int j = 0; j < num; j++) {
            %>
      
            <td align="center"><%=j%> * <%=i %>= <%=j * i %></td>
            <%
                }
            %>
        </tr>
        <%
            }
        %>
      
    </table>

</body>
</html>