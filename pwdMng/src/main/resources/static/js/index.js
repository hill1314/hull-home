$(function(){
	$(".search").click(function () {
		$('.searchbox').removeClass('hide');
    });
	$(".add").click(function () {
		$('.addbox').removeClass('hide');
   });   
    $(".close").click(function(){
    	$(".form-data").addClass('hide');
    })
	searchbtn();
});
    function editinfo(){
		$('.editbox').removeClass('hide');    	
    }
    
	function searchbtn(){
		var code = $.trim($('#code').val());
		var ldata = {"userId":"1","loginCode":code}
		$.ajax({
		    url: '/pwd/list/',
		        type: 'POST',
		        dataType: 'json',
            	contentType:'application/json',
		        async: true,
		        data: JSON.stringify(ldata),
		        success:function(data){
		        	console.log(data)
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

    var ldata = {"loginCode":use_name,"loginPwd":use_password,"type":use_type,"mobile":use_mobile}
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

function modBtn(){
    var use_name = $.trim($('#use_name_m').val());
    var use_password = $.trim($('#use_password_m').val());
    var use_type = $.trim($('#use_type_m').val());
    var use_mobile = $.trim($('#use_mobile_m').val());

    var ldata = {"loginCode":use_name,"loginPwd":use_password,"type":use_type,"mobile":use_mobile}
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
