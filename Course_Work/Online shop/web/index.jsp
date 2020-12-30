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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/formpage.css">
<style>
    .page-form form button {
        background-color: rgb(110, 176, 170) !important;
    }

    .page-form form button:hover {
        background-color: rgb(83, 134, 130) !important;
    }

    .page-form form img {
        min-width: 390px;
        height: 200px;
        align-content: center;
    }
    .page-form.row{
        margin-top: -30px;
        margin-bottom: -20px;
    }
    .page-form.row button{
        background-color: #169eb3 !important;
    }
</style>
<head>
    <title>$FirstPage$</title>
</head>

<body>
<div class="page-form">
    <form action="${pageContext.request.contextPath}/locale" method="get">

        <div class="page-form row">
            <div >
                <select class="btn btn-info dropdown-toggle" name="lang" id="lang">
                    <c:choose>
                        <c:when test="${param.lang =='en'}">
                            <option value ="uk"><fmt:message key="start_page.label.uk"/></option>
                            <option value ="en" selected><fmt:message key="start_page.label.en"/></option>
                            <option value="ru"><fmt:message key="start_page.label.ru"/></option>
                            <option value="fr"><fmt:message key="start_page.label.fr"/></option>
                        </c:when>
                        <c:when test="${param.lang =='ru'}">
                            <option value ="uk"><fmt:message key="start_page.label.uk"/></option>
                            <option value ="en"><fmt:message key="start_page.label.en"/></option>
                            <option value="ru"selected><fmt:message key="start_page.label.ru"/></option>
                            <option value="fr"><fmt:message key="start_page.label.fr"/></option>
                        </c:when>
                        <c:when test="${param.lang =='fr'}">
                            <option value ="uk"><fmt:message key="start_page.label.uk"/></option>
                            <option value ="en"><fmt:message key="start_page.label.en"/></option>
                            <option value="ru"><fmt:message key="start_page.label.ru"/></option>
                            <option value="fr"selected><fmt:message key="start_page.label.fr"/></option>
                        </c:when>
                        <c:otherwise>
                            <option value ="uk"selected><fmt:message key="start_page.label.uk"/></option>
                            <option value ="en"><fmt:message key="start_page.label.en"/></option>
                            <option value="ru"><fmt:message key="start_page.label.ru"/></option>
                            <option value="fr"><fmt:message key="start_page.label.fr"/></option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-info "><fmt:message key="start_page.button.apply"/></button>
            </div>
        </div>

        <div class=" form-group">
            <p><img src="images/dressUp.jpg" alt="Dress Up"></p>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block"><a
                    href="${pageContext.request.contextPath}/login"><fmt:message key="start_page.button.login" /></a></button>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block"><a
                    href="${pageContext.request.contextPath}/register"><fmt:message key="start_page.button.register" /></a></button>
        </div>
    </form>
    <div class="text-center"><a href="${pageContext.request.contextPath}/catalogue"><fmt:message key="start_page.label.guest" /></a></div>
</div>
</body>
</html>
