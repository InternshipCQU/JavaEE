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

        beforeSend: function () {
            $("loading").show();
        },

        success: function(data) {
            //console.log(data)
            var blog = JSON.parse(data);

            $("#final").attr("id", "null")


            if (blog.noMore === "true") {
                $("#bottom").before("<hr data-text='no more'>")
                $("#bottom").attr("id","bottomAfter")
            } else {

                if (data != null) {

                    $("#null").after("<div class=\"post\" id =\"final\" >\n" +
                        "    <div class=\"post-heading\">\n" +
                        "        <div class=\"post-avature\">\n" +
                        "            <img id = \"userAvater\" src=\"http://localhost:8080/assets/images/avatars/avatar-6.jpg\" alt=\"\">\n" +
                        "        </div>\n" +
                        "        <div class=\"post-title\">\n" +
                        "            <h4 id = \"username\">  </h4>\n" +
                        "            <p id = \"time\"> 5 <span> hrs</span>  </p>\n" +
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
                        "            <h3 id = \"title\">    </h3>\n" +
                        "            <p id = \"content\"> </p>              \n" +
                        "        <div class=\"fullsizeimg\">\n" +

                        "            <img src=\"http://localhost:8080/assets/images/post/img-1.jpg\" alt=\"\">\n" +
                        "        </div>\n" +
                        "        <div class=\"post-state-details\">\n" +
                        "            <div>\n" +
                        "                <img src=\"http://localhost:8080/assets/images/icons/reactions_like.png\" alt=\"\">\n" +
                        "                <img src=\"http://localhost:8080/assets/images/icons/reactions_love.png\" alt=\"\">\n" +
                        "                <p id = \"likeNum\"> 13 </p>\n" +
                        "            </div>\n" +
                        "            <p id = \"clickNumber\"> 24 Comments</p>\n" +
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
                        "    <div class=\"post-comments\" >\n" +
                        "        <a id = \"commentsNull\">   </a>\n"+
                        "        <a href=\"#\" class=\"view-more-comment\"   id = \"commentLink\"> Veiw 8 more Comments</a>\n" +
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
                $("#commentLink").attr("href",blog.link)
                $("#commentLink").html("View " + blog.commentNumber + " more Comments") //设置博客链接
                $("#commentLink").attr("id","pass")
                $("#username").html(blog.username);//设置博主名字
                $("#username").attr("id", "pass");
                $("#likeNumber").html(blog.likeNumber);//设置点赞数量
                $("#likeNumber").attr("id", "pass");
                $("#likeNum").html(blog.likeNumber);
                $("#likeNum").attr("id", "pass");//设置点赞数量
                $("#commentNumber").html(blog.commentNumber);
                $("#commentNumber").attr("id", "pass");//设置评论数量
                $("#clickNumber").html(blog.clickNumber + " views");
                $("#clickNumber").attr("id", "pass");//设置浏览量
                $("#forwardNumber").html(blog.forwardNumber);
                $("#forwardNumber").attr("id", "pass");//设置转发数
                $("#saveNumber").html(blog.saveNumber);
                $("#saveNumber").attr("id", "pass");//设置收藏数
                $("#link").attr("href", blog.link);
                $("#link").attr("id", "pass");//设置博客链接

                $("#title").html("《" + blog.blogTitle+"》");
                $("#title").attr("id", "pass");//设置博客标题
                $("#content").html(blog.blogContent);
                $("#content").attr("id", "pass");//设置博客内容
                $("#time").html(blog.createTime);
                $("#time").attr("id", "pass");//设置时间

                // $("#userAvater").attr("src", blog.userAvater);
                // $("#userAvater").attr("id", "pass");//设置博主头像

                $("#comments").attr("id", "commentsNull")

                var comments = blog.comments
                if(comments !== "{}") {
                    $.each(comments, function (index, comment) {
                        console.log(comment)
                        //var comment = JSON.parse(comment);
                        $("#commentsNull").after("<div class=\"post-comments-single\">\n" +
                            "                                    <div class=\"post-comment-avatar\">\n" +
                            "                                        <img id = \"commentAvater\" src=\"http://localhost:8080/assets/images/avatars/avatar-5.jpg\" alt=\"\">\n" +
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


                        $("#commentUser").html(comment.username);
                        $("#commentUser").attr("id", "pass");//设置评论者名字
                        $("#commentText").html(comment.commentContent);
                        $("#commentText").attr("id", "pass");//设置评论内容
                        // $("#commentTime").html(comment.commentTime);
                        // $("#commentTime").attr("id", "pass");//设置时间
                        //
                        // $("#commentAvater").attr("src", comment.userAvater);
                        // $("#commentAvater").attr("id", "pass");//设置用户头像
                    });

                }
                $("#commentsNull").attr("id","pass")


                //window.location.href = 'http://localhost:8080/mainpage';
                //这里是如果成功的将数据传递之后做的操作 可以写alert和跳转语句 根据情况进行书写就写
            }
        },
        complete: function () {
            $("loading").hide();
        },
    });
}


//====

//====blogPage====

function follow(userID)
{
    urls = window.location.pathname;
    str = urls.split("/")
    $.ajax({

        url: 'http://localhost:8080/blogs/follow', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"blogID":str[str.length-1]}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            if(data != null){

            }
        }
    });
}

function like()
{
    urls = window.location.pathname;
    str = urls.split("/")
    $.ajax({

        url: 'http://localhost:8080/blogs/like', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"blogID":str[str.length-1]}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            if(data != null){

            }
        }
    });
}

function comment()
{
    urls = window.location.pathname;
    str = urls.split("/")
    $.ajax({

        url: 'http://localhost:8080/blogs/comment', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"blogID":str[str.length-1]}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            if(data != null){
            }

        }
    });
}


function forward()
{
    urls = window.location.pathname;
    str = urls.split("/")
    $.ajax({

        url: 'http://localhost:8080/blogs/forward', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"blogID":str[str.length-1]}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            if(data != null){

            }
        }
    });
}

function collect()
{
    urls = window.location.pathname;
    str = urls.split("/")
    $.ajax({

        url: 'http://localhost:8080/blogs/collect', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"blogID":str[str.length-1]},//这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            if(data != null){

            }

        }
    });
}



//====
