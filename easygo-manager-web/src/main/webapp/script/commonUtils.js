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

function openWindow(url,name,iWidth,iHeight){
	 var url;                            //转向网页的地址;
	 var name;                           //网页名称，可为空;
	 var iWidth;                         //弹出窗口的宽度;
	 var iHeight;                        //弹出窗口的高度;
	 var iTop = (window.screen.height-30-iHeight)/2;       //获得窗口的垂直位置;
	 var iLeft = (window.screen.width-10-iWidth)/2;        //获得窗口的水平位置;
	 window.open(url,name,'height='+iHeight+',,innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}

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


