<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/pageform.css">
<head>
    <title>Orders</title>
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
        <h2>Orders</h2>
        <div class=" table">
            <table class="table table-striped table-bordered table-sm">
                <tr>
                    <th>Price</th>
                    <th>Status</th>
                    <th>Date of creation</th>
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

    <div class="text-center">Return to <a href="${pageContext.request.contextPath}/catalogue">main page</a>?</div>
</div>
</body>
</html>
