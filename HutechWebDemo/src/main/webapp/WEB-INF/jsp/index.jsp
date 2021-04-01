<%-- 
    Document   : index
    Created on : Mar 24, 2021, 7:26:20 PM
    Author     : duonghuuthanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
    </head>
    <body>
        <h1>Welcome to My SaleApp!!!</h1>
        <ul style="font-size:20px;color:red;">
            <c:forEach items="${categories}" var="cate">
            <li>${cate.id} - ${cate.name}</li>
            </c:forEach>
        </ul>
    </body>
</html>
