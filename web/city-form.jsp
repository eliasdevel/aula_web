<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<form  action="<c:out value = "${action}"/>&id=<c:out value = "${city.getId()}"/>" method="POST"  >
    <div class="form-group">
        <label for="inputName">Nome</label>
        <input name ="name" value="<c:out value="${city.getName()}"/>" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="estadoHelp" placeholder="Nome da Cidade">
    </div>
    <div class="form-group">
        <label for="inputSigla">Estado</label>
        <select  class="form-control" name="state_id"  id="exampleFormControlSelect1"  required/>
        <option value="">Selecione</option>
        <c:if test="${city.getState() != null}">
            <option value="${city.getState().getId()}" selected>${city.getState().getId()}</option>
        </c:if>
        <c:forEach items="${states}" var="state">
            <c:if test="${state.getId() != city.getState().getId()}">
                <option value="${state.getId()}">${state.getName()}</option>
            </c:if>
        </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Salvar</button>
</form>