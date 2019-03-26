// disable billing address inputs when option is clicked to use the same address
// function checkBillingAddress() {
//     if ($("#theSameAsShippingAddress").is(":checked")) {
//         $(".billingAddress").prop("disabled", true);
//     } else {
//         $(".billingAddress").prop("disabled", false);
//     }
// }

$("#theSameAsShippingAddress").change(function () {
    // disable select / option also
    if (this.checked) {
        $(".billingAddress").prop("disabled", true);
        $(".billingState .select-dropdown").prop("disabled", true);
    } else {
        $(".billingAddress").prop("disabled", false);
        $(".billingState .select-dropdown").prop("disabled", false);
    }
});

// detect quantity change (shopping cart)
$('.cartItemQty').change(function () {
    let id = this.id;

    // $('#update-item-' + id).style.display = "flex-inline";
    $('#update-item-' + id).css('display', 'inline');
});

function checkPasswordMatch() {
    let password = $("#newPassword").val();
    let confirmPassword = $("#confirmNewPassword").val();

    if (password === "" && confirmPassword === "") {
        $("#checkPasswordMatch").html("");
        $("updateUserInfoButton").prop("disabled", false);
    } else {
        if (password !== confirmPassword) {
            $("#checkPasswordMatch").html("passwords do not match");
            $("#updateUserInfoButton").prop("disabled", true);
        } else {
            $("#checkPasswordMatch").html("passwords match");
            $("#updateUserInfoButton").prop("disabled", false);
        }
    }
}

$(document).ready(function () {
    $("#newPassword").keyup(checkPasswordMatch());
    $("#confirmNewPassword").keyup(checkPasswordMatch());
});

let flowerList = $("#flowerList");
$(flowerList).DataTable({
    "lengthMenu": [[5, 10, 15, 20, -1], [5, 10, 15, 20, "all"]],
    "ordering": false,
    stateSave: true
});

$(flowerList).on('page.dt', function () {
    $('html, body').animate({
        scrollTop: $('#flowerList').offset().top
    }, 500);
});