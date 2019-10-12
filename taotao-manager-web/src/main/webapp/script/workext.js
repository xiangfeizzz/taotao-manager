
function loadWorkextInfo(){
	var param={flowId:flowId};
	var url=this.getDomain()+"/flow/getFlowInfo";
	$.ajax({
	    url : url,
	    type : "POST",
	    async : true,
	    contentType: "application/json; charset=utf-8",
	    data : JSON.stringify(param),
	    dataType : 'json',
	    success : function(data) {
	    	if(data.resultCode=="000000"){
	    		var flow=data.data.tbFlow;
	    		$.each($("input").not($("input[type='radio']")),function(n,v){
	    			var name=$(v).attr("name");
	    			var value=flow[name];
	    			$(v).val(value);
	    		});
	    		$("[name='workextDesc']").val(flow['workextDesc']);
	    		$("select[name='isLegalDay'][option[value='"+flow.isLegalDay+"']").attr("selected", true);
	    	}else{
	    		alert(data.resultMsg)
	    	}
	    }
	});
	
}

function check(){
	var workextHours=$("input[name='workextHours']").val();
	if(isNaN(workextHours) || workextHours.trim()==""){
		alert("加班时长不合法");
		return false;
	}
	var workextStartTime=$("input[name='workextStartTime']").val();
	if(workextStartTime==""){
		alert("请选择开始日期");
		return false;
	}
	var workextEndTime=$("input[name='workextEndTime']").val();
	if(workextEndTime==""){
		alert("请选择结束日期");
		return false;
	}
	
	var isLegalDay=$("select[name='isLegalDay'] option:selected").val();
	if(isLegalDay==""){
		alert("请选择是否法定假日");
		return false;
	}
	
	var workextDesc=$("textArea[name='workextDesc']").val();
	if(workextDesc==""){
		alert("请填写加班事由");
		return false;
	}
	return true;
}