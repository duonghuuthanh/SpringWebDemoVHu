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
<form>
    <div class="row">
        <div class="col-md-10 form-group">
            <input type="text" 
                   name="kw"
                   class="form-control" 
                   placeholder="Nhập từ khoá để tìm..." />
        </div>
        <div class="col-md-2">
            <input type="submit" 
                   class="btn btn-info"
                   value="Tìm kiếm" />
        </div>
    </div>
</form>
<table class="table">
    <tr>
        <th>Id</th>
        <th>Ten SP</th>
        <th>Mo ta</th>
        <th>Gia Sp</th>
        <th></th>
    </tr>
    <c:forEach items="${products}" var="p">
    <tr id="product${p.id}">
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.description}</td>
        <td>${p.price} VND</td>
        <td>
            <a href="javascript:;"
               class="btn btn-danger"
               onclick="deleteProduct(${p.id})">Xoa</a> 
            <a href="<c:url value="/product/${p.id}" />" 
               class="btn btn-info">Cap nhat</a>
            <a href="javascript:;" 
               class="btn btn-success">Thêm vào giỏ</a>
        </td>
    </tr>
    </c:forEach>
</table>
<script src="<c:url value="/js/main.js" />"></script>