<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#99CCFF">
	<jsp:useBean id="sum" class="com.test.bean.SumBean" />
	<jsp:setProperty name="sum" property="firstNumber" param="firstNumber" />
	<jsp:setProperty name="sum" property="secondNumber" param="secondNumber" />
	<jsp:setProperty name="sum" property="result"
		param="result" />
	<div align="center">
		<h2>Here are the values set to the bean using the attribute
			'param'</h2>
		<h2>Entered First Number::::<jsp:getProperty name="sum" property="firstNumber" /></h2><br>
		<h2>Entered Second Number::::<jsp:getProperty name="sum" property="secondNumber" /></h2><br>
		<h2>And the Sum is ::::<jsp:getProperty name="sum" property="result" /></h2>
	</div>
</body>
</html>