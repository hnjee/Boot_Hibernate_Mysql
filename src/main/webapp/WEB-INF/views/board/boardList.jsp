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
	<form action="./${board}List" id="frm">
		<input type="hidden" name="page" id="p">
	    <div>
		  <div class="col-sm-1" style="padding-left: 0; padding-right:5px; margin-bottom: 10px; float:left;" >
			  <select class="form-control col-sm-5" id="sel1" name="kind">
			    <option value="title">title</option>
			    <option value="contents">contents</option>
			    <option value="writer">writer</option>
			  </select>
		  </div>
		  
	      <div class="col-sm-2" style="padding-left: 0; padding-right:5px;margin-bottom: 10px; float:left">
				<input type="text" class="form-control" placeholder="Search" name="search" value="${param.search}">	
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
	
	
<div class="container">
	<ul class="pagination">
		<c:if test="${pager.curBlock>1}">
			<li><a href="#" class="custompager" title="${pager.startNum-1}">이전</a></li>
		</c:if>
		
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="p">
			<li><a href="#" class="custompager" title="${p}">${p}</a></li>
		</c:forEach>
		
		<c:if test="${pager.curBlock<pager.totalBlock}">
			<li><a href="#" class="custompager" title="${pager.lastNum+1}">다음</a></li>
		</c:if>
	</ul>
</div>
	
	<!-- 
    <div>
    		<a href="#" class="customPager" title="0"> << </a>
 			<c:if test="${page.hasPrevious()}">
	   			<a href="#" class="customPager" title="${page.number-1}"> ◁ </a>
	   		</c:if>
	    	<c:forEach begin="${page.number}" end="${page.number+4}" var="i">
	    			<c:if test="${i lt page.getTotalPages()}">
	    			<a href="#" class="customPager" title="${i}">${i+1}</a>
	   			 	</c:if>
			</c:forEach>
	   		<c:if test="${page.hasNext()}">
	   			<a href="#" class="customPager" title="${page.number+1}"> ▷ </a>
	   		</c:if>
	   		<a href="#" class="customPager" title="${page.getTotalPages()-1}"> >> </a>
    </div>  -->
	
	<!-- <c:forEach begin="1" end="${page.totalPages}"  var="i">
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
	$(".custompager").click(function(){
		var page=$(this).attr("title");
		$("#p").val(page);
		$("#frm").submit();
	});

	var kind = '${param.kind}';
	if(kind == ''){
		$("#title").prop("selected", true);
	}else {
		$("#"+kind).prop("selected", true);
	}
	
	
	var result = '${result}';
	if(result != '') {
		if(result == 1) {
			alert("게시글 쓰기 성공");
		} else {
			alert("게시글 쓰기 실패");
		}
	}
</script>

</body>
</html>