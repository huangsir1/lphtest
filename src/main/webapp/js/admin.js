$(function(){
	//js获取项目根路径，如： http://localhost:8083/uimcardprj
	function getRootPath(){
	    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	    var curWwwPath=window.document.location.href;
	    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	    var pathName=window.document.location.pathname;
	    var pos=curWwwPath.indexOf(pathName);
	    //获取主机地址，如： http://localhost:8083
	    var localhostPaht=curWwwPath.substring(0,pos);
	    //获取带"/"的项目名，如：/uimcardprj
	    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	    return(localhostPaht+projectName);
	}
	
	obj={
		addable:true,
		tempid:100,
		search:function(){
			$('#tab').datagrid('load',{
				sid:$.trim($('input[name="sid"]').val()),
			});
		},
		add:function(){
			if(this.addable){
				$('#save,#redo').show();
				$('#tab').datagrid('insertRow',{
					index:0,
					row:{
						userid:++this.tempid,
						name:'Tom',
						password:'123',
					},
				});
				$('#tab').datagrid('beginEdit',0);
				this.addable=false;
			}
		},
		
		save:function(){
			$('#tab').datagrid('endEdit',0);
		},
		redo:function(){
			$('#tab').datagrid('rejectChanges');
			this.addable=true;
		},
		edit:function(){
			var index=$('#tab').datagrid('getSelected');
			alert(index.userid);
		},
		dele:function(){
			var index=$('#tab').datagrid('getSelected');
			$.ajax({
				url:getRootPath()+'/delete',
				type:'POST',
				data:{
					userid:index.userid,
				},
				beforeSend : function (jqXHR, settings) {
					$('#tab').datagrid('loading'); 
				},
				success:function(data){
					console.log(data);
					if(data){
						$('#tab').datagrid('load'); 
						$('#tab').datagrid('loaded'); 
						$('#tab').datagrid('unselectAll'); 
						$.messager.show({ 
							title : '提示',
							msg : data + '个用户被删除成功！',
						});
					}
				},
			});
		},
			
	};
	$('#tab').datagrid({
		width:400,
		title:'用户列表',
		iconCls:'icon-search',
		url:getRootPath()+'/getAllPost',
		pagination:true,
		rownumbers:true,
		pageSize:5,
		pageList:[5,10,15,20],
		singleSelect:true,
		sortName:'userid',
		toolbar:'#tool',
		onDblClickRow:function(rowIndex,rowData){
			console.log('dbclick');
			if(rowData.userid==1000){
				window.location.href = getRootPath()+"/admin-jsp/detail.jsp";
			}
		},
		onAfterEdit:function(rowIndex, rowData, changes){
			obj.addable=true;
			var url='';
			//$('#save,#redo').hide();
			
			var inserted=$('#tab').datagrid('getChanges','inserted');
			if(inserted.length>0){
				url=getRootPath()+'/insert';
			}

			$.ajax({
				url:url,
				type:'POST',
				data:{
					id:rowData.userid,
					name:rowData.name,
					password:rowData.password,
				},
				beforeSend : function (jqXHR, settings) {
					$('#tab').datagrid('loading'); 
				},
				success:function(data){
					if(data){
						$('#tab').datagrid('load'); 
						$('#tab').datagrid('loaded'); 
						$('#tab').datagrid('unselectAll'); 
						$.messager.show({ 
							title : '提示',
							msg : data + '个用户被添加成功！',
						});
					}
				},
			});
		},
		columns:[[
			{
				field:'id',
				title:'序号',
				width:100,
				editor:{
					type:'validatebox',
					options:{
						required:true,
					},
				},
			},
			{
				field:'post_author',
				title:'作者',
				width:100,
				editor:{
					type:'validatebox',
					options:{
						required:true,
					},
				},
			},
			{
				field:'post_date',
				title:'发帖日期',
				width:100,
				editor:{
					type:'validatebox',
					options:{
						required:true,
					},
				},
			},
		]],
	});
	
	
});