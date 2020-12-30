<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="language"/>

<html lang="${sessionScope.lang}">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/pageform.css">
<head>
    <title><fmt:message key="user.orders.label.orders"/></title>
</head>
<style>
    .page-form form button {
        background-color: rgb(110, 176, 170) !important;
    }

    .page-form form button:hover {
        background-color: rgb(83, 134, 130) !important;
    }


</style>
<body>
<div class="page-form">
    <form class="page-form" action="${pageContext.request.contextPath}/orders" method="get">
        <h2><fmt:message key="user.orders.label.orders"/></h2>
        <div class=" table">
            <table class="table table-striped table-bordered table-sm">
                <tr>
                    <th><fmt:message key="user.orders.label.price"/></th>
                    <th><fmt:message key="user.orders.label.status"/></th>
                    <th><fmt:message key="user.orders.label.date_of_creation"/></th>
                </tr>
                <c:set var="orders" value="${requestScope.get('orders')}"/>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td>${order.getPrice()}</td>
                        <td>${order.getStatus()}</td>
                        <td>${order.getCreatedAt()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <c:set var="href" value="/orders?" scope="request"/>
        <jsp:include page="../pagination.jsp"/>
    </form>

    <div class="text-center"><fmt:message key="label.return_to"/>  <a href="${pageContext.request.contextPath}/catalogue">
        <fmt:message key="label.main_page"/></a>?</div>
</div>
</body>
</html>
