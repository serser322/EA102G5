<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.emp.model.*"%>


<%
	EmpVO empVO = (EmpVO) request.getAttribute("empVO");
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show One</title>
</head>
<body>
	


<table>
	<tr>
		<th>員工編號</th>
		<th>員工姓名</th>
		<th>員工電話</th>
		<th>員工信箱</th>
		
	</tr>
	<tr>
		<td><%=empVO.getEmpNo()%></td>
		<td><%=empVO.getEmpName()%></td>
		<td><%=empVO.getEmpPhone()%></td>
		<td><%=empVO.getEmpEmail()%></td>
		
	</tr>
</table>


</body>
</html>