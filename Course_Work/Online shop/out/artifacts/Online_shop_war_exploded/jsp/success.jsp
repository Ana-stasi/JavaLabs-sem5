<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="language"/>

<html lang="${sessionScope.lang}">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/formpage.css">
<head>
</head>
<body>
<div class="page-form">
    <div class="alert alert-success">
        <strong><fmt:message key="success.label.success"/></strong>${requestScope.get('success')}
        <a href="${pageContext.request.contextPath}${requestScope.get('pagelink')}" class="alert-link"> <fmt:message key="success.label.continue"/></a>
        <button onclick="location.href='${requestScope.get('pagelink')}'" type="button" class="close"
                data-dismiss="alert">
            &times
        </button>
    </div>
</div>
</body>
</html>
