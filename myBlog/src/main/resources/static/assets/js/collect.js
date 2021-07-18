new Vue().$mount('#app')

// $.ajax({
//     url:"http://" + window.location.host + "/blogs/isCollect",
//     type:"post",
//     data:{
//     }
//     }
// )
var jsonStr_1={"blogId":parseInt(document.getElementById("blogId").innerHTML),"userId":document.getElementById("userId").innerHTML,"tagId":1,"collectnumber":0};
console.log(jsonStr_1)
$.ajax({
        url: "http://" + window.location.host + "/blogs/isCollect",
        type: 'get',
        contentType: 'application/json',
        dataType: 'json',
        data: jsonStr_1,
        success: function (o)
        {
            var o1 = document.getElementById("collectnum");
            var c1 = o1.innerHTML;
            var o2= document.getElementById("collectCount");
            o2.innerHTML=c1;

            $(document).ready(function()
            {
                // var stat=o.IsLiked;
                var element=document.getElementById("btn_collect_icon")
                if(o.isCollect===false)
                {
                    //没有收藏
                    element.removeClass("el-icon-star-off el-icon-star-on");
                    element.addClass("el-icon-star-off");
                    element.setAttribute("rel","uncollect");

                }
                else{
                    //已经收藏
                    element.removeClass("el-icon-star-off el-icon-star-on");
                    element.addClass("el-icon-star-on");
                    element.setAttribute("rel","collect");
                }

                $("#btn_collect").click(function()
                {
                    var A=$(this).attr("id");
                    $("#btn_collect").click(function() {
                            {
                                var A = $(this).attr("id");
                                var B = A.split("like");
                                var messageID = B[1];
                                var C = parseInt($("#collectCount" + messageID).html());
                                $(this).css("background-position", "")
                                var D = $(this).attr("rel");
                                if (D === 'collect') {
                                    $("#collectCount" + messageID).html(C + 1);

                                    // $(this).addClass("heartAnimation").attr("rel","unlike");
                                    element.removeClass("el-icon-star-off el-icon-star-on");
                                    element.addClass("el-icon-star-off");
                                    element.setAttribute("rel", "uncollect");
                                    jsonStr_1.collectnumber = parseInt(C + 1);
                                    $.ajax({
                                        url: "http://" + window.location.host + "/blogs/collect",
                                        type: 'get',
                                        contentType: 'application/json',
                                        dataType: 'json',
                                        data: jsonStr_1,
                                        success: function () {

                                        }
                                    })

                                } else {
                                    $("#collectCount" + messageID).html(C - 1);
                                    // $(this).removeClass("heartAnimation").attr("rel","like");
                                    element.removeClass("el-icon-star-off el-icon-star-on");
                                    element.addClass("el-icon-star-on");
                                    element.setAttribute("rel", "collect");
                                    $(this).css("background-position", "left");
                                    jsonStr_1.likenumber = parseInt(C - 1);
                                    $.ajax({
                                        url: "http://" + window.location.host + "/blogs/cancelCollect",
                                        type: 'get',
                                        contentType: 'application/json',
                                        dataType: 'json',
                                        data: jsonStr_1,
                                        success: function () {

                                        }
                                    })
                                }
                            }
                        }
                    )
                });
            });
        }
    }
);