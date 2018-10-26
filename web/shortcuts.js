$(document).ready(function () {
    var keya = 0;
    document.onkeydown = function (e) {
        keya = e.which;

    }

    document.onkeyup = function (e) {

        if (e.which == 80) {

            var checkattr = $("#adv-search .dropdown-toggle").attr('aria-expanded');
            if ((checkattr == 'false') == true) {
                $("#adv-search .dropdown-toggle").attr("aria-expanded", "true");
                $("#adv-search .dropdown").addClass("open");
                $("#adv-search .form-control").focus();
            }

        }



    }
});