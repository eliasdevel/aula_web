<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>     
<pre style="text-align: center">Cadastro de usuário, Preencha o formulário abaixo.</pre>
<div class ="col-md-10 col-lg-10" style="margin: 10px">
    <form  action="<c:out value = "${action}"/>" method="POST" >
        <div class="form-group">
            <label for="inputName">Nome</label>
            <input name ="name" required="true" value="<c:out value="${user.getName()}"/>" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="estadoHelp" placeholder="Nome">

        </div>
        <div class="form-group">
            <label for="inputSigla">E-mail</label>
            <input required="true" name ="email" value="<c:out value="${user.getEmail()}"/>" type="email" class="form-control" id="exampleInputPassword1" placeholder="E-mail">
        </div>
        <div class="form-group">
            <label for="inputSigla">Senha</label>
            <input required="true" id="password" name ="password" value="<c:out value="${user.getPassword()}"/>" type="password" class="form-control" id="exampleInputPassword1" placeholder="Senha">
        </div>
        <div class="form-group">
            <label for="inputSigla">Confirmar Senha</label>
            <input required="true" name ="confirm_password" onblur="confirmPassword(this)"  type="password" class="form-control" id="exampleInputPassword1" placeholder="Senha">
        </div>
        <div class="form-group">
            <label for="inputSigla">CPF</label>
            <input  required="true" name ="cpf" oninput="mascara(this, 'cpf')" c value="<c:out value="${user.getCpf()}"/>" type="text" class="cpf form-control" id="exampleInputPassword1" placeholder="Cpf">
        </div>

        <div class="form-group">
            <label for="exampleFormControlSelect1">Estado</label>
            <select required="true" class="form-control" id="exampleFormControlSelect1" name="state"  >
                <c:if test="${user != null}">
                    <option value="${user.getAddress().getCity().getState().getId()}" selected>${user.getAddress().getCity().getState().getName()}</option>
                </c:if>
                <c:forEach items="${states}" var="state">
                    <c:if test="${user.getAddress().getCity().getState().getId() != state.getId()}">
                        <option value="${state.getId()}">${state.getName()}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleFormControlSelect1">Cidade</label>
            <select class="form-control" id="exampleFormControlSelect1" name="city"  >
                <c:if test="${user != null}">
                    <option value="${user.getAddress().getCity().getId()}" selected>${user.getAddress().getCity().getName()}</option>
                </c:if>
                <c:forEach items="${citys}" var="city">
                    <c:if test="${user.getAddress().getCity().getId() != city.getId()}">
                        <option value="${city.getId()}">${city.getName()}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="inputSigla">Rua</label>
            <input name ="street" value="<c:out value="${user.getAddress().getStreet()}"/>" type="text" class="form-control" id="exampleInputPassword1" placeholder="Rua">
        </div>

        <div class="form-group">
            <label for="inputSigla">Cep</label>
            <input  name ="cep"   oninput="mascara(this, 'cep')" value="<c:out value="${user.getAddress().getCep()}"/>" type="text" class="form-control" id="exampleInputPassword1" placeholder="Cep">
        </div>


        <c:if test="${user != null}">
            <input type="hidden" name="address_id" value="<c:out value="${user.getAddress().getId()}" />">
        </c:if>
        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
</div>
        
        