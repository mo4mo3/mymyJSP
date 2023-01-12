<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.lst_typeP{overflow:hidden;width:80%,padding:0 10px margin:0 auto}
.lst_type li{overflow:hidden;clear:both;margin:10px 0 0; color:2#2d2c2d;}
font-family:'돋움',Dotum;font-size:12px;line-height:100px;
list-style
</style>
<meta charset="UTF-8">
<title>이미지 리스트창</title>
</head>
<body>
<ul class ="lst_type">
<li>
<span style='margin-left:50px'>이미지</span>
<span> 이미지 이름</span>
<span>선택하기</span>
</li>
<%
for(int i=0; i<10;i++){
%>
<li>
<a href='#' style='margin-left:50px></a>
</ul>
</body>
</html>