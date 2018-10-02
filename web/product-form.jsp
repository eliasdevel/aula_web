<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<form  action="<c:out value = "${action}"/>" id ="product-form"  method="POST"  >
    <div class="form-group">
        <label for="inputName">Nome</label>
        <input name ="name" value="<c:out value="${product.getName()}"/>" type="text" class="form-control"  aria-describedby="estadoHelp" placeholder="Nome"/>

    </div>
    <div class="form-group">
        <label for="inputSigla">Descrição</label>
        <input name ="description" value="<c:out value="${product.getDescription()}"/>" type="text" class="form-control"  placeholder="Descrição"/>
    </div>
    <div class="form-group">
        <label for="inputSigla">Preço</label>
        <input name ="price" value="<c:out value="${product.getPrice()}"/>" type="number"min="0" max="10000" class="form-control" />
    </div>


    <div class="form-group">
        <label for="exampleFormControlSelect1">Categoria</label>
        <select  class="form-control" name="category"  id="exampleFormControlSelect1"  />
        <option value="0">Selecione</option>
            <c:if test="${product != null}">
                <option value="${product.getCategorie().getId()}" selected>${product.getCategorie().getName()}</option>
            </c:if>
            <c:forEach items="${categories}" var="categorie">
                <c:if test="${product.getCategorie().getId() != categorie.getId()}">
                    <option value="${categorie.getId()}">${categorie.getName()}</option>
                </c:if>
            </c:forEach>
        </select>
    </div>


    <div class="form-group" id="images-inputs" seq="1">
        <label for="inputSigla" class="glyphicon-plus" id="add-image" style="cursor: pointer;font-size: 25"></label>
        <label for="inputSigla" class="">Imagens</label>
        <input class="images" id="image-1"  type="file" class="form-control"  placeholder="Adicionar Imagem">
        <br/>
    </div>

    <button type="submit" class="btn btn-primary">Salvar</button>
</form>
<script type="text/javascript" src="product-form.js"></script>
