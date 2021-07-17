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
        error:function(jqXHR,textStatus,errorThrown ){
            alert("errorThrown")
        },
        success: function(data) {
            //console.log(data)
            var blog = JSON.parse(data);

            $("#final").attr("id", "null")

            if (blog.noMore === "true") {

                $("#final").after("<hr style=\"top: 13px; position: relative;\">")
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

                $("#userAvater").attr("src", blog.userAvater);
                $("#userAvater").attr("id", "pass");//设置博主头像

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
//==== search The Blog ====
function searchTheBlog()
{
    //alert("load the blog")
    urls = window.location.pathname;
    str = urls.split("/")
    //alert("hello"),
    //alert(str[2])
    $.ajax({

        url: 'http://localhost:8080/getTheSearchBlogs', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"class":"other"}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: false,

        error:function(jqXHR,textStatus,errorThrown ){
            alert("errorThrown")
        },
        success: function(data) {
            //console.log(data)
            var blog = JSON.parse(data);
            //alert(blog)
            $("#final").attr("id", "null")
            if (blog.noMore === "true") {

            } else {

                if (data != null) {

                    $("#null").after("<div id = \"final\">\n" +
                        "\n" +
                        "                            <div class=\"fundings\" >\n" +
                        "                                <div class=\"fundings_desc\">\n" +
                        "                                    <a id = \"path\" href=\"#\"><h3 id = \"title\">Please help cleanup the oil and remediation of an spill</h3></a>\n" +
                        "                                    <div class=\"fundings_desc_meta\">\n" +
                        "                                        <div class=\"postMeta--author-text\">\n" +
                        "                                            <a href=\"#\" id = \"bloggerName\">admin</a>\n" +
                        "                                            <span class=\"middot\">·</span>\n" +
                        "                                            <time id = \"time\">24 Aug 2020</time>\n" +
                        "                                        </div>\n" +
                        "                                    </div>\n" +
                        "                                    <div class=\"fundings_footer\">\n" +
                        "                                        <text> 相关度 </text>\n" +
                        "                                        <div class=\"fund_raise_progress\">\n" +
                        "                                            <div id = \"relation\" class=\"fund_raise_progress_filler\" style=\"width:35%\"></div>\n" +
                        "                                        </div>\n" +
                        "                                    </div>\n" +
                        "                                    <div class=\"fund_raise_btns\">\n" +
                        "                                        <a class=\"button small block light px-0\" href=\"#\" id = \"path2\">点击查看</a>\n" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "                            </div>\n" +
                        "\n" +
                        "                        </div>");
                }
                $("#null").attr("id", "null2");
                $("#title").html(blog.blogTitle) //设置博客链接
                $("#title").attr("id","pass")
                $("#time").html(blog.createTime);//设置博主名字
                $("#time").attr("id", "pass");
                $("#path").attr("href",blog.link);//设置点赞数量
                $("#path").attr("id", "pass");
                $("#path2").attr("href",blog.link);//设置点赞数量
                $("#path2").attr("id", "pass");
                $("#bloggerName").html(blog.username);//设置点赞数量
                $("#bloggerName").attr("id", "pass");
                // $("#userAvater").attr("src", blog.userAvater);
                // $("#userAvater").attr("id", "pass");//设置博主头像


            }
        },
        complete: function () {
            $("loading").hide();
        },
    });
}
//====

//=====getUserBlog======
function getUserBlog()
{
    //alert("load the blog")
    urls = window.location.pathname;
    str = urls.split("/")
    //alert("hello"),
    //alert(str[2])
    $.ajax({

        url: 'http://localhost:8080/getPersonalBlog', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: false,

        error:function(jqXHR,textStatus,errorThrown ){
            alert("errorThrown")
        },
        success: function(data) {
            //console.log(data)
            var blog = JSON.parse(data);
            //alert(blog)
            $("#final").attr("id", "null")
            if (blog.noMore === "true") {

            } else {
                //alert(blog.blogTitle)

                if (data != null) {

                    $("#null").after("<div class=\"post\" id = \"final\">\n" +
                        "                                <div class=\"post-description\" id = \"path\">\n" +
                        "                                   <h3 id = \"title\">    </h3>\n" +
                        "                                   <p id = \"content\"> </p>              \n" +
                        "                                    <div class=\"post-state-details\">\n" +
                        "                                        <div>\n" +
                        "                                            <img src=\"http://localhost:8080/assets/images/icons/reactions_like.png\" alt=\"\">\n" +
                        "                                            <img src=\"http://localhost:8080/assets/images/icons/reactions_love.png\" alt=\"\">\n" +
                        "                                            <p> 13 </p>\n" +
                        "                                        </div>\n" +
                        "                                        <p id = \"time\"> 24 Comments</p>\n" +
                        "                                        <p id = \"clickNumber\"> 24 Comments</p>\n" +

                        "                                    </div>\n" +
                        "\n" +
                        "                                </div>\n" +
                        "\n" +
                        "                                <div class=\"post-state\">\n" +
                        "                                    <div class=\"post-state-btns\" > <i class=\"uil-thumbs-up\"></i> <text id = \"likeNumber\"> </text> <span> Liked </span>\n" +
                        "                                    </div>\n" +
                        "                                    <div class=\"post-state-btns\"> <i class=\"uil-heart\"></i> 18 <span> Coments</span>\n" +
                        "                                    </div>\n" +
                        "                                    <div class=\"post-state-btns\"> <i class=\"uil-share-alt\"></i> 193 <span> Shared\n" +
                        "                                        </span>\n" +
                        "                                    </div>\n" +
                        "                                    <div class=\"post-state-btns\"> <i class=\"uil-bookmark\"></i> 13 <span> Saved </span>\n" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "                            </div>");
                }
                $("#null").attr("id", "null2");

                $("#path").attr("href",blog.link);//设置点赞数量
                $("#path").attr("id", "pass");
                $("#clickNumber").html(blog.clickNumber + " views");
                $("#clickNumber").attr("id", "pass");

                $("#likeNumber").html(blog.likeNumber);
                $("#likeNumber").attr("id", "pass");

                $("#title").html("《" + blog.blogTitle+"》");
                $("#title").attr("id", "pass");//设置博客标题

                $("#content").html(blog.blogContent);
                $("#content").attr("id", "pass");//设置博客内容
                $("#time").html(blog.createTime);
                $("#time").attr("id", "pass");//设置时间

                // $("#userAvater").attr("src", blog.userAvater);
                // $("#userAvater").attr("id", "pass");//设置博主头像


            }
        },
        complete: function () {
            $("loading").hide();
        },
    });
}
//====


//=====manageBlog======
function manageBlog()
{
    //alert("load the blog")
    urls = window.location.pathname;
    str = urls.split("/")
    //alert("hello"),
    //alert(str[2])
    $.ajax({

        url: 'http://localhost:8080/manageBlog', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: false,

        error:function(jqXHR,textStatus,errorThrown ){
            alert("errorThrown")
        },
        success: function(data) {
            //console.log(data)
            var blog = JSON.parse(data);
            //alert(blog)
            $("#final").attr("id", "null")
            if (blog.noMore === "true") {

            } else {


                if (data != null) {

                    $("#null").after("<div class=\"sl_pokes_cont\" id = \"final\">\n" +
                        // "                                <a id = \"path\">\n" +
                        "                            <div class=\"sl_poke_users\" id=\"1\">\n" +
                        "                                <div class=\"sl_poke_info\">\n" +
                        "                                    <a id = \"path\" >\n" +
                        "                                        <div class=\"avatar\"> <img src=\"http://localhost:8080/assets/images/avatars/avatar-1.jpg\" alt=\"\">\n" +
                        "                                            </div>\n" +
                        "                                    </a>\n" +
                        "                                    <div class=\"sl_poke_info_innr\">\n" +
                        "                                        <div class=\"sl_poke_info_innr_user\">\n" +
                        "                                            <span>\n" +
                        "                                                <a id = \"path2\" > <span class=\"user-name\" id = \"title\"> Dennis Han </span>  </a>\n" +
                        "                                            </span>\n" +
                        "                                        </div>\n" +
                        "                                         <a id = \"edit\">\n" +
                        "                                        <button type=\"button\" class=\"button light small\" style=\"margin: 5px\">\n" +"<img src=\"http://localhost:8080/assets/images/icons/edit.svg\" width=\"20\" height=\"20\" style=\"margin-right: 10px\"><span class=\"button-text\">编辑博文</span>"+
                        "\n" +
                        "                                        </button>\n" +
                        "                                         </a>\n" +
                        "                                        <button type=\"button\" class=\"button light small\" onclick='deleteblog("+blog.blogId+","+blog.userId+")' style=\"margin: 5px\" >\n" + "<img src=\"http://localhost:8080/assets/images/icons/delete.svg\" width=\"20\" height=\"20\" style=\"margin-right: 10px\"><span class=\"button-text\">删除博文</span>"+

                        "                                        </button>\n" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "                            </div>\n" +
                        // "                           </a>\n" +
                        "                        </div>");
                }
                $("#null").attr("id", "null2");

                $("#path").attr("href",blog.link);//设置点赞数量
                $("#path").attr("id", "pass");

                $("#path2").attr("href",blog.link);//设置点赞数量
                $("#path2").attr("id", "pass");

                $("#title").html("《" + blog.blogTitle+"》");
                $("#title").attr("id", "pass");//设置博客标题

                $("#edit").attr("href",blog.editPath);
                $("#edit").attr("id", "pass");

                // $("#content").html(blog.blogContent);
                // $("#content").attr("id", "pass");//设置博客内容
                // $("#time").html(blog.createTime);
                // $("#time").attr("id", "pass");//设置时间

                // $("#userAvater").attr("src", blog.userAvater);
                // $("#userAvater").attr("id", "pass");//设置博主头像


            }
        },
        complete: function () {
            $("loading").hide();
        },
    });
}

//====i

function deleteblog(blogId,userId) {
    // alert("I am deleting blog."+parseInt(blogId)+" "+parseInt(userId));
    var infomsg = {"blogId": blogId, "userId": userId};
    $.ajax({
        url: 'http://localhost:8080/deletemyblog',
        type: 'get',
        data: infomsg,
        async: false,
        success: function (o) {
            alert("删除博客成功");
            location.reload();
        }
    })
}
//====


//====getblogPageComments====


function getblogPageComments()
{
    //alert("load the blog")
    urls = window.location.pathname;
    str = urls.split("/")
    //alert("hello"),
    //alert(str[2])
    $.ajax({

        url: 'http://localhost:8080/getComments', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"blogId":str[3]}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: false,

        error:function(jqXHR,textStatus,errorThrown ){
            alert("errorThrown")
        },
        success: function(data) {
            //console.log(data)
            var comment = JSON.parse(data);
            //alert(blog)
            $("#comments").attr("id", "commentsNull")

            if(comment.noMore !== "True") {

                if (comment !== "{}") {
                    $("#commentsNull").after("<div class=\"post-comments-single\" id='comments'>\n" +
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

                    $("#commentsNull").attr("id", "commentsNull2")
                    $("#commentUser").html(comment.username);
                    $("#commentUser").attr("id", "pass");//设置评论者名字
                    $("#commentText").html(comment.commentContent);
                    $("#commentText").attr("id", "pass");//设置评论内容
                    $("#commentTime").html(comment.commentTime);
                    $("#commentTime").attr("id", "pass");//设置时间
                    //
                    $("#commentAvater").attr("src", comment.userAvatar);
                    $("#commentAvater").attr("id", "pass");//设置用户头像

                }
            }
        },
        complete: function () {
            $("loading").hide();
        },
    });
}
//====


//==== comment ====
function comment()
{

    var tagId = $("#tagId").text()
    var comment = $("#commentContent").val()
    var blogId = $("#blogId").text()

    $.ajax({

        url: 'http://localhost:8080/blogs/comment', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"tagId":tagId,"comment":comment,"blogId":blogId}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            var message = JSON.parse(data);
            if(message.login === "true"){
                alert("评论成功");
                //window.location.href = 'http://localhost:8080/blogs/';
            }else{
                alert("请登录")
                window.location.href = 'http://localhost:8080/login';
            }


        }
    });

}

//=====forward=====
function forward()
{
    var tagId = $("#tagId").text()
    var blogId = $("#blogId").text()
    $.ajax({

        url: 'http://localhost:8080/blogs/forward', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"tagId":tagId,"blogId":blogId}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            var message = JSON.parse(data);
            if(message.login === "true"){
                alert("转发成功")
            }else{
                alert("请登录")
                window.location.href = 'http://localhost:8080/login';
            }

            //window.location.href = 'http://localhost:8080/mainpage';
            //这里是如果成功的将数据传递之后做的操作 可以写alert和跳转语句 根据情况进行书写就写
        }
    });
}
