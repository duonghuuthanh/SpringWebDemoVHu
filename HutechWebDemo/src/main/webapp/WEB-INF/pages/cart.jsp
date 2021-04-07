<%-- 
    Document   : cart
    Created on : Apr 5, 2021, 7:48:04 PM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-warning">GIỎ HÀNG</h1>

<div class="alert alert-danger">
    <h1>Tong tien: ${cartStat.totalAmount} VND</h1>
    <h1>Tong so luong: ${cartStat.totalQuantity}</h1>
</div>

<table class="table">
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Đơn giá</th>
        <th>Số lượng</th>
    </tr>
    <c:if test="${cartProducts == null}">
        <td colspan="4" class="text-info">KHONG CO SAN PHAM NAO TRONG GIO!</td>
    </c:if>
    <c:if test="${cartProducts != null}">
    <c:forEach items="${cartProducts.values()}" var="p">
    <tr>
        <td>${p.productId}</td>
        <td>${p.productName}</td>
        <td>${p.price} VNĐ</td>
        <td>
            <input type="number" value="${p.quantity}" />
        </td>
    </tr>
    </c:forEach>
    </c:if>
</table>
<a href="javascript:;" class="btn btn-danger"
   onclick="saveCart()">Thanh toán</a>
<script src="<c:url value="/js/main.js" />"></script>
