<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="trago-toolbar" style="margin-left: 0px" class="row" >
    <div class="col-md-12">
        <a class="glyphicon glyphicon-plus" title="Novo Cadastro" href="?p=<c:out value = "${savePage}"/>"> </a>
        <div class="input-group" id="adv-search" style="float:right;margin-left:100px;">
         
            <div class="input-group-btn ">
                <div class="btn-group" role="group" style="float: right">
                    <div class="dropdown dropdown-lg ">
                        <button title="Pesquisa"type="button" class="btn btn-default glyphicon glyphicon-search" data-toggle="dropdown" aria-expanded="false"></button>
                        <div class="dropdown-menu dropdown-menu-right" role="menu">
                            <form class="form-horizontal" accept-charset="UTF-8" role="form" >
                                <input type='hidden' name ='p' value="<c:out value = "${page}"/>"/>
                                <c:forEach items="${searchColumns}" var="search">
                                    <div class="form-group">
                                        <label for="contain"><c:out value="${search.value}"/></label>
                                        <input  class="form-control input-clearable" name = "<c:out value="${search.key}"/>"  value = '<c:out value="${searchValues.get(search.key)}"/>' type="text" />
                                    </div>
                                </c:forEach>
                                <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                                <button type="submit" onclick='$(".input-clearable").val("");' class="btn btn-primary"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span></button>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
