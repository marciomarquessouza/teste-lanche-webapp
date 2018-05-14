$(document).ready(function() {

    //Envia o formulário do Item
    $("#itemForm").submit(function(event) {

        event.preventDefault();
        ajaxPost();

    });

    function ajaxPost() {

        var formData = {
            code : $("#code").val(),
            description : $("#description").val(),
            price : $("#price").val(),
            imageUrl : $("#imageUrl").val()
        }

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : window.location + "/api/save",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
                if(result.status == "Done") {
                    $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                    												"Post Successfully! <br>" +
                    												"---> Item's Info: Code = " + result.data.code +
                    												" ,description = " + result.data.description +
                    												" ,price = " + result.data.price +
                    												" ,imageUrl = " + result.data.imageUrl +
                    												"</p>");

                }else{
                    $("#postResultDiv").html("<strong>Error</strong>");
                }
                console.log(result);
            },
            error : function(e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });

        resetData();

    }

    function resetData(){
        $("#code").val("");
        $("#description").val("");
        $("#price").val("");
        $("#imageUrl").val("");
    }
})