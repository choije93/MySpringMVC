<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" 
    prefix="c" %>     
<c:set var="path" 
       value="${pageContext.request.contextPath}"
       scope="session" />
<c:import url="/include/header.jsp" /> 

<br>
<section>
<div align="center">
<br><br>
<img src="${path}/psd/files/bellas2.jpg" width=60%  height=50% />

</div>

</section>

<br>
<c:import url="/include/footer.jsp" /> 