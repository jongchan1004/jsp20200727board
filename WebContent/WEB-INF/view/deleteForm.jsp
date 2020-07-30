<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<title>게시글 삭제</title>
</head>
<body>

<%--
<form action="delete.do" method="post"> 
<p>
	번호: ${delReq.articleNumber }
	<input type="number" name="no" readonly="readonly" value="${delReq.articleNumber }" hidden />
</p>
<p>
	제목: ${delReq.title }
	<input type="text" name="title" readonly="readonly" value="${delReq.title }" hidden/>
</p>
<p>
	내용: <br />
	<span style="white-space: pre-wrap;"><c:out value="${delReq.content }" />
	<textarea name="content" cols="30" rows="5" readonly="readonly" hidden>${delReq.content }</textarea>
</p>
<input type="submit" value="글 삭제"/>
</form>
--%>

<form action="delete.do" method="post">
	<div class="container pt-3">
		<h4>${delReq.articleNumber } 번  ${delReq.title }을(를) 삭제하시겠습니까?</h4> 
		<input type="number" name="no" readonly="readonly" value="${delReq.articleNumber }" hidden />
		<br />
		<input class="btn btn-primary" type="submit" value="  예    "/>
		<a class="btn btn-primary" href="${ctxPath }/article/list.do">아니오</a>
	</div>
</form>
</body>
</html>