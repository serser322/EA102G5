<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.emp.model.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMP_test</title>
</head>


<body>

<c:if test="${not empty errMessages}">
	<font style="color:red">�Эץ����~:</font>
		<c:forEach var="err" items="${errMessages}">
			<font style="color:red">${err}</font>
		</c:forEach>	
</c:if>

	<p><a href='showAll.jsp'>��ܥ����޲z��</a></p>
	

	<form method="post" action="emp.do">
		<h4>��J���u�s��:</h4>
 		<input type="text" name="empNo">
 		
		<input type="hidden" name="action" value="getOne">
		<input type="submit" value="�T�{">

	</form>

<!-- �s�W�޲z�� -->
<ul>
  <li><a href='addEmp.jsp'>�s�W�޲z��</a> </li>
</ul>

</body>
</html>