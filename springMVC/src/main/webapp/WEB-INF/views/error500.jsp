<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>내부오류--500</h1>
	<h2>${exception }</h2>
	<h3>주소를 다시 확인하세요.</h3>
	<h4>${company}-----${manager }-----${phone }</h4>
	<h5>${errormessage }</h5>
	
</body>
</html>