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
});
    function editinfo(){
		$('.editbox').removeClass('hide');    	
    }
    
	function searchbtn(){
		var inp = $.trim($('#num').val());
		var pass = $.trim($('#pass').val());
		var ldata = {mode:'raw',raw:1}
		$.ajax({
		    url: 'http://97.64.82.90:9000/pwd/list/',
		        type: 'post',
		        dataType: 'json',
		        async: true,
		        data: ldata,
		        success:function(data){
		        	console.log(data,'data')
		        },
		        error:function(ref){
					Console.log(ref,'ref')
		        }
	    });
	}
