var choiceUserId="";
var choiceUserName="";
var choiceDeptId="";
var choicePositionId="";


function choiceUser(flag){
	var url=this.getDomain()+"/page/choiceUser?preffix=flowConf&flag="+flag;
	openWindow(url,"",780,400);
	return false;
}

function openWindow(url,name,iWidth,iHeight){
	 var url;                            //转向网页的地址;
	 var name;                           //网页名称，可为空;
	 var iWidth;                         //弹出窗口的宽度;
	 var iHeight;                        //弹出窗口的高度;
	 var iTop = (window.screen.height-30-iHeight)/2;       //获得窗口的垂直位置;
	 var iLeft = (window.screen.width-10-iWidth)/2;        //获得窗口的水平位置;
	 window.open(url,name,'height='+iHeight+',,innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}

function choiceClose(flag){
	if(flag=="1"){
		$("input[name='userName']").val(choiceUserName);
		$("input[name='userId']").val(choiceUserId);
		$("select[name='deptId'] option[value="+choiceDeptId+"]").attr("selected", true); 
		$("select[name='positionId'] option[value="+choicePositionId+"]").attr("selected", true); 
	}else if(flag=="2"){
		var userNameOrder=$("input[name='userNameOrder']").val();
		var userIdOrder=$("input[name='userIdOrder']").val();
		var userNames=userNameOrder+","+choiceUserName;
		var userIds=userIdOrder+","+choiceUserId;
		if(userNames.indexOf(",")==0){
			userNames=userNames.substring(1);
			userIds=userIds.substring(1);
		}
		$("input[name='userNameOrder']").val(userNames);
		$("input[name='userIdOrder']").val(userIds);
	}
}

function deleteUser(flag){
	if(flag=="1"){
		$("input[name='userName']").val("");
		$("input[name='userId']").val("");
	}else if(flag=="2"){
		var userNameOrder=$("input[name='userNameOrder']").val();
		var userIdOrder=$("input[name='userIdOrder']").val();
		userNameOrder=userNameOrder.substring(0,userNameOrder.lastIndexOf(","));
		userIdOrder=userIdOrder.substring(0,userIdOrder.lastIndexOf(","));
		$("input[name='userNameOrder']").val(userNameOrder);
		$("input[name='userIdOrder']").val(userIdOrder);
	}
	return false;
}


function check(){
	var flowType=$("select[name='flowType'] option:selected").val();
	if(flowType==""){
		alert("请选择流程类型");
		return false;
	}
	var deptId=$("select[name='deptId'] option:selected").val();
	if(deptId==""){
		alert("请选择部门");
		return false;
	}
	var positionId=$("select[name='positionId'] option:selected").val();
	if(positionId==""){
		alert("请选择职位");
		return false;
	}
	var userIdOrder=$("input[name='userIdOrder']").val();
	if(userIdOrder==""){
		alert("请填选择审核人");
		return false;
	}
	return true;
}
