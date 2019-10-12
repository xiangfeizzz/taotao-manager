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
$(function(){
	var userId='${userId}';
	var param={userId:userId};
	var url="${pageContext.request.contextPath}/user/getUserInfo";
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
	    		$.each($("input").not($("input[type='radio']")),function(n,v){
	    			var name=$(v).attr("name");
	    			var value=user[name];
	    			$(v).val(value);
	    		});
	    		var dept=data.data.tbDept;
	    		var role=data.data.tbRole;
	    		var position=data.data.tbPosition;
	    		loadDept($("select[name='deptId']"),dept.deptId);
	    		loadPosition($("select[name='positionId']"),position.positionId);
	    		loadRole($("select[name='roleId']"),role.roleId);
	    		$("input[name='sex'][value='"+user.sex+"']").attr("checked", true);
	    		$("select[name='edu'][option[value='"+user.edu+"']").attr("selected", true);
	    	}else{
	    		alert(data.resultMsg)
	    	}
	    }
	});
});

function update(){
	var url="${pageContext.request.contextPath}/user/userUpd";
	var birth=$("input[name='birth'][type='date']").val();
	$("input[name='birth'][type='hidden']").val(birth);
	var hireDate=$("input[name='hireDate'][type='date']").val();
	$("input[name='hireDate'][type='hidden']").val(hireDate);
	
	var jsonObj = $("#MainArea").serializeObject(); // json对象
	console.log(jsonObj);
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
	    		window.history.back(-1); 
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 个人信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<form id=MainArea>
<div style="padding-left: 50px;">
       <div class="ItemBlock_Title1"><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/images/item_point.gif"> 用户信息 </div> 
        </div>
        
        <input type="hidden" name="userId" />
        
          <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<tr>
                        <td>姓名</td>
                        <td><input type="text" name="userName"></input></td>
                        <td>登录账号</td>
                        <td><input type="text" name="loginName"></input> </td>
                    </tr>
                     <tr>
                        <td>性别</td>
                        <td>
                        	<input type="radio" name="sex" value="1">男</input>
                        	<input type="radio" name="sex" value="0">女</input>
                         </td>
                        <td>联系地址</td>
                        <td><input type="text" name="address"></input> </td>
                    </tr>
                    <tr>
                        <td>身份证号</td>
                        <td><input type="text" name="idNo"></input> </td>
                        <td>银行卡号</td>
                        <td><input type="text" name="bankNo"></input> </td>
                    </tr>
                     <tr>
                        <td>手机号码</td>
                        <td><input type="text" name="mobile"></input> </td>
                        <td>邮箱</td>
                        <td><input type="text" name="email"></input> </td>
                    </tr>
                     <tr>
                        <td>生日</td>
                        <td>
                        	<input type="date" name="birth" ></input> 
                        	<input type="hidden" name="birth" ></input>
                        </td>
                        <td>入职日期</td>
                        <td>
                        	<input type="date" name="hireDate"></input>
                        	<input type="hidden" name="hireDate"></input>
                        </td>
                    </tr>
                    <tr>
                        <td>毕业学校</td>
                        <td><input type="text" name="school"></input> </td>
                        <td>学历</td>
                        <td>
                       		 <select name="edu" >
                                <option value="" selected="selected">请选择学历</option>
                                <option value="1">初中</option>
                                <option value="2">高中</option>
                                <option value="3">中专</option>
                                <option value="4">大专</option>
                                <option value="5">本科</option>
                                <option value="6">研究生</option>
                                <option value="7">博士</option>
                            </select>
                        
                         </td>
                    </tr>
                    <tr>
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
                    </tr>
                    <tr>
                        <td>角色</td>
                        <td>
                        	 <select name="roleId" >
                                <option value="" selected="selected">请选择角色</option>
                            </select>
                        </td>
                        <td>薪资</td>
                        <td><input type="text" name="salary"></input> </td>
                    </tr>
                    <tr>
                        <td>年假</td>
                        <td><input type="text" name="holiday"></input> </td>
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
1，登录账号不能为空，不能是已存在的。</br>
2，手机号码，邮箱，身份证号，银行卡号，薪资，年假等必须输入正确的格式。</br>
</div>

</body>
</html>
