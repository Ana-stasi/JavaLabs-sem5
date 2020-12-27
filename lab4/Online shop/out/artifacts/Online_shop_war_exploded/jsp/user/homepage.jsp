<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/formpage.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<style>
    .page-form {
        size: 500px;
    !important;
        width: auto;
    !important;
    }

    .page-form form button {
        background-color: rgb(110, 176, 170) !important;
    }

    .page-form form button:hover {
        background-color: rgb(83, 134, 130) !important;
    }
</style>
<head>
    <title>$Homepage$</title>
</head>

<body>
<div class="page-form">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav navbar-left">
                    <li><a href="${pageContext.request.contextPath}/create"><span class="glyphicon"></span> Create order</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-left">
                    <li><a href="${pageContext.request.contextPath}/orders"><span class="glyphicon"></span> View orders</a>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/logout"><span
                            class="glyphicon glyphicon-log-in"></span> Log out</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <form action="${pageContext.request.contextPath}/catalogue" method="get">
        <h2>Catalogue</h2>

        <div class="table">
            <table class="table table-striped table-bordered table-sm">
                <tr>
                    <th>№</th>
                    <th>Category</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Color</th>
                    <th>Weight</th>
                    <th>Date added</th>
                </tr>
                <c:set var="products" value="${requestScope.get('products')}"/>
                <c:forEach var="product" items="${requestScope.get('products')}">
                    <tr>
                        <td>${product.getId()}</td>
                        <td>${product.getCategory().getName()}</td>
                        <td>${product.getName()}</td>
                        <td>${product.getPrice()}</td>
                        <td>${product.getColor().getName()}</td>
                        <td>${product.getWeight()}</td>
                        <td>${product.getDateAdded()}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
        <c:set var="href" value="/catalogue?" scope="request"/>
        <jsp:include page="../pagination.jsp"/>
    </form>
</div>


</div>
</body>
</html>
