<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<form  action="<c:out value = "${action}"/>" method="POST"  >
  <div class="form-group">
    <label for="inputName">Categoria</label>
    <input name ="name" value="<c:out value="${categorie.getName()}"/>" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="estadoHelp" placeholder="Nome da categoria">
    
  </div>
  
  <button type="submit" class="btn btn-primary">Salvar</button>
</form>