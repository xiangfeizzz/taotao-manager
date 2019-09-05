<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>请假申请</title>
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
var flowId='${flowId}';
var param={userId:userId};

function save(){
	var url="${pageContext.request.contextPath}/holiday/holidayAdd";
	var startTime=$("input[name='startTime'][type='date']").val();
	$("input[name='startTime'][type='hidden']").val(startTime);
	var endTime=$("input[name='endTime'][type='date']").val();
	$("input[name='endTime'][type='hidden']").val(endTime);
	
	$("input[name='flowId']").val(flowId);
	
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
	    		alert("提交成功");
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 请假申请
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<form id="MainArea" >
<div style="padding-left: 50px;">
       <div class="ItemBlock_Title1"><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/images/item_point.gif"> 请假申请</div> 
        </div>
        
        <input type="hidden" name="flowId" />
        
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<tr>
                        <td>请假类型</td>
                        <td>
                        	 <select name="type" >
                                <option value="" selected="selected">请假类型</option>
                               	<option value="1">事假</option>
                                <option value="2">病假</option>
                                <option value="3">婚假</option>
                                <option value="4">产假</option>
                                <option value="5">丧假</option>
                                <option value="6">探亲假</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                     <td>请假时长</td>
                        <td><input type="text" name="datetime"></input> </td>
                      <td>剩余年假</td>
                        <td><input type="text" name="holiday" disabled="disabled" value="4"></input> </td>
                    </tr>
                     <tr>
                        <td>开始日期</td>
                        <td>
                        	<input type="date" name="startTime" ></input> 
                        	<input type="hidden" name="startTime" ></input>
                        </td>
                        <td>结束日期</td>
                        <td>
                        	<input type="date" name="endTime"></input>
                        	<input type="hidden" name="endTime"></input>
                        </td>
                    </tr>
                    <tr>
                        <td>请假事由</td>
                        <td colspan="3"><input type="textArea" type="text" cols="100" rows="5" name="desc"></input> </td>
                    </tr>
                </table>
            </div>
        </div>
        
         <div id="InputDetailBar" style="float: left">
            <input type="image" src="${pageContext.request.contextPath}/style/images/button/submit.PNG"  onclick="return save();" />
        </div>
        
   </div>
</form>

<div class="Description">
验证规则：</br>
1，请假类型，请假时长，开始日期，结束日期，请假事由必须输入正确的格式。</br>
2，请假时长，单位为小时。</br>
</div>
</body>
</html>
