<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:import  url = "tool-bar.jsp"/>
<table class="table table-dark" >
    <thead>
        <tr>
            <th scope="col"> Opções </th>
            <th scope="col">ID</th>
            <th scope="col">Nome</th>
            <th scope="col">Descrição</th>
        </tr>
    </thead>
    <tbody>   
        <c:forEach items = "${products}"  var = "product">
            <tr>
                <td> 
                    <a style="font-size:  20px" href="?p=ProductForm&id=<c:out value = "${product.getId()}"/>" class="glyphicon-pencil"></a>
                    <a style="font-size:  20px" onclick="return confirm('Você tem certeza que deseja excluir o registro?')" href="?p=ProductSave&ac=delete&id=<c:out value = "${product.getId()}"/>" class="glyphicon-minus"></a>
                </td>


                <td scope="col"> 
                    <c:out value = "${product.getId()}"/>
                </td>
                <td scope="col"> 
                   <c:out value = "${product.getName()}"/>
                </td>
                <td scope="col"> 
                     <c:out value = "${product.getDescription()}"/>
                </td>

            </tr>
        </c:forEach>
    </tbody>
</table>