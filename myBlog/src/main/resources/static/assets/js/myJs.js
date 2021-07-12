//var basePath = [[${#httpServletRequest.getScheme() + "://" + #httpServletRequest.getServerName() + ":" + #httpServletRequest.getServerPort() + #httpServletRequest.getContextPath()}]];

//==== Utils ====
function getQueryVariable(variable)//根据variable获取url中的参数
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}
//====

//==== 加载分类 ====
function loadCSS()
{
    $.ajax({

        url: 'http://localhost:8080/classify', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"class":"CSS"}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            if(data != null){
                var a = JSON.parse(data);
                alert(a.test);
                $("#test").attr("href",a.test);//成功改写标签里面的属性值 从而可以依靠返回的json数据动态修改前端的值
            }
            //window.location.href = 'http://localhost:8080/mainpage';
            //这里是如果成功的将数据传递之后做的操作 可以写alert和跳转语句 根据情况进行书写就写
        }
    });
}

function loadCPP()
{
    $.ajax({

        url: 'http://localhost:8080/classify', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"class":"C++"}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            if(data != null){
                var a = JSON.parse(data);
                alert(a.test);
                $("#test").attr("href",a.test);//成功改写标签里面的属性值 从而可以依靠返回的json数据动态修改前端的值
            }
            //window.location.href = 'http://localhost:8080/mainpage';
            //这里是如果成功的将数据传递之后做的操作 可以写alert和跳转语句 根据情况进行书写就写
        }
    });
}

function loadJAVA()
{
    alert("go to ajax")
    $.ajax({

        url: 'http://localhost:8080/ajax', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"class":"JAVA"}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            if(data != null){
                var a = JSON.parse(data);
                alert(a.test);
                $("#test").attr("href",a.test);//成功改写标签里面的属性值 从而可以依靠返回的json数据动态修改前端的值
            }
            //window.location.href = 'http://localhost:8080/mainpage';
            //这里是如果成功的将数据传递之后做的操作 可以写alert和跳转语句 根据情况进行书写就写
        }
    });
}

function loadPYTHON()
{
    alert("go to ajax")
    $.ajax({

        url: 'http://localhost:8080/ajax', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"class":"PYTHON"}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            if(data != null){
                var a = JSON.parse(data);
                alert(a.test);
                $("#test").attr("href",a.test);//成功改写标签里面的属性值 从而可以依靠返回的json数据动态修改前端的值
            }
            //window.location.href = 'http://localhost:8080/mainpage';
            //这里是如果成功的将数据传递之后做的操作 可以写alert和跳转语句 根据情况进行书写就写
        }
    });
}

function loadOTHER()
{
    alert("go to ajax")
    $.ajax({

        url: 'http://localhost:8080/ajax', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"class":"OTHER"}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            if(data != null){
                var a = JSON.parse(data);
                alert(a.test);
                $("#test").attr("href",a.test);//成功改写标签里面的属性值 从而可以依靠返回的json数据动态修改前端的值
            }
            //window.location.href = 'http://localhost:8080/mainpage';
            //这里是如果成功的将数据传递之后做的操作 可以写alert和跳转语句 根据情况进行书写就写
        }
    });
}

function loadC()
{
    alert("go to ajax")
    $.ajax({

        url: 'http://localhost:8080/ajax', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"class":"C"}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            if(data != null){
                var a = JSON.parse(data);
                alert(a.test);
                $("#test").attr("href",a.test);//成功改写标签里面的属性值 从而可以依靠返回的json数据动态修改前端的值
            }
            //window.location.href = 'http://localhost:8080/mainpage';
            //这里是如果成功的将数据传递之后做的操作 可以写alert和跳转语句 根据情况进行书写就写
        }
    });
}

//====


//==== Dynamic show ====

