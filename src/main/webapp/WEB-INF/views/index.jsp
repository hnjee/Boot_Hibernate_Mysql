<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>
<c:import url="./template/boot.jsp"></c:import> 
<link rel="stylesheet" type="text/css" href="./css/test.css">

</head>
<body>
	<c:import url="./template/nav.jsp"></c:import> 
	
	<div class="container">
		<h1>INDEX ! </h1>
		<img src="${pageContext.request.contextPath}/images/20190705_300c8f262e69893db9d3c97fad37dc91.jpg"> 
	</div>
	<script type="text/javascript">
		var result='${result}';
		if(result!=''){
			alert('${result}');	
		}
	</script>
</body>
</html>