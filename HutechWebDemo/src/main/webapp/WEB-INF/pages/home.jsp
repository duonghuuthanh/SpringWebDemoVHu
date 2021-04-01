<%-- 
    Document   : home
    Created on : Mar 29, 2021, 6:52:55 PM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"  
    uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info">DANH MUC SAN PHAM</h1>
<table class="table">
    <tr>
        <th>Id</th>
        <th>Ten SP</th>
        <th>Mo ta</th>
        <th>Gia Sp</th>
        <th></th>
    </tr>
    <c:forEach items="${products}" var="p">
    <tr>
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.description}</td>
        <td>${p.price} VND</td>
        <td>
            <a href="#" class="btn btn-danger">Xoa</a> 
            <a href="<c:url value="/product/${p.id}" />" 
               class="btn btn-info">Cap nhat</a>
        </td>
    </tr>
    </c:forEach>
</table>