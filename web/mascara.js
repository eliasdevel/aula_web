function mascara(i, t) {

    var v = i.value;

    if (isNaN(v[v.length - 1])) {
        i.value = v.substring(0, v.length - 1);
        return;
    }

    if (t == "data") {
        i.setAttribute("maxlength", "10");
        if (v.length == 2 || v.length == 5)
            i.value += "/";
    }

    if (t == "cpf") {
        i.setAttribute("maxlength", "14");
        if (v.length == 3 || v.length == 7)
            i.value += ".";
        if (v.length == 11)
            i.value += "-";
    }

    if (t == "cnpj") {
        i.setAttribute("maxlength", "18");
        if (v.length == 2 || v.length == 6)
            i.value += ".";
        if (v.length == 10)
            i.value += "/";
        if (v.length == 15)
            i.value += "-";
    }

    if (t == "cep") {
        i.setAttribute("maxlength", "9");
        if (v.length == 5)
            i.value += "-";
    }

    if (t == "tel") {
        if (v[0] == 9) {
            i.setAttribute("maxlength", "10");
            if (v.length == 5)
                i.value += "-";
        } else {
            i.setAttribute("maxlength", "9");
            if (v.length == 4)
                i.value += "-";
        }
    }
}
validForm = false;
function confirmPassword(i) {
    if (i.value != document.getElementById("password").value) {
        if (!document.getElementById("for_password_error")) {
            $("#password").parent().append("<p id='for_password_error' style='color:red'>Senha Inconsistente</p>");
        }
        $("form").attr('onsubmit', 'return false;');

    } else {
        $("form").attr('onsubmit', 'return true;');
        $("#for_password_error").remove();
    }

}

