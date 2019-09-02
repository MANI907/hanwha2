<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = 'c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	<!-- 	<script>
			function call(){
				location.href = "empinsert";
			} 
		
		</script> -->
	</head>
	
	<body>
		<h1>직원목록</h1>
	
		<button onclick="location.href = 'empinsert';">직원 추가</button>
		<hr>
	
		<table border=1>
			<tr>
				<th>직원번호</th>
				<th>이름</th>
				<th>성</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>입사일</th>
				<th>직책</th>
				<th>급여</th>
				<th>커미션</th>
				<th>매니저</th>
				<th>부서</th>
				<th></th>
				
			</tr>
			
			<c:forEach var="emp" items ="${emplist }">
			<tr>
				
				<td><a href="empdetail?empid=${emp.employee_id}">${emp.employee_id}</a></td>
				<td>${emp.first_name }</td>
				<td>${emp.last_name }</td>
				<td>${emp.email }</td>
				<td>${emp.phone_number }</td>
				<td>${emp.hire_date }</td>
				<td>${emp.job_id}</td>
				<td>${emp.salary }</td>
				<td>${emp.commission_pct }</td>
				<td>${emp.manager_id }</td>
				<td>${emp.department_id}</td>
			
				<td><a href = "empdelete?empid=${emp.employee_id}" >삭제하기</a></td>
			</tr>
			</c:forEach>
		</table>
		<%-- ${emplist }  --%>
	</body>
	
</html>