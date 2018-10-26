<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="trago-toolbar" style="margin-left: 0px" class="row" >
    <div class="col-md-12">
        <div class="input-group" id="adv-search" style="float:right;margin-left:100px;">
            <input type="text" class="form-control" placeholder="Pesquisa" />
            <div class="input-group-btn">
                <div class="btn-group" role="group">
                    <div class="dropdown dropdown-lg">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="caret"></span></button>
                        <div class="dropdown-menu dropdown-menu-right" role="menu">
                            <form class="form-horizontal" role="form">
                                <input type='hidden' name ='p' value="<c:out value = "${page}"/>"/>
                                <c:forEach items="${searchColumns}" var="search">
                                    <div class="form-group">
                                        <label for="contain"><c:out value="${search.value}"/></label>
                                        <input class="form-control" name = "<c:out value="${search.key}"/>"  value = '<c:out value="${searchValues.get(search.key)}"/>' type="text" />
                                    </div>
                                </c:forEach>
                                <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                            </form>
                        </div>
                    </div>
                   
                </div>
            </div>
        </div>
    </div>
</div>
