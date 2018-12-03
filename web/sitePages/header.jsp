<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<nav class="topBar">
    <div class="container">
        <ul class="list-inline pull-left hidden-sm hidden-xs">
            <!--<li><span class="text-primary">duvidas? ligue </span> Call +120 558 7885</li>-->
        </ul>
        <ul class="topBarNav pull-right">


            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="false"> <i class="fa fa-user mr-5"></i><span class="hidden-xs">Minha Conta<i class="fa fa-angle-down ml-5"></i></span> </a>
                <ul class="dropdown-menu w-150" role="menu">
                    <li><a href="login.html">Login</a>
                    </li>
                    <li><a href="register.html">Criar Conta</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="wishlist.html">Lista de Desejos</a>
                    </li>
                    <li><a href="cart.html">Meu Carrinho</a>
                    </li>
                    <li><a href="checkout.html">Checkout</a>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="false"> <i class="fa fa-shopping-basket mr-5"></i> <span class="hidden-xs">
                        Carrinho<sup class="text-primary">(3)</sup>
                        <i class="fa fa-angle-down ml-5"></i>
                    </span> </a>
                <ul class="dropdown-menu cart w-250" role="menu">
                    <li>
                        <div class="cart-items">
                            <ol class="items">
                                <li>
                                    <a href="#" class="product-image">   </a>
                                    <div class="product-details">
                                        <div class="close-icon"> <a href="#"><i class="fa fa-close"></i></a> </div>
                                        <p class="product-name"> <a href="#">Sumi9xm@gmail.com</a> </p> <strong>1</strong> x <span class="price text-primary">$59.99</span> </div>
                                    <!-- end product-details -->
                                </li>
                                <!-- end item -->
                                <li>
                                    <a href="#" class="product-image"> <img src="https://lh3.googleusercontent.com/-Gy3KAlilHAw/WNf7a2eL5YI/AAAAAAAAD2Y/V3jUt14HiZA3HLpeOKkSaOu57efGuMw9ACL0B/w245-d-h318-n-rw/shoes_01.jpg" class="img-responsive" alt="Sample Product "> </a>
                                    <div class="product-details">
                                        <div class="close-icon"> <a href="#"><i class="fa fa-close"></i></a> </div>
                                        <p class="product-name"> <a href="#">Lorem Ipsum dolor sit</a> </p> <strong>1</strong> x <span class="price text-primary">$39.99</span> </div>
                                    <!-- end product-details -->
                                </li>
                                <!-- end item -->
                                <li>
                                    <a href="#" class="product-image"> <img src="https://lh3.googleusercontent.com/-ydDc-0L0WFY/WNf7a6Awe_I/AAAAAAAAD2Y/I8IzJtYRWegkOUxCZ5SCK6vbdiiSxVsCQCL0B/w245-d-h318-n-rw/bags_07.jpg" class="img-responsive" alt="Sample Product "> </a>
                                    <div class="product-details">
                                        <div class="close-icon"> <a href="#"><i class="fa fa-close"></i></a> </div>
                                        <p class="product-name"> <a href="#">Lorem Ipsum dolor sit</a> </p> <strong>1</strong> x <span class="price text-primary">$29.99</span> </div>
                                    <!-- end product-details -->
                                </li>
                                <!-- end item -->
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
                                <option value="all">All Categories</option>
                                <optgroup label="Mens">
                                    <option value="shirts">Shirts</option>
                                    <option value="coats-jackets">Coats & Jackets</option>
                                    <option value="underwear">Underwear</option>
                                    <option value="sunglasses">Sunglasses</option>
                                    <option value="socks">Socks</option>
                                    <option value="belts">Belts</option>
                                </optgroup>
                               
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