
function loadHolidayInfo(){
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
	    		$("[name='holidayDesc']").val(flow['holidayDesc']);
	    		$("select[name='holidayType'][option[value='"+flow.holidayType+"']").attr("selected", true);
	    	}else{
	    		alert(data.resultMsg)
	    	}
	    }
	});
}

function check(){
	var holidayType=$("select[name='holidayType'] option:selected").val();
	if(holidayType==""){
		alert("请选择请假类型");
		return false;
	}
	var holidayHours=$("input[name='holidayHours']").val();
	if(isNaN(holidayHours) || holidayHours.trim()==""){
		alert("请假时长不合法");
		return false;
	}
	var holidayStartTime=$("input[name='holidayStartTime']").val();
	if(holidayStartTime==""){
		alert("请选择开始日期");
		return false;
	}
	var holidayEndTime=$("input[name='holidayEndTime']").val();
	if(holidayEndTime==""){
		alert("请选择结束日期");
		return false;
	}
	
	var holidayDesc=$("textArea[name='holidayDesc']").val();
	if(holidayDesc==""){
		alert("请填写请假事由");
		return false;
	}
	return true;
}
