<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Hunyun OA</title>
	<link href="${pageContext.request.contextPath}/style/css/login.css" type=text/css rel=stylesheet>
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
</head>
<script type="text/javascript">
		function login(){
			var loginName=$("input[name='loginName']").val();
			var password=$("input[name='password']").val();
			if(loginName.trim()==""||password.trim()==""){
				alert("用户名或密码不能为空");
				return ;
			}
			
			var url="${pageContext.request.contextPath}/login/checkPassword?loginName="+loginName+"&password="+password;
		    $.ajax({
	            url: url,
	            type: "GET",
	            async: false,
	            dataType: "json",
	            contentType: "application/json",
	            success: function (data) {
	                	if(data.resultCode == "000000"){
	    					window.location.href="${pageContext.request.contextPath}/home/page/main?preffix=home&loginName="+loginName;
	    				}else{
	    					alert(data.resultMsg);
	    				}
	                }
	         });
		}
	</script>

<body leftmargin=0 topmargin=0 marginwidth=0 marginheight=0 class=PageBody style="overflow-x:hidden" >



<!-- 显示表单 -->
    <div id="CenterAreaBg"> 
        <div id="CenterArea" style="left: 700px;">
            <div id="LogoImg"><img border="0" src="${pageContext.request.contextPath}/style/images/logo.png" /></div>
            <div id="LoginInfo">
                <table BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
                	<tr>
                		<td colspan="3"><!-- 显示错误 -->
							<font color="red"><s:fielderror/></font>
                		</td>
                	</tr>
                    <tr>
                        <td width=45 class="Subject"><img border="0" src="${pageContext.request.contextPath}/style/images/login/userId.gif" /></td>
                        <td>
                        	<input type="text" name="loginName" size="20" tabindex="1"  cssClass="TextField required" />
                        </td>
                        <td rowspan="2" style="padding-left:10px;">
                        	<input type="image" onclick="login()" tabindex="3" src="${pageContext.request.contextPath}/style/images/login/userLogin_button.gif" />
                        </td>
                    </tr>
                    <tr>
                        <td class="Subject"><img border="0" src="${pageContext.request.contextPath}/style/images/login/password.gif" /></td>
                        <td><input type="password" name="password"  size="20" tabindex="2"  cssClass="TextField required" /></td>
                    </tr>
                </table>
            </div>
            <div id="CopyRight"><a href="javascript:void(0)">&copy; 2019 版权所有 hunyunoa</a></div>
        </div>
    </div>
</body>

</html>

