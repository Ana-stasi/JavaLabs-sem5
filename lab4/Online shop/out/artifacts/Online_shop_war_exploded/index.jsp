<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
</style>
<head>
    <title>$FirstPage$</title>
</head>

<body>
<div class="page-form">
    <form action="${pageContext.request.contextPath}/catalogue" method="get">
        <div class=" form-group">
            <p><img src="images/dressUp.jpg" alt="Dress Up"></p>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block"><a
                    href="${pageContext.request.contextPath}/login">Login</a></button>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block"><a
                    href="${pageContext.request.contextPath}/register">Sign Up</a></button>
        </div>
    </form>
    <div class="text-center"><a href="${pageContext.request.contextPath}/catalogue">Continue as a guest</a></div>
</div>
</body>
</html>
