<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:if test="${noResult != null}">
    <pre class="center-block " style="text-align: center" >Nenhum registro encontrado para esta pesquisa!</pre>
</c:if>

<div id ="product-list-div" style="margin: 20px">
    <c:import  url = "product-interaction.jsp"/>
</div>
<script type="text/javascript">
    function resizeProducts() {
        $("img").ready(function () {


            $(".product-link img").each(function (index) {

                var canvas = document.getElementById("canvas_" + $(this).attr('prd_id'));
                var img = new Image;
                img.src = $(this).attr('src');
                var ctx = canvas.getContext("2d");
                var cw = canvas.width;
                var ch = canvas.height;
                var maxW = 300;
                var maxH = 300;
                var iw = img.width;
                var ih = img.height;
                var scale = Math.min((maxW / iw), (maxH / ih));
                var iwScaled = iw * scale;
                var ihScaled = ih * scale;
                canvas.width = iwScaled;
                canvas.height = ihScaled;
                ctx.drawImage(img, 0, 0, iwScaled, ihScaled);
                $(this).parent().remove();

            });
        });
    }
    $(window).scroll(function () {
        var oft =1;
        if ($(window).scrollTop() + $(window).height() > $(document).height() - 100) {
            $.ajax({
                method: "GET",
                cache: false,
                url: "?p=ClearProductList",
                dataType: 'html',
                data: {keyword: $("input[name^=keyword]").val(), category: $("input[name^=category]").val(),offset:oft}
            }).done(function (msg) {
                $("#product-list-div").append(msg);
                $(".product-link img").each(function (index) {
                    $.getScript("sitePages/resize.js");


                });
                oft++;
            });
        }
    })







</script>
