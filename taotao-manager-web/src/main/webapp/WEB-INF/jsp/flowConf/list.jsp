<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>审批流转</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/css/pageCommon.css" />
<script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/script/commonUtils.js" charset="utf-8"></script>
</head>
<script type="text/javascript" async="async">

var loginName='${loginName}';
var page;
var pageNum=1;
var pageSize=10;

$(function(){
	loadDept($("select[name='deptId']"));
	loadPosition($("select[name='positionId']"));
	search();
});

function search(pNum){
	if (pNum != undefined) {
		if(pNum==0){
			return;
		}
		pageNum=pNum;
	}
	var flowType=$("select[name='flowType'] option:selected").val();
	var deptId=$("select[name='deptId'] option:selected").val();
	var positionId=$("select[name='positionId']").val();
	var param={flowType:flowType,deptId:deptId,positionId:positionId,pageNum:pageNum,pageSize:pageSize};
	var url="${pageContext.request.contextPath}/flowConf/getFlowConfList";
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
	    			var confId=v["confId"];
	    			tfont.find("label[name='confId']").text(confId);
	    			tfont.find("label[name='deptName']").text(v["deptName"]);
	    			tfont.find("label[name='positionName']").text(v["positionName"]);
	    			tfont.find("label[name='userName']").text(v["userName"]);
	    			tfont.find("label[name='flowName']").text(v["flowName"]);
	    			tfont.find("label[name='userNameOrder']").text(v["userNameOrder"]);
	    			tfont.find("label[name='createTime']").text(v["createTime"]);
	    			var hrefUpd="${pageContext.request.contextPath}/page/upd?preffix=flowConf&confId=";
	    			tfont.find("a[name='upd']").attr("href",hrefUpd+confId);
	    			$("#TableData").append(tfont.html());
	    		});
	    	}else{
	    		alert(data.resultMsg)
	    	}
	    }
	});
}

function del(obj){
	if(window.confirm('确定删除么')){
		var confId=$(obj).parent().parent().find("label[name='confId']").text();
		var param={confId:confId};
		var url="${pageContext.request.contextPath}/flowConf/del";
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

function add(){
	window.location.href="${pageContext.request.contextPath}/page/add?preffix=flowConf";
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
					流程配置查询
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
						<td>流程类型</td>
						<td>
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
						<td>部门</td>
                        <td>
                        	 <select name="deptId" >
                                <option value="" selected="selected">请选择部门</option>
                            </select>
                        </td>
                        <td>职位</td>
                        <td>
                        	 <select name="positionId" >
                                <option value="" selected="selected">请选择职位&nbsp;&nbsp;</option>
                            </select>
                        </td>
                        <td>
							 <div id="InputDetailBar" style="float: left"> 
					            <input type="image" src="${pageContext.request.contextPath}/style/images/button/query.PNG"  onclick="search(1)" />
					            <input type="image" src="${pageContext.request.contextPath}/style/images/button/createNew.png"  onclick="add()" />
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
					<td style="display:none">流程配置编号</td> 
					<td >部门</td> 
					<td >职位</td>
					<td >员工姓名</td>
					<td >流程类型</td>
					<td >审核人</td>
					<td >创建时间</td>
					<td >操作</td>
				</tr>
			</thead>
			<tbody id="TableData" class="dataContainer" datakey="userList">

			</tbody>
			<tfoot class="TableDetail1 template" style="display:none">
				<tr class="TableDetail1 template" align="center"  style="display:run-in">
					<td style="display:none"><label name="confId"></label></td>
					<td><label name="deptName"></label></td>
					<td><label name="positionName"></label></td>
					<td><label name="userName"></label></td>
					<td><label name="flowName"></label></td>
					<td><label name="userNameOrder"></label></td>
					<td><label name="createTime"></label></td>
					<td> 
						<a onclick="del(this)">删除</a> 
						<a name="upd"  href="" >修改</a> 
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
