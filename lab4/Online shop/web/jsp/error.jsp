<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/formpage.css">
<head>
</head>
<body>
<div class="page-form">
    <div class="alert alert-danger">
        <strong>Error! </strong>${requestScope.get('error')}
        <button onclick="location.href='${requestScope.get('pagelink')}'" type="button" class="close"
                data-dismiss="alert">
            &times
        </button>
    </div>
</div>
</body>
</html>
