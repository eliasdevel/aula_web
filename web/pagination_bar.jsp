<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>



<nav aria-label="...">
    <ul class="pagination">
        <c:forEach items="${pageLinks}" var="page">
            <li class="page-item"><a class="page-link" href="<c:out value="${page.value}"/>"><c:out value="${page.key+1}"/></a></li>
               
        </c:forEach>
    </ul>
</nav>