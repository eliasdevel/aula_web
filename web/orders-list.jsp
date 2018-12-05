<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:import  url = "tool-bar.jsp"/>
<table class="table table-dark" >
    <thead>
        <tr>
            <th scope="col"> Opções </th>
            <th scope="col">ID</th>
            <th scope="col">Data</th>
            <th scope="col">Cliente</th>
            <th scope="col">Produto</th>
            <th scope="col">Preço</th>
            <th scope="col">Quantidade</th>
            <th scope="col">Total</th>
        </tr>
    </thead>
    <tbody>   
        <c:forEach items = "${orders}"  var = "order">
        
                <tr>
                    <td> 
                    </td>
                    <td scope="col"> 
                        <c:out value = "${order.getId()}"/>
                    </td>
                    <td scope="col"> 
                        <c:out value = "${order.getFormatedDate()}"/>
                    </td>
                    <td scope="col"> 
                        <a href="admin?p=UserForm&id=<c:out value = "${order.getUser().getId()}"/>"> <c:out value = "${order.getUser().getName()}"/> </a>
                    </td>
                    <td scope="col"> 
                        <a href="admin?p=ProductForm&id=<c:out value = "${order.getProd().getId()}"/>"> <c:out value = "${order.getProd().getName()}"/> </a>
                    </td>
                    <td scope="col"> 
                        <c:out value = "${order.getProd().getPrice()}"/>
                    </td>
                    <td scope="col"> 
                        <c:out value = "${order.getQuantity()}"/>
                    </td>
                    <td scope="col"> 
                        <c:out value = "${order.getQuantity()*order.getProd().getPrice()}"/>
                    </td>
                </tr>
            </c:forEach>
    </tbody>
</table>