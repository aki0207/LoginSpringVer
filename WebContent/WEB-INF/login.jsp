<%@page import="spring.test.controller.LoginControler"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>ログイン</title>
</head>
<body>
	<spring:url value="/login" var="url" htmlEscape="true" />
	<form:form action="${url}" method="POST" modelAttribute="UM">

		ID：<form:input path="id" />
		<form:input path="name" disabled="true" />
		<BR />
		<input type="submit" value="ログイン" />
		<BR />
	</form:form>
	${msg}
</body>
</html>
