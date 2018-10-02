$(document).ready(function () {
    function encodeImage(imageUri, callback) {
        var c = document.createElement('canvas');
        var ctx = c.getContext("2d");
        var img = new Image();
        img.onload = function () {
            c.width = this.width;
            c.height = this.height;
            ctx.drawImage(img, 0, 0);
            var dataURL = c.toDataURL("image/jpeg");
            callback(dataURL)
        };
        img.src = imageUri;
    }
    $(".images").change(function () {
        imageId = $("#images-inputs").attr('seq');
        nextId = parseInt($("#images-inputs").attr('seq')) + 1;
        $("#images-inputs").attr('seq', nextId);
        var file = document.getElementById('image-1').files[0];
        if (file) {
            // create reader
            var reader = new FileReader();
            reader.readAsBinaryString(file);
            reader.onload = function (e) {
                // browser completed reading file - display it
                $("#images-inputs").append("<img width='80px' style ='margin-right:10px' src ='data:image/png;base64, " + btoa(e.target.result) + "'> ");
                $("#images-inputs").append('<input name ="images-hd[]" type="hidden" value = "' + btoa(e.target.result) + '">')
            };
        }
    });
    $("#product-form").submit(function () {
        var file = document.getElementById('image-1').files[0];
        if (file) {
            // create reader
            var reader = new FileReader();
            reader.readAsBinaryString(file);
            reader.onload = function (e) {
                // browser completed reading file - display it
                alert(btoa(e.target.result));
            };
        }
    });
});