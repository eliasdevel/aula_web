<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<nav class="topBar">
    <div class="container">
        <ul class="list-inline pull-left hidden-sm hidden-xs">
            <!--<li><span class="text-primary">duvidas? ligue </span> Call +120 558 7885</li>-->
        </ul>
        <ul class="topBarNav pull-right">


            <li class="dropdown pull-left">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="false"> <i class="fa fa-user mr-5"></i><span class="hidden-xs">Minha Conta<i class="fa fa-angle-down ml-5"></i></span> </a>
                <ul class="dropdown-menu w-150" role="menu">

                    <c:if test="${clientData.getId() >0}">
                        <li><b><a>Olá <c:out value = "${clientData.getName()}"/></a></b>
                        </li>
                    </c:if>
                    <c:if test="${clientData.getId() < 1}">
                        <li><a href="?p=Login">Login</a>
                        </li>
                        <li><a href="?p=CreateAccount">Criar Conta</a>
                        </li>
                    </c:if>

                    <li class="divider"></li>
                    <li><a href="?p=MyCart">Meu Carrinho</a>
                    </li>
                    <li><a href="checkout.html">Checkout</a>
                    </li>
                    <c:if test="${clientData != null}">
                        <li><b><a href="?p=Logout">Sair</a></b>
                        </li>
                    </c:if>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="false"> <i class="fa fa-shopping-basket mr-5"></i> <span class="hidden-xs">
                        Carrinho<sup class="text-primary">(<c:out value = "${cartProducts.size()}"/>)</sup>
                        <i class="fa fa-angle-down ml-5"></i>
                    </span> </a>
                <ul class="dropdown-menu cart w-250" role="menu">
                    <li>
                        <div class="cart-items">
                            <ol class="items">

                                <c:forEach items = "${cartProducts}"  var = "prod">
                                    <li>
                                        <a class="prd-cart-img" ><img prd_id="<c:out value = "${prod.getId()}"/>" style="display: none"  src="data:image/png;base64, <c:out value = "${prod.getImages()[0].getBase64Data()}"/>" ></a> 
                                        <a class="product-image" href="?p=Productp&id=<c:out value = "${prod.getId()}"/>"><canvas id="prd-cart-canvas-<c:out value = "${prod.getId()}"/>"></canvas></a> 
                                        <div class="product-details">
                                            <div class="close-icon"> <a href="?p=RemoveFromCart&id=<c:out value = "${prod.getId()}"/>"><i class="fa fa-close"></i></a> </div>
                                            <p class="product-name"> <a href="#"><c:out value = "${prod.getName()}"/></a> </p> <strong><c:out value = "${cartNumbers.get(prod.getId())}"/></strong> x <span class="price text-primary"><c:out value = "${prod.getPrice()}"/>R$</span> </div>
                                        <!-- end product-details -->
                                    </li>
                                    <!-- end item -->
                                </c:forEach>
                            </ol>
                        </div>
                    </li>
                    <li>
                        <div class="cart-footer"> 
                            <a href="#" class="pull-left"><i class="fa fa-cart-plus mr-5"></i>Ver Carrinho</a> 
                            <a href="#" class="pull-right"><i class="fa fa-shopping-basket mr-5"></i>Checkout</a> 
                        </div>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav><!--=========-TOP_BAR============-->

<!--=========MIDDEL-TOP_BAR============-->

<div class="middleBar">
    <div class="container">
        <div class="row display-table">
            <!-- end col -->
            <div class="col-sm-7 vertical-align ">
                <form>
                    <div class="row grid-space-1">
                        <div class="col-sm-6">
                            <input type="text" name="keyword" value="<c:out value = "${searchValues.get('keyword')}"/>" class="form-control input-lg" placeholder="Buscar">
                        </div>
                        <!-- end col -->
                        <div class="col-sm-3">
                            <select class="form-control input-lg" name="category">
                                <option value="">Todas</option>
                                <c:if test="${category != null}">
                                    <option value="${category.getId()}" selected>${category.getName()}</option>
                                </c:if>
                                <c:forEach items = "${categories}"  var = "categori">
                                    <c:if test="${categori.getId() != category.getId()}">
                                        <option value="<c:out value = "${categori.getId()}"/>"><c:out value = "${categori.getName()}"/></option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                        <!-- end col -->
                        <div class="col-sm-3">
                            <input type="submit" class="btn btn-default btn-block btn-lg" value="Search">
                        </div>
                        <!-- end col -->
                    </div>
                    <!-- end row -->
                </form>
            </div>
            <!-- end col -->

            <!-- end col -->
        </div>
        <!-- end  row -->
    </div>
</div>

<nav class="navbar navbar-main navbar-default" role="navigation" style="opacity: 1;">
    <div class="container">
        <!-- Brand and toggle -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>             
        </div>
        <!-- Collect the nav links,  -->
        <div class="collapse navbar-collapse navbar-1" style="margin-top: 0px;">            
            <ul class="nav navbar-nav">
                <li><a href="?p=Home" >Home</a></li>
                <li class="dropdown megaDropMenu">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="false">Menu <i class="fa fa-angle-down ml-5"></i></a>
                    <ul class="dropdown-menu dropdown-menu-left">
                        <li><a href="?p=About">Sobre</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div>
</nav>