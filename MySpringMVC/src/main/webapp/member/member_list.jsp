<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" 
    prefix="c" %>     
<c:set var="path" 
       value="${pageContext.request.contextPath}"
       scope="session" />
 <c:import url="/include/header1.jsp" />     


<script>
  function menroll(){
	  location.href="${path}/member_form.do"
  }
</script>


<section>     
<div align="center">


<h2>회원 목록보기<input type=button value="회원등록"  onClick="menroll()"></h2>

<table border=1>
 <tr><td>아이디</td><td>이름</td><td>전화번호</td><td>주소</td></tr>
 <c:forEach var="m"  items="${li}">

 <tr>
 <td>${m.id}</td>
 <td> ${m.name }</td>
  <td>${m.tel }</td>
 <td>${m.roadAddress } </td>

 </tr>
 
</c:forEach>


 </table>


<form action = "${path}/member_list.do">
   <select name=ch1>
     <option value="name"> 이 름 </option>
     <option value="roadAddress"> 주 소 </option>
   </select>
   <input  type=text  name=ch2>
   <input  type=submit  value="검색하기" >
 </form>
 

</div>
</section>
<br>
<c:import url="/include/footer.jsp" /> 


