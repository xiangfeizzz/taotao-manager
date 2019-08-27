<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>导航菜单</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/menu.css" />
	<script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
</head>
<script type="text/javascript">
$(function(){
	var loginName = '${loginName}';
	var url="${pageContext.request.contextPath}/menu/getMenuList?loginName="+loginName;
    $.ajax({
        url: url,
        type: "post",
        async: false,
        dataType: "json",
        contentType: "application/json",
        success: function (data) {
            	if(data.resultCode == "000000"){
            		var headerList=data.data.headerList;
            		var menuList=data.data.menuList;
				}else{
					alert("加载用户数据异常");
				}
            }
     });
	
});
		
</script>

<body style="margin: 0" scroll="no" style="overflow-x:hidden" >
<input type="hidden" name="loginName" th:value="${loginName}"/>
<div id="Menu"> 

    <ul id="MenuUl">
		<%-- 顶级菜单 --%>
		<s:iterator value="#application.topPrivilegeList">
		<s:if test="#session.user.hasPrivilegeByName(name)">
	        <li class="level1">
	            <div onClick="menuClick(this);" class="level1Style">
<%-- 	            	<img src="${pageContext.request.contextPath}/style/images/MenuIcon/${icon}" class="Icon" />  --%>
	            	${name}
	            </div>
	            <%-- 二级菜单 display: none; --%>
	            <ul style="" class="MenuLevel2">
	            	<s:iterator value="children">
	            	<s:if test="#session.user.hasPrivilegeByName(name)">
		                <li class="level2">
		                    <div class="level2Style">
<%-- 			                    <img src="${pageContext.request.contextPath}/style/images/MenuIcon/menu_arrow_single.gif" />  --%>
			                    <a target="right" href="${pageContext.request.contextPath}/${url}.action"> ${name}</a>
		                 	</div>
		                </li>
	                </s:if>
	            	</s:iterator>
	            </ul>
	        </li>
        </s:if>
		</s:iterator>        
    </ul>
    
</div>
</body>
</html>