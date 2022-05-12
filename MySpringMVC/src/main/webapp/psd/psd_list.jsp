<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" 
    prefix="c" %>     
<c:set var="path" 
       value="${pageContext.request.contextPath}"
       scope="session" />
<c:import url="/include/header1.jsp" /> 


<style>
 
</style>


<script>
  function srecord(){
	  location.href="${path}/psd_form.do"
  }
</script>


<section>     
<div align="center">


<h2 > 쇼핑몰 목록&nbsp;&nbsp;<input type=button value="상품등록"  onClick="srecord()"></h2>
 전체레코드:${B1}   , 현재페이지 ${nowPage} /${totalPage} 전체페이지

<table border=1>
<tr><td>상품코드</td><td>제목</td><td>상품이름</td><td>상품가격</td><td>배송비</td><td>갯수</td><td>이미지</td></tr>
 <c:forEach var="m"  items="${li}">
 <tr>
 <td> <a href=psd_content.do?pcode=${m.pcode} > ${m.pcode} </a></td>
 <td>${m.title }</td>
 <td>${m.pname }</td>
 <td>${m.price }</td>
 <td>${m.shipping }</td>
 <td>${m.quantity }</td>
 <td><img src="${path}/psd/files/${m.img}" width=35  height=35 /></td>
 
 </tr>
</c:forEach>
</table>


 &emsp;<a href="${path}/psd_list.do?startIdx=1&ch1=${ch1}&ch2=${ch2}">처음</a>
&emsp;
<c:if test="${startIdx > 1 }">
  <a href="${path}/psd_list.do?startIdx=${startIdx-4}&ch1=${ch1}&ch2=${ch2}"> 이 전 </a>
</c:if>
<c:if test="${startIdx == 1 }">
  이 전
</c:if>
&emsp;
<c:if test="${ nowPage < totalPage  }">
<a href="${path}/psd_list.do?startIdx=${startIdx+4}&ch1=${ch1}&ch2=${ch2}"> 다 음 </a>
</c:if>
<c:if test="${nowPage == totalPage  }">
다 음 
</c:if>
&emsp;<a href="${path}/psd_list.do?startIdx=${endPage}&ch1=${ch1}&ch2=${ch2}">마지막</a>
  



 <form action = "${path}/psd_list.do" >
   <select name=ch1>
     <option value="title"> 제 목 </option>
     <option value="pname"> 상품이름 </option>
   </select>
   <input  type=text  name=ch2>
   <input  type=submit  value="검색하기" >
 </form>



</div>
<br>
</section>
<br>
<c:import url="/include/footer.jsp" /> 
 