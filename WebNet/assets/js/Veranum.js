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
            "ctl00$ContentPlaceHolder1$txtContraseña": {
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


    var precioServicios = 0;
    var precioHabitaciones = 0;
    var dias = 0;
    var totalxdias = 0;
    var total = 0;


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
            calcularPrecios();
        }
    });

    $('input[id$="txtFechaSalida"]').datepicker({
        dateFormat: 'dd/mm/yy',
        changeMonth: true,
        changeYear: true,
        minDate: "+1d",
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
            calcularPrecios();
        }
    });


    $('input[id$="btnSeguir"]').click(function (e) {
        e.preventDefault();
        $('html,body').animate({
            scrollTop: $("#pasodos_reserva").offset().top
        }, 'slow');


        var fecha1 = $('input[id$="txtFechaIngreso"]').val();
        var fecha2 = $('input[id$="txtFechaSalida"]').val();
        var idhotel = $('select[id$="cbHoteles"]').val();
        var cant = $('select[id$="cbCantPersonas"]').val();

        var jsonData = JSON.stringify({ fecha1: fecha1, fecha2: fecha2, idhotel: idhotel, cant: cant });

        $.ajax({
            type: "POST",
            url: "getHabitacionesDisponibles.asmx/getHabs",
            data: jsonData,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: OnSuccess,
            error: OnErrorCall
        });

        function OnSuccess(response) {
            $('#habdisponibles').html("");
            var data = JSON.parse(response.d);
            if (data == null) {
                $('#nohabs').show();
                $('#pasodos_reserva').hide();
            } else {
                var count = data.length;
                $('#nohabs').hide();
                $('#pasodos_reserva').show();
                var html = "";
                $('#cantHabs').html(count);
                $.each(data, function (index, val) {
                    html += '<div class="grid_3">';
                    html += '    <div class="wow fadeInLeft animated cajahab" data-wow-delay="0.5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">';
                    html += '        <div class="block-4_s6">';
                    html += '            <h5 class=" text-3 color-1 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp; text-shadow: 1px 1px 5px #000">' + val.nombre + '</h5>';
                    html += '            <div class="block-4_s6_item">';
                    html += '                <hr />';
                    html += '                <div class="wrap-box__none">';
                    html += '                    <div class="text-5">#' + val.ubicacion + ' | ' + val.cant_personas + ' personas max.</div>';
                    html += '                    <div class="text-5"><span class="color-5 text__bold">$' + val.precio + ' </span> / Noche</div>';
                    html += '                </div>';
                    html += '                <input type="checkbox" style="width: 40px; height:40px;" data-precio="' + val.precio + '" class="mihabsselecteds" name="habitaciones" id="habitacion-' + val.id_habitacion + '" value="' + val.id_habitacion + '"><br>Elegir';
                    html += '            </div>';
                    html += '        </div>';
                    html += '    </div>';
                    html += '</div>';
                });
                $('#habdisponibles').append(html);
                reDOM();
            }

        }
        function OnErrorCall(response) {
            $('#nohabs').show();
        }
    });

    function calcularPrecios() {
        totalxdias = parseInt(precioHabitaciones) + parseInt(precioServicios);
        total = parseInt(totalxdias) * parseInt(dias);
        $('#totalxdias').html(totalxdias);
        $('#total').html(total);
    }

    function reDOM() {
        $('.mihabsselecteds').change(function () {
            if ($('input[name=habitaciones]:checked').length == 0) {
                $('#goPasoTres').attr("disabled", "disabled");
                $('#pasotres_servicios').hide();
            } else
                $('#goPasoTres').removeAttr("disabled");


            if ($(this).is(':checked')) {
                precioHabitaciones += $(this).data('precio');
            } else {
                precioHabitaciones -= $(this).data('precio');
            }
            calcularPrecios();

        });

        $('.miservicios').change(function () {
            if ($(this).is(':checked')) {
                precioServicios += $(this).data('precio');
            } else {
                precioServicios -= $(this).data('precio');
            }

            calcularPrecios();
        });
    }

    $('#goPasoTres').click(function (e) {
        e.preventDefault();
        $('#pasotres_servicios').show();
        $('html,body').animate({
            scrollTop: $("#pasotres_servicios").offset().top
        }, 'slow');

        $.ajax({
            type: "POST",
            url: "getHabitacionesDisponibles.asmx/getServicios",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: OnSuccess,
            error: OnErrorCall
        });

        function OnSuccess(response) {
            $('#serviciosDisp').html("");
            var html = "";
            var data = JSON.parse(response.d);
            $.each(data, function (index, val) {
                html += '<div class="grid_3" style="margin-top: 5px;">';
                html += '    <div class="wow fadeInLeft animated cajahotel" data-wow-delay="0.5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">';
                html += '        <div class="block-4_s6">';
                html += '            <h5 class=" text-3 wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">' + val.nombre + '</h5>';
                html += '            <div class="block-4_s6_item">';
                html += '                <div class="wrap-box__left"></div>';
                html += '                <div class="wrap-box__none">';
                html += '                    <div class="text-5"><span class="color-1 text__bold">$' + val.precio + '</span> / Uso</div>';
                html += '                </div>';
                html += '                <input type="checkbox" style="width: 40px; height:40px;" class="miservicios" data-precio="' + val.precio + '" name="servicios" id="servicios-' + val.id_servicio + '" value="' + val.id_servicio + '"><br>Elegir';
                html += '            </div>';
                html += '        </div>';
                html += '    </div>';
                html += '</div>';
            });
            $('#serviciosDisp').append(html);
            reDOM();

        }
        function OnErrorCall(response) {
            $('#nohabs').show();
        }

    });



    $('input[id$="btnReservar"]').click(function (e) {
        e.preventDefault();

        var habitaciones = $('input[name=habitaciones]:checked').map(function () {
            return $(this).val();
        }).toArray();

        var servicios = $('input[name=servicios]:checked').map(function () {
            return $(this).val();
        }).toArray();

        var fecha1 = $('input[id$="txtFechaIngreso"]').val();
        var fecha2 = $('input[id$="txtFechaSalida"]').val();
        var idhotel = $('select[id$="cbHoteles"]').val();
        var cant = $('select[id$="cbCantPersonas"]').val();


        var jsonData = JSON.stringify({ fecha1: fecha1, fecha2: fecha2, total: total, idhotel: idhotel, cant: cant, habitaciones: habitaciones, servicios: servicios });
        console.log(jsonData);
        $.ajax({
            type: "POST",
            url: "guardarReserva.asmx/guardar",
            data: jsonData,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: OnSuccess,
            error: OnErrorCall
        });

        function OnSuccess(response) {
            var data = response.d;
            if (data == 0) {
                alert("Ha ocurrido un error, intente de nuevo.");
            } else {
                alert("Tu reserva ha sido creada. El identificador de tu reserva es #" + data + ". Ahora serás redireccionado a tus reservas");
                window.location = "misreservas.aspx";
            }
        }
        function OnErrorCall(response) { console.log(response); }
    });

});