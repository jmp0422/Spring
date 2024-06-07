<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int result = (int)request.getAttribute("result");
	if(result == 1){
%>
- ${weatherDTO.id}<br>,
 ${weatherDTO.lat}<br>,
  ${weatherDTO.lon}<br>,
  ${weatherDTO.weather}<br>,
  ${weatherDTO.wind}<br>,
  ${weatherDTO.feels}<br>,
  ${weatherDTO.cloud}
  
<%		
	}
%>
<!-- 화면을 html 로 넣는 방법, 이고  json  으로 받아와서 바로 뿌려 줄수도있다.  -->