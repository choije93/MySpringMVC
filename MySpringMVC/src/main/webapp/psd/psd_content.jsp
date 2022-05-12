<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" 
    prefix="c" %>     
<c:set var="path" 
       value="${pageContext.request.contextPath}"
       scope="session" />
<%@ taglib prefix="fmt" 
     uri="http://java.sun.com/jsp/jstl/fmt"%>       
<c:import url="/include/header1.jsp" /> 



<section>     
<div align="center">
<script>
  function formCk(){
	if (f1.title.value ==""){
		alert("확인")  
		return  false;
	}  
	
	  
  } 
  
  function delCk(pcode){
	  // alert("pcode확인:" + pcode );
	  location.href="${path}/psd_delete.do?pcode="+pcode
  }
</script>

<h2>쇼핑몰 상품 수정</h2>

<form name="f1"  onSubmit="return  formCk()"
      action="${path}/psd_UpdateOK.do"  method="post"
      enctype="multipart/form-data">


<input type=hidden name="pcode" size=20 value="${m.pcode}" />
 
<table border=1>
 <tr><td width=20%>제목</td><td class=td2 width=45%>
    <input type=text name="title" size=20 value="${m.title}" ></td>
    <td rowspan=7 width=35%> <img src="${path}/psd/files/${m.img}" width=170 height=250 /> </td></tr>
 <tr><td>상품명</td>
    <td class=td2><input type=text name="pname" size=20  value="${m.pname}" ></td></tr>
  <tr><td>가격</td>
    <td class=td2><input type=number name="price" size=20  value="${m.price}" > </td></tr>
  <tr><td>수량</td>
    <td class=td2><input type=number name="quantity" size=20  value="${m.quantity}" ></td></tr>
  <tr><td>배송비</td>
    <td class=td2><input type=number name="shipping" size=20  value="${m.shipping}" ></td></tr>
 <tr><td>파일사이즈</td>
    <td class=td2>  ${m.imgsize} </td></tr>
 <tr><td>저장날짜</td>
    <td class=td2>
    
    <fmt:formatDate value="${m.rdate}"
         pattern="yyyy-MM-dd"/>
     
     </td></tr>

  <tr><td>상품이미지</td>
    <td class=td2 colspan=2><input type=file name="imgFile"  ></td></tr>
  
 <tr><td colspan=3 align="center">
  <input type=submit value="상품수정" >
  <input type=button value="상품삭제"  onClick="delCk(${m.pcode})"  ></td>
  </tr>
 </table>
 
</form>


</div>
</section>
<br>

<c:import url="/include/footer.jsp" /> 