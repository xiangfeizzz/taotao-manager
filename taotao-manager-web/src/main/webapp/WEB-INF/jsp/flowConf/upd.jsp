<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>流程配置</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/commonUtils.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/flowConf.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/css/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>
<style>
td{
 height:25px;
}
</style>
<script type="text/javascript">
var confId='${confId}';
$(function(){
	$("input[name='confId']").val(confId);
	var param={confId:confId};
	var url="${pageContext.request.contextPath}/flowConf/getFlowConfInfo";
	$.ajax({
	    url : url,
	    type : "POST",
	    async : true,
	    contentType: "application/json; charset=utf-8",
	    data : JSON.stringify(param),
	    dataType : 'json',
	    success : function(data) {
	    	if(data.resultCode=="000000"){
	    		var conf=data.data.tbFlowConf;
	    		$.each($("input").not($("input[type='radio']")),function(n,v){
	    			var name=$(v).attr("name");
	    			var value=conf[name];
	    			$(v).val(value);
	    		});
	    		loadDept($("select[name='deptId']"),conf.deptId);
	    		loadPosition($("select[name='positionId']"),conf.positionId);
	    		$("select[name='flowType'][option[value='"+conf.flowType+"']").attr("selected", true);
	    	}else{
	    		alert(data.resultMsg)
	    	}
	    }
	});
});

function update(){
	
	if(!check()){
		return false;
	}
	var url="${pageContext.request.contextPath}/flowConf/upd";
	var jsonObj = $("#MainArea").serializeObject(); // json对象
	$.ajax({
	    url : url,
	    type : "POST",
	    async : true,
	    contentType: "application/json; charset=utf-8",
	    data : JSON.stringify(jsonObj),
	    dataType : 'json',
	    success : function(data) {
	    	if(data.resultCode=="000000"){
	    		alert("修改成功");
	    	}else{
	    		alert(data.resultMsg)
	    	}
	    }
	});
	return false;
}

</script>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title">
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 流程配置修改
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<form id="MainArea" >
<div style="padding-left: 50px;">
       <div class="ItemBlock_Title1"><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/images/item_point.gif"> 流程配置修改</div> 
        </div>
        
         <input type="hidden" name="confId" />
        
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
                            </select><font>*</font>
						</td>
						<td>选择员工</td>  
						<td>
                    		<input type="text" name="userName" readonly="readonly"></input>
                    		<input type="hidden" name="userId" ></input>
                    		<input type="image" src="${pageContext.request.contextPath}/style/images/point.gif"  onclick="return choiceUser(1);" />
                    		<input type="image" src="${pageContext.request.contextPath}/style/images/time_cancel.gif"  onclick="return deleteUser(1);" />
						</td>
					 </tr>
                     <tr>
						<td>部门</td>
                        <td>
                        	 <select name="deptId" >
                                <option value="" selected="selected">请选择部门</option>
                            </select><font>*</font>
                        </td>
                        <td>职位</td>
                        <td>
                        	 <select name="positionId" >
                                <option value="" selected="selected">请选择职位&nbsp;&nbsp;</option>
                            </select><font>*</font>
                        </td>
                    </tr>
                    <tr>
                    	<td>选择审核人</td>
                    	<td>
                    		<input type="text" name="userNameOrder" readonly="readonly"></input>
                    		<input type="hidden" name="userIdOrder" ></input>
                    		<input type="image" src="${pageContext.request.contextPath}/style/images/point.gif"  onclick="return choiceUser(2);" />
                    		<input type="image" src="${pageContext.request.contextPath}/style/images/time_cancel.gif"  onclick="return deleteUser(2);" />
        				</td>
                    </tr>
                    
                </table>
            </div>
        </div>
        
         <div id="InputDetailBar" style="float: left">
            <input type="image" src="${pageContext.request.contextPath}/style/images/button/save.png"  onclick="return update();" />
        </div>
        
   </div>
</form>

<div class="Description">
验证规则：</br>
1，流程类型、部门、职位校验唯一性。</br>
2，流程类型、部门、职位不能为空</br>
</div>
</body>
</html>
