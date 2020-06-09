<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
  <h1>Member Information 수정</h1>
  <form:form action="./memberUpdate" method="post" modelAttribute="memberVO">
    <div class="form-group">
      <label for="id">아이디:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id" value="${member.id}" readonly>
    </div>

	<div class="form-group">
	 <label for="pw">비밀번호: </label>
      <form:input path="pw" type="password" class="form-control" id="pw" placeholder="Enter pw" name="pw" value="${member.pw}"/>
 	   <form:errors path="pw" cssClass="r"></form:errors>
    </div> 
    
	<div class="form-group">
      <label for="pw">비밀번호 확인: </label>
      <form:input path="pwChk" type="password" class="form-control" id="pwChk" placeholder="Enter pwChk" name="pwChk"/>
    	<form:errors path="pw" cssClass="r"></form:errors>
    </div>       

    <div class="form-group">
      <label for="name">이름: </label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="${member.name}">
    </div>  
      
    <div class="form-group">
      <label for="age">나이: </label>
      <input type="text" class="form-control" id="age" placeholder="Enter age" name="age" value="${member.age}">
    </div> 
    
     <div class="form-group">
      <label for="phone">핸드폰번호: </label>
      <input type="text" class="form-control" id="phone" placeholder="Enter phone number" name="phone" value="${member.phone}">
    </div> 
    <div class="form-group">
      <label for="email">E-mail: </label>
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" value="${member.email}">
    </div>
    <button class="btn btn-primary" id="up">Update</button>
  </form:form> 
</div>

</body>
</html>