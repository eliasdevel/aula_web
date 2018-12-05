<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:if test="${noResult != null}">
    <pre class="center-block " style="text-align: center" >Nenhum registro encontrado para esta pesquisa!</pre>
</c:if>
<div class="container">
    <div id="products" class="row list-group">
        <c:forEach items = "${products}"  var = "product">
            <div class="item  col-xs-4 col-lg-4">
                <div class="thumbnail">
                    <a href="?p=Productp&id=<c:out value = "${product.getId()}"/>"><img style="max-height: 250px" class="group list-group-image" src="data:image/png;base64, <c:out value = "${product.getImages()[0].getBase64Data()}"/>" /></a>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            <c:out value = "${product.getName()}"/></h4>
                        <p class="group inner list-group-item-text">
                           Click na imagem para ver a descrição do produto
                        </p>
                        <br/>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                  R$&nbsp<c:out value = "${product.getPrice()}"/></p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success glyphicon glyphicon-shopping-cart" href="?p=AddToCart&id=<c:out value = "${product.getId()}&redirect=MyCart"/>">Adicionar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
