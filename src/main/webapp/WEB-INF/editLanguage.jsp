<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Language</title>
</head>
<body>
	<form:form method="POST" action="/edit/${id}" modelAttribute="language">
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label>
	    <form:label path="creator">Creator
	    <form:errors path="creator"/>
	    <form:textarea path="creator"/></form:label>
	    <form:label path="currentVersion">Version
	    <form:errors path="currentVersion"/>
	    <form:input path="currentVersion"/></form:label>
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>