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
    .page-form h2:before, .page-form h2:after {
        width: 20% !important;
    }
</style>
<head>
    <title><fmt:message key="register.label.register"/></title>
</head>
<body>
<div class="page-form">
    <form action="${pageContext.request.contextPath}/register" method="post">
        <h2><fmt:message key="register.label.register"/></h2>
        <p class="hint-text"><fmt:message key="register.label.create_account"/></p>
        <div class="form-group">
            <input type="text" class="form-control" name="user_name" placeholder="<fmt:message key="register.label.username"/>" required="required"
                   autocomplete="false">
        </div>
        <div class="form-group">
            <input type="email" class="form-control" name="email" placeholder="<fmt:message key="register.label.email"/>" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="<fmt:message key="register.label.password"/>" required="required"
                   aria-autocomplete="list">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="confirm_password" placeholder="<fmt:message key="register.label.confirm_password"/>"
                   required="required">
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block"><fmt:message key="register.button.register_now"/></button>
        </div>
    </form>
    <div class="text-center"><fmt:message key="register.label.have_account"/> <a href="${pageContext.request.contextPath}/login"><fmt:message key="register.href.sign_in"/></a>
    </div>
</div>
</body>
</html>
