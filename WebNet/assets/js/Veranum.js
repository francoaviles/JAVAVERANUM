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
            }
        }
    });

});