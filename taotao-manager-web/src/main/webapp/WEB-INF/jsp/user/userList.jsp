<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>员工查询</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/css/pageCommon.css" />
<script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
</head>
<script type="text/javascript" async="async">

var loginName='${loginName}';
var page;
var pageNum=1;
var pageSize=10;

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
	    			var tfont=$("#table").find("tfoot");
	    			var userId=v["userId"];
	    			tfont.find("label[name='userId']").text(userId);
	    			tfont.find("label[name='loginName']").text(v["loginName"]);
	    			tfont.find("label[name='userName']").text(v["userName"]);
	    			tfont.find("label[name='sex']").text(v["sex"]);
	    			tfont.find("label[name='mobile']").text(v["mobile"]);
	    			tfont.find("label[name='eamil']").text(v["eamil"]);
	    			var hrefInfo="${pageContext.request.contextPath}/user/page/userInfo?preffix=user&userId=";
	    			var hrefUpd="${pageContext.request.contextPath}/user/page/userUpd?preffix=user&userId=";
	    			tfont.find("a[name='userInfo']").attr("href",hrefInfo+userId);
	    			tfont.find("a[name='userUpd']").attr("href",hrefUpd+userId);
	    			$("#TableData").prepend(tfont.html());
	    		});
	    	}else{
	    		alert(data.resultMsg)
	    	}
	    }
	});
}

function userDel(obj){
	if(window.confirm('确定删除么')){
		var userId=$(obj).parent().parent().find("label[name='userId']").text();
		var param={userId:userId,loginName:loginName};
		var url="${pageContext.request.contextPath}/user/userDel";
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

function userAdd(){
	window.location.href="${pageContext.request.contextPath}/user/page/userAdd?preffix=user&userName="+loginName;
}

</script>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<input type="image" border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
					员工查询
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

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
					<td style="display:none">用户编号</td> 
					<td >登录名</td> 
					<td >姓名</td>
					<td >性别</td>
					<td >手机</td>
					<td >邮箱</td>
					<td >相关操作</td>
				</tr>
			</thead>
			<tbody id="TableData" class="dataContainer" datakey="userList">

			</tbody>
			<tfoot class="TableDetail1 template" style="display:none">
				<tr class="TableDetail1 template" align="center"  style="display:run-in">
					<td style="display:none"><label name="userId">1</label></td>
					<td><label name="loginName">xucc</label></td>
					<td><label name="userName">xucc</label></td>
					<td><label name="sex">男</label></td>
					<td><label name="mobile">15150476209</label></td>
					<td><label name="eamil">15150476209@139.com</label></td>
					<td> 
						<a name="userInfo" href="" >查看</a> 
						<a onclick="userDel(this)">删除</a> 
						<a name="userUpd"  href="" >修改</a> 
					</td>
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
