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
<link rel="stylesheet" href="/css/formpage.css">
<style>
    .page-form form button{
        background-color: rgb(110, 176, 170) !important;
    }
    .page-form form button:hover{
        background-color: rgb(83, 134, 130) !important;
    }
    .page-form h2:before, .page-form h2:after {
        width:10% !important;
    }

</style>
<head>
    <title><fmt:message key="add.h2.add_product"/></title>
</head>
<body>
<div class="page-form">
    <form action="${pageContext.request.contextPath}/add" method="post">
        <h2><fmt:message key="add.h2.add_product"/></h2>
         <div class=" page-form row">
        <div>
                <select class="btn btn-info dropdown-toggle" name="category" id="category">
                    <c:choose>
                        <c:when test="${param.category=='jeans'}">
                            <option value ="none"><fmt:message key="catalogue.label.category"/></option>
                            <option value="2" selected><fmt:message key="add.label.jeans"/></option>
                            <option value="1"><fmt:message key="add.label.sweaters"/></option>
                            <option value="4"><fmt:message key="add.label.shirts"/></option>
                        </c:when>
                        <c:when test="${param.category=='sweater`s'}">
                            <option value ="none"><fmt:message key="catalogue.label.category"/></option>
                            <option value="2" ><fmt:message key="add.label.jeans"/></option>
                            <option value="1"selected><fmt:message key="add.label.sweaters"/></option>
                            <option value="4"><fmt:message key="add.label.shirts"/></option>
                        </c:when>
                        <c:when test="${param.category=='sweater`s'}">
                            <option value ="none"><fmt:message key="catalogue.label.category"/></option>
                            <option value="4" selected><fmt:message key="add.label.shirts"/></option>
                            <option value="1"><fmt:message key="add.label.sweaters"/></option>
                            <option value="2"><fmt:message key="add.label.jeans"/></option>
                        </c:when>
                        <c:otherwise>
                            <option value ="none" selected><fmt:message key="catalogue.label.category"/></option>
                                <option value="4" ><fmt:message key="add.label.shirts"/></option>
                                <option value="1"><fmt:message key="add.label.sweaters"/></option>
                                <option value="2"><fmt:message key="add.label.jeans"/></option>
                        </c:otherwise>
                    </c:choose>
                </select>
        </div>
             <div >
                 <div>
                     <select class="btn btn-info dropdown-toggle" name="color" id="color">
                         <c:choose>
                             <c:when test="${param.color=='white'}">
                                 <option value ="none"><fmt:message key="catalogue.label.color"/></option>
                                 <option value="2" selected><fmt:message key="label.color.white"/></option>
                                 <option value="1"><fmt:message key="label.color.black"/></option>
                                 <option value="4"><fmt:message key="label.color.red"/></option>
                                 <option value="6"><fmt:message key="label.color.blue"/></option>
                                 <option value="7"><fmt:message key="label.color.yellow"/></option>
                                 <option value="5"><fmt:message key="label.color.orange"/></option>
                             </c:when>
                             <c:when test="${param.color=='black'}">
                                 <option value ="none"><fmt:message key="catalogue.label.color"/></option>
                                 <option value="2"><fmt:message key="label.color.white"/></option>
                                 <option value="1"selected><fmt:message key="label.color.black"/></option>
                                 <option value="4"><fmt:message key="label.color.red"/></option>
                                 <option value="6"><fmt:message key="label.color.blue"/></option>
                                 <option value="7"><fmt:message key="label.color.yellow"/></option>
                                 <option value="5"><fmt:message key="label.color.orange"/></option>
                             </c:when>
                             <c:when test="${param.color =='red'}">
                                 <option value ="none"><fmt:message key="catalogue.label.color"/></option>
                                 <option value="2"><fmt:message key="label.color.white"/></option>
                                 <option value="1"><fmt:message key="label.color.black"/></option>
                                 <option value="4" selected><fmt:message key="label.color.red"/></option>
                                 <option value="6"><fmt:message key="label.color.blue"/></option>
                                 <option value="7"><fmt:message key="label.color.yellow"/></option>
                                 <option value="5"><fmt:message key="label.color.orange"/></option>
                             </c:when>
                             <c:when test="${param.color =='blue'}">
                                 <option value ="none"><fmt:message key="catalogue.label.color"/></option>
                                 <option value="2"><fmt:message key="label.color.white"/></option>
                                 <option value="1"><fmt:message key="label.color.black"/></option>
                                 <option value="4" ><fmt:message key="label.color.red"/></option>
                                 <option value="6"selected><fmt:message key="label.color.blue"/></option>
                                 <option value="7"><fmt:message key="label.color.yellow"/></option>
                                 <option value="5"><fmt:message key="label.color.orange"/></option>
                             </c:when>
                             <c:when test="${param.color =='yellow'}">
                                 <option value ="none"><fmt:message key="catalogue.label.color"/></option>
                                 <option value="2"><fmt:message key="label.color.white"/></option>
                                 <option value="1"><fmt:message key="label.color.black"/></option>
                                 <option value="4"><fmt:message key="label.color.red"/></option>
                                 <option value="6"><fmt:message key="label.color.blue"/></option>
                                 <option value="7" selected><fmt:message key="label.color.yellow"/></option>
                                 <option value="5"><fmt:message key="label.color.orange"/></option>
                             </c:when>
                             <c:when test="${param.color =='orange'}">
                                 <option value ="none"><fmt:message key="catalogue.label.color"/></option>
                                 <option value="2"><fmt:message key="label.color.white"/></option>
                                 <option value="1"><fmt:message key="label.color.black"/></option>
                                 <option value="4"><fmt:message key="label.color.red"/></option>
                                 <option value="6"><fmt:message key="label.color.blue"/></option>
                                 <option value="7"><fmt:message key="label.color.yellow"/></option>
                                 <option value="5"selected><fmt:message key="label.color.orange"/></option>
                             </c:when>
                             <c:otherwise>
                                 <option value ="none" selected><fmt:message key="catalogue.label.color"/></option>
                                 <option value="2"><fmt:message key="label.color.white"/></option>
                                 <option value="1"><fmt:message key="label.color.black"/></option>
                                 <option value="4"><fmt:message key="label.color.red"/></option>
                                 <option value="6"><fmt:message key="label.color.blue"/></option>
                                 <option value="7"><fmt:message key="label.color.yellow"/></option>
                                 <option value="5"><fmt:message key="label.color.orange"/></option>
                             </c:otherwise>
                         </c:choose>
                     </select></div>
             </div>
         </div>
        <div class="form-group">
            <input type="text" class="form-control" name="pr_name" placeholder="<fmt:message key="label.product_name"/>" required="required">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="price" placeholder="<fmt:message key="catalogue.label.price"/>" required="required">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="weight" placeholder="<fmt:message key="catalogue.label.weight"/>" required="required">
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block"><fmt:message key="add.label.save"/></button>
        </div>
    </form>
    <div class="text-center"><fmt:message key="label.return_to"/> <a href="${pageContext.request.contextPath}/catalogue"> <fmt:message key="label.main_page"/></a>?</div>
</div>
</body>
</html>
