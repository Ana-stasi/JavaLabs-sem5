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
    <title><fmt:message key="label.block_user"/></title>
</head>
<style>
    .page-form form button{
        background-color: rgb(110, 176, 170) !important;
    }
    .page-form form button:hover{
        background-color: rgb(83, 134, 130) !important;
    }
    .page-form h2:before, .page-form h2:after {
        width: 10% !important;
    }
    .page-form.row{
        margin-top: -30px;
        margin-bottom: -20px;
    }
</style>
<body>
<div class="page-form">
<form class="page-form" action="${pageContext.request.contextPath}/user" method="get">
    <h2><fmt:message key="label.block_user"/></h2>
    <div class=" table">
        <table class="table table-striped table-bordered table-sm">
            <tr>
                <th><fmt:message key="login.label.username"/></th>
                <th><fmt:message key="register.label.email"/></th>
                <th><fmt:message key="user.orders.label.status"/></th>
            </tr>
            <c:set var="users" value="${requestScope.get('users')}"/>
            <c:forEach var="user" items="${users}" >
                <tr>
                    <td>${user.getUsername()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getEnable()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <c:set var="href" value="/user?" scope="request"/>
    <jsp:include page="../pagination.jsp"/>
</form>
    <form class="page-form" action="${pageContext.request.contextPath}/user" method="post">

        <div class="page-form row">
            <div>
                <input type="text" class="form-control" name="username" placeholder="<fmt:message key="login.label.username"/>" required="required">
            </div>
        <div >
            <select class="btn btn-info dropdown-toggle" name="status" id="status">
                <c:choose>
                    <c:when test="${param.status=='block'}">
                        <option value ="none"><fmt:message key="user.orders.label.status"/></option>
                        <option value ="false"selected><fmt:message key="users.label.status_block"/></option>
                        <option value="true">unblock</option>
                    </c:when>
                    <c:when test="${param.status=='unblock'}">
                        <option value ="none"><fmt:message key="user.orders.label.status"/></option>
                        <option value ="false"><fmt:message key="users.label.status_block"/></option>
                        <option value="true" selected><fmt:message key="users.label.status_unblock"/></option>
                    </c:when>
                    <c:otherwise>
                        <option value ="none" selected><fmt:message key="user.orders.label.status"/></option>
                        <option value ="false"><fmt:message key="users.label.status_block"/></option>
                        <option value="true"><fmt:message key="users.label.status_unblock"/></option>
                    </c:otherwise>
                </c:choose>
            </select>
        </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block"><fmt:message key="add.label.save"/></button>
        </div>
    </form>
    <div class="text-center"><fmt:message key="label.return_to"/> <a href="${pageContext.request.contextPath}/catalogue"> <fmt:message key="label.main_page"/></a>?</div>
</div>
</body>
</html>
