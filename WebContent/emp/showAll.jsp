
<%@page import="java.util.*"%>
<%@page import="com.emp.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
	EmpService empSvc = new EmpService();
	List<EmpVO> empList = empSvc.getAll();
	pageContext.setAttribute("empList",empList);
	
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show A ll Emp</title>
</head>
<body>
<table>
	<tr>
		<th>員工編號</th>
		<th>員工姓名</th>
		<th>員工電話</th>
		<th>員工信箱</th>
	</tr>


	<c:forEach var="list" items="${empList}">
		<tr>
			<td>${list.empNo}</td>
			<td>${list.empName}</td>
			<td>${list.empPhone}</td>
			<td>${list.empEmail}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>