function loadTheBlog()
{
    //alert("load the blog")
    urls = window.location.pathname;
    str = urls.split("/")
    //alert(str[2])
    $.ajax({

        url: 'http://localhost:8080/getTheBlogs', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"class":str[2]}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: false,

        success: function(data) {
            var blog = JSON.parse(data);
            $("#final").attr("id", "null")
            $("#comments").attr("id", "commentsNull")

            if (blog.noMore === "true") {
                alert(blog.noMore)
            } else {

                if (data != null) {

                    $("#null").after("<div class=\"post\" id =\"final\" >\n" +
                        "    <div class=\"post-heading\">\n" +
                        "        <div class=\"post-avature\">\n" +
                        "            <img src=\"http://localhost:8080/assets/images/avatars/avatar-6.jpg\" alt=\"\">\n" +
                        "        </div>\n" +
                        "        <div class=\"post-title\">\n" +
                        "            <h4 id = \"username\">  </h4>\n" +
                        "            <p> 5 <span> hrs</span> <i class=\"uil-users-alt\"></i> </p>\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <div class=\"post-btn-action\">\n" +
                        "            <span class=\"icon-more uil-ellipsis-h\"></span>\n" +
                        "            <div class=\"mt-0 p-2\" uk-dropdown=\"pos: top-right;mode:hover \">\n" +
                        "                <ul class=\"uk-nav uk-dropdown-nav\">\n" +
                        "                    <li><a href=\"#\"> <i class=\"uil-share-alt mr-1\"></i> Share</a> </li>\n" +
                        "                    <li><a href=\"#\"> <i class=\"uil-edit-alt mr-1\"></i> Edit Post </a></li>\n" +
                        "                    <li><a href=\"#\"> <i class=\"uil-comment-slash mr-1\"></i> Disable comments\n" +
                        "                        </a></li>\n" +
                        "                    <li><a href=\"#\"> <i class=\"uil-favorite mr-1\"></i> Add favorites </a>\n" +
                        "                    </li>\n" +
                        "                    <li><a href=\"#\" class=\"text-danger\"> <i class=\"uil-trash-alt mr-1\"></i>\n" +
                        "                            Delete </a></li>\n" +
                        "                </ul>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "\n" +
                        " <a id = \"link\">\n" +
                        "    <div class=\"post-description\">\n" +
                        "        <div class=\"fullsizeimg\">\n" +
                        "            <img src=\"http://localhost:8080/assets/images/post/img-1.jpg\" alt=\"\">\n" +
                        "        </div>\n" +
                        "        <div class=\"post-state-details\">\n" +
                        "            <div>\n" +
                        "                <img src=\"http://localhost:8080/assets/images/icons/reactions_like.png\" alt=\"\">\n" +
                        "                <img src=\"http://localhost:8080/assets/images/icons/reactions_love.png\" alt=\"\">\n" +
                        "                <p> 13 </p>\n" +
                        "            </div>\n" +
                        "            <p> 24 Comments</p>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        " </a>\n" +
                        "    <div class=\"post-state\">\n" +
                        "        <div class=\"post-state-btns\"> <i class=\"uil-thumbs-up\"></i><text id = \"likeNumber\">126</text><span> Liked </span>\n" +
                        "        </div>\n" +
                        "        <div class=\"post-state-btns\"> <i class=\"uil-heart\"></i> <text  id = \"commentNumber\">126</text> <span> Coments</span>\n" +
                        "        </div>\n" +
                        "        <div class=\"post-state-btns\" > <i class=\"uil-share-alt\"></i> <text  id = \"forwardNumber\">126</text> <span> Shared\n" +
                        "            </span>\n" +
                        "        </div>\n" +
                        "        <div class=\"post-state-btns\" > <i class=\"uil-bookmark\"></i> <text  id = \"saveNumber\">126</text> <span> Saved </span>\n" +
                        "        </div>\n" +
                        "    </div>\n" +

                        "    <!-- post comments -->\n" +
                        "    <div class=\"post-comments\">\n" +
                        "        <a href=\"#\" class=\"view-more-comment\"   id = \"commentsNull\"> Veiw 8 more Comments</a>\n" +
                        "        <div class=\"post-comments-single\">\n" +
                        "            <div class=\"post-comment-avatar\">\n" +
                        "                <img src=\"http://localhost:8080/assets/images/avatars/avatar-5.jpg\" alt=\"\">\n" +
                        "            </div>\n" +
                        "            <div class=\"post-comment-text\">\n" +
                        "                <div class=\"post-comment-text-inner\">\n" +
                        "                    <h6> Alex Dolgove</h6>\n" +
                        "                    <p> Ut wisi enim ad minim laoreet dolore magna aliquam erat </p>\n" +
                        "                </div>\n" +
                        "                <div class=\"uk-text-small\">\n" +
                        "                    <a href=\"#\" class=\"text-danger mr-1\"> <i class=\"uil-heart\"></i> Love\n" +
                        "                    </a>\n" +
                        "                    <a href=\"#\" class=\" mr-1\"> Replay </a>\n" +
                        "                    <span> 1d</span>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "            <a href=\"#\" class=\"post-comment-opt\"></a>\n" +
                        "        </div>\n" +
                        "        <div class=\"post-comments-single\">\n" +
                        "            <div class=\"post-comment-avatar\">\n" +
                        "                <img src=\"http://localhost:8080/assets/images/avatars/avatar-2.jpg\" alt=\"\">\n" +
                        "            </div>\n" +
                        "            <div class=\"post-comment-text\">\n" +
                        "                <div class=\"post-comment-text-inner\">\n" +
                        "                    <h6>Stella Johnson</h6>\n" +
                        "                    <p> Ut wisi enim ad minim laoreet dolore <strong> David !</strong> </p>\n" +
                        "                </div>\n" +
                        "                <div class=\"uk-text-small\">\n" +
                        "                    <a href=\"#\" class=\"text-primary mr-1\"> <i class=\"uil-thumbs-up\"></i>\n" +
                        "                        Like\n" +
                        "                    </a>\n" +
                        "                    <a href=\"#\" class=\" mr-1\"> Replay </a>\n" +
                        "                    <span> 2d</span>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "            <a href=\"#\" class=\"post-comment-opt\"></a>\n" +
                        "        </div>\n" +
                        "        <div class=\"post-comments-single\">\n" +
                        "            <div class=\"post-comment-avatar\">\n" +
                        "                <img src=\"http://localhost:8080/assets/images/avatars/avatar-3.jpg\" alt=\"\">\n" +
                        "            </div>\n" +
                        "            <div class=\"post-comment-text\">\n" +
                        "                <div class=\"post-comment-text-inner\">\n" +
                        "                    <h6> Jonathan Madano </h6>\n" +
                        "                    <p> sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna\n" +
                        "                        aliquam\n" +
                        "                        erat\n" +
                        "                        volutpat.<strong> David !</strong> </p>\n" +
                        "                </div>\n" +
                        "                <div class=\"uk-text-small\">\n" +
                        "                    <a href=\"#\" class=\"text-danger mr-1\"> <i class=\"uil-heart\"></i> Love\n" +
                        "                    </a>\n" +
                        "                    <a href=\"#\" class=\" mr-1\"> Replay </a>\n" +
                        "                    <span> 3d</span>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "            <a href=\"#\" class=\"post-comment-opt\"></a>\n" +
                        "        </div>\n" +

                        "        <a href=\"#\" class=\"view-more-comment\"> Veiw 8 more Comments</a>\n" +
                        "        <div class=\"post-add-comment\">\n" +
                        "            <div class=\"post-add-comment-avature\">\n" +
                        "                <img src=\"http://localhost:8080/assets/images/avatars/avatar-2.jpg\" alt=\"\">\n" +
                        "            </div>\n" +
                        "            <div class=\"post-add-comment-text-area\">\n" +
                        "                <input type=\"text\" placeholder=\"Write your comment...\">\n" +
                        "                <div class=\"icons\">\n" +
                        "                    <span class=\"uil-link-alt\"></span>\n" +
                        "                    <span class=\"uil-grin\"></span>\n" +
                        "                    <span class=\"uil-image\"></span>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</div>");
                }
                $("#null").attr("id", "null2");
                $("#username").html(blog.username);
                $("#username").attr("id", "pass");
                $("#likeNumber").html(blog.likeNumber);
                $("#likeNumber").attr("id", "pass");
                $("#commentNumber").html(blog.commentNumber);
                $("#commentNumber").attr("id", "pass");
                $("#forwardNumber").html(blog.forwardNumber);
                $("#forwardNumber").attr("id", "pass");
                $("#saveNumber").html(blog.saveNumber);
                $("#saveNumber").attr("id", "pass");
                $("#link").attr("href", blog.link);
                $("#link").attr("id", "pass");


                $("#commentsNull").after("<div class=\"post-comments-single\">\n" +
                    "                                    <div class=\"post-comment-avatar\">\n" +
                    "                                        <img src=\"http://localhost:8080/assets/images/avatars/avatar-5.jpg\" alt=\"\">\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"post-comment-text\">\n" +
                    "                                        <div class=\"post-comment-text-inner\">\n" +
                    "                                            <h6 id = \"commentUser\"> Alex Dolgove</h6>\n" +
                    "                                            <p id = \"commentText\"> Ut wisi enim ad minim laoreet dolore magna aliquam erat </p>\n" +
                    "                                        </div>\n" +
                    "                                        <div class=\"uk-text-small\">\n" +
                    "                                            <a href=\"#\" class=\"text-danger mr-1\"> <i class=\"uil-heart\"></i> Love\n" +
                    "                                            </a>\n" +
                    "                                            <a href=\"#\" class=\" mr-1\"> Replay </a>\n" +
                    "                                            <span id = \"commentTime\"> 1d</span>\n" +
                    "                                        </div>\n" +
                    "                                    </div>\n" +
                    "                                    <a href=\"#\" class=\"post-comment-opt\"></a>\n" +
                    "                                </div>"
                )

                $("#commentsNull").attr("id", "ull");
                $("#commentUser").html(blog.commentUser);
                $("#commentUser").attr("id", "pass");
                $("#commentText").html(blog.commentText);
                $("#commentText").attr("id", "pass");
                $("#commentTime").html(blog.commentTime);
                $("#commentTime").attr("id", "pass");


                //window.location.href = 'http://localhost:8080/mainpage';
                //这里是如果成功的将数据传递之后做的操作 可以写alert和跳转语句 根据情况进行书写就写
            }
        }
    });
}

