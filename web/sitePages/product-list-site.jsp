<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:forEach items = "${products}"  var = "product">
    <div class="product col-md-12 col-lg-12 center-block" id="product_<c:out value = "${product.getId()}"/>">
        <div class="product product-name"><c:out value = "${product.getName()}"/></div>
        <div class="product product-description"><c:out value = "${product.getDescription()}"/></div>
        <a class="product-link" href="?p=Productp&id=<c:out value = "${product.getId()}"/>"><img class="product"  width="200px" src="data:image/png;base64, <c:out value = "${product.getImages()[0].getBase64Data()}"/>" ></a>
    </div>
</c:forEach>
