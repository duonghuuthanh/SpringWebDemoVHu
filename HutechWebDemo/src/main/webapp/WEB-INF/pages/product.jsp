<%-- 
    Document   : product
    Created on : Mar 29, 2021, 6:58:08 PM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"  
    uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">QUAN LY SAN PHAM</h1>
<form:form method="POST" 
           action="/HutechWebDemo/add-product" 
           modelAttribute="product">
    
    <div class="alert alert-danger">
        <form:errors path="*" element="div" />
    </div>
    <div class="form-group">
        <label for="name">Name</label>
        <form:input id="name" 
                    cssClass="form-control" 
                    path="name" />
        <form:errors path="name" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="description">Description</label>
        <form:input id="description" 
                    cssClass="form-control" 
                    path="description" />
    </div>
    <div class="form-group">
        <label for="price">Price</label>
        <form:input id="price" 
                    cssClass="form-control" 
                    path="price" />
        <form:errors path="price" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="cate">Danh muc </label>
        <form:select id="cate" path="category" 
                     cssClass="form-control">
            <c:forEach items="${categories}" var="cat">
                <option value="${cat.id}">${cat.name}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <form:hidden path="id" />
        <input type="submit" value="Them san pham"
               class="btn btn-danger" />
    </div>
</form:form>

