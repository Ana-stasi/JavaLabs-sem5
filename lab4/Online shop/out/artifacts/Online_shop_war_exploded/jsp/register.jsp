<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
</style>
<head>
    <title>Sign up</title>
</head>
<body>
<div class="page-form">
    <form action="${pageContext.request.contextPath}/register" method="post">
        <h2>Register</h2>
        <p class="hint-text">Create your account. It's free and only takes a minute.</p>
        <div class="form-group">
            <input type="text" class="form-control" name="user_name" placeholder="Username" required="required"
                   autocomplete="false">
        </div>
        <div class="form-group">
            <input type="email" class="form-control" name="email" placeholder="Email" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required="required"
                   aria-autocomplete="list">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="confirm_password" placeholder="Confirm Password"
                   required="required">
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Register Now</button>
        </div>
    </form>
    <div class="text-center">Already have an account? <a href="${pageContext.request.contextPath}/login">Sign in</a>
    </div>
</div>
</body>
</html>
