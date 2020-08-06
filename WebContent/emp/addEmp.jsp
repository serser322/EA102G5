<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ page import="com.emp.model.*" %>

<%
	EmpVO empVO = (EmpVO) request.getAttribute("empVO");
%>
    
<html>
<head>
<meta charset="UTF-8">
<title>Add Emp</title>
</head>
<body>

<c:if test="${not empty errMessages}">
	<font style="color:red">請修正錯誤:</font>
		<c:forEach var="err" items="${errMessages}">
			<font style="color:red">${err}</font>
		</c:forEach>
</c:if>

<form method="post" action="emp.do">

	<table>
		<tr>
			<td>員工姓名</td>
			<td><input type="text" name="empName" value="<%= (empVO==null)? "XXX" : empVO.getEmpName()%>"/></td>		
		</tr>
		<tr>
			<td>員工電話</td>
			<td><input type="text" name="empPhone" value="<%= (empVO==null)? "XXX" :empVO.getEmpPhone()%>"/></td>		
		</tr>
		<tr>
			<td>員工email</td>
			<td><input type="text" name="empEmail" value="<%= (empVO==null)? "XXX" :empVO.getEmpEmail()%>"/></td>		
		</tr>
	</table>

	<br>
    <input type="hidden" name="action" value="add">
	<input type="submit" value="確認">

</form>

</body>
</html>