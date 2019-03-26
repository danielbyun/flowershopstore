$(document).ready(function () {
    // side navbar
    $('.sidenav').sidenav();

    // carousel
    $('.carousel.carousel-slider').carousel({
        fullWidth: true,
        indicators: true,
        duration: 200
    });

    // select
    $('select').formSelect();

    // dropdown
    $('.dropdown-trigger').dropdown();

    // tabs
    $('.tabs').tabs();

    // datatable
    $("#flowerListTable").DataTable({
        "lengthMenu": [[5, 10, 15, 20, -1], [5, 10, 15, 20, "display all"]],
        "ordering": false,
        stateSave: true
    });

    //initialize all modals
    $('.modal').modal({
        dismissible: true
    });

//call the specific div (modal)
    $('.delete-flower').modal();
});
