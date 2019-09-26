<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>起草申请</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/css/pageCommon.css" />
<script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
</head>
<script type="text/javascript" async="async">
var userId='${userId}';
function create(){
	var flowId=$("select[name='flowId'] option:selected").val();
	if(flowId==""){
		alert("请选择流程");
	}else{
		window.location.href="${pageContext.request.contextPath}/page/holidayAdd?preffix=flow&flowId="+flowId+"&userId="+userId;
	}
}
</script>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<input type="image" border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
					起草申请
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

<div id=MainArea>
<div style="padding-left: 50px;">
         <div class="ItemBlock_Title1"><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/images/item_point.gif"> 流程选择 </div> 
         </div>
		<div class="ItemBlockBorder">
			<div class="ItemBlock">
				<table cellpadding="0" cellspacing="0" class="mainForm">
					<tr>
						 <td>
                       		 <select name="flowId" style="width: 30%">
                                <option value="" selected="selected">请选择流程</option>
                               	<option value="1">请假申请</option>
                                <option value="2">加班申请</option>
                                <option value="3">物品申领</option>
                                <option value="4">出差申请</option>
                                <option value="5">辞职申请</option>
                                <option value="6">报销申请</option>
                            </select>
                        
                         </td>
						<td>
							 <div id="InputDetailBar" style="float: left"> 
					            <input type="image" src="${pageContext.request.contextPath}/style/images/button/createNew.png"  onclick="create()" />
					        </div>
						</td>
					</tr>
				</table>
			</div>
		</div>
		

		<div class="ItemBlock_Title1" />
		</div>
	</div>
</body>
</html>
