<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
	서명 업로드 성공!!<img src="${ pageContext.servletContext.contextPath }/resources/uploadFiles/${savedName}" width=300 height=300> <br> <br>
	<hr color="red">
	등록된 서명의 주인은 ${signDTO.name} <br>
	등록된 서명주인의 생년월일은 ${signDTO.birth} <br>

</body>
</html>