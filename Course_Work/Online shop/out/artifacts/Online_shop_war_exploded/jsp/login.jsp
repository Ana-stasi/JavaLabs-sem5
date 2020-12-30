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
<link rel="stylesheet" href="/css/pageform.css">
<style>
    .page-form form button {
        background-color: rgb(110, 176, 170) !important;
    }

    .page-form form button:hover {
        background-color: rgb(83, 134, 130) !important;
    }

    .page-form a {
        color: #386d77 !important;
        text-decoration: underline;
    !important;
    }

    .page-form a:hover {
        text-decoration: underline;
    }

</style>
<head>
    <title>$Login$</title>
</head>

<body>
<div class="page-form">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <h2><fmt:message key="login.label.login"/></h2>
        <div class="form-group"><input type="text" class="form-control" name="user_name" placeholder="<fmt:message key="login.label.username"/>"
                                       required="required"></div>

        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="<fmt:message key="login.label.password"/>" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block"><fmt:message key="login.button.login"/></button>
        </div>
        <div class="text-center"><fmt:message key="login.label.account"/> <a href="${pageContext.request.contextPath}/register"><fmt:message key="login.href.register"/></a>
        </div>
    </form>
</div>
</body>
</html>
