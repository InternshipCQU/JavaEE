//
// $.ajax({
//     url:"https://"+window.location.host+"/changebackground",
//     type:"GET",
//     data:JSON.stringify(document.getElementById("userId").innerHTML),
//     dataType:"json",
//     success:function(data){
//         document.getElementById('imageshow').src=data;
//     },
//     error:function(){
//         alert("ERROR!");
//     }
// })

function previewImage(file) {
    var img = document.getElementById('imageshow');
    var reader = new FileReader();
    reader.onload = function (evt) { img.src = evt.target.result; }
    reader.readAsDataURL(file.files[0]);
}

    function getuser(){
    $.ajax({
        url:"http://"+window.location.host+"/getusersess",
        type:"GET",
        data:{},
        dataType:"json",
        success:function(recdata){
            // alert("a "+data);
            document.getElementById("userId").innerHTML=recdata.userId;
            document.getElementById("useralias").innerHTML=recdata.username;
            document.getElementById("usernameopt").innerHTML=recdata.username;
            // document.getElementById("imageshow").src=recdata.background;
            if(recdata.userprofile!==undefined) {
                document.getElementById("userprofileopt").innerHTML = recdata.userprofile;
            }
            else
            {
                document.getElementById("userprofileopt").innerHTML="";
            }
            // document.getElementById("userprofileopt").innerHTML=recdata.userprofile;
            document.getElementById("email").innerHTML=recdata.email;
            if(recdata.radiovl=="0")
            {
                document.getElementById("radioval").innerHTML="Men";
            }
            else
            {
                document.getElementById("radioval").innerHTML="Women";
            }
            document.getElementById("userlastname").innerHTML=recdata.lastname;
            document.getElementById("userfirstname").innerHTML=recdata.firstname;
            document.getElementById("area").innerHTML=recdata.area;
            document.getElementById("telephone").innerHTML=recdata.telephone;

            document.getElementById("lastlogin").innerHTML=recdata.lastlogin;
            document.getElementById("userRefisiterTime").innerHTML=recdata.userRefisiterTime;
            document.getElementById("blogsNum").innerHTML=recdata.blogsNum;
            document.getElementById("fansNum").innerHTML=recdata.fansNum;
            document.getElementById("likesNum").innerHTML=recdata.likesNum;
            document.getElementById("birthdate").innerHTML=recdata.birthdate;
            var avatarfile=recdata.avatar;
            var o1=document.getElementById("avatarfile");
            o1.innerHTML="<img src=\""+avatarfile+"\" alt=\"\"\>";
            var o2=document.getElementById("inputtemp");

            o2.innerHTML="<input name=\"userId\" value="+recdata.userId.toString()+ " type=\"hidden\">";
            var o3=document.getElementById("inputbackgroundtemp");
            o3.innerHTML="<img src=\""+recdata.background+"\" id=\"imageshow\" alt=\"\"> \n";
            var o4=document.getElementById("inputtemp2");
            o4.innerHTML="<input name=\"userId\" value="+recdata.userId.toString()+ " type=\"hidden\">";
            getfollowlist(recdata.userId);
            getfavoriteslist(recdata.userId);
            uploadfiles(recdata.userId.toString());
            showbackground(recdata.userId.toString());

        }
    })

}

    function uploadfiles(userId){
        $.ajax({
            url:"http://"+window.location.host+"/upload",
            type:"POST",
            data: {},
            dataType:"json",
            success:function(data){
                $("#img_input").on("change", function (e) {
                    var file = e.target.files[0]; //获取图片资源
                    // 只选择图片文件
                    alert(file.type);
                    if (!file.type.match('image.*')) {
                        return false;
                    }
                    var reader = new FileReader();
                    reader.readAsDataURL(file); // 读取文件
                    // alert("RECEIVED FILE");
                    // 渲染文件
                    reader.onload = function (arg) {

                        var img = '<img class="preview" src="' + reader.result + '" alt="preview"/>';
                        $(".preview_box").empty().append(img);
                    }
                });
            }})
    }

    function showbackground(userId){
        $.ajax({
            url:"http://"+window.location.host+"/changebackground",
            type:"POST",
            data: {},
            dataType:"json",
            success:function(data){
                $("#input_2").on("change", function (e) {
                    var file = e.target.files[0]; //获取图片资源
                    // 只选择图片文件
                    alert(file.type);
                    if (!file.type.match('image.*')) {
                        return false;
                    }
                    var reader = new FileReader();
                    reader.readAsDataURL(file); // 读取文件
                    // alert("RECEIVED FILE");
                    // 渲染文件
                    reader.onload = function (arg) {

                        var img = '"<img src=\\"'+reader.result+'\\" id=\\"imageshow\\" alt=\\"\\">";';
                        $(".bg_preview_box").empty().append(img);
                    }
                });
            }})
    }

    function changestatus(){
    $.ajax({
        url:"http://"+window.location.host+"/changecontent",
        type:"GET",
        data:{"flag":"a"},
        dataType:"json",
        success:function(data){

            var o1=document.getElementById("userprofileopt");
            var c1=o1.innerHTML;
            o1.innerHTML="<input type='text' id='userprofileopt2' name='useralias' size='30' maxlength='130' >";
            var o2=document.getElementById("useralias");
            var c2=o2.innerHTML;
            o2.innerHTML="<input type='text' id='useralias2' name='useralias' size='12' maxlength='80' >";
            var o3=document.getElementById("email");
            var c3=o3.innerHTML;
            o3.innerHTML="<input type='text' id='email2' name='email' size='16' maxlength='60' value="+c3+">";
            var o4=document.getElementById("radioval");
            var c4=o4.innerHTML;
            if (c4==="男"){
                o4.innerHTML="<input type= 'radio' id='radioval2' name= 'radioval2' value= '0'  checked='checked'/> Men<input type= 'radio' id='radioval2' name= 'radioval2' value= '1'/> Women"}
            else
            {
                o4.innerHTML="<input type= 'radio' id='radioval2' name= 'radioval2' value= '0' /> Men<input type= 'radio' id='radioval2' name= 'radioval2' value= '1'  checked/> Women"
            }

            var o5=document.getElementById("userlastname");
            var c5=o5.innerHTML;
            o5.innerHTML="<input type='text' id='userlastname2' name='userlastname' size='12' maxlength='15' value="+c5+">";
            var o6=document.getElementById("userfirstname");
            var c6=o6.innerHTML;
            o6.innerHTML="<input type='text' id='userfirstname2' name='userfirstname' size='12' maxlength='15' value="+c6+">";
            var o7=document.getElementById("area");
            var c7=o7.innerHTML;
            o7.innerHTML="<select id='selectlist'>\n <option value='Mainland China'>Mainland China</option>\n<option value='Hong Kong'>Hong Kong</option>\n" +
                "                                                <option value='Macao'>Macao</option>\n<option value='Taiwan'>Taiwan</option>\n <option value='Canada'>Canada</option>\n<option value='United States'>United States</option>\n" +
                "                                                <option value='United Kingdom'>United Kingdom</option>\n<option value='Singapore'>Singapore</option>\n<option value='Japan'>Japan</option>\n" +
                "                                                <option value='Korea'>Korea</option>\n<option value='Australia'>Australia</option>\n<option value='Germany'>Germany</option>\n" +
                "                                            </select>\n</div>";
            var o8=document.getElementById("telephone");
            var c8=o8.innerHTML;
            o8.innerHTML="<input type='text' id='telephone2' name='telephone' size='12' maxlength='11' value="+c8+">";
            var o9=document.getElementById("lookp");
            // var c9=o9.innerHTML;
            o9.innerHTML=" <a href='JavaScript:void(0);' onClick='check()'> 保存资料</a>";
            var o10=document.getElementById("birthdate");
            var c10=o10.innerHTML;

            o10.innerHTML="<input id=\"birthdate2\" type=\"date\" placeholder="+c10+"\" value="+c10+"/>";
        }})

}


    function check(){
    $.ajax({
        url:"http://"+window.location.host+"/changecontent",
        type:"GET",
        data:{"flag":"a"},
        dataType:"json",
        success:function(data){

            // var o1=document.getElementById("userId");
            // var c1=o1.innerHTML;
            // o1.innerHTML="<input type='text' name='userId' size='12' maxlength='8' readonly='true' placeholder="+c1+">"
            var o1=document.getElementById("useralias2").value;
            var c1=document.getElementById("useralias");
            var c2=document.getElementById("usernameopt");
            if(o1==="") {
                alert("Username cannot be null!")
                location.reload()

            }
            else {
                c1.innerHTML = o1
                c2.innerHTML = o1
            }
            var o2=document.getElementById("email2").value;
            var c2=document.getElementById("email");
            if(o2==="") {
                alert("Email cannot be null!")
                location.reload()
            }
            else {
                c2.innerHTML=o2
            }
            var o3=document.getElementById("userlastname2").value;
            var c3=document.getElementById("userlastname");
            if(o3===""){
                alert("Last name cannot be null!")
                location.reload()
            }
            else{
                c3.innerHTML=o3
            }
            var o4=document.getElementById("userfirstname2").value;
            var c4=document.getElementById("userfirstname");
            if(o4===""){
                alert("First name cannot be null!")
                location.reload()
            }
            else{
                c4.innerHTML=o4
            }
            var o5=document.getElementById("telephone2").value;
            var c5=document.getElementById("telephone");
            if(o5===""){
                alert("Telephone cannot be null!")
                location.reload()
            }
            else if (o5.length!==11){
                alert("The length of telephone number must be 11!")
                location.reload()
            }
            else{
                c5.innerHTML=o5

            }
            var o6=document.getElementById("radioval2");
            var c6=$("input:radio[name='radioval2']:checked").val();
            var oM_IN;
            if(c6==="1")
            {
                var o7=document.getElementById("radioval")
                o7.innerHTML="Women"
                oM_IN="W"
            }
            else {
                var o7=document.getElementById("radioval")
                o7.innerHTML="Men"
                oM_IN="M"
            }
            var o8=document.getElementById("selectlist");
            var c8=document.getElementById("area");
            c8.innerHTML=o8.value;
            var o9=document.getElementById("userprofileopt2");
            var c9=document.getElementById("userprofileopt");
            c9.innerHTML=o9.value;
            var o10=document.getElementById("lookp");
            // var c10=o10.innerHTML;
            o10.innerHTML="<a href=\"JavaScript:void(0);\" onClick=\"changestatus()\"> 编辑资料</a>";
            var o11=document.getElementById("birthdate2").value;
            var c11=document.getElementById("birthdate");
            if(o11===""){
                alert("Birthdate cannot be null!")
                location.reload()
            }
            else {
                c11.innerHTML = o11
            }
            var formData={
                userId:parseInt(document.getElementById("userId").innerHTML),
                username:o1,
                password:"NOT APPLICABLE",
                gender:oM_IN,
                email:o2,
                telephone:o5,
                firstname:o4,
                lastname:o3,
                avatar:"None",
                lastLogin:document.getElementById("lastlogin").innerHTML,
                fansNum:parseInt(document.getElementById("fansNum").innerHTML),
                likesNum:parseInt(document.getElementById("likesNum").innerHTML),
                blogsNum:parseInt(document.getElementById("blogsNum").innerHTML),
                userRegisterTime:document.getElementById("userRefisiterTime").innerHTML,
                birthdate:o11,
                profile:document.getElementById("userprofileopt").innerHTML,
                area:o8.value
            };
            if(formData.username!==""&&formData.birthdate!==""&&formData.firstname!==""&&formData.lastname!==""&&formData.telephone!==""&&formData.lastname!==""&&formData.firstname!=="")
            {
                submit(formData);
            }
        }})

}

    function submit(formData){

    // alert(document.getElementById("telephone").value);
    $.ajax({
        url:"http://"+window.location.host+"/submitinfo",
        type:"POST",
        data:JSON.stringify(formData),
        contentType:'application/json',
        dataType:"text",
        success:function(data){

        },
        error:function(xhr,textStatus,errorThrown){
            alert(xhr.status);
            alert("Something wrong.");
        }
    })
}


    function getfollowlist(userId) {
        $.ajax({
            url: "http://" + window.location.host + "/getfollow",
            type: "POST",
            data: JSON.stringify(userId),
            contentType: "application/json",
            dataType: "json",
            success: function (receivedata) {
                var c1 = document.getElementById("my_follows");
                // var BLOG1=receivedata.BLOG1;
                if (receivedata.FOLLOW1 === undefined) {
                    c1.innerHTML = "You dont follow any people."
                } else {
                    if (receivedata.FOLLOW1 !== undefined) {
                        c1.innerHTML = c1.innerHTML + "                                    <li class=\"list-group-item\">\n" +
                            "                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" viewBox=\"0 0 24 24\">\n" +
                            "                                            <path fill=\"currentColor\"\n" +
                            "                                                  d=\"M20 22H4a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1h16a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1zm-1-2V4H5v16h14zM7 6h4v4H7V6zm0 6h10v2H7v-2zm0 4h10v2H7v-2zm6-9h4v2h-4V7z\">\n" +
                            "                                            </path>\n" +
                            "                                        </svg>\n" +
                            "                                        <a href=" + receivedata.LINK1 + ">" + receivedata.FOLLOW1 + "</a> </li>"
                    }
                    if (receivedata.FOLLOW2 !== undefined) {
                        c1.innerHTML = c1.innerHTML + "                                    <li class=\"list-group-item\">\n" +
                            "                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" viewBox=\"0 0 24 24\">\n" +
                            "                                            <path fill=\"currentColor\"\n" +
                            "                                                  d=\"M20 22H4a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1h16a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1zm-1-2V4H5v16h14zM7 6h4v4H7V6zm0 6h10v2H7v-2zm0 4h10v2H7v-2zm6-9h4v2h-4V7z\">\n" +
                            "                                            </path>\n" +
                            "                                        </svg>\n" +
                            "                                        <a href=" + receivedata.LINK2 + ">" + receivedata.FOLLOW2 + "</a> </li>"
                    }

                    if (receivedata.FOLLOW3 !== undefined) {
                        c1.innerHTML = c1.innerHTML + "                                    <li class=\"list-group-item\">\n" +
                            "                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" viewBox=\"0 0 24 24\">\n" +
                            "                                            <path fill=\"currentColor\"\n" +
                            "                                                  d=\"M20 22H4a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1h16a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1zm-1-2V4H5v16h14zM7 6h4v4H7V6zm0 6h10v2H7v-2zm0 4h10v2H7v-2zm6-9h4v2h-4V7z\">\n" +
                            "                                            </path>\n" +
                            "                                        </svg>\n" +
                            "                                        <a href=" + receivedata.LINK3 + ">" + receivedata.FOLLOW3 + "</a> </li>"
                    }
                    if (receivedata.FOLLOW4 !== undefined) {
                        c1.innerHTML = c1.innerHTML + "                                    <li class=\"list-group-item\">\n" +
                            "                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" viewBox=\"0 0 24 24\">\n" +
                            "                                            <path fill=\"currentColor\"\n" +
                            "                                                  d=\"M20 22H4a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1h16a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1zm-1-2V4H5v16h14zM7 6h4v4H7V6zm0 6h10v2H7v-2zm0 4h10v2H7v-2zm6-9h4v2h-4V7z\">\n" +
                            "                                            </path>\n" +
                            "                                        </svg>\n" +
                            "                                        <a href=" + receivedata.LINK4 + ">" + receivedata.FOLLOW4 + "</a> </li>"
                    }

                }
            },
            error: function (xhr, textStatus, errorThrown) {
                alert(xhr.status);
                alert("Something wrong.");
            }
        })}

    function getfavoriteslist(userId) {
            $.ajax({
                url: "http://" + window.location.host + "/getfavorites",
                type: "POST",
                data: JSON.stringify(userId),
                contentType: "application/json",
                dataType: "json",
                success: function (receivedata) {
                    var c1 = document.getElementById("my_favorites");
                    // var BLOG1=receivedata.BLOG1;
                    if (receivedata.LIKES1 === undefined) {
                        c1.innerHTML = "There's no favorite blog."
                    } else {

                        if (receivedata.LIKES1 !== undefined) {
                            c1.innerHTML = c1.innerHTML + "                                    <li class=\"list-group-item\">\n" +
                                "                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" viewBox=\"0 0 24 24\">\n" +
                                "                                            <path fill=\"currentColor\"\n" +
                                "                                                  d=\"M20 22H4a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1h16a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1zm-1-2V4H5v16h14zM7 6h4v4H7V6zm0 6h10v2H7v-2zm0 4h10v2H7v-2zm6-9h4v2h-4V7z\">\n" +
                                "                                            </path>\n" +
                                "                                        </svg>\n" +
                                "                                        <a href=" + receivedata.LINK1 + ">" + receivedata.LIKES1 + "</a> </li>"
                        }
                        if (receivedata.LIKES2 !== undefined) {
                            c1.innerHTML = c1.innerHTML + "                                    <li class=\"list-group-item\">\n" +
                                "                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" viewBox=\"0 0 24 24\">\n" +
                                "                                            <path fill=\"currentColor\"\n" +
                                "                                                  d=\"M20 22H4a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1h16a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1zm-1-2V4H5v16h14zM7 6h4v4H7V6zm0 6h10v2H7v-2zm0 4h10v2H7v-2zm6-9h4v2h-4V7z\">\n" +
                                "                                            </path>\n" +
                                "                                        </svg>\n" +
                                "                                        <a href=" + receivedata.LINK2 + ">" + receivedata.LIKES2 + "</a> </li>"
                        }
                        if (receivedata.LIKES3 !== undefined) {
                            c1.innerHTML = c1.innerHTML + "                                    <li class=\"list-group-item\">\n" +
                                "                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" viewBox=\"0 0 24 24\">\n" +
                                "                                            <path fill=\"currentColor\"\n" +
                                "                                                  d=\"M20 22H4a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1h16a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1zm-1-2V4H5v16h14zM7 6h4v4H7V6zm0 6h10v2H7v-2zm0 4h10v2H7v-2zm6-9h4v2h-4V7z\">\n" +
                                "                                            </path>\n" +
                                "                                        </svg>\n" +
                                "                                        <a href=" + receivedata.LINK3 + ">" + receivedata.LIKES3 + "</a> </li>"
                        }
                        if (receivedata.LIKES4 !== undefined) {
                            c1.innerHTML = c1.innerHTML + "                                    <li class=\"list-group-item\">\n" +
                                "                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" viewBox=\"0 0 24 24\">\n" +
                                "                                            <path fill=\"currentColor\"\n" +
                                "                                                  d=\"M20 22H4a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1h16a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1zm-1-2V4H5v16h14zM7 6h4v4H7V6zm0 6h10v2H7v-2zm0 4h10v2H7v-2zm6-9h4v2h-4V7z\">\n" +
                                "                                            </path>\n" +
                                "                                        </svg>\n" +
                                "                                        <a href=" + receivedata.LINK4 + ">" + receivedata.LIKES4 + "</a> </li>"
                        }

                    }
                },
                error: function (xhr, textStatus, errorThrown) {
                    alert(xhr.status);
                    alert("Something wrong.");
                }
            })
    }
