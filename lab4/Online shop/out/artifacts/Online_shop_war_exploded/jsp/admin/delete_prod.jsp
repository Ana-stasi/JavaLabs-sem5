<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/pageform.css">
<style>
    .page-form form button{
        background-color: rgb(110, 176, 170) !important;
    }
    .page-form form button:hover{
        background-color: rgb(83, 134, 130) !important;
    }
    .page-form a {
        color: #65c6d9 !important;
        text-decoration: underline;!important;
    }
    .page-form a:hover {
        text-decoration: none;
    }
    .page-form h2:before, .page-form h2:after {
        width: 20% !important;
    }


</style>
<head>
    <title>Delete Product</title>
</head>
<body>
<div class="page-form">
    <form action="${pageContext.request.contextPath}/delete" method="post">
        <h2>Delete Product</h2>
        <p class="hint-text">Don`t remember product №? View <a href="${pageContext.request.contextPath}/catalogue">catalogue</a></p>
        <div class="form-group">
            <input type="number" class="form-control" name="product_id" placeholder="Product №" required="required">
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Delete</button>
        </div>
    </form>
</div>
</body>
</html>
