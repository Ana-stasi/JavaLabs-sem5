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
    .page-form form button{
        background-color: rgb(110, 176, 170) !important;
    }
    .page-form form button:hover{
        background-color: rgb(83, 134, 130) !important;
    }


</style>
<body>
<div class="page-form">
    <form class="page-form" action="${pageContext.request.contextPath}/order_status" method="get">
        <h2>Edit order status</h2>
        <div class=" table">
            <table class="table table-striped table-bordered table-sm">
                <tr>
                    <th>№</th>
                    <th>Price</th>
                    <th>Status</th>
                    <th>Date of creation</th>
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
                <input type="number" class="form-control" name="order_number" placeholder="Order №" required="required">
            </div>
            <div >
                <select class="btn btn-info dropdown-toggle" name="status" id="status">
                    <c:choose>
                        <c:when test="${param.status=='paid'}">
                            <option value ="registered">registered</option>
                            <option value ="paid" selected>paid</option>
                            <option value="canceled">canceled</option>
                        </c:when>
                        <c:when test="${param.status=='canceled'}">
                            <option value ="registered">registered</option>
                            <option value ="paid">paid</option>
                            <option value="canceled" selected>canceled</option>
                        </c:when>
                        <c:otherwise>
                            <option value ="registered" selected>registered</option>
                            <option value ="paid">paid</option>
                            <option value="canceled">canceled</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Save</button>
        </div>


    </form>

    <div class="text-center">Return to <a href="${pageContext.request.contextPath}/catalogue">main page</a>?</div>
</div>
</body>
</html>
