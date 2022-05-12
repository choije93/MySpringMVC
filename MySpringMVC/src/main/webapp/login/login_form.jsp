<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" 
    prefix="c" %>     
<c:set var="path" 
       value="${pageContext.request.contextPath}"
       scope="session" />
<c:import url="/include/header1.jsp" /> 
<br>

<section>
<div align="center">
<br><br>
<h2>로그인하기</h2>
<br>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
  jQuery.ajaxSetup({cache:false});
  $(document).ready(function(){
	var  path = "${pageContext.request.contextPath}"  
	$('#idBtn').click(function(){
		
		var query ={
			         id : $('#id').val(),
			         pwd : $('#pwd').val()
		           }
		
		if (f1.id.value==""){
			alert("아이디 입력은 필수 입니다.");
			f1.id.focus();
			return  false;
		}
		if (f1.pwd.value==""){
			alert("암호 입력은 필수 입니다.");
			f1.pwd.focus();
			return  false;
		}
				
		$.ajax({
		  type:'get',
		  url : path + "/login_formOK.do",
		  data : query,
		  success: function(data){
			  if(data == 0 ){
				  alert("로그인 실패");
				  $('#id').val('');
				  $('#pwd').val('');
				  $('#id').focus();
				  
			  }else{
				  alert("로그인 성공");
				  location.href="${path}/index.jsp"
			  }			  
		  }
		})
	})  
	  
  })

</script>



<form name="f1" >
<table border=1 >
 <tr><td >아이디</td><td  class=td2 ><input type=text name="id" id="id" size=15  ></td></tr>
 <tr><td >암호</td><td  class=td2 ><input type=password name="pwd" id="pwd" size=15 ></td></tr>
  <tr><td colspan=2 align="center">
  <input type=button  id="idBtn"  value="로그인" >
</td>
  </tr>
</table>
 </form>


</div>
</section>

<br>
<c:import url="/include/footer.jsp" /> 