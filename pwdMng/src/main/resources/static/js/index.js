$(function(){
    // 编辑方法
    $(".user_edit").click(function () {
        var index = $(this).data('index');
        $('.editbox').removeClass('hide');
        var editdata = userllist[index];
        $('#use_name_edit').val(editdata.user_name);
        $('#use_password_edit').val(editdata.user_password);
        $('#use_type_edit').val(editdata.type);
        $('#use_mobile_edit').val(editdata.mobile);
    });

    $(".search").click(function () {
        $('.searchbox').removeClass('hide');
    });
    $(".add").click(function () {
        $('.addbox').removeClass('hide');
    });
    $(".close").click(function(){
        $(".form-data").addClass('hide');
    });

    //初始查询
    searchbtn();

});


function searchbtn(){
    var code = $.trim($('#code').val());
    var userId = sessionStorage.getItem("userId");
    var ldata = {"userId":userId,"loginCode":code}

    $.ajax({
        url: '/pwd/list/',
        type: 'POST',
        dataType: 'json',
        contentType:'application/json',
        async: true,
        data: JSON.stringify(ldata),
        success:function(data){
            console.log(data);
            if (data.resultCode == '0000') {
                initlists(data.data);
            } else {
                alert(data.resultMsg);
            }
        },
        error:function(ref){
            console.error(ref)
        }
    });
}

function addBtn(){
    var use_name = $.trim($('#use_name').val());
    var use_password = $.trim($('#use_password').val());
    var use_type = $.trim($('#use_type').val());
    var use_mobile = $.trim($('#use_mobile').val());
    var userId = sessionStorage.getItem("userId");
    console.log("===="+userId);

    var ldata = {"loginCode":use_name,"loginPwd":use_password,"type":use_type,"mobile":use_mobile,"userId":userId}
    $.ajax({
        url: '/pwd/add/',
        type: 'POST',
        dataType: 'json',
        contentType:'application/json',
        async: true,
        data: JSON.stringify(ldata),
        success:function(data){
            console.log(data);
            if (data.resultCode == '0000') {
                alert("操作成功");
                window.location.href = "index.html";
            } else {
                alert(data.resultMsg);
            }
        },
        error:function(ref){
            console.log(ref,'ref')
        }
    });
}

function editinfo(ele){
    $('.editbox').removeClass('hide');
    $('#use_name_m').val(ele.loginCode);
    $('#use_password_m').val(ele.loginPwd);
    $('#use_type_m').val(ele.type);
    $('#use_mobile_m').val(ele.mobile);
}

function modBtn(){
    var use_name = $.trim($('#use_name_m').val());
    var use_password = $.trim($('#use_password_m').val());
    var use_type = $.trim($('#use_type_m').val());
    var use_mobile = $.trim($('#use_mobile_m').val());
    var userId = sessionStorage.getItem("userId");

    var ldata = {"loginCode":use_name,"loginPwd":use_password,"type":use_type,"mobile":use_mobile,"userId":userId}
    $.ajax({
        url: '/pwd/modify/',
        type: 'POST',
        dataType: 'json',
        contentType:'application/json',
        async: true,
        data: JSON.stringify(ldata),
        success:function(data){
            console.log(data);
            if (data.resultCode == '0000') {
                alert("操作成功");
                window.location.href = "index.html";
            } else {
                alert(data.resultMsg);
            }
        },
        error:function(ref){
            console.error(ref,'ref');
        }
    });
}

//列表渲染
function initlists(data) {
    if(data==null || data==''){
        return;
    }
    var listdom = '';
    data.forEach(function(ele,i){
        // var pwdInfo = ele;
        // console.log(pwdInfo);
        listdom +='<tr>' +
            '<td>'+i+'</td>' +
            '<td>'+ele.loginCode+'</td>' +
            '<td>'+ele.loginPwd+'</td>' +
            '<td>'+ele.type+'</td>' +
            '<td>'+ele.mobile+'</td>' +
            '<td class="user_edit" data-index="'+i+'" ' +
            '   onclick="editinfo('+ele+')">编辑</td>' +
            '</tr>';
    });
    $('table').append(listdom);
}


//查询
function queryPwd() {
    var userId = sessionStorage.getItem("userId");
    var loginCode = $.trim($('#loginCode').val());
    var key = $.trim($('#key').val());
    console.log(userId+"-"+loginCode);

    var ldata = {"loginCode":loginCode,"key":key,"userId":userId}
    $.ajax({
        url: '/pwd/decrypt/',
        type: 'POST',
        dataType: 'json',
        async: true,
        data: ldata,
        success:function(data){
            console.log(data);
            if (data.resultCode == '0000') {
                alert("密码为:"+data.data);
                window.location.href = "index.html";
            } else {
                alert(data.resultMsg);
            }
        },
        error:function(ref){
            console.error(ref,'ref');
        }
    });
}

function loginOut() {
    sessionStorage.clear();
}