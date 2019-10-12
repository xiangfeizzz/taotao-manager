<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>审批流转</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/css/pageCommon.css" />
<script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/script/commonUtils.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/script/flowList.js"></script>
</head>
<script type="text/javascript" async="async">

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
	var userName=$("input[name='userName']").val();
	var flowType=$("select[name='flowType'] option:selected").val();
	var flowStatus=$("select[name='flowStatus'] option:selected").val();
	var rangeTime=$("select[name='rangeTime'] option:selected").val();
	var param={userName:userName,flowType:flowType,flowStatus:flowStatus,rangeTime:rangeTime,pageNum:pageNum,pageSize:pageSize};
	var url="${pageContext.request.contextPath}/flow/getFlowList?type=check";
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
	    		loadPageBar(data);
	    		$("#TableData").html("");
	    		$.each(data.data.list,function(n,v){
	    			var tfont=$("#table").find("tfoot").clone();
	    			var flowId=v["flowId"];
	    			tfont.find("label[name='flowId']").text(flowId);
	    			tfont.find("label[name='userName']").text(v["userName"]);
	    			tfont.find("label[name='flowName']").text(v["flowName"]);
	    			tfont.find("label[name='flowType']").text(v["flowType"]);
	    			tfont.find("label[name='flowStatusDesc']").text(v["flowStatusDesc"]);
	    			tfont.find("label[name='flowStatus']").text(v["flowStatus"]);
	    			tfont.find("label[name='createTime']").text(v["createTime"]);
	    			var flowType=v["flowType"];
	    			var hrefInfo=loadInfoUrl(flowType);
	    			tfont.find("a[name='info']").attr("href",hrefInfo+flowId);
	    			$("#TableData").prepend(tfont.html());
	    		});
	    	}else{
	    		alert(data.resultMsg)
	    	}
	    }
	});
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
					待我审批
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
						<td>姓名<input type="text" name="userName" style="width: 45%" /></td>
						<td>流程类型
						 <select name="flowType"  >
                                <option value="" selected="selected">请选择流程</option>
                               	<option value="1">请假申请</option>
                                <option value="2">加班申请</option>
                                <option value="3">出差申请</option>
                                <option value="4">离职申请</option>
                                <option value="5">物品申领</option>
                                <option value="6">报销申请</option>
                            </select>
						</td>
						<td>流程状态
						 <select name="flowStatus" style="width: 60%">
                                <option value="" selected="selected">请选择流程状态</option>
                               	<option value="-1">待提交</option>
                               	<option value="0">待审核</option>
                               	<option value="1">审核中</option>
                               	<option value="2">审核通过</option>
                                <option value="3">审核拒绝</option>
                            </select>
						</td>
						
						<td>时长
						 <select name="rangeTime" style="width: 60%">
                                <option value="" selected="selected">请选择时长</option>
                               	<option value="3">近三个月</option>
                               	<option value="6">近半年</option>
                                <option value="12">近一年</option>
                            </select>
						</td>
						<td>
						 <div id="InputDetailBar" > 
					            <input type="image" src="${pageContext.request.contextPath}/style/images/button/query.PNG"  onclick="search(1)" />
					        </div>
						</td>
						</tr> 
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
					<td style="display:none">流程id</td> 
					<td >申请人</td>
					<td >流程类型</td>
					<td >流程状态</td>
					<td >创建时间</td>
					<td >操作</td>
				</tr>
			</thead>
			<tbody id="TableData" class="dataContainer" datakey="userList">

			</tbody>
			<tfoot class="TableDetail1 template" style="display:none">
				<tr class="TableDetail1 template" align="center"  style="display:run-in">
					<td style="display:none"><label name="flowId"></label></td>
					<td><label name="userName"></label></td>
					<td><label name="flowName"></label><label name="flowType" style="display:none"></label></td>
					<td><label name="flowStatusDesc"></label><label name="flowStatus" style="display:none"></label></td>
					<td><label name="createTime"></label></td>
					<td> 
						<a name="info" href="" >查看</a> 
						<a onclick="del(this)" href="">审核通过</a> 
						<a onclick="del(this)" href="">审核拒绝</a> 
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
