$(document).ready(function () {
    // side navbar
    $('.sidenav').sidenav();

    // carousel
    $('.carousel.carousel-slider').carousel({
        fullWidth: true,
        indicators: true,
        duration: 200
    });

    // tabs
    $('.tabs').tabs();

    // dropdown
    $('.dropdown-trigger').dropdown();

    // select
    $('select').formSelect();

    // collapsible
    $('.collapsible.expandable').collapsible({
        accordion: false
    });
});
