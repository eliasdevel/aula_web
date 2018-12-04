<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="pt" >
    <head>
        <link rel="shortcut icon" href="assets/favicon.ico" />
        <meta charset="UTF-8"> 
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title><c:out value = "Itrago- ${title}"/></title>
        <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="sitePages/assets/main.css" rel="stylesheet">
        <script src="jquery/jquery.js"></script>
        <script src="bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="mascara.js"></script>
    </head>
    <body>
        <c:import  url = "header.jsp"/>
        <div style="margin-top: 10px" class= "main" style="height:100%">
            <c:import  url = "${content}"/>
        </div>
    </body>


    <script type="text/javascript">
        !function ($, n, e) {
            var o = $();
            $.fn.dropdownHover = function (e) {
                return "ontouchstart" in document ? this : (o = o.add(this.parent()), this.each(function () {
                    function t(e) {
                        o.find(":focus").blur(), h.instantlyCloseOthers === !0 && o.removeClass("open"), n.clearTimeout(c), i.addClass("open"), r.trigger(a)
                    }
                    var r = $(this),
                            i = r.parent(),
                            d = {
                                delay: 100,
                                instantlyCloseOthers: !0
                            },
                            s = {
                                delay: $(this).data("delay"),
                                instantlyCloseOthers: $(this).data("close-others")
                            },
                            a = "show.bs.dropdown",
                            u = "hide.bs.dropdown",
                            h = $.extend(!0, {}, d, e, s),
                            c;
                    i.hover(function (n) {
                        return i.hasClass("open") || r.is(n.target) ? void t(n) : !0
                    }, function () {
                        c = n.setTimeout(function () {
                            i.removeClass("open"), r.trigger(u)
                        }, h.delay)
                    }), r.hover(function (n) {
                        return i.hasClass("open") || i.is(n.target) ? void t(n) : !0
                    }), i.find(".dropdown-submenu").each(function () {
                        var e = $(this),
                                o;
                        e.hover(function () {
                            n.clearTimeout(o), e.children(".dropdown-menu").show(), e.siblings().children(".dropdown-menu").hide()
                        }, function () {
                            var t = e.children(".dropdown-menu");
                            o = n.setTimeout(function () {
                                t.hide()
                            }, h.delay)
                        })
                    })
                }))
            }, $(document).ready(function () {
                $('[data-hover="dropdown"]').dropdownHover()
            })
        }(jQuery, this);
    </script>
</html>