<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>员工查询</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/css/pageCommon.css" />
<script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
</head>
<script type="text/javascript" async="async">

var loginName='${loginName}';
var flag='${flag}';
var page;
var pageNum=1;
var pageSize=5;

$(function(){
	search();
});

function search(pNum){
	if (pNum != undefined) {
		if(pNum==0){
			return;
		}
		pageNum=pNum;
	}
	var qryUserName=$("input[name='qryUserName']").val();
	var param={loginName:loginName,qryUserName:qryUserName,pageNum:pageNum,pageSize:pageSize};
	var url="${pageContext.request.contextPath}/user/getUserList";
	$.ajax({
	    url : url,
	    type : "POST",
	    async : true,
	    contentType: "application/json; charset=utf-8",
	    data : JSON.stringify(param),
	    dataType : 'json',
	    success : function(data) {
	    	if(data.resultCode=="000000"){
	    		var user=data.data.tbUser;
	    		$("input[name='firstPage']").val(data.data.firstPage);
	    		$("input[name='prePage']").val(data.data.prePage);
	    		$("input[name='nextPage']").val(data.data.nextPage);
	    		$("input[name='lastPage']").val(data.data.lastPage);
	    		
	    		$("label[name='pageNum']").text(data.data.pageNum);
	    		$("label[name='pages']").text(data.data.pages);
	    		$("label[name='pageSize']").text(data.data.pageSize);
	    		$("label[name='total']").text(data.data.total);
	    		$("#TableData").html("");
	    		$.each(data.data.list,function(n,v){
	    			var tfont=$("#table").find("tfoot").clone();
	    			var userId=v["userId"];
	    			tfont.find("label[name='userId']").text(userId);
	    			tfont.find("label[name='loginName']").text(v["loginName"]);
	    			tfont.find("label[name='userName']").text(v["userName"]);
	    			var deptId=v["deptId"];
	    			var positionId=v["positionId"];
	    			$.each(window.opener.window.dept,function(n,v){
		    			 if(v.deptId==deptId){
		    				 tfont.find("label[name='deptName']").text(v.deptName);
		    				 tfont.find("input[name='deptId']").val(deptId);
		    			 }
		    		});
	    			$.each(window.opener.window.position,function(n,v){
		    			 if(v.positionId==positionId){
		    				 tfont.find("label[name='positionName']").text(v.positionName);
		    				 tfont.find("input[name='positionId']").val(positionId);
		    			 }
		    		});
	    			
	    			tfont.find("label[name='userName']").text(v["userName"]);
	    			
	    			$("#TableData").prepend(tfont.html());
	    		});
	    	}else{
	    		alert(data.resultMsg)
	    	}
	    }
	});
}

function choice(){
		var checked=$("input[type='checkbox']:checked");
		var userId=$(checked).parent().parent().find("label[name='userId']").text();
		var userName=$(checked).parent().parent().find("label[name='userName']").text();
		var deptId=$(checked).parent().parent().find("input[name='deptId']").val();
		var positionId=$(checked).parent().parent().find("input[name='positionId']").val();
		window.opener.window.choiceUserId=userId;
		window.opener.window.choiceUserName=userName;
		window.opener.window.choicePositionId=positionId;
		window.opener.window.choiceDeptId=deptId;
		window.opener.window.choiceClose(flag);
		window.close();
}


</script>
<body>


<div id=MainArea>
<div style="padding-left: 50px;">
         <div class="ItemBlock_Title1"><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/images/item_point.gif"> 查询条件 </div> 
         </div>
		<div class="ItemBlockBorder">
			<div class="ItemBlock">
				<table cellpadding="0" cellspacing="0" class="mainForm">
					<tr>
						<td>姓名&nbsp;&nbsp;<input type="text" name="qryUserName" /></td>
						<td>
							 <div id="InputDetailBar" style="float: left"> 
					            <input type="image" src="${pageContext.request.contextPath}/style/images/button/query.PNG"  onclick="search(1)" />
					            <input type="image" src="${pageContext.request.contextPath}/style/images/button/select.PNG"  onclick="choice()" />
					        </div>
						</td>
					</tr>
				</table>
			</div>
		</div>
		
		<table id="table" border="0" cellspacing="0" cellpadding="0" style="margin-top: 0px;width:98%" class="TableStyle">
		<div class="ItemBlock_Title1"><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/images/item_point.gif"> 查询结果 </div> 
         </div>
			<thead>
				<tr align=center valign=middle id=TableTitle>
					<td></td>
					<td style="display:none">用户编号</td> 
					<td >登录名</td> 
					<td >姓名</td>
					<td >部门</td>
					<td >职位</td>
				</tr>
			</thead>
			<tbody id="TableData" class="dataContainer" datakey="userList">

			</tbody>
			<tfoot class="TableDetail1 template" style="display:none">
				<tr class="TableDetail1 template" align="center"  style="display:run-in">
					<td><input type="checkbox" /></td>
					<td style="display:none"><label name="userId"></label></td>
					<td><label name="loginName"></label></td>
					<td><label name="userName" ></label></td>
					<td><label name="deptName" ></label> <input type="hidden" name="deptId" ></input></td>
					<td><label name="positionName" ></label> <input type="hidden" name="positionId" ></input></td>
				</tr>
			</tfoot>
		</table>


		<div class="ItemBlock_Title1" />
		<div>
			<div style="float: left;">
				页次：<label name="pageNum" ></label>/<label name="pages" ></label>页 &nbsp;
				每页显示：<label name="pageSize" ></label>条&nbsp;总记录数：<label name="total" ></label>条&nbsp;</div>
			<input type="image" name="firstPage" src="${pageContext.request.contextPath}/style/images/btn_all_left.gif" onclick="search(this.value)" />
			<input type="image" name="prePage" src="${pageContext.request.contextPath}/style/images/btn_to_left.gif"  onclick="search(this.value)" />
			<input type="image" name="nextPage" src="${pageContext.request.contextPath}/style/images/btn_to_right.gif"  onclick="search(this.value)" />
			<input type="image" name="lastPage" src="${pageContext.request.contextPath}/style/images/btn_all_right.gif" onclick="search(this.value)"  />
		</div>
		</div>
	</div>
</body>
</html>
