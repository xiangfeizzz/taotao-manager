<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Itcast OA</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery_treeview/jquery.cookie.js"></script>
</head>
<script type="text/javascript">
</script>

	<frameset rows="100,*,35" framespacing=0 border=0 frameborder="0">
		<frame noresize name="TopMenu" scrolling="no" src="${pageContext.request.contextPath}/home/page/top?preffix=home&loginName=${loginName}"  >
		<frameset cols="180,*" id="resize">
			<frame width="384"  name="menu" scrolling="yes" src="${pageContext.request.contextPath}/home/page/left?preffix=home&loginName=${loginName}" >
			<frame noresize name="right" scrolling="yes" src="${pageContext.request.contextPath}/home/page/right?preffix=home">
		</frameset>
		<frame noresize name="status_bar" scrolling="no" src="${pageContext.request.contextPath}/home/page/bottom?preffix=home">
	</frameset>

	<noframes>
<body>
</body>
</noframes></html>



