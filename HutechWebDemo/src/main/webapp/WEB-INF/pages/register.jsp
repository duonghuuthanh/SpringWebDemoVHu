<%-- 
    Document   : register
    Created on : Apr 12, 2021, 7:31:44 PM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-success">DANG KY</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<form:form method="post" modelAttribute="user">
    <div class="form-group">
        <lable for="firstName">First Name</lable>
        <form:input id="firstName" 
                    class="form-control"
                    path="firstName" />
    </div>
    <div class="form-group">
        <lable for="lastName">Last Name</lable>
        <form:input id="lastName" 
                    class="form-control"
                    path="lastName" />
    </div>
    <div class="form-group">
        <lable for="email">Email</lable>
        <form:input id="email" 
                    class="form-control"
                    path="email" />
    </div>
    <div class="form-group">
        <lable for="phone">Phone</lable>
        <form:input id="phone" 
                    class="form-control"
                    path="phone" />
    </div>
    <div class="form-group">
        <lable for="username">Username</lable>
        <form:input id="username" 
                    class="form-control"
                    path="username" />
    </div>
    <div class="form-group">
        <lable for="password">Password</lable>
        <form:password id="password" 
                    class="form-control"
                    path="password" />
    </div>
    <div class="form-group">
        <lable for="confirm">Confirm Password</lable>
        <form:password id="confirm" 
                    class="form-control"
                    path="confirmPassword" />
    </div>
    <div class="form-group">
        <input type="submit" value="Dang ky" class="btn btn-danger" />
    </div>
</form:form>