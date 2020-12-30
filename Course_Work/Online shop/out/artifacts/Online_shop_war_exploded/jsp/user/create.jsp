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
        color: #65c6d9 !important;
        text-decoration: underline;
    !important;
    }

    .page-form a:hover {
        text-decoration: none;
    }

    .page-form h2:before, .page-form h2:after {
        width: auto !important;
    }


</style>
<head>
    <title><fmt:message key="user.create_order.label.order_product"/></title>
</head>
<body>
<div class="page-form">
    <form action="${pageContext.request.contextPath}/create" method="post">
        <h2><fmt:message key="user.create_order.label.order_product"/></h2>
        <p class="hint-text"><fmt:message key="user.label.dont_remember"/>
            <a href="${pageContext.request.contextPath}/catalogue"><fmt:message key="label.catalogue"/></a>
        </p>
        <div class="form-group">
            <input type="number" class="form-control" name="product_id" placeholder="<fmt:message key="label.product_number"/>" required="required">
        </div>
        <div class="form-group">
            <input type="number" class="form-control" name="amount" placeholder="<fmt:message key="user.create_order.label.amount"/>" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block"><fmt:message key="user.create_order.label.order"/></button>
        </div>
    </form>
</div>
</body>
</html>
