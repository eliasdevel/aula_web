$(document).ready(function () {
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

