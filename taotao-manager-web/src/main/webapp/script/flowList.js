
function loadInfoUrl(flowType){
	var url="";
	if(flowType=="1"){
		url=this.getDomain()+"/page/holidayInfo?preffix=flow&flowId=";
	}else if(flowType=="2"){
		url=this.getDomain()+"/page/workextInfo?preffix=flow&flowId=";
	}
	return url;
}

function loadUpdUrl(flowType){
	var url="";
	if(flowType=="1"){
		url=this.getDomain()+"/page/holidayUpd?preffix=flow&flowId=";
	}else if(flowType=="2"){
		url=this.getDomain()+"/page/workextUpd?preffix=flow&flowId=";
	}
	return url;
}

function del(obj){
	var flowStatus=$(obj).parent().parent().find("label[name='flowStatus']").text();
	if(flowStatus!="0"){
		alert("非起草状态不能删除");
		return false;
	}
	
	if(window.confirm('确定删除么')){
		var flowId=$(obj).parent().parent().find("label[name='flowId']").text();
		var param={flowId:flowId};
		var url=this.getDomain()+"/flow/flowDel";
		$.ajax({
		    url : url,
		    type : "POST",
		    async : true,
		    contentType: "application/json; charset=utf-8",
		    data : JSON.stringify(param),
		    dataType : 'json',
		    success : function(data) {
		    	if(data.resultCode=="000000"){
		    		$(obj).parent().parent().remove();
		    		alert("删除成功");
		    	}else{
		    		alert(data.resultMsg)
		    	}
		    }
		});
     }
}

function back(obj){
	var flowStatus=$(obj).parent().parent().find("label[name='flowStatus']").text();
	if(flowStatus!="1"){
		alert("非待审核状态不能撤回");
		return false;
	}
	
	if(window.confirm('确定撤回么')){
		var flowId=$(obj).parent().parent().find("label[name='flowId']").text();
		var param={flowId:flowId};
		var url=this.getDomain()+"/flow/flowBack";
		$.ajax({
		    url : url,
		    type : "POST",
		    async : true,
		    contentType: "application/json; charset=utf-8",
		    data : JSON.stringify(param),
		    dataType : 'json',
		    success : function(data) {
		    	if(data.resultCode=="000000"){
		    		$(obj).parent().parent().remove();
		    		alert("撤回成功");
		    	}else{
		    		alert(data.resultMsg)
		    	}
		    }
		});
     }
}

function flowSubmit(obj){
	var flowStatus=$(obj).parent().parent().find("label[name='flowStatus']").text();
	if(flowStatus!="0" && flowStatus!="4"){
		alert("起草状态、审核拒绝状态才能提交");
		return false;
	}
	
	if(window.confirm('确定提交么')){
		var flowId=$(obj).parent().parent().find("label[name='flowId']").text();
		var param={flowId:flowId};
		var url=this.getDomain()+"/flow/flowSubmit";
		$.ajax({
		    url : url,
		    type : "POST",
		    async : true,
		    contentType: "application/json; charset=utf-8",
		    data : JSON.stringify(param),
		    dataType : 'json',
		    success : function(data) {
		    	if(data.resultCode=="000000"){
		    		$(obj).parent().parent().remove();
		    		alert("提交成功");
		    	}else{
		    		alert(data.resultMsg)
		    	}
		    }
		});
     }
}