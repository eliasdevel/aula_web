<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<c:import  url = "tool-bar.jsp"/>
<table class="table table-dark" >
    <thead>
        <tr>
            <th scope="col"> Opções </th>
            <th scope="col">Nome</th>
        </tr>
    </thead>
    <tbody>   
        <c:forEach items = "${categories}"  var = "categorie">
            <tr>
                <td> 
                    <a style="font-size:  20px" href="?p=CategorieForm&id=<c:out value = "${categorie.getId()}"/>" class="glyphicon-pencil"></a>
                    <a style="font-size:  20px" href="?p=CategorieSave&ac=delete&id=<c:out value = "${categorie.getId()}"/>" class="glyphicon-minus"></a>
                </td>
                
                <td scope="col"> 
                    <c:out value = "${categorie.getName()}"/><p>
                </td>

            </tr>
        </c:forEach>
    </tbody>
</table>