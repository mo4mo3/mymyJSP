<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 request.setCharacterEncoding("utf-8")
 int score=Integer.parseInt(request.getParameter("score"));
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점수 출력창</title>
</head>
<body>
<h1>시험점수 <%=score %></h1>
</body>
</html>