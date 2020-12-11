$(document).ready(function(){
    //Ajax send request to load data
    $('.student').on("click", function(){
        // Gọi ajax đổ dữ liệu ra div main content
        $.ajax({
            method: "get", // gửi request bằng phương thức gì
            url:    "student_list.html", // gửi đi đâu
            // các trạng thái
            success: function(data){ // data trả về nếu request ok
                $('.main_content .title').css("display","none")
                $('.main_content').html(data); // đổ dữ liệu
            },
            error:   function(er){

            }
        });
    });
});