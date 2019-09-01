<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>TopMenu</title>
	<LINK href="${pageContext.request.contextPath}/style/css/top.css" type=text/css rel=stylesheet>
	
	<script type="text/javascript">
	</script>
	<style type="text/css">
		#messageArea{
			color: white;
			font-size: 14px;
			font-weight: bold;
		}
	</style>
</head>

<body CLASS=PageBody leftmargin=0 topmargin=0 marginwidth=0 marginheight=0 style='border-width:0px'>
	
	<div id="Head1">
		<div id="Logo">
        	<iframe name="autoRefashion" src="" width="0" height="0"></iframe>
			<a id="msgLink" href="javascript:void(0)"></a>
            <font color="#0000CC" style="color:#F1F9FE; font-size:28px; font-family:Arial Black, Arial">HuiYun OA</font> 
        </div>
		<div id="Head1Right">
			<div id="Head1Right_UserName">
                <img border="0" width="13" height="14" src="${pageContext.request.contextPath}/style/images/top/user.gif" /> 您好，<b>${loginName}</b>&nbsp;&nbsp;
			</div>
			<div id="Head1Right_UserName">
            	<a target="_parent" href="${pageContext.request.contextPath}/user/page/loginUI?preffix=user" style="color:#b3e1ff">
            		<img border="0" width="13" height="14"  src="${pageContext.request.contextPath}/style/images/top/logout.gif"/>
            		 退出系统
                </a>
			</div>
			<div id="Head1Right_Time">
				</div>
		</div>
	</div>
    
    <div id="Head2">
        <div id="Head2_Awoke">
<!--             <ul id="AwokeNum"> -->
<%--                 <li><a target="desktop" href="javascript:void(0)"><img border="0" width="11" height="13" src="${pageContext.request.contextPath}/style/images/top/msg.gif" /> 消息<span id="msg"></span></a></li> --%>
<!--                 <li class="Line"></li> -->
<%--                 <li><a target="desktop" href="javascript:void(0)"><img border="0" width="16" height="11" src="${pageContext.request.contextPath}/style/images/top/mail.gif" /> 邮件<span id="mail"></span></a></li> --%>
<!--                 <li class="Line"></li> -->
                
<!--                 是否有待审批文档的提示1 -->
<%--                 <li><a href="${pageContext.request.contextPath}/formFlowAction_myTaskList.action" target="right"> --%>
<%--                 		<img border="0" width="12" height="14" src="${pageContext.request.contextPath}/style/images/top/wait.gif" />  --%>
<!--                 		待办事项（<span id="wait" class="taskListSize">0</span>） -->
<!--                 	</a> -->
<!--                 </li> -->
<!--                 <li class="Line"></li> -->
                
<!--                 是否有待审批文档的提示2 -->
<!--                 <li id="messageArea"></li> -->
<!--             </ul> -->
        </div>
        
    </div>

</body>

</html>
