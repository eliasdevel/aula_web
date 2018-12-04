<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div style="margin: 20px;">
    <b><p style="text-align: center" ><span class="glyphicon glyphicon-shopping-cart"></span>Informações Do Carrinho</p></b>
    <table class="table table-dark" >
        <thead>
            <tr>
                <th scope="col"> Opções </th>
                <th scope="col">Nome</th>
                <th scope="col">Imagem</th>
                <th scope="col">Descrição</th>
                <th scope="col">Preço</th>
                <th scope="col">Total</th>
            </tr>
        </thead>
        <tbody>   
            <c:forEach items = "${cartProducts}"  var = "product">
                <tr>
                    <td> 
                        <a style="font-size:  20px" href="?p=ProductForm&id=<c:out value = "${product.getId()}"/>" class="glyphicon-plus"></a>
                        <a style="font-size:  20px" onclick="return confirm('Você tem certeza que deseja excluir o registro?')" href="?p=ProductSave&ac=delete&id=<c:out value = "${product.getId()}"/>" class="glyphicon-minus"></a>
                    </td>
                    <td scope="col"> 
                        <c:out value = "${product.getName()}"/>
                    </td>
                    <td  class="image-product-grid" id-prd="<c:out value = "${product.getId()}"/>" scope="col"> 

                    </td>
                    <td scope="col"> 
                        <c:out value = "${product.getDescription()}"/>
                    </td>
                    <td scope="col"> 
                        <c:out value = "${product.getPrice()}"/>&nbsp;R$
                    </td>
                    <td scope="col"> 
                        <c:out value = "${product.getPrice()}"/>&nbsp;R$
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <button type="button" class="btn btn-primary">Finalizar</button>
</div>
