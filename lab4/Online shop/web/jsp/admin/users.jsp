<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/pageform.css">
<head>
    <title>Block user</title>
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
<form class="page-form" action="${pageContext.request.contextPath}/user" method="get">
    <h2>Block user</h2>
    <div class=" table">
        <table class="table table-striped table-bordered table-sm">
            <tr>
                <th>Username</th>
                <th>Email</th>
                <th>Status</th>
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
                <input type="text" class="form-control" name="username" placeholder="Username" required="required">
            </div>
        <div >
            <select class="btn btn-info dropdown-toggle" name="status" id="status">
                <c:choose>
                    <c:when test="${param.status=='block'}">
                        <option value ="none">Status</option>
                        <option value ="false" selected>block</option>
                        <option value="true">unblock</option>
                    </c:when>
                    <c:when test="${param.status=='unblock'}">
                        <option value ="none">Status</option>
                        <option value ="false">block</option>
                        <option value="true" selected>unblock</option>
                    </c:when>
                    <c:otherwise>
                        <option value ="none" selected>Status</option>
                        <option value ="false">block</option>
                        <option value="true">unblock</option>
                    </c:otherwise>
                </c:choose>
            </select>
        </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Save</button>
        </div>
        <span class="error_message">${requestScope.get('err')}</span>

    </form>
    <div class="text-center">Return to <a href="${pageContext.request.contextPath}/catalogue">main page</a>?</div>
</div>
</body>
</html>
