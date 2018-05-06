$(function(){
	var tab = 'account_number';
	// 选项卡切换
	$(".account_number").click(function () {
		$('.tel-warn').addClass('hide');
		tab = $(this).attr('class').split(' ')[0];
        $(this).addClass("on");
        $(".message").removeClass("on");
        $(".form2").addClass("hide");
        $(".form1").removeClass("hide");
    });
	// 选项卡切换
	$(".message").click(function () {
		$('.tel-warn').addClass('hide');
		tab = $(this).attr('class').split(' ')[0];
		$(this).addClass("on");
        $(".account_number").removeClass("on");
		$(".form2").removeClass("hide");
		$(".form1").addClass("hide");
		
    });

	$('#num').keyup(function(event) {
		$('.tel-warn').addClass('hide');
	});

	$('#pass').keyup(function(event) {
		$('.tel-warn').addClass('hide');
	});


	$('#num2').keyup(function(event) {
		$('.tel-warn').addClass('hide');
	});
	
	$(".log-btn").click(function(){
		var inp = $.trim($('#name').val());
        var pass = $.trim($('#pwd').val());
        if (checkAccount(inp) && checkPass(pass)) {
			var ldata = {name:inp,pwd:pass};
			$.ajax({
	            url: '/user/login',
	            type: 'post',
	            dataType: 'json',
	            async: true,
	            data: ldata,
	            success:function(data){
	            	console.log(data);
	                if (data.resultCode == '0000') {
	                	alert("登陆成功");
                        window.location.href = "index.html";
	                } else {
						alert(data.resultMsg);
	                }
	            },
	            error:function(){
	                // window.location.href = "index.html";
	            }
	        });
		} else {
			return false;
		}
	});
	
	$(".regbtn").click(function(){
		var inp = $.trim($('#name').val());
		var pass = $.trim($('#passport').val());
		var confirmPwd = $.trim($('#passport2').val());

		console.log(inp+"-"+pass+"-"+confirmPwd)
        if(checkAccount(inp) && checkPass(pass) && checkCPass(confirmPwd,pass)){
            var ldata = {"mobile":"123","name":inp,"password":pass,"verifyCode":"123"};
            $.ajax({
                url: '/user/register',
                type: 'POST',
                dataType: 'json',
				contentType:'application/json',
                async: true,
                data: JSON.stringify(ldata),
                success:function(data){
                    console.log(data);
                    if (data.resultCode == '0000') {
                        alert("注册成功");
                        window.location.href = "index.html";
                    } else {
                        alert(data.resultMsg);
                    }
                },
                error:function(msg){
                	console.error(msg);
                    // window.location.href = "reg.html";
                }
            });
        }
	});
	
	function checkAccount(username){
		if (username == '') {
			$('.num-err').removeClass('hide').find("em").text('请输入账户');
			return false;
		} else {
			$('.num-err').addClass('hide');
			return true;
		}
	}

	function checkPass(pass){
		if (pass == '') {
			$('.pass-err').removeClass('hide').text('请输入密码');
			return false;
		} else {
			$('.pass-err').addClass('hide');
			return true;
		}
	}

    function checkCPass(confirmPwd,pass) {
        if (confirmPwd == '') {
            $('.confirmpwd-err').removeClass('hide').text('请输入确认密码');
            return false;
        } else if(confirmPwd!=pass){
            $('.confirmpwd-err').removeClass('hide').text('两次输入的密码不一致');
            return false;
        } else {
            $('.confirmpwd-err').addClass('hide');
            return true;
        }
    }

	// 登录的回车事件
	$(window).keydown(function(event) {
    	if (event.keyCode == 13) {
    		$('.log-btn').trigger('click');
    	}
    });
});