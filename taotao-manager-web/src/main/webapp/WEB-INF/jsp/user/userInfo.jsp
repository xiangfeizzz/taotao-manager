<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>个人信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/css/pageCommon.css" />
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/commonUtils.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/user.js" charset="utf-8"></script>
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
$(function(){
	loadUserInfo();
	$("#MainArea").find("input,textarea,select,radio").attr('disabled',"disabled");
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
                        <td><input type="text"  name="userName"></input></td>
                        <td>登录账号</td>
                        <td><input type="text"  name="loginName"></input> </td>
                    </tr>
                     <tr>
                        <td>性别</td>
                        <td>
                        	<input type="radio" name="sex" value="1"  ></input>男
                        	<input type="radio" name="sex" value="0"  ></input>女
                         </td>
                        <td>联系地址</td>
                        <td><input type="text"  name="address"></input> </td>
                    </tr>
                    <tr>
                        <td>身份证号</td>
                        <td><input type="text"  name="idNo"></input> </td>
                        <td>银行卡号</td>
                        <td><input type="text"  name="bankNo"></input> </td>
                    </tr>
                     <tr>
                        <td>手机号码</td>
                        <td><input type="text"  name= "mobile"></input> </td>
                        <td>邮箱</td>
                        <td><input type="text"  name="email"></input> </td>
                    </tr>
                     <tr>
                        <td>生日</td>
                        <td><input type="date" name="birth" value=""></input> </td>
                        <td>入职日期</td>
                        <td><input type="date" name="hireDate"></input> </td>
                    </tr>
                    <tr>
                        <td>毕业学校</td>
                        <td><input type="text"  name="school"></input> </td>
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
                        	 <select name="roleId"  >
                                <option value="" selected="selected">请选择角色</option>
                            </select>
                        </td>
                        <td>薪资</td>
                        <td><input type="text"  name="salary"></input> </td>
                    </tr>
                    <tr>
                        <td>年假</td>
                        <td><input type="text"  name="holiday"></input> </td>
                    </tr>
                </table>
            </div>
        </div>
        
        
   </div>
</form>

</body>
</html>
