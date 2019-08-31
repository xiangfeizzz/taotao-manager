<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>导航菜单</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/menu.css" />
	<script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/script/menu.js"></script>
</head>
<style>
.MenuLevel2{width:130px;}
</style>
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
            		var menuHtml="";
            		$.each(JSON.parse(headerList),function(n,v){
            			var menuName=v.menuName;
            			var menuIcon=v.menuIcon;
            			var menuId=v.menuId;
            			var imagesIconPath="${pageContext.request.contextPath}/style/images/MenuIcon/"+menuIcon;
            			menuHtml="<li class='level1'>";
            			menuHtml+="<div onClick='menuClick(this)' class='level1Style'>";
            			menuHtml+="<img src="+imagesIconPath+" class='Icon' /> ";
            			menuHtml+="<a href='#'><label > "+menuName+"</label></a>";
            			menuHtml+="</div>";
            			var subMenuHtml="";
            			$.each(JSON.parse(menuList),function(n,value){
            				var parentId=value.parentId;
            				if(parentId==menuId){
            					var name=value.menuName;
                    			var id=value.menuId;
                    			var menuUrl="${pageContext.request.contextPath}/"+value.menuUrl+"&loginName="+loginName;
                				subMenuHtml+="<ul class='MenuLevel2' style='display:none'>";
                				subMenuHtml+=" <li class='level2'>";
                				subMenuHtml+=" <div class='level2Style'>";
                				subMenuHtml+=" <img src='${pageContext.request.contextPath}/style/images/MenuIcon/menu_arrow_single.gif' />";
                				subMenuHtml+=" <a target='right' href="+menuUrl+"><label >"+name+"</label></a>";
                				subMenuHtml+=" </div></li></ul>";
            				}
            			});
            			menuHtml+=subMenuHtml;
            			menuHtml+="</li>";
            			$("#MenuUl").append(menuHtml);
            		});
				}else{
					alert("加载用户数据异常");
				}
            }
     });
	
});
		
</script>


<body scroll="no" style="overflow-x:hidden;overflow-y:hidden;margin: 0;border-width:0px"  >
<ul id="MenuUl" ></ul>
    
</body>
</html>