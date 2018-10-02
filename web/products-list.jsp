<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
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
                    <a style="font-size:  20px" href="?p=ProductSave&ac=delete&id=<c:out value = "${product.getId()}"/>" class="glyphicon-minus"></a>
                </td>


                <td scope="col"> 
                    <c:out value = "${product.getId()}"/><p>
                </td>
                <td scope="col"> 
                    <c:out value = "${product.getName()}"/><p>
                </td>
                <td scope="col"> 
                    <c:out value = "${product.getDescription()}"/><p>
                </td>

            </tr>
        </c:forEach>
    </tbody>
</table>