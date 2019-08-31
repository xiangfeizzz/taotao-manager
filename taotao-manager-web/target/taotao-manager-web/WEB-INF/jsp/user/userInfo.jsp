<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>个人信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
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
	var loginName='${loginName}';
	var param={loginName:loginName};
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
	    		var dept=data.data.tbDept;
	    		var position=data.data.tbPosition;
	    		$.each($("label"),function(n,v){
	    			var name=$(v).attr("name");
	    			var text=user[name];
	    			$(v).text(text);
	    		});
	    		
	    		$("lable[name='positionName']").text(position.positionName);
	    		$("lable[name='deptName']").text(dept.deptName);
	    		
	    	}else{
	    		alert(data.resultMsg)
	    	}
	    }
	});
});


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

<div id=MainArea>
        <div class="ItemBlock_Title1">
        </div>
        
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<tr>
                        <td>用户姓名</td>
                        <td><label name="userName"></label></td>
                        <td>登录账号</td>
                        <td><label name="loginName"></label> </td>
                    </tr>
                     <tr>
                        <td>性别</td>
                        <td><label name="sex"></label> </td>
                        <td>联系地址</td>
                        <td><label name="address"></label> </td>
                    </tr>
                    <tr>
                        <td>身份证号</td>
                        <td><label name="idNo"></label> </td>
                        <td>银行卡号</td>
                        <td><label name="bankNo"></label> </td>
                    </tr>
                     <tr>
                        <td>手机号码</td>
                        <td><label name="mobile"></label> </td>
                        <td>邮箱</td>
                        <td><label name="email"></label> </td>
                    </tr>
                     <tr>
                        <td>生日</td>
                        <td><label name="birth"></label> </td>
                        <td>入职日期</td>
                        <td><label name="hireDate"></label> </td>
                    </tr>
                    <tr>
                        <td>毕业学校</td>
                        <td><label name="school"></label> </td>
                        <td>学历</td>
                        <td><label name="edu"></label> </td>
                    </tr>
                    <tr>
                        <td>所属部门</td>
                        <td><label name="deptName"></label> </td>
                        <td>所属职位</td>
                        <td><label name="positionName"></label> </td>
                    </tr>
                    <tr>
                        <td>角色</td>
                        <td><label name="roleName"></label> </td>
                        <td>薪资</td>
                        <td><label name="salary"></label> </td>
                    </tr>
                    <tr>
                        <td>年假</td>
                        <td><label name="holiday"></label> </td>
                    </tr>
                </table>
            </div>
        </div>
</div>
</body>
</html>
