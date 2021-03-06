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


function Indexlike(blogId,userId,tagId){
    //alert(blogId+","+userId+","+tagId)
    $.ajax({

        url: 'http://localhost:8080/blogs/like', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"blogId":blogId,"userId":userId,"tagId":tagId}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            //alert("success like")
            var s = "pass" + blogId
            var likeNumber = "likeNumber" + blogId
            //alert(likeNumber)


            var number = parseInt($("#" + likeNumber).text())+ 1
            //alert("number: " + number)
            $("#" + likeNumber).html(number)
            //alert("结束0")
            var fun = "IndexCancelLike(" + blogId+ "," +  userId + ","+ tagId + ")"
            // $("#" + s).attr("id","sss")
            // alert("结束1")
            //$("#" + s).attr("onclick","Indexlike(" + blog.blogId+ "," +  blog.userId + ","+ blog.tagId + ")" );
            $("#" + s).attr("onclick",fun );
           // alert("结束2")
        }
    });
}


function IndexCancelLike(blogId,userId,tagId){
    //alert(blogId+","+userId+","+tagId)
    $.ajax({

        url: 'http://localhost:8080/blogs/cancelLike', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"blogId":blogId,"userId":userId,"tagId":tagId}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
           // alert("success")
            var s = "pass" + blogId
            var likeNumber = "likeNumber" + blogId
            //alert(likeNumber)
            var number =  parseInt($("#" + likeNumber).text())-1
            //alert("number: " + number)
            $("#" + likeNumber).html(number)
            //alert("结束0")
            var fun = "Indexlike(" + blogId+ "," +  userId + ","+ tagId + ")"
            //alert("Indexlike(" + blog.blogId+ "," +  blog.userId + ","+ blog.tagId + ")")
            // $("#" + s).attr("id","sss")
            // alert("结束1")
            //$("#" + s).attr("onclick","Indexlike(" + blog.blogId+ "," +  blog.userId + ","+ blog.tagId + ")");
            $("#" + s).attr("onclick",fun);
            //alert("结束2")
        }
    });
}

function IndexSave(blogId,tagId){
    //alert(blogId+","+userId+","+tagId)
    $.ajax({

        url: 'http://localhost:8080/blogs/collect', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"blogId":blogId,"tagId":tagId}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            //alert("success like")
            var s = "savebutton" + blogId
            var saveNumber = "saveNumber" + blogId
            //alert(likeNumber)


            var number = parseInt($("#" + saveNumber).text())+ 1
            //alert("number: " + number)
            $("#" + saveNumber).html(number)
            //alert("结束0")
            var fun = "IndexCancelSave(" + blogId + ","+ tagId + ")"
            // $("#" + s).attr("id","sss")
            // alert("结束1")
            //$("#" + s).attr("onclick","Indexlike(" + blog.blogId+ "," +  blog.userId + ","+ blog.tagId + ")" );
            $("#" + s).attr("onclick",fun );
             //alert("结束2")
        }
    });
}


function IndexCancelSave(blogId,tagId){
    //alert("save")
    //alert(blogId+","+userId+","+tagId)
    $.ajax({

        url: 'http://localhost:8080/blogs/cancelCollect', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"blogId":blogId,"tagId":tagId}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            //alert("success")
            var s = "savebutton" + blogId
            var saveNumber = "saveNumber" + blogId
            //alert(likeNumber)
            var number =  parseInt($("#" + saveNumber).text())-1
            //alert("number: " + number)
            $("#" + saveNumber).html(number)
            //alert("结束0")
            var fun = "IndexSave(" + blogId+ ","+ tagId + ")"
            //alert("Indexlike(" + blog.blogId+ "," +  blog.userId + ","+ blog.tagId + ")")
            // $("#" + s).attr("id","sss")
            // alert("结束1")
            //$("#" + s).attr("onclick","Indexlike(" + blog.blogId+ "," +  blog.userId + ","+ blog.tagId + ")");
            $("#" + s).attr("onclick",fun);
            //alert("结束2")
        }
    });
}

