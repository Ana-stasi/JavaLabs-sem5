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
    <title><fmt:message key="label.order_status"/></title>
</head>
<style>
    .page-form form button{
        background-color: rgb(110, 176, 170) !important;
    }
    .page-form form button:hover{
        background-color: rgb(83, 134, 130) !important;
    }
    .page-form h2:before, .page-form h2:after {
        width: 20% !important;
    }
    .page-form.row{
        margin-top: -30px;
        margin-bottom: -20px;
    }

</style>
<body>
<div class="page-form">
    <form class="page-form" action="${pageContext.request.contextPath}/order_status" method="get">
        <h2><fmt:message key="label.order_status"/></h2>
        <div class=" table">
            <table class="table table-striped table-bordered table-sm">
                <tr>
                    <th>№</th>
                    <th><fmt:message key="catalogue.label.price"/></th>
                    <th><fmt:message key="user.orders.label.status"/></th>
                    <th><fmt:message key="user.orders.label.date_of_creation"/></th>
                </tr>
                <c:set var="orders" value="${requestScope.get('orders')}"/>
                <c:forEach var="order" items="${orders}" >
                    <tr>
                        <td>${order.getNumber()}</td>
                        <td>${order.getPrice()}</td>
                        <td>${order.getStatus()}</td>
                        <td>${order.getCreatedAt()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <c:set var="href" value="/order_status?" scope="request"/>
        <jsp:include page="../pagination.jsp"/>
    </form>
    <form class="page-form" action="${pageContext.request.contextPath}/order_status" method="post">

        <div class="page-form row">
            <div>
                <input type="number" class="form-control" name="order_number" placeholder="<fmt:message key="label.order_number"/>" required="required">
            </div>
            <div >
                <select class="btn btn-info dropdown-toggle" name="status" id="status">
                    <c:choose>
                        <c:when test="${param.status=='paid'}">
                            <option value ="registered"><fmt:message key="order_status.label.registered"/></option>
                            <option value ="paid" selected><fmt:message key="order_status.label.paid"/></option>
                            <option value="canceled"><fmt:message key="order_status.label.canceled"/></option>
                        </c:when>
                        <c:when test="${param.status=='canceled'}">
                            <option value ="registered"><fmt:message key="order_status.label.registered"/></option>
                            <option value ="paid"><fmt:message key="order_status.label.paid"/></option>
                            <option value="canceled" selected><fmt:message key="order_status.label.canceled"/></option>
                        </c:when>
                        <c:otherwise>
                            <option value ="registered" selected><fmt:message key="order_status.label.registered"/></option>
                            <option value ="paid"><fmt:message key="order_status.label.paid"/></option>
                            <option value="canceled"><fmt:message key="order_status.label.canceled"/></option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block"><fmt:message key="add.label.save"/></button>
        </div>
    </form>

    <div class="text-center"><fmt:message key="label.return_to"/> <a href="${pageContext.request.contextPath}/catalogue"><fmt:message key="label.main_page"/></a>?</div>
</div>
</body>
</html>
