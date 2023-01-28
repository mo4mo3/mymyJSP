<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
pageContext.setAttribute("result", "hello");
%>
<body>
<%= request.getAttribute("result") %>입니다.
${requestScope.result }<br>
${names[1]}<br>
${notice.title}<br>
${result}<br>
${empty param.n? '값이 비어 있습니다.':param.n}<br>
${header.accept}<br>
</body>
</html>