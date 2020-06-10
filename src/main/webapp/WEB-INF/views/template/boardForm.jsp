<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../template/summernote.jsp"></c:import>

<form action="${board}${path}" method="post" enctype="multipart/form-data">
	  <input type="hidden" name="num" id="num" value="${vo.num}">
	  
	  <div class="form-group">	  	
	    <label for="title">Title:</label>
	    <input type="text" class="form-control" value="${vo.title}" id="title" name="title">
	  </div>
	  
	  <div class="form-group">
	    <label for="writer">Writer:</label>
	    <input type="text" class="form-control" id="writer" value="${vo.writer}" name="writer">
	  </div>
	  
	  <div class="form-group">
	    <label for="contents">Contents:</label>
	     <textarea class="form-control" id="summernote" name="contents">${vo.contents}</textarea>
	  </div>
		
	  <input type="button" class="btn btn-info" id="add" value="FileAdd">
	  <div class="form-group" id="f"></div>
		
	  <button type="submit" class="btn btn-default">Submit</button>
</form>
