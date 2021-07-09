//var basePath = [[${#httpServletRequest.getScheme() + "://" + #httpServletRequest.getServerName() + ":" + #httpServletRequest.getServerPort() + #httpServletRequest.getContextPath()}]];

function loadCSS()
{
    $.ajax({

        url: 'http://localhost:8080/ajax', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"class":"CSS"}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            alert("good")
            //这里是如果成功的将数据传递之后做的操作 可以写alert和跳转语句 根据情况进行书写就写
        }
    });
}

function loadCPP()
{
    $.ajax({

        url: 'http://localhost:8080/ajax', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"class":"C++"}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            alert("good")
            //这里是如果成功的将数据传递之后做的操作 可以写alert和跳转语句 根据情况进行书写就写
        }
    });
}

function loadJAVA()
{
    $.ajax({

        url: 'http://localhost:8080/ajax', //这里是返回路径 在controller里写好对应函数就行 TODO:记得修改路径后面的 这是测试
        type: 'get',
        data: {"class":"JAVA"}, //这里是向后端传输的json 应该是可以直接传对象 比如User这种entity
        //例如点赞的话 我们传递blogID userID到后端 后端再进行操作
        async: true,
        success: function(data){
            alert("good")
            //这里是如果成功的将数据传递之后做的操作 可以写alert和跳转语句 根据情况进行书写就写
        }
    });
}