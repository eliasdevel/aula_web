<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

 <c:forEach items = "${products}"  var = "product">
        <div onload="resizeProducts()" class="product col-md-4 col-lg-4 center-block" style=" font-size: 18px; padding: 5px;  height: 450px; " id="product_<c:out value = "${product.getId()}"/>">
            <div style="color:#777; margin-right:5px; height: 100%; border:1px solid #0cd4d2; width: 100%;">
                <div class="col-md-4 col-lg-4 product-comentary" style="text-align: center; ">
                    <div class="product product-name"><c:out value = "${product.getName()}"/></div> <br/>
                    <div class="product product-description"><c:out value = "${product.getDescription()}"/></div><br/>
                    <div class="product product-name">Preço:&nbsp;<c:out value = "${product.getPrice()}"/></div>R$<br/>
                    <a  href="?p=AddToCart&id=<c:out value = "${product.getId()}"/>&redirect=Home" class="product product-name glyphicon glyphicon-shopping-cart"></a><br/>
                </div>
                <div class="col-md-8 col-lg-8">
                    <a class="product-link" href="?p=Productp&id=<c:out value = "${product.getId()}"/>"><img prd_id="<c:out value = "${product.getId()}"/>" class="product img-responsive" width="100%" style="display: none"  src="data:image/png;base64, <c:out value = "${product.getImages()[0].getBase64Data()}"/>" ></a>
                    <a class="product-link "  href="?p=Productp&id=<c:out value = "${product.getId()}"/>"><canvas class="img-responsive" style="margin-top: 10px" id="canvas_<c:out value = "${product.getId()}"/>"> </canvas>    </a>

                </div>
            </div>
        </div>
    </c:forEach>
