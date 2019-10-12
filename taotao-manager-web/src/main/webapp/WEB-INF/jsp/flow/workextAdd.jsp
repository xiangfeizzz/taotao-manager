<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>加班申请</title>
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
function save(flowStatus){
	
	$("input[name='flowStatus']").val(flowStatus);
	
	var workextStartTime=$("input[name='workextStartTime'][type='date']").val();
	$("input[name='workextStartTime'][type='hidden']").val(workextStartTime);
	var workextEndTime=$("input[name='workextEndTime'][type='date']").val();
	$("input[name='workextEndTime'][type='hidden']").val(workextEndTime);
	
	if(!check()){
		return false;
	}
	
	var url="${pageContext.request.contextPath}/flow/workextAdd";
	
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
	    	 	window.location.href="${pageContext.request.contextPath}/page/choiceFlow?preffix=flow";
	    	}else{
	    		alert(data.resultMsg)
	    	}
	    }
	});
	return false;
}

function check(){
	var workextHours=$("input[name='workextHours']").val();
	if(isNaN(workextHours) || workextHours.trim()==""){
		alert("加班时长不合法");
		return false;
	}
	var workextStartTime=$("input[name='workextStartTime']").val();
	if(workextStartTime==""){
		alert("请选择开始日期");
		return false;
	}
	var workextEndTime=$("input[name='workextEndTime']").val();
	if(workextEndTime==""){
		alert("请选择结束日期");
		return false;
	}
	
	var isLegalDay=$("select[name='isLegalDay'] option:selected").val();
	if(isLegalDay==""){
		alert("请选择是否法定假日");
		return false;
	}
	
	var workextDesc=$("textArea[name='workextDesc']").val();
	if(workextDesc==""){
		alert("请填写加班事由");
		return false;
	}
	return true;
}

</script>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        
        
        <div id="Title">
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 加班申请
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<form id="MainArea" >
<div style="padding-left: 50px;">
       <div class="ItemBlock_Title1"><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/images/item_point.gif"> 加班申请</div> 
        </div>
        
        <input name="flowStatus" type="hidden" />
        
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                     <tr>
                        <td>开始日期</td>
                        <td>
                        	<input type="date" name="workextStartTime" ></input> 
                        	<input type="hidden" name="workextStartTime" ></input>
                        	<font>*</font>
                        </td>
                        <td>结束日期</td>
                        <td>
                        	<input type="date" name="workextEndTime" ></input>
                        	<input type="hidden" name="workextEndTime" ></input>
                        	<font>*</font>
                        </td>
                    </tr>
                    <tr>
                    	<td>加班时长</td>
                        <td><input type="text" name="workextHours" 	></input> <font>*</font></td> 
	                    <td>是否法定假日</td>
	                        <td >
	                        	 <select name="isLegalDay" >
	                                <option value="" selected="selected" >请选择</option>
	                               	<option value="1">是</option>
	                                <option value="2">否</option>
	                            </select>
	                        </td>
                    </tr>
                    <tr>
                        <td>加班事由</td>
                        <td colspan="3"><textArea type="text" cols="60" rows="4" name="workextDesc" /></textArea> 
                        <font>*</font></td>
                    </tr>
                </table>
            </div>
        </div>
        
         <div id="InputDetailBar" style="float: left">
            <input type="image" src="${pageContext.request.contextPath}/style/images/button/submit.PNG"  onclick="return save(1);" />
            <input type="image" src="${pageContext.request.contextPath}/style/images/button/saveToDraftBox.png"  onclick="return save(0);" />
        </div>
        
   </div>
</form>

<div class="Description">
验证规则：</br>
1，加班时长，开始日期，结束日期，加班事由必须输入正确的格式。</br>
2，加班时长，单位为小时。</br>
</div>
</body>
</html>
