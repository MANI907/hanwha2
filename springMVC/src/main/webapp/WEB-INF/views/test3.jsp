<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
	<h1>회사명: ${company }</h1>
	<h1>부서: ${dept }</h1>
	<h1>이름: ${myname }</h1>
	
	<hr>
	paramtest
	<form action="paramtest">
		id : <input name="userid" type="number"><br>
		name : <input name="username" type="text"><br>
		<input type="submit" value="서버전송"><br>
	</form>
	
	<hr>
	paramtest2
	<form action="paramtest2">
		id : <input name="userid" type="number"><br>
		name : <input name="username" type="text"><br>
		<input type="submit" value="서버전송"><br>
	</form>
	
</body>
</html>