<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.r{
		color: red;
	}
</style>
</head>
<body>


<form:form modelAttribute="boardVO" action="${board}${path}" method="post" enctype="multipart/form-data">
	  <form:input type="hidden" path="num" name="num" id="num" />
	  
	  <div class="form-group">	  	
	    <label for="title">Title:</label>
	    <form:input type="text" path="title" class="form-control"  id="title" name="title"/>
	    <form:errors path="title" cssClass="r"></form:errors>
	  </div>
	  
	  <div class="form-group">
	    <label for="writer">Writer:</label>
	    <form:input type="text" path="writer" class="form-control" id="writer" name="writer"  readonly="true"/>
	  </div>
	  
	  <div class="form-group">
	    <label for="contents">Contents:</label>
	     <textarea class="form-control" id="summernote" name="contents">${vo.contents}</textarea>
	  </div>
		
	  <input type="button" class="btn btn-info" id="add" value="FileAdd">
	  <div class="form-group" id="f"></div>
		
	  <button type="submit" class="btn btn-default">Submit</button>
</form:form>

<script type="text/javascript">
	$(document).ready(function() {
	  $('#summernote').summernote();
	});
</script>

</body>
</html>