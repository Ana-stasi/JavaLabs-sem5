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
    <title><fmt:message key="homepage.label.homepage"/></title>
</head>

<body>
<div class="page-form">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav navbar-left">
                    <li><a href="${pageContext.request.contextPath}/create"><span class="glyphicon"></span><fmt:message key="user.menubar.label.create_order"/> </a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-left">
                    <li><a href="${pageContext.request.contextPath}/orders"><span class="glyphicon"></span> <fmt:message key="user.menubar.label.view_orders"/> </a>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/logout"><span
                            class="glyphicon glyphicon-log-in"></span> <fmt:message key="menubar.label.log_out"/></a></li>
                </ul>
            </div>
        </div>
    </nav>
    <form class="page-form" action="${pageContext.request.contextPath}/catalogue" method="get">
        <span class="page-form">
            <span>
              <label for="price"><fmt:message key="catalogue.label.sort.by_price"/>: </label>
                 <select class="btn btn-info dropdown-toggle" name="price" id="price">
                    <c:choose>
                        <c:when test="${param.price =='Asc'}">
                            <option value="3" selected><fmt:message key="catalogue.label.price.sort.asc"/></option>
                            <option value="4"><fmt:message key="catalogue.label.price.sort.desc"/></option>
                            <option value="none"><fmt:message key="catalogue.label.sort.none"/></option>
                        </c:when>
                        <c:when test="${param.price=='Desc'}">
                            <option value="3"><fmt:message key="catalogue.label.price.sort.asc"/></option>
                            <option value="4" selected><fmt:message key="catalogue.label.price.sort.desc"/></option>
                            <option value="none"><fmt:message key="catalogue.label.sort.none"/></option>
                        </c:when>
                        <c:otherwise>
                            <option value="none" selected><fmt:message key="catalogue.label.sort.none"/></option>
                            <option value="3"><fmt:message key="catalogue.label.price.sort.asc"/></option>
                            <option value="4"><fmt:message key="catalogue.label.price.sort.desc"/></option>
                        </c:otherwise>
                    </c:choose>
                </select></span>
            <span>  <label for="name"><fmt:message key="catalogue.label.sort.by_name"/>: </label>
                <select class="btn btn-info dropdown-toggle" name="name" id="name">
                    <c:choose>
                        <c:when test="${param.name=='A-Z'}">
                            <option value="1" selected><fmt:message key="catalogue.label.name.sort.a_z"/></option>
                            <option value="2"><fmt:message key="catalogue.label.name.sort.z_a"/></option>
                            <option value="none"><fmt:message key="catalogue.label.sort.none"/></option>
                        </c:when>
                        <c:when test="${param.name=='Z-A'}">
                            <option value="1"><fmt:message key="catalogue.label.name.sort.a_z"/></option>
                            <option value="2" selected><fmt:message key="catalogue.label.name.sort.z_a"/></option>
                            <option value="none"><fmt:message key="catalogue.label.sort.none"/></option>
                        </c:when>
                        <c:otherwise>
                            <option value="none" selected><fmt:message key="catalogue.label.sort.none"/></option>
                            <option value="1"><fmt:message key="catalogue.label.name.sort.a_z"/></option>
                            <option value="2"><fmt:message key="catalogue.label.name.sort.z_a"/></option>
                        </c:otherwise>
                    </c:choose>
                </select></span>
               <span>  <label for="date"><fmt:message key="catalogue.label.sort.by_date_added"/>: </label>
                <select class="btn btn-info dropdown-toggle" name="date" id="date">
                    <c:choose>
                        <c:when test="${param.date=='new-old'}">
                            <option value="5" selected><fmt:message key="catalogue.label.date.sort.new_old"/></option>
                            <option value="none"><fmt:message key="catalogue.label.date.sort.old_new"/></option>
                            <option value="none"><fmt:message key="catalogue.label.sort.none"/></option>
                        </c:when>
                        <c:when test="${param.date=='old-new'}">
                            <option value="5"><fmt:message key="catalogue.label.date.sort.new_old"/></option>
                            <option value="none" selected><fmt:message key="catalogue.label.date.sort.old_new"/></option>
                            <option value="none"><fmt:message key="catalogue.label.sort.none"/></option>
                        </c:when>
                        <c:otherwise>
                            <option value="none" selected><fmt:message key="catalogue.label.sort.none"/></option>
                            <option value="5"><fmt:message key="catalogue.label.date.sort.new_old"/></option>
                            <option value="none"><fmt:message key="catalogue.label.date.sort.old_new"/></option>
                        </c:otherwise>
                    </c:choose>
                </select></span>
             <button type="submit" class="btn btn-success btn-lg "><fmt:message key="catalogue.button.sort"/></button>
        </span>
    </form>
    <form action="${pageContext.request.contextPath}/catalogue" method="get">
        <h2><fmt:message key="catalogue.label.catalogue"/></h2>
        <div class="table">
            <table class="table table-striped table-bordered table-sm">
                <tr>
                    <th>№</th>
                    <th><fmt:message key="catalogue.label.category"/></th>
                    <th><fmt:message key="catalogue.label.name"/></th>
                    <th><fmt:message key="catalogue.label.price"/></th>
                    <th><fmt:message key="catalogue.label.color"/></th>
                    <th><fmt:message key="catalogue.label.weight"/></th>
                    <th><fmt:message key="catalogue.label.date_added"/></th>
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
            <jsp:include page="../pagination.jsp"/>
        </div>
    </form>
</div>


</div>
</body>
</html>
