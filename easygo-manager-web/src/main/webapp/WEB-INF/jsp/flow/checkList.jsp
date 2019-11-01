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
	
	var flowId="2";
	var param={flowId:flowId,pageSize:pageSize};
	var url="${pageContext.request.contextPath}/flowCheck/list";
	$.ajax({
	    url : url,
	    type : "POST",
	    async : true,
	    contentType: "application/json; charset=utf-8",
	    data : JSON.stringify(param),
	    dataType : 'json',
	    success : function(data) {
	    	if(data.resultCode=="000000"){
	    		var user=data.data;
	    		loadPageBar(data);
	    		$("#TableData").html("");
	    		$.each(data.data,function(n,v){
	    			var tfont=$("#table").find("tfoot").clone();
	    			var checkId=v["checkId"];
	    			var flowId=v["flowId"];
	    			tfont.find("label[name='checkId']").text(checkId);
	    			tfont.find("label[name='userName']").text(v["userName"]);
	    			tfont.find("label[name='checkDesc']").text(v["checkDesc"]);
	    			tfont.find("label[name='status']").text(v["status"]);
	    			tfont.find("label[name='createTime']").text(v["createTime"]);
	    			$("#TableData").append(tfont.html());
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
		
		<table id="table" border="0" cellspacing="0" cellpadding="0" style="margin-top: 0px;width:98%" class="TableStyle">
		<div class="ItemBlock_Title1"><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/images/item_point.gif"> 审核结果 </div> 
         </div>
			<thead>
				<tr align=center valign=middle id=TableTitle>
					<td style="display:none">流程id</td> 
					<td >审核人</td>
					<td >审批描述</td>
					<td >审批状态</td>
					<td >审批时间</td>
				</tr>
			</thead>
			<tbody id="TableData" class="dataContainer" datakey="userList">

			</tbody>
			<tfoot class="TableDetail1 template" style="display:none">
				<tr class="TableDetail1 template" align="center"  style="display:run-in">
					<td style="display:none"><label name="checkId"></label><label name="flowId"></label></td>
					<td><label name="userName"></label></td>
					<td><label name="checkDesc"></label></td>
					<td><label name="status"></label></td>
					<td><label name="createTime"></label></td>
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
