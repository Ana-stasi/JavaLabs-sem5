<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/pageform.css">
<style>
    .page-form form button {
        background-color: rgb(110, 176, 170) !important;
    }

    .page-form form button:hover {
        background-color: rgb(83, 134, 130) !important;
    }

    .page-form a {
        color: #386d77 !important;
        text-decoration: underline;
    !important;
    }

    .page-form a:hover {
        text-decoration: underline;
    }

</style>
<head>
    <title>$Login$</title>
</head>

<body>
<div class="page-form">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <h2>Login</h2>
        <div class="form-group"><input type="text" class="form-control" name="user_name" placeholder="Username"
                                       required="required"></div>

        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Login</button>
        </div>
        <div class="text-center">Don`t have account? <a href="${pageContext.request.contextPath}/register">Sign up</a>
        </div>
    </form>
</div>
</body>
</html>
