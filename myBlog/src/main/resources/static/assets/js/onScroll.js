//要触发的事件（自己定义事件的内容）

function ajax_function() {
    window.location.href = 'http://baidu.com';
}



var timeoutInt; // 要保证最后要运行一次

// window.onscroll窗口添加滚动条事件
window.onscroll = function () {
    setTimeout(function () {
        if (timeoutInt != undefined) {
            window.clearTimeout(timeoutInt);
        }
        timeoutInt = window.setTimeout(function () {
            //监听事件内容
            if(getScrollHeight() == getDocumentTop() + getWindowHeight()){
                //当滚动条到底时,这里是触发内容
                //异步请求数据,局部刷新dom
                loadTheBlog()//调用上面自定义的事件函数。
            }
        }, 105);
    }, 100);
}



//（浏览器窗口上边界内容高度）
function getDocumentTop() {
    var scrollTop = 0, bodyScrollTop = 0, documentScrollTop = 0;
    if (document.body) {
        bodyScrollTop = document.body.scrollTop;
    }
    if (document.documentElement) {
        documentScrollTop = document.documentElement.scrollTop;
    }
    scrollTop = (bodyScrollTop - documentScrollTop > 0) ? bodyScrollTop : documentScrollTop;
    console.log("scrollTop:"+scrollTop);
    return scrollTop;
}



//可视窗口高度（屏幕可以看见的高度）
function getWindowHeight() {
    var windowHeight = 0;
    if (document.compatMode == "CSS1Compat") {
        windowHeight = document.documentElement.clientHeight;
    } else {
        windowHeight = document.body.clientHeight;
    }
    console.log("windowHeight:"+windowHeight);
    return windowHeight;
}



//滚动条滚动高度（即整个网页的高度）
function getScrollHeight() {
    var scrollHeight = 0, bodyScrollHeight = 0, documentScrollHeight = 0;
    if (document.body) {
        bodyScrollHeight = document.body.scrollHeight;
    }
    if (document.documentElement) {
        documentScrollHeight = document.documentElement.scrollHeight;
    }
    scrollHeight = (bodyScrollHeight - documentScrollHeight > 0) ? bodyScrollHeight : documentScrollHeight;
    console.log("scrollHeight:"+scrollHeight);
    return scrollHeight;
}