<%-- 
    Document   : header
    Created on : Mar 29, 2021, 6:37:59 PM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="<c:url value="/" />">Trang chu</a>
        </li>
        <c:forEach items="${categories}" var="cate">
        <li class="nav-item">
            <a class="nav-link" 
               href="<c:url value="/?cateId=${cate.id}" />">${cate.name}</a>
        </li>
        </c:forEach>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/cart" />">Giỏ hàng</a>
        </li>
    </ul>
</nav>