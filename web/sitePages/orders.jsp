<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div style="margin: 20px;">
    <b><p style="text-align: center" ><span class="glyphicon glyphicon-list"></span>Informações Do Pedido</p></b>
    <table class="table table-dark" >
        <thead>
            <tr>
                
                <th scope="col">Nome Do Produto</th>
                <th scope="col">Data/Hora do Pedido</th>
                <th scope="col">Imagem</th>
                <th scope="col">Quantidade</th>
                <th scope="col">Preço</th>
                <th scope="col">Total</th>
            </tr>
        </thead>
        <tbody>   
            <c:forEach items = "${orders}"  var = "order">
                <tr>
                  
                    <td scope="col"> 
                        <c:out value = "${order.getProd().getName()}"/>
                    </td>
                    <td scope="col"> 
                        <c:out value = "${order.getFormatedDate()}"/>
                    </td>
                    <td  class="image-product-grid"  scope="col"> 
                        <a class="product-link" href="?p=Productp&id=<c:out value = "${order.getProd().getId()}"/>"><img  class="product img-responsive"  style="max-height: 64px"  src="data:image/png;base64, <c:out value = "${order.getProd().getImages()[0].getBase64Data()}"/>" ></a>
                    </td>
                    <td scope="col"> 
                        <c:out value = "${order.getQuantity()}"/>
                    </td>
                    <td scope="col"> 
                        <c:out value = "${order.getProd().getPrice()}"/>&nbsp;R$
                    </td>
                    <td scope="col"> 
                        <c:out value = "${order.getProd().getPrice() * order.getQuantity()}"/>&nbsp;R$
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>
