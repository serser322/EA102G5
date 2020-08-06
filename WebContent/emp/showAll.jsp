
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
		<th>���u�s��</th>
		<th>���u�m�W</th>
		<th>���u�q��</th>
		<th>���u�H�c</th>
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