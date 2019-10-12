
function loadUserInfo(){
	var param={userId:userId};
	var url=this.getDomain()+"/user/getUserInfo";
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
	
}



function del(obj){
	if(window.confirm('确定删除么')){
		var userId=$(obj).parent().parent().find("label[name='userId']").text();
		var param={userId:userId,loginName:loginName};
		var url=this.getDomain()+"/user/userDel";
		$.ajax({
		    url : url,
		    type : "POST",
		    async : false,
		    contentType: "application/json; charset=utf-8",
		    data : JSON.stringify(param),
		    dataType : 'json',
		    success : function(data) {
		    	if(data.resultCode=="000000"){
		    		$(obj).parent().parent().remove();
		    		alert("删除成功");
		    	}else{
		    		alert(data.resultMsg)
		    	}
		    }
		});
     }
}
