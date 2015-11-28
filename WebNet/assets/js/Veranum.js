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

    $('input[id$="txtFechaNac"]').datepicker({
        dateFormat: "dd/mm/yy",
        yearRange: "-100:+0",
        maxDate: "-15y",
        minDate: "-100y",
        changeMonth: true,
        changeYear: true
    });

    $('input[id$="txtFechaIngreso"]').datepicker({
        dateFormat: 'dd/mm/yy',
        minDate: "+0d",
        changeMonth: true,
        changeYear: true,
        numberOfMonths: 1,
        onClose: function (selectedDate) {
            var date2 = $('input[id$="txtFechaIngreso"]').datepicker('getDate');
            date2.setDate(date2.getDate() + 1);
            $("#fecha_termino").datepicker("option", "minDate", date2);
            if ($('input[id$="txtFechaSalida"]').val().length <= 0)
                $('input[id$="txtFechaSalida"]').datepicker('setDate', date2);

            var date = $('input[id$="txtFechaIngreso"]').datepicker('getDate');
            var date2 = $('input[id$="txtFechaSalida"]').datepicker('getDate');
            dias = Math.ceil((date2 - date) / (1000 * 60 * 60 * 24));
            $('.dias_totales').html(dias);
        }
    });
    $('input[id$="txtFechaSalida"]').datepicker({
        dateFormat: 'dd/mm/yy',
        changeMonth: true,
        changeYear: true,
        minDate: "+2d",
        numberOfMonths: 1,
        onClose: function (selectedDate) {
            var date2 = $('input[id$="txtFechaSalida"]').datepicker('getDate');
            date2.setDate(date2.getDate() - 1);
            $('input[id$="txtFechaIngreso"]').datepicker("option", "maxDate", date2);
        },
        onSelect: function () {
            var date = $('input[id$="txtFechaIngreso"]').datepicker('getDate');
            var date2 = $('input[id$="txtFechaSalida"]').datepicker('getDate');
            dias = Math.ceil((date2 - date) / (1000 * 60 * 60 * 24));
            $('.dias_totales').html(dias);
        }
    });

});