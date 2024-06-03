<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/out.css"> <!--확인 css파일 넣기 -->

<title>Insert title here</title>
</head>
<body>
	welcome!! spring world!!!<a href="hi">hi call</a>
	
	<hr color="red">
	<img src="resources/img/ok.JPG">
	<br><br>
	
	
<!-- <a href = "WEB-INF/views/member.jsp"> 
			<button id="b1">첫페이지로</button>
	</a>  확인 web-inf는 보안이라 갈수없음 , 컨트롤러로 다른 페이지로 돌려야함-->
	
	 <jsp:forward page="WEB-INF/views/member.jsp"/>
	
</body>
</html>