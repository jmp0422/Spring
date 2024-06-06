<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
서명등록 페이지입니다.<br>
<hr>
<h3>서명 등록하기</h3>
<form action="${ pageContext.servletContext.contextPath }/sign/insert" method="post" encType="multipart/form-data">
	name : <input name="name"> <br>
	birth : <input name="birth"> <br>
	img : <input type="file" name="image"><br>
	<button  class="btn btn-danger">서버로 전송</button>
</form>
<hr> 

<h3>서명 검색하기</h3>
<form action="${ pageContext.servletContext.contextPath }/sign/one">
	name : <input name="name"> <br>
	birth : <input name="birth"> <br>
	<button class="btn btn-danger">북마크 검색</button>
</form>
<hr>

<h3>등록된 서명 전체 검색하기</h3>
<a href="${ pageContext.servletContext.contextPath }/sign/list">전체 검색</a>
<hr>

<h3>등록된 서명 삭제하기</h3>
<form action="${ pageContext.servletContext.contextPath }/sign/delete">
name : <input name="name"> <br>
birth : <input name="birth"> <br>
<button  class="btn btn-danger">서버로 전송</button>
</form>

<hr> 
</body>
</html>