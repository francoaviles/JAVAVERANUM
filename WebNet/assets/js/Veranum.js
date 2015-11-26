$(document).ready(function () {
    //----------------WOW ini-----------------
    if ($('html').hasClass('desktop')) {
        new WOW().init();
    }
    else { $('.wow').css('visibility', 'visible'); }

    $(".scrollbar").mCustomScrollbar({
        scrollButtons: { enable: false },
        alwaysShowScrollbar: 1,
        setHeight: "502"
    });

    $(".registroForm").validate({
        rules: {
            "ctl00$ContentPlaceHolder1$txtRut": {
                required: true
            },
            "ctl00$ContentPlaceHolder1$txtContraseña": {
                required: true
            },
            "ctl00$ContentPlaceHolder1$txtNombre": {
                required: true
            },
            "ctl00$ContentPlaceHolder1$txtApePa": {
                required: true
            },
            "ctl00$ContentPlaceHolder1$txtApeMa": {
                required: true
            },
            "ctl00$ContentPlaceHolder1$txtFechaNac": {
                required: true,
                date: true
            },
            "ctl00$ContentPlaceHolder1$txtTelefono": {
                required: true,
                number: true
            },
            "ctl00$ContentPlaceHolder1$txtDireccion": {
                required: true,
            },
            "ctl00$ContentPlaceHolder1$txtEmail": {
                required: true,
                email: true
            }
        }
    });

});