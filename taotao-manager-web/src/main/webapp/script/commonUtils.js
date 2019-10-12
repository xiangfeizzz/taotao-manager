var dept;
var position;	

$.fn.serializeObject = function()
{
   var o = {};
   var a = this.serializeArray();
   $.each(a, function() {
       if (o[this.name]) {
           if (!o[this.name].push) {
               o[this.name] = [o[this.name]];
           }
           o[this.name].push(this.value || '');
       } else {
           o[this.name] = this.value || '';
       }
   });
   return o;
};

function loadPageBar(data){
	$("input[name='firstPage']").val(data.data.firstPage);
	$("input[name='prePage']").val(data.data.prePage);
	$("input[name='nextPage']").val(data.data.nextPage);
	$("input[name='lastPage']").val(data.data.lastPage);
	
	$("label[name='pageNum']").text(data.data.pageNum);
	$("label[name='pages']").text(data.data.pages);
	$("label[name='pageSize']").text(data.data.pageSize);
	$("label[name='total']").text(data.data.total);
}


function loadDept(obj,sId){
	var url=this.getDomain()+"/dept/getDeptList";
	$.ajax({
	    url : url,
	    type : "POST",
	    async : true,
	    contentType: "application/json; charset=utf-8",
	    dataType : 'json',
	    success : function(data) {
	    	if(data.resultCode=="000000"){
	    		dept=data.data;
	    		var option="";
	    		$.each(data.data,function(n,v){
	    			 if(v.deptId==sId){
	    				 option+="<option selected='selected' value="+v.deptId+">"+v.deptName+"</option>";
	    			 }else{
	    				 option+="<option value="+v.deptId+">"+v.deptName+"</option>";
	    			 }
	    		});
	    		$(obj).append(option);
	    	}
	    }
	});
}

function loadPosition(obj,sId){
	var url=this.getDomain()+"/position/getPositionList";
	$.ajax({
	    url : url,
	    type : "POST",
	    async : true,
	    contentType: "application/json; charset=utf-8",
	    dataType : 'json',
	    success : function(data) {
	    	if(data.resultCode=="000000"){
	    		position=data.data;
	    		var option="";
	    		$.each(data.data,function(n,v){
	    			if(v.positionId==sId){
	    				option+="<option selected='selected'  value="+v.positionId+">"+v.positionName+"</option>";
	    			}else{
	    				option+="<option value="+v.positionId+">"+v.positionName+"</option>";
	    			}
	    		});
	    		$(obj).append(option);
	    	}
	    }
	});
}

function loadRole(obj,sId){
	var url=this.getDomain()+"/role/getRoleList";
	$.ajax({
	    url : url,
	    type : "POST",
	    async : true,
	    contentType: "application/json; charset=utf-8",
	    dataType : 'json',
	    success : function(data) {
	    	if(data.resultCode=="000000"){
	    		var option="";
	    		$.each(data.data,function(n,v){
	    			if(v.roleId==sId){
	    				option+="<option selected='selected'  value="+v.roleId+">"+v.roleName+"</option>";
	    			}else{
	    				option+="<option value="+v.roleId+">"+v.roleName+"</option>";
	    			}
	    		});
	    		$(obj).append(option);
	    	}
	    }
	});
}


function getDomain(){
	var curWwwPath=window.document.location.href;
	var pathName=window.document.location.pathname;
	var pos=curWwwPath.indexOf(pathName);
	var localhostPath=curWwwPath.substring(0,pos);
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
	return localhostPath+projectName;
}


