<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" 
    prefix="c" %>     
<c:set var="path" 
       value="${pageContext.request.contextPath}"
       scope="session" />



<html>
<head>
<meta charset="UTF-8">
<title>Bellas♥</title>
<link rel="stylesheet" href="${path}/include/css/header1.css">
<style type="text/css">

</style>
</head>
<header>
<h2> <a href="${path}/index.jsp"><img src="${path}/psd/files/bellas.jpg" width=150  height=80  /></a> </h2>
</header>


<body>


<ul>
  <c:if test="${session == 'admin'}">
    <li><a href="${path}/psd_list.do">쇼핑몰</a></li>
    <li><a href="${path}/member_list.do">회원목록</a></li>
    <li><a href="${path}/index.jsp">처음으로</a></li>
  </c:if>
  
  <c:if test="${session == null}">
    <li style="float:right"><a href="${path}/login/login_form.jsp">로그인</a></li>
    <li style="float:right"><a href=${path}/member_form.do>회원가입</a></li>  
  </c:if>
  <c:if test="${session != null}">
     <li style="float:right"><a href="${path}/logout.do">${session} 로그아웃</a></li>
         
  </c:if>
</ul>

</body>








<!--  
<nav>
<c:if test="${session == 'admin'}">
&emsp;<a href="${path}/psd_list.do">쇼핑몰</a>
&emsp;<a href="${path}/member_list.do">회원목록</a>
&emsp;<a href="${path}/index.jsp">처음으로</a>
</c:if>
<c:if test="${session == null}">
&emsp;<a href="${path}/login/login_form.jsp">로그인</a>
&emsp;<a href=${path}/member_form.do>회원가입</a>
</c:if>
<c:if test="${session != null}">
&emsp;<a href="${path}/logout.do">${session} 로그아웃</a>
</c:if>
&emsp;
</nav>
-->



