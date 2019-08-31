<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>密码修改</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
	<script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
</head>
<script type="text/javascript">
function save(){
	var oldPassword=$("input[name='oldPassword']").val();
	var password=$("input[name='password']").val();
	var password2=$("input[name='password2']").val();
	if(oldPassword.trim()==""|| password.trim()==""|| password2.trim()==""){
		alert("必填项不能为空");
		return;
	}
	if(password!=password2){
		alert("新密码两次输入不一致");
		return;
	}
	if(password.length>20){
		alert("密码最大长度不能超过20个字符");
		return;
	}
	var url="${pageContext.request.contextPath}/user/changePwd";
	var loginName='${loginName}';
	var param={oldPassword:oldPassword,password:password,loginName:loginName};
	$.ajax({
	    url : url,
	    type : "POST",
	    async : true,
	    contentType: "application/json; charset=utf-8",
	    data : JSON.stringify(param),
	    dataType : 'json',
	    success : function(data) {
	    	if(data.resultCode=="000000"){
	    		alert("修改密码成功");
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 密码修改</div>
        <div id="Title_End"></div>
    </div>
</div>

<div id=MainArea>
        <div class="ItemBlock_Title1">
        </div>
        
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<tr height="50">
						<td width="150">
							<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
							请输入原密码
						</td>
						<td><input type="password" name="oldPassword" class="InputStyle" /> *</td>
					</tr>
					<tr height="25">
						<td width="150">
							<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
							请输入新密码
						</td>
						<td><input type="password" name="password" class="InputStyle" /> *</td>
						<td></td>
					</tr>
					<tr height="25">
						<td width="150">
							<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
							请再次输入新密码
						</td>
						<td><input type="password" name="password2" class="InputStyle" /> *</td>
						<td></td>
					</tr>
                </table>
            </div>
        </div>
       
        <div id="InputDetailBar" style="float: left"> 
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"  onclick="save()" />
        </div>
</div>

<div class="Description">
验证规则：</br>
1，旧密码不能为空。</br>
2，新密码不能为空。</br>
3，再次输入的密码要和新密码一致。</br>
3，密码最大长度不能超过20个字符</br>
</div>

</body>
</html>