function IndexForward(blogId,tagId){
    //alert(blogId+","+userId+","+tagId)
    //alert("IndexForward")
    $.ajax({

        url: 'http://localhost:8080/blogs/forward', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"blogId":blogId,"tagId":tagId}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            //alert("success like")
            var forwardNumber = "forwardNumber" + blogId
            //alert(likeNumber)
            var number = parseInt($("#" + forwardNumber).text())+ 1
            //alert("number: " + number)
            $("#" + forwardNumber).html(number)
            //alert("结束0")
            // alert("结束2")
        }
    });
}

function Alert(){
    alert("请登录")
}


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
                        "                      <a id = 'userLink'>\n"+
                        "        <div class=\"post-avature\">\n" +
                        "            <img id = \"userAvater\" src=\"http://localhost:8080/assets/images/avatars/avatar-6.jpg\" alt=\"\">\n" +
                        "        </div>\n" +
                        "                      </a>\n"+
                        "        <div class=\"post-title\">\n" +
                        "            <h4 id = \"username\">  </h4>\n" +
                        "            <p id = \"time\"> 5 <span> hrs</span>  </p>\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <div class=\"post-btn-action\">\n" +
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
                        "        <div class=\"post-state-btns\" id = 'likebutton'> <i class=\"uil-thumbs-up\"></i><text id = \"likeNumber\">126</text><span> Liked </span>\n" +
                        "        </div>\n" +
                        "        <div class=\"post-state-btns\" id = 'forwardbutton'> <i class=\"uil-share-alt\"></i> <text  id = \"forwardNumber\">126</text> <span> Shared\n" +
                        "            </span>\n" +
                        "        </div>\n" +
                        "        <div class=\"post-state-btns\" id = 'savebutton'> <i class=\"uil-bookmark\"></i> <text  id = \"saveNumber\">126</text> <span> Saved </span>\n" +
                        "        </div>\n" +
                        "    </div>\n" +

                        "    <!-- post comments -->\n" +
                        "    <div class=\"post-comments\" >\n" +
                        "        <a id = \"commentsNull\">   </a>\n"+
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
                $("#likeNumber").attr("id", "likeNumber" + blog.blogId);
                $("#likeNum").html(blog.likeNumber);
                $("#likeNum").attr("id", "pass");//设置点赞数量
                $("#commentNumber").html(blog.commentNumber);
                $("#commentNumber").attr("id", "pass");//设置评论数量
                $("#clickNumber").html(blog.clickNumber + " views");
                $("#clickNumber").attr("id", "pass");//设置浏览量
                $("#forwardNumber").html(blog.forwardNumber);
                $("#forwardNumber").attr("id", "forwardNumber"+blog.blogId);//设置转发数

                $("#saveNumber").html(blog.saveNumber);
                $("#saveNumber").attr("id", "saveNumber" + blog.blogId);//设置收藏数
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

                $("#userLink").attr("href", blog.userLink);
                $("#userLink").attr("id", "pass");//设置博主头像

                $("#comments").attr("id", "commentsNull")

               // alert("blog.isliked： " + blog.isliked)

                if(blog.isliked === "-1"){
                    $("#likebutton").attr("onclick","Alert()" );
                    $("#likebutton").attr("id", "pass" + blog.blogId);
                }else if(blog.isliked === "0"){
                    //alert("没有点过赞")
                    $("#likebutton").attr("onclick","Indexlike(" + blog.blogId+ "," +  blog.userId + ","+ blog.tagId + ")" );
                    $("#likebutton").attr("id", "pass" + blog.blogId);//设置博客链接
                }else{
                    $("#likebutton").attr("onclick","IndexCancelLike(" + blog.blogId + "," +  blog.userId + ","+ blog.tagId + ")" );
                    $("#likebutton").attr("id", "pass" + blog.blogId);//设置博客链接
                }

                if(blog.iscollect === "-1"){
                    $("#savebutton").attr("onclick","Alert()" );
                    $("#savebutton").attr("id", "savebutton" + blog.blogId);
                }else if(blog.iscollect === "0"){
                    //alert("没有点过赞")
                    $("#savebutton").attr("onclick","IndexSave(" + blog.blogId+ ","+ blog.tagId + ")" );
                    $("#savebutton").attr("id", "savebutton" + blog.blogId);//设置博客链接
                }else{
                    $("#savebutton").attr("onclick","IndexCancelSave(" + blog.blogId + ","+ blog.tagId + ")" );
                    $("#savebutton").attr("id", "savebutton" + blog.blogId);//设置博客链接
                }

                if(blog.iscollect === "-1"){
                    $("#forwardbutton").attr("onclick","Alert()" );
                    $("#forwardbutton").attr("id", "forwardbutton" + blog.blogId);
                }else{
                    $("#forwardbutton").attr("onclick","IndexForward(" + blog.blogId + ","+ blog.tagId + ")" );
                    $("#forwardbutton").attr("id", "forwardbutton" + blog.blogId);//设置博客链接
                }






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
                            "                                </div>"
                        )


                        $("#commentUser").html(comment.username);
                        $("#commentUser").attr("id", "pass");//设置评论者名字
                        $("#commentText").html(comment.commentContent);
                        $("#commentText").attr("id", "pass");//设置评论内容
                        // $("#commentTime").html(comment.commentTime);
                        // $("#commentTime").attr("id", "pass");//设置时间
                        //
                        $("#commentAvater").attr("src", comment.commentAvater);
                        $("#commentAvater").attr("id", "pass");//设置用户头像
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
                    $("#null").before("<div id = \"final\">\n" +
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
    // alert("load the blog")
    urls = window.location.pathname;
    str = urls.split("/")
    //alert("hello"),
    // alert(str[2])
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

                // alert(blog.blogTitle)

                if (data != null) {

                    $("#null").after("<div class=\"post\" id = \"final\">\n" +
                        "                                <div class=\"post-description\" id = \"path\">\n" +
                        "                                  <a id = 'link'>\n"+
                        "                                   <h3 id = \"title\">    </h3>\n" +
                        "                                  </a>\n"+
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

                $("#link").attr("href",blog.link);//设置点赞数量
                $("#link").attr("id", "pass");
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
                // $("#null").attr("id", "null2");

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
                        "                                            <span id = \"commentTime\"> 1d</span>\n" +
                        "                                        </div>\n" +
                        "                                    </div>\n" +
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
    function getallfavorites()
    {
        urls=window.location.pathname;
        str=urls.split("/");
        $.ajax({
            url:'http://localhost:8080/reqfavorites',
            type:'get',
            data:{},
            async:false,
            error:function(xhr){
                alert("Something wrong.");
            },
            success:function (data) {
                var favorites = JSON.parse(data);
                console.log("data type: "+typeof data)
                var blog = JSON.parse(data);
                console.log("data: "+data)
                //alert(blog)
                $("#finalfavorites").attr("id", "null");
                if (favorites.noMore === "true") {

                } else {
                    if (favorites != null) {

                        $("#null").after("<div class=\"sl_pokes_cont\" id = \"final\">\n" +
                            "                                <a id = \"path\">\n" +
                            "                            <div class=\"sl_poke_users\" id=\"1\">\n" +
                            "                                <div class=\"sl_poke_info\">\n" +
                            "                                    <div class=\"sl_poke_info_innr\">\n" +
                            "                                        <div class=\"sl_poke_info_innr_user\">\n" +
                            "                                            <span>\n" +
                            "                                                <a id=\"directing\" href=\"" + "#" + "\"> <span class=\"user-name\" id = \"title\"> Dennis Han </span>  </a>\n" +
                            "                                            </span>\n" +
                            "                                        </div>\n" +
                            "                                        <button class=\"button light small\" style=\"margin: 5px\" onclick='cancelFavorites("+favorites.blogid+","+favorites.userid+")'> 取消收藏</button>\n" +
                            "                                    </div>\n" +
                            "                                </div>\n" +
                            "                            </div>\n" +
                            "                           </a>\n" +
                            "                        </div>");
                    }
                    // $("#null").attr("id", "null2");

                    // $("#path").attr("href",blog.link);//设置点赞数量
                    $("#path").attr("id", "pass");
                    $("#directing").attr("href", "/blogs/"+favorites.bloggername+"/" + favorites.blogid);
                    $("#title").html(favorites.blogname);
                    $("#title").attr("id", "pass");//设置博客标题

                }
            }}
        )
    }

function cancelFavorites(blogId,userId) {
    // alert("I am deleting blog."+parseInt(blogId)+" "+parseInt(userId));
    var infomsg = {"blogId": blogId, "userId": userId};
    // console.log("blogId type: "+typeof blogId);
    // console.log("userId type: "+typeof userId);
    $.ajax({
        url: 'http://localhost:8080/cancelFavorites',
        type: 'get',
        data: infomsg,
        async: false,
        success: function (o) {
            alert("取消收藏成功");
            location.reload();
        },
        error: function (e)
        {
            console.log("出错")
            console.log(e.status)
        }
    })
}



    function getallfollow()
    {
        //alert("load the blog")
        urls = window.location.pathname;
        str = urls.split("/")

        $.ajax({

            url: 'http://localhost:8080/reqfollow',
            type: 'get',
            data: {},
            async: false,

            error:function(jqXHR,textStatus,errorThrown ){
                alert("errorThrown")
            },
            success: function(data) {
                //console.log(data)
                var followings = JSON.parse(data);
                //alert(blog)
                $("#finalfollowing").attr("id", "null")
                if (followings.noMore === "true") {

                } else {


                    if (followings != null) {

                        $("#null").after("<div class=\"sl_pokes_cont\" id = \"final\">\n" +
                            "                                <a id = \"path\">\n" +
                            "                            <div class=\"sl_poke_users\" id=\"1\">\n" +
                            "                                <div class=\"sl_poke_info\">\n" +
                            "                                    <a href=\"userinfo.html\">\n" +
                            "                                        <div class=\"avatar\"> <img id=\"touxiang\" src=\""+followings.avatar+"\" alt=\"\">\n" +
                            "                                            </div>\n" +
                            "                                    </a>\n" +
                            "                                    <div class=\"sl_poke_info_innr\">\n" +
                            "                                        <div class=\"sl_poke_info_innr_user\">\n" +
                            "                                            <span>\n" +
                            "                                                <a id=\"directing\" href=\""+followings.userId+"\"> <span class=\"user-name\" id = \"title\"> Dennis Han </span>  </a>\n" +
                            "                                            </span>\n" +
                            "                                        </div>\n" +
                            "                                        <button class=\"button light small\" style=\"margin: 5px\" onclick='clickbutton("+parseInt(followings.userId)+")'> 取消关注</button>\n" +
                            "                                    </div>\n" +
                            "                                </div>\n" +
                            "                            </div>\n" +
                            "                           </a>\n" +
                            "                        </div>");
                    }
                    // $("#null").attr("id", "null2");

                    // $("#path").attr("href",blog.link);//设置点赞数量
                    $("#path").attr("id", "pass");
                    $("#directing").attr("href","/personalspaceguest/"+followings.userId);
                    $("#title").html(followings.username);
                    $("#title").attr("id", "pass");//设置博客标题
                    $("#touxinag").attr("src",followings.avatar);




                }
            },
            complete: function () {
                $("loading").hide();
            },
        });
    }

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

function clickbutton(userId)
{
    var jsonstr={"userId":userId};
    $.ajax({
        url: 'http://localhost:8080/reqdelfollow', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: jsonstr, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity

        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作

        async: false,
        success:function(data){
            location.reload();
},
        error:function(xhr){
            alert("something wrong:"+xhr.status);
        }
    })
}


//=====forward=====
function forward()
{
    var tagId = $("#tagId").text()
    var blogId = $("#blogId").text()
    $.ajax({

        url: 'http://localhost:8080/blogs/forward', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"blogId":blogId,"tagId":tagId}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
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


//=====mayknowpeople=====
function mayknowpeople()
{
    $.ajax({

        url: 'http://localhost:8080/mayknowpeople', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            if(data != null){
                //alert(data)
                bloggers1 = JSON.stringify(data);
                bloggers = JSON.parse(bloggers1)
                //alert(bloggers)
                $.each(bloggers, function (index, blogger) {
                    $("#bloggeryoumayknow").after("\n" +
                        "                        <div class=\"sl_sidebar_sugs\">\n" +
                        "                            <div class=\"sl_sidebar_sugs_avatar\">\n" +
                        "                                <img id = 'avatar' src=\"http://localhost:8080/assets/images/avatars/avatar-1.jpg\" alt=\"\">\n" +
                        "                            </div>\n" +
                        "                            <div class=\"sl_sidebar_sugs_text\">\n" +
                        "                                <a href=\"#\" class=\"sl_user_link_name\" id = 'name'> Jonathan Madano </a>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"user-follow-button sl_sidebar_sugs_btns\">\n" +
                        "                                <button type=\"button\" class=\"button small\" onclick='submitfollow("+blogger.userId+")'>\n" +
                        "                                    <span> Follow</span>\n" +
                        "                                </button>\n" +
                        "                            </div>\n" +
                        "                        </div>");

                    $("#name").attr("href", "/personalspaceguest/" + blogger.userId);
                    $("#name").html(blogger.username);
                    $("#name").attr("id","pass");
                    $("#avatar").attr("src", blogger.avatar);//设置博客标题
                    $("#avatar").attr("id","pass");
                });



            }


            //window.location.href = 'http://localhost:8080/mainpage';
            //这里是如果成功的将数据传递之后做的操作 可以写alert和跳转语句 根据情况进行书写就写
        }
    });
}



function submitfollow(userId) {
    var jsonstr = {"userId": userId};
    $.ajax({
        url: 'http://localhost:8080/submitfollow',
        type: 'get',
        data: jsonstr,
        async: false,
        success: function (data) {
            location.reload();
        },
        error: function (xhr) {
            alert("something wrong");
        }
    })
}

function searchTheBlogs(){
    searchTheBlog()
    searchTheBlog()
    searchTheBlog()
    searchTheBlog()
    searchTheBlog()
    searchTheBlog()
}


function changeNews(iden){
    alert(iden)
    $.ajax({

        url: 'http://localhost:8080/deleteNotification', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"iden":iden}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,

    });
}


//=====notification=====
function notification()
{
    $.ajax({

        url: 'http://localhost:8080/notification', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            if(data != null){
                //alert(data)
                news1 = JSON.stringify(data);
                news = JSON.parse(news1)
                //alert(bloggers)
                $.each(news, function (index, newsget) {

                    $("#note").after("<li id = 'iden' onclick='changeNews()'>\n" +
                        "                                       <a href=\"#\">\n" +
                        "                                           <strong id='newsContent'>这里是传送过来的消息 我实在是不想写了</strong>\n" +
                        "                                       </a>\n" +
                        "                                   </li>");

                    $("#newsContent").html(newsget.newsContent);
                    $("#newsContent").attr("id","pass");
                    $("#iden").attr("onclick","changeNews(" + newsget.newsId + ")");
                    $("#iden").attr("id","pass");
                });

            }


            //window.location.href = 'http://localhost:8080/mainpage';
            //这里是如果成功的将数据传递之后做的操作 可以写alert和跳转语句 根据情况进行书写就写
        }
    });
}

