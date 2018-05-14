$(document).ready(function() {

    //Busca os dados do Item
    $("#getAllItemId").click(function(event){
        event.preventDefault();
        ajaxGet();
    });

    function ajaxGet() {

        $.ajax({
            type : "GET",
            url : window.location + "/api/all",
            success: function(result){
                if(result.status == "Done") {

                    $('#getResultDiv ul').empty();

                    var itemList = "";

                    $.each(result.data, function(i, item){
                        var item = "Id = " + i +
                        ", code= " + item.code+
                        ", description= " + item.description +
                        ", price= " + item.price +
                        ", imageUrl = " + item.imageUrl +
                        "<br>";
                        $('#getResultDiv .list-group').append(item)
                    });

                    console.log("Success: ", result);

                }else{
                    $("#getResultDiv").html("<strong>Error</strong>");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                $("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }
})