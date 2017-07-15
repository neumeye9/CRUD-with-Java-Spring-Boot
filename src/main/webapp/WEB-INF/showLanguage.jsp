<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Language Details</title>
</head>
<body>
	<p><c:out value="${language.name}"/></p>
	<p><c:out value="${language.creator}"/></p>
	<p><c:out value="${language.currentVersion}"/></p>
</body>
<br>
<a href="/edit/${id}">Edit</a>
<br>
<a href="/delete/${id}">Delete</a>
<br>
<a href="/">Dashboard</a>
</html>