<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>个人信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/commonUtils.js" charset="utf-8"></script>
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
var userId='${userId}';
var param={userId:userId};
$(function(){
	loadDept($("select[name='deptId']"));
	loadPosition($("select[name='positionId']"));
	loadRole($("select[name='roleId']"));
});

function save(){
	var url="${pageContext.request.contextPath}/flowConf/add";
	
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
	    		alert("添加成功");
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 员工添加
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<form id="MainArea" >
<div style="padding-left: 50px;">
       <div class="ItemBlock_Title1"><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/images/item_point.gif"> 员工添加</div> 
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
                                <option value="3">物品申领</option>
                                <option value="4">出差申请</option>
                                <option value="5">辞职申请</option>
                                <option value="6">报销申请</option>
                            </select><font>*</font>
						</td>
					 </tr>
                     <tr>
						<td>所属部门</td>
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
                </table>
            </div>
        </div>
        
         <div id="InputDetailBar" style="float: left">
            <input type="image" src="${pageContext.request.contextPath}/style/images/button/save.png"  onclick="return save();" />
        </div>
        
   </div>
</form>

<div class="Description">
验证规则：</br>
1，流程类型、所属部门、职位不能是已存在的。</br>
2，流程类型、所属部门、职位 不能为空</br>
</div>
</body>
</html>
