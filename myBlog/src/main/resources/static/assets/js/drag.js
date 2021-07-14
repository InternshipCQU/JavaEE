// new Vue().$mount('#app')
/**
 * Created by shuai_wy on 2017/3/14.
 */

var show_num = [];
draw(show_num);
function dj(){
    draw(show_num);
}
// function sublim(){
//     var val=document.getElementById("text").value;
//     val = val.toLowerCase();
//     var num = show_num.join("");
//     num = num.toLowerCase();
//     alert("测试")
//     if(val===''){
//         alert('请输入验证码！');
//         return false;
//     }else if(val === num){
//         alert('提交成功！');
//         document.getElementById(".input-val").val('');
//         draw(show_num);
//         return true;
//     }else{
//         alert('验证码错误！\n你输入的是:  '+val+"\n正确的是:  "+num+'\n请重新输入！');
//         document.getElementById("text").value='';
//         draw(show_num);
//         return false;
//     }

function draw(show_num) {
    var canvas_width=document.getElementById('canvas').clientWidth;
    var canvas_height=document.getElementById('canvas').clientHeight;
    var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
    var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
    canvas.width = canvas_width;
    canvas.height = canvas_height;
    var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0,q,w,e,r,t,y,u,i,o,p,a,s,d,f,g,h,j,k,l,z,x,c,v,b,n,m";
    var aCode = sCode.split(",");
    var aLength = aCode.length;//获取到数组的长度

    for (var i = 0; i <= 3; i++) {
        var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
        var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
        var txt = aCode[j];//得到随机的一个内容
        show_num[i] = txt;
        var x = 10 + i * 20;//文字在canvas上的x坐标
        var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
        context.font = "bold 23px 微软雅黑";

        context.translate(x, y);
        context.rotate(deg);

        context.fillStyle = randomColor();
        context.fillText(txt, 0, 0);

        context.rotate(-deg);
        context.translate(-x, -y);
    }
    for (var i = 0; i <= 5; i++) { //验证码上显示线条
        context.strokeStyle = randomColor();
        context.beginPath();
        context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
        context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
        context.stroke();
    }
    for (var i = 0; i <= 30; i++) { //验证码上显示小点
        context.strokeStyle = randomColor();
        context.beginPath();
        var x = Math.random() * canvas_width;
        var y = Math.random() * canvas_height;
        context.moveTo(x, y);
        context.lineTo(x + 1, y + 1);
        context.stroke();
    }
}
function randomColor() {//得到随机的颜色值
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    return "rgb(" + r + "," + g + "," + b + ")";
}

function hide_error_user()
{
    var error_username = document.getElementById("error_username");
    error_username.setAttribute("hidden", true);
}


function hide_error_password()
{
    var error_password = document.getElementById("error_password");
    error_password.setAttribute("hidden", true);
}


function check()
{
    // var username = document.getElementById("username");
    // var password = document.getElementById("password");
    var val=document.getElementById("code").value;
    val = val.toLowerCase();
    var num = show_num.join("");
    num = num.toLowerCase();
    // if(("" === username.value))
    // {
    //     alert("请输入用户名")
    //     username.focus()
    //     return false;
    // }
    // if("" === password.value) {
    //     alert("请输入密码")
    //     password.focus()
    //     return false;
    // }
    if(val === ""){
        alert('请输入验证码！');
        document.getElementById("code").focus()
        return false;
    }else if(val === num && val !== ""){
        // alert('登录成功！');
        document.getElementById("code").value = "";
        draw(show_num);
        return true;
    }else{
        alert('验证码错误！\n你输入的是:  '+val+"\n正确的是:  "+num+'\n请重新输入！');
        document.getElementById("code").value='';
        draw(show_num);
        return false;
    }

}

function CheckSignup()
{
    var sign_password = document.getElementById("sign-password");
    var confirm_password = document.getElementById("confirm-password");
    var sign_username = document.getElementById("sign-username");
    var sign_email = document.getElementById("sign-email");
    console.log(sign_password.value)

    if (sign_username.value ==="")
    {
        alert("请输入用户名");
        sign_username.focus();
        return false;
    }
    if (sign_email.value === "")
    {
        alert("请输入邮箱")
        sign_email.focus();
        return false;
    }
    if (sign_password.value === "")
    {
        alert("请输入密码");
        sign_password.focus();
        return false;
    }
    if (sign_password.value !== confirm_password.value)
    {
        alert("注册密码与确认密码不一致")
        confirm_password.focus();
        return false;
    }
    return true;
}


function alert_()
{
    // alert("测试")
    var login = document.getElementById("login");
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    if(null === username || "" === username.value) {
        alert("请输入用户名");
        login.disabled=true;
    }
    if(null === password || "" === password.value) {
        alert("请输入密码");
        login.disabled=true;
    }
    $.ajax({
            url: "http://localhost:8080",
            type: "POST",
            data: {
                "username":username.value,
                "password":password.value
            },
            dataType : "json",
            success : function (data)
            {
                if (data.status === "ok")
                {
                    window.location.href("index.html")
                }
            },
        }
    );
}

