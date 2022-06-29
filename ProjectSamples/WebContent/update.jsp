<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int seq = Integer.parseInt(request.getParameter("seq"));    
    
BbsDao dao = BbsDao.getInstance();
BbsDto dto = dao.getBbs(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>글 수정하기</h2>
   <div align="center">
   <form action="updateAf.jsp" method="post">
     <input type="hidden" name="seq"  value=<%=seq %>>
      <table border="1">
         <colgroup>
            <col style="width: 200px">
            <col style="width: 400px">
         </colgroup>

         <tr>
            <th>작성자</th>
            <td><%=dto.getId()%></td>
         </tr>
         <tr>
            <th>작성일</th>
            <td><%=dto.getWdate()%></td>
         </tr>
         <tr>
            <th>조회수</th>
            <td><%=dto.getReadcount()%></td>
         </tr>
         <tr>
            <th>제목</th>
            <td><input type="text" value="<%=dto.getTitle() %>" name="title" ></td>
            <!-- input으로 확인하는 경우가 많음 -->
         </tr>
         <tr>
            <th>정보</th>
            <td><%=dto.getRef()%> - <%=dto.getStep()%> - <%=dto.getDepth()%></td>
         </tr>
         <tr>
            <th>내용</th>
            <td><textarea row="15" cols="90" name="content"><%=dto.getContent()%></textarea>
            </td>
         </tr>
		<tr>
		 <input type="submit" value="수정완료">
      <button type="button" onclick="bbslist()">취소</button>
		</tr>
      </table>
     
      </form>
     
 
</body>
</html>