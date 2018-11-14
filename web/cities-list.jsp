<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<c:import  url = "tool-bar.jsp"/>
<table class="table table-dark" >
    <thead>
        <tr>
            <th scope="col"> Opções </th>
            <th scope="col">Id</th>
            <th scope="col">Nome</th>
        </tr>
    </thead>
    <tbody>   
        <c:forEach items = "${cities}"  var = "city">
            <tr>
                <td> 
                    <a style="font-size:  20px" href="?p=CityForm&id=<c:out value = "${city.getId()}"/>" class="glyphicon-pencil"></a>
                    <a style="font-size:  20px" onclick="return confirm('Você tem certeza que deseja excluir o registro?')" href="?p=CitySave&ac=delete&id=<c:out value = "${city.getId()}"/>" class="glyphicon-minus"></a>
                </td>


                <td scope="col"> 
                    <c:out value = "${city.getId()}"/><p>
                </td>
                <td scope="col"> 
                    <c:out value = "${city.getName()}"/><p>
                </td>

            </tr>
        </c:forEach>
    </tbody>
</table>