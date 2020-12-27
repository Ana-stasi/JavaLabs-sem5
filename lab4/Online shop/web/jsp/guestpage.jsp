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
        width: 70px;
        background: #63738a;
    }

    .page-form form button:hover {
        background: #546275;
    }

    .page-form form img {
        min-width: 390px;
        height: 200px;
        align-content: center;
    }

    .page-form btn-info {
        background: #546275;
    !important;
    }
</style>

<head>
    <title>$Catalogue$</title>
</head>

<body>
<div class="page-form">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="myNavbar">

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/login"><span
                            class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <form class="page-form" action="${pageContext.request.contextPath}/catalogue" method="get">
        <span class="page-form">
            <span>
              <label for="price">By price: </label>
                 <select class="btn btn-info dropdown-toggle" name="price" id="price">
                    <c:choose>
                        <c:when test="${param.price =='Asc'}">
                            <option value="3" selected>Asc</option>
                            <option value="4">Desc</option>
                            <option value="none">None</option>
                        </c:when>
                        <c:when test="${param.price=='Desc'}">
                            <option value="3">Asc</option>
                            <option value="4" selected>Desc</option>
                            <option value="none">None</option>
                        </c:when>
                        <c:otherwise>
                            <option value="none" selected>None</option>
                            <option value="3">Asc</option>
                            <option value="4">Desc</option>
                        </c:otherwise>
                    </c:choose>
                </select></span>
            <span>  <label for="name">By name: </label>
                <select class="btn btn-info dropdown-toggle" name="name" id="name">
                    <c:choose>
                        <c:when test="${param.name=='A-Z'}">
                            <option value="1" selected>A-Z</option>
                            <option value="2">Z-A</option>
                            <option value="none">None</option>
                        </c:when>
                        <c:when test="${param.name=='Z-A'}">
                            <option value="1">A-Z</option>
                            <option value="2" selected>Z-A</option>
                            <option value="none">None</option>
                        </c:when>
                        <c:otherwise>
                            <option value="none" selected>None</option>
                            <option value="1">A-Z</option>
                            <option value="2">Z-A</option>
                        </c:otherwise>
                    </c:choose>
                </select></span>
               <span>  <label for="date">By date added: </label>
                <select class="btn btn-info dropdown-toggle" name="date" id="date">
                    <c:choose>
                        <c:when test="${param.date=='new-old'}">
                            <option value="5" selected>new-old</option>
                            <option value="none">old-new</option>
                            <option value="none">None</option>
                        </c:when>
                        <c:when test="${param.date=='old-new'}">
                            <option value="5">new-old</option>
                            <option value="none" selected>old-new</option>
                            <option value="none">None</option>
                        </c:when>
                        <c:otherwise>
                            <option value="none" selected>None</option>
                            <option value="5">new-old</option>
                            <option value="none">old-new</option>
                        </c:otherwise>
                    </c:choose>
                </select></span>
             <button type="submit" class="btn btn-success btn-lg ">Sort</button>
        </span>
    </form>
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
                <c:forEach var="product" items="${products}">
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
        <div class="page-form pagination">
            <c:set var="href" value="/catalogue?" scope="request"/>
            <jsp:include page="../jsp/pagination.jsp"/>
        </div>
    </form>
</div>
</body>
</html>
