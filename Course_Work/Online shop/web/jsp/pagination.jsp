<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="language"/>

<html lang="${sessionScope.lang}">

<head>
    <meta charset="UTF-8"/>
    <title>Pagination</title>
</head>
<style>
    .pagination {
        margin-top: -10px;
        position: center;
    !important;
    }

    .pagination a {

        color: #18a2b7 !important;
        text-decoration: underline;
    }
</style>
<body class="page-form">

<div class="pagination">
    <c:if test="${page!=null}">
        <c:choose>
            <c:when test="${page==1}">
                <c:if test="${lastPage==page+1}">
                    <p><c:out value="${page}"/></p>
                </c:if>
                <c:if test="${lastPage!=page+1}">
                    <p><strong><c:out value="${page}"/> ...
                        <a href="${href}&page=${lastPage}">${lastPage} </a></strong>
                        <a href="${href}&page=${page+1}"> <fmt:message key="pagination.label.next"/> </a></p>
                </c:if>
            </c:when>

            <c:when test="${page==lastPage}">
                <c:if test="${1==page-1}">
                    <p><a href="${href}&page=${page-1}"><fmt:message key="pagination.label.previous"/></a>
                        <strong><c:out value="${page}"/></strong></p>
                </c:if>
                <c:if test="${1!=page-1}">
                    <p><a href="${href}&page=${page-1}"><fmt:message key="pagination.label.previous"/></a><strong>
                        <a href="${href}">1</a> ... <c:out value="${page}"/></strong></p>
                </c:if>
            </c:when>

            <c:otherwise>
                <p><a href="${href}&page=${page-1}"><fmt:message key="pagination.label.previous"/></a>
                    <strong> <a href="${href}">1</a>
                        ... <c:out value="${page}"/>
                        <a href="${href}&page=${lastPage}">${lastPage}</a>
                    </strong> <a href="${href}&page=${page+1}"><fmt:message key="pagination.label.next"/></a></p>
            </c:otherwise>
        </c:choose>
    </c:if>
</div>
</body>
</html>
