<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARDLIST</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>


<div class="container">
	<h2>${board} List</h2>
	<form  action="./${board}List">
	    <div>
		  <div class="col-sm-1" style="padding-left: 0; padding-right:5px; margin-bottom: 10px; float:left;" >
			  <select class="form-control col-sm-5" id="sel1" name="kind">
			    <option value="title">title</option>
			    <option value="contents">contents</option>
			    <option value="writer">writer</option>
			  </select>
		  </div>
		  
	      <div class="col-sm-2" style="padding-left: 0; padding-right:5px;margin-bottom: 10px; float:left">
				<input type="text" class="form-control" name="search">	
		  </div>	 
	  
	        <button style="float:left"class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>

	    </div>
	 </form>
	 
	<table class="table talbe-hover">
		<tr>
			<td>Num</td>
			<td>Title</td>
			<td>Writer</td>
			<td>Date</td>
			<td>Hit</td>
		</tr>
		
		<c:forEach items="${page.content}" var="vo">
		<tr>
			<td>${vo.num}</td>
			<td>
				<c:catch>	
					<c:forEach begin="1" end="${vo.depth}"> -> </c:forEach>
				</c:catch>
				<a href="./${board}Select?num=${vo.num}"> ${vo.title}</a>
			</td>
			<td>${vo.writer}</td>
			<td>${vo.regDate}</td>
			<td>${vo.hit}</td>
		</tr>
		</c:forEach>	
	</table>
     

    <div>
    		<a href="./${board}List?page=0"> << </a>
 			<c:if test="${page.hasPrevious()}">
	   			<a href="./${board}List?page=${page.number-1}"> ◁ </a>
	   		</c:if>
	    	<c:forEach begin="${page.number}" end="${page.number+4}" var="i">
	    			<c:if test="${i lt page.getTotalPages()}">
	    			<a href="./${board}List?page=${i}">${i+1}</a>
	   			 	</c:if>
			</c:forEach>
	   		<c:if test="${page.hasNext()}">
	   			<a href="./${board}List?page=${page.number+1}"> ▷ </a>
	   		</c:if>
	   		<a href="./${board}List?page=${page.getTotalPages()-1}"> >> </a>
	   		
	   		<hr>
	  	 	<c:if test="${not page.isFirst()}">
				<a href="./${board}List?page=${page.number-1}">[이전페이지]</a>
			</c:if>
			<span>${page.number+1}</span>
			<c:if test="${not page.isLast()}">
				<a href="./${board}List?page=${page.number+1}">[다음페이지]</a>		
			</c:if>
    </div>
	
	<!--    	<c:forEach begin="1" end="${page.totalPages}"  var="i">
     		${i}
    	</c:forEach>  -->
	<!--  <ul class="pagination">
		<c:if test="${pager.curBlock gt 1}">
			<li><a href="./${board}List?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}"> < </a></li>
		</c:if>
		
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<li><a href="./${board}List?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
		</c:forEach>
		
		<c:if test="${pager.curBlock lt pager.totalBlock}">
	 		<li><a href="./${board}List?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"> > </a></li>
		</c:if>
	</ul>-->
	
	<div><a href="./${board}Write" class="btn btn-danger">Write</a></div>
</div>


<script type="text/javascript">
	var result='${result}';
	if(result!=''){
		if(result=='1'){
			alert('${path} 성공');
		}		
	}
</script>

</body>
</html>