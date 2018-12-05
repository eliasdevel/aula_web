<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="row center-block">
    <div class="col-lg-4 item-photo">
        <!-- Imagens do item -->
        <c:forEach items = "${product.getImages()}"  var = "image">
            <img style="max-width:100%" src="data:image/png;base64, <c:out value = "${image.getBase64Data()}"/>" >
        </c:forEach>
    </div>
    <div class="col-lg-4" style="border:0px solid gray">
        <!-- Valor e nome do Produto -->
        <h3><c:out value = "${product.getName()}"/></h3>
        <!-- Preço -->
        <h6 class="title-price"><small>Valor do Produto</small></h6>
        <h3 style="margin-top:0px;">R$&nbsp<c:out value = "${product.getPrice()}"/></h3>
        <!-- Detalhes do produto -->
        <!-- Botão de Compra -->
        <br/>
        <br/>
        <div class="section" style="padding-bottom:20px;">
            <a href="?p=AddToCart&id=<c:out value = "${product.getId()}&redirect=MyCart"/>"><button class="btn btn-success"><span style="margin-right:20px" class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>Adicionar ao Carrinho</button></a>
        </div>                                        
    </div>                              
    <div class="col-lg-12">
        <ul class="menu-items">
            <li class="active">Descrição do Produto</li>
        </ul>
        <div style="width:100%;border-top:1px solid silver">
            <p style="padding:10px; text-align: justify; text-indent: 2em;">
                <small>
                    <c:out value = "${product.getDescription()}"/>
                </small>
            </p>
        </div>
    </div>		
</div>
