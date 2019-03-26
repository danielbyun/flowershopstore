$(document).ready(function () {
// delete functions
    $(".delete-flower").on('click', function () {
        // inline javascript thymeleaf

        /*<![CDATA[*/
        let path = /*[[@{/}]]*/'remove';
        /*]]>*/

        // delete
        let id = $(this).attr('id');

        console.log("deleting a flower, " + id);

        if (window.confirm("are you sure? you want to delete this product? this can't be undone.")) {
            $.post(path, {'id': id}, function (res) {
                console.log(res);
                location.reload();
            });
        }
    });

    $("#deleteSelected").click(function () {
        let idList = $('.checkboxFlower');
        let flowerIdList = [];
        for (let i = 0; i < idList.length; i++) {
            if (idList[i].checked === true) {
                flowerIdList.push(idList[i]['id']);
            }
        }

        /*<![CDATA[*/
        let path = /*[[@{/}]]*/'removeList';
        /*]]>*/

        if (window.confirm("are you sure you want to remove all selected flowers? this can't be undone.")) {
            $.ajax({
                type: 'POST',
                url: path,
                data: JSON.stringify(flowerIdList),
                contentType: "application/json",
                success: function (result) {
                    console.log(result);
                    location.reload();
                },
                error: function (result) {
                    console.log(result);
                    location.reload();
                }
            })
        }
    });
    $("#selectAllFlowers").on("click", function () {
        if ($(this).prop('checked') === true) {
            $(".checkboxFlower").click();
        } else if ($(this).prop('checked') === false) {
            $(".checkboxFlower").click();
        }
    });
});