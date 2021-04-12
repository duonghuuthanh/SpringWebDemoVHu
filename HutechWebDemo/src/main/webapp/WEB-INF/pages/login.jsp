<%-- 
    Document   : login
    Created on : Apr 12, 2021, 6:54:47 PM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">LOGIN</h1>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Something wrong!!!
    </div>
</c:if>

<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
       Access Denied!!! 
    </div>
</c:if>

<c:url value="/login" var="action" />
<form method="post" action="${action}">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" name="username" 
               id="username"
               class="form-control" />
    </div>
    <div class="form-group">
        <label for="password">Username</label>
        <input type="password" name="password" 
               id="password"
               class="form-control" />
    </div>
    <div class="form-group">
        <input type="submit" value="login"
               class="btn btn-danger"/>
    </div>
</form>
