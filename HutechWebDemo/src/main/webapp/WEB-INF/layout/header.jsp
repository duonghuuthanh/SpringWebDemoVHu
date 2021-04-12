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
            <a class="nav-link" href="<c:url value="/cart" />">
                Giỏ hàng <span class="badge badge-info" id="cart-quantity">${cartStat.totalQuantity}</span>
            </a>
        </li>
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name == null}">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/login" />">
                        Dang nhap
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/register" />">
                        Dang ky
                    </a>
                </li>
            </c:when>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        ${pageContext.request.userPrincipal.name}
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/logout" />">
                        Dang xuat
                    </a>
                </li>
            </c:when>
        </c:choose>
    </ul>
</nav>