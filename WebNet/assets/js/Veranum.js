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
                required: true,
                minlength: 8,
                maxlength: 15

            },
            "ctl00$ContentPlaceHolder1$txtContraseña": {
                required: true,
                minlength: 3,
                maxlength: 30
            },
            "ctl00$ContentPlaceHolder1$txtNombre": {
                required: true,
                minlength: 2,
                maxlength: 20
            },
            "ctl00$ContentPlaceHolder1$txtApePa": {
                required: true,
                minlength: 2,
                maxlength: 20
            },
            "ctl00$ContentPlaceHolder1$txtApeMa": {
                required: true,
                minlength: 2,
                maxlength: 20
            },
            "ctl00$ContentPlaceHolder1$txtFechaNac": {
                required: true,
                date: true,
                minlength: 8,
                maxlength: 20

            },
            "ctl00$ContentPlaceHolder1$txtTelefono": {
                required: true,
                number: true,
                minlength: 7,
                maxlength: 15
            },
            "ctl00$ContentPlaceHolder1$txtDireccion": {
                required: true,
                minlength: 5,
                maxlength: 50

            },
            "ctl00$ContentPlaceHolder1$txtEmail": {
                required: true,
                email: true,
                minlength: 3,
                maxlength: 50
            }
        }
    });

    $(".loginForm").validate({
        rules: {
            "ctl00$ContentPlaceHolder1$txtRut": {
                required: true,
                minlength: 8,
                maxlength: 15
            },
            "ctl00$ContentPlaceHolder1$txtContraseña":{
                required: true,
                minlength: 3,
                maxlength: 30
            }
        }
    });

});