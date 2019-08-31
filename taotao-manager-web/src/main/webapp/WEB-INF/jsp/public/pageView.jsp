<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<div id=PageSelectorBar>
	<div id=PageSelectorMemo>页次：${currentPage}/${pageCount}页 &nbsp;每页显示：${pageSize }条 &nbsp;总记录数：${recordCount }条</div>
	<div id=PageSelectorSelectorArea>
		<a href="javascript: gotoPage(1)" title="首页" style="cursor: hand;">
			<img src="${pageContext.request.contextPath}/style/images/pageSelector/firstPage.png"/>
		</a>
		<s:iterator begin="%{beginPageIndex}" end="%{endPageIndex}" var="num">
			<s:if test="currentPage == #num">
				<span class="PageSelectorNum PageSelectorSelected">${num}</span>
			</s:if>
			<s:else>
				<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPage(${num});">${num}</span>
			</s:else>
		</s:iterator>
		<a href="javascript: gotoPage(${pageCount})" title="尾页" style="cursor: hand;">
			<img src="${pageContext.request.contextPath}/style/images/pageSelector/lastPage.png"/>
		</a>
		转到：
		<select id="pn" onchange="gotoPage(this.value)">
			<s:iterator begin="1" end="%{pageCount}" var="num">
				<option value="${num}">${num}</option>					
			</s:iterator>
		</select>		
	</div>
</div>


<script type="text/javascript">
	function gotoPage( pageNum ){
		// window.location.href = "forumAction_show.action?id=${id}&pageNum=" + pageNum;
		
		$(document.forms[0]).append("<input type='hidden' name='pageNum' value='" + pageNum + "'/>");
		document.forms[0].submit(); // 提交表单
	}
</script>