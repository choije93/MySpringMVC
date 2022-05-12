<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" 
    prefix="c" %>     
<c:set var="path" 
       value="${pageContext.request.contextPath}"
       scope="session" />
<c:import url="/include/header1.jsp" /> 



<section>     
<div align="center">

<h2>쇼핑몰 상품 등록</h2>
<form name="f1"  onSubmit="return  formCk()"
      action="${path}/psd_formOK.do"  method="post"
      enctype="multipart/form-data">


<table border=1>
 <tr><td>제목</td><td class=td2>
    <input type=text name="title" size=20 ></td></tr>
 <tr><td>상품명</td>
    <td class=td2><input type=text name="pname" size=20 ></td></tr>
  <tr><td>가격</td>
    <td class=td2><input type=number name="price" size=20 ></td></tr>
  <tr><td>수량</td>
    <td class=td2><input type=number name="quantity" size=20 ></td></tr>
  <tr><td>배송비</td>
    <td class=td2><input type=number name="shipping" size=20 ></td></tr>
  <tr><td>상품이미지</td>
    <td class=td2><input type=file name="imgFile"  ></td></tr>
  
 <tr><td colspan=2 align="center">
  <input type=submit value="상품등록" >
  <input type=reset value="다시작성" ></td>
  </tr>
 </table>
 
</form>

</div>
</section>

<br>
<c:import url="/include/footer.jsp" /> 
