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
        text-decoration: underline;
    }
    .page-form a:hover {
        text-decoration: underline;
    }
    .page-form h2:before, .page-form h2:after {
        width: 20% !important;
    }


</style>
<head>
    <title>Edit Product</title>
</head>
<body>
<div class="page-form">
    <form action="${pageContext.request.contextPath}/edit" method="post">
        <h2>Edit Product</h2>
        <p class="hint-text">Don`t remember product №? View <a href="${pageContext.request.contextPath}/catalogue">catalogue</a></p>
        <div class="form-group">
            <input type="text" class="form-control" name="product_id" placeholder="Product №" required="required">
        </div>
        <div class=" page-form row">
        <div >
            <select class="btn btn-info dropdown-toggle" name="category" id="category">
                <c:choose>
                    <c:when test="${param.category=='jeans'}">
                        <option value ="none">Category</option>
                        <option value="2" selected>jeans</option>
                        <option value="1">sweater`s</option>
                        <option value="4">shirts</option>
                    </c:when>
                    <c:when test="${param.category=='sweater`s'}">
                        <option value ="none">Category</option>
                        <option value="2" >jeans</option>
                        <option value="1"selected>sweater`s</option>
                        <option value="4">shirts</option>
                    </c:when>
                    <c:when test="${param.category=='sweater`s'}">
                        <option value ="none">Category</option>
                        <option value="4" selected>shirts</option>
                        <option value="1">sweater`s</option>
                        <option value="2">jeans</option>
                    </c:when>
                    <c:otherwise>
                        <option value ="none" selected>Category</option>
                        <option value="4" >shirts</option>
                        <option value="1">sweater`s</option>
                        <option value="2">jeans</option>
                    </c:otherwise>
                </c:choose>
            </select>
        </div>
        <div >
            <div>
                <select class="btn btn-info dropdown-toggle" name="color" id="color">
                    <c:choose>
                        <c:when test="${param.color=='white'}">
                            <option value ="none">Color</option>
                            <option value="2" selected>white</option>
                            <option value="1">black</option>
                            <option value="4">red</option>
                            <option value="6">blue</option>
                            <option value="7">yellow</option>
                            <option value="5">orange</option>
                        </c:when>
                        <c:when test="${param.color=='black'}">
                            <option value ="none">Color</option>
                            <option value="2">white</option>
                            <option value="1"selected>black</option>
                            <option value="4">red</option>
                            <option value="6">blue</option>
                            <option value="7">yellow</option>
                            <option value="5">orange</option>
                        </c:when>
                        <c:when test="${param.color =='red'}">
                            <option value ="none">Color</option>
                            <option value="2">white</option>
                            <option value="1">black</option>
                            <option value="4" selected>red</option>
                            <option value="6">blue</option>
                            <option value="7">yellow</option>
                            <option value="5">orange</option>
                        </c:when>
                        <c:when test="${param.color =='blue'}">
                            <option value ="none">Color</option>
                            <option value="2">white</option>
                            <option value="1">black</option>
                            <option value="4" >red</option>
                            <option value="6"selected>blue</option>
                            <option value="7">yellow</option>
                            <option value="5">orange</option>
                        </c:when>
                        <c:when test="${param.color =='yellow'}">
                            <option value ="none">Color</option>
                            <option value="2">white</option>
                            <option value="1">black</option>
                            <option value="4">red</option>
                            <option value="6">blue</option>
                            <option value="7" selected>yellow</option>
                            <option value="5">orange</option>
                        </c:when>
                        <c:when test="${param.color =='orange'}">
                            <option value ="none">Color</option>
                            <option value="2">white</option>
                            <option value="1">black</option>
                            <option value="4">red</option>
                            <option value="6">blue</option>
                            <option value="7">yellow</option>
                            <option value="5"selected>orange</option>
                        </c:when>
                        <c:otherwise>
                            <option value ="none" selected>Color</option>
                            <option value="2">white</option>
                            <option value="1">black</option>
                            <option value="4">red</option>
                            <option value="6">blue</option>
                            <option value="7">yellow</option>
                            <option value="5">orange</option>
                        </c:otherwise>
                    </c:choose>
                </select></div>
        </div>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="pr_name" placeholder="Product name" required="required">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="price" placeholder="Price" required="required">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="weight" placeholder="Weight" required="required">
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Save</button>
        </div>
    </form>
</div>
</body>
</html>
