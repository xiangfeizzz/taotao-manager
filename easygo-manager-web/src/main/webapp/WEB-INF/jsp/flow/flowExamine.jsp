<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>审批流转</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/css/pageCommon.css" />
<script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/script/commonUtils.js" charset="utf-8"></script>
</head>
<script type="text/javascript" async="async">
var checkId='${checkId}';
function save(){
	$("input[name=checkId]").val(checkId);
	
	if(!check()){
		return false;
	}
	var url="${pageContext.request.contextPath}/flowCheck/add";
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
	    		window.close();
	    	}else{
	    		alert(data.resultMsg)
	    	}
	    }
	});
	return false;
}


function check(){
	var status=$("select[name='status'] option:selected").val();
	if(status==""){
		alert("请选择审核状态");
		return false;
	}
	var checkDesc=$("textArea[name='checkDesc']").val();
	if(checkDesc.trim()==""){
		alert("请填写审核意见");
		return false;
	}
	return true;
}

</script>
<body>


<form id="MainArea" >
<div style="padding-left: 50px;">
       <div class="ItemBlock_Title1"><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/images/item_point.gif"> 审核</div> 
        </div>
        
        <input name="checkId" type="hidden" />
        
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<tr>
                        <td>审核状态</td>
                        <td colspan="3">
                        	 <select name="status" >
                                <option value="" selected="selected" >请选择</option>
                               	<option value="3">审核通过</option>
                                <option value="4">审核拒绝</option>
                            </select><font>*</font>
                        </td>
                    </tr>
                    <tr>
                        <td>审核意见</td>
                        <td colspan="3"><textArea type="text" cols="30" rows="4" name="checkDesc" /></textArea> 
                        <font>*</font></td>
                    </tr>
                </table>
            </div>
        </div>
        
         <div id="InputDetailBar" style="float: left">
            <input type="image" src="${pageContext.request.contextPath}/style/images/button/submit.PNG"  onclick="return save();" />
        </div>
        
   </div>
</form>


</body>
</html>
