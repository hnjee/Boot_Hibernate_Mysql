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
<style type="text/css">
	.r{
		color: red;
	}
</style>
</head>

<body>
<c:import url="../template/nav.jsp"></c:import>
<div class="container">
  <h1>Member Join JPA</h1>
  <form:form modelAttribute="memberVO" action="./memberJoin" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="id">아이디:</label>
      <form:input path="id" type="text" class="form-control" id="id" placeholder="Enter id" name="id"/>
   	  <form:errors path="id" cssClass="r"></form:errors>
    </div>
    <div class="form-group">
      <label for="pw">비밀번호: </label>
      <form:input path="pw" type="password" class="form-control" id="pw" placeholder="Enter pw" name="pw"/>
      <form:errors path="pw" cssClass="r"></form:errors>
    </div>   
     <div class="form-group">
      <label for="pwChk">비밀번호 확인: </label>
      <form:input path="pwChk" type="password" class="form-control" id="pwChk" placeholder="Enter pw" name="pwChk"/>
      <form:errors path="pwChk" cssClass="r"></form:errors>
    </div> 
    <div class="form-group">
      <label for="name">이름:</label>
      <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter name" name="name"/>
   	  <form:errors path="name" cssClass="r"></form:errors>
    </div>
    <div class="form-group">
      <label for="age">나이: </label>
      <form:input path="age" type="text" class="form-control" id="age" placeholder="Enter age" name="age"/>
      <form:errors path="age" cssClass="r"></form:errors>
    </div> 
    <div class="form-group">
      <label for="email">이메일: </label>
      <form:input path="email" type="text" class="form-control" id="email" placeholder="Enter email" name="email"/>
      <form:errors path="email" cssClass="r"></form:errors>
    </div>   
    <div class="form-group">
      <label for="phone">핸드폰번호: </label>
      <form:input path="phone" type="text" class="form-control" id="phone" placeholder="Enter phone" name="phone"/>
      <form:errors path="phone" cssClass="r"></form:errors>
    </div>   
    
    <div class="form-group">
    	 <label for="avatar">프로필사진: </label>
	 	 <input type="file" class="form-control" id="pic" name="avatar">
	</div>	
    ㄴ
    
	<button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>

</body>
</html>