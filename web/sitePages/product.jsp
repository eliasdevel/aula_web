<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="product col-md-12 col-lg-12 center-block" id="product_<c:out value = "${product.getId()}"/>">
    <div class="product product-name"><c:out value = "${product.getName()}"/></div>
    <div class="product product-description"><c:out value = "${product.getDescription()}"/></div>
    <c:forEach items = "${product.getImages()}"  var = "image">
        <img class="product"  width="200px" src="data:image/png;base64, <c:out value = "${image.getBase64Data()}"/>" >
    </c:forEach>
</div>        
