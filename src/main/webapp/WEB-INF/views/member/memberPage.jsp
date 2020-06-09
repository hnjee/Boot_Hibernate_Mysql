<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>

<body>
<c:import url="../template/nav.jsp"></c:import>
<div class="container">
		<h1>멤버 정보</h1>  
	    <h3>ID: ${member.id}</h3>
	    <h3>이름: ${member.name}</h3>
	    <h3>나이: ${member.age}</h3>
	    <h3>email: ${member.email}</h3>
	    <h3>핸드폰번호: ${member.phone}</h3>
	    <br>
	   <button class="btn btn-primary" id="up" > Update </button>
	   <button class="btn btn-danger" id="del" > Delete </button>
</div>

<script type="text/javascript">
	
	$("#up").on("click", function() {
		location.href="./memberUpdate";
	});
	
	$("#del").click(function() {
		var result = confirm("정말 탈퇴하시겠습니까?");
		if(result){
			location.href="./memberDelete";	
		}
	});
</script>

</body>
</html>