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
		width:1100,
		title:'详细信息',
		iconCls:'icon-search',
		url:getRootPath()+'/getReports',
		pagination:true,
		rownumbers:true,
		pageSize:10,
		pageList:[5,10,15,20],
		singleSelect:true,
		sortName:'userid',
		toolbar:'#tool',
		onDblClickRow:function(rowIndex,rowData){
			$('#tab').datagrid('beginEdit',rowIndex);
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
				field:'date',
				title:'日期',
				width:100,
			},
			{
				field:'zd',
				title:'主动',
				width:100,
			},
			{
				field:'gd',
				title:'果断',
				width:100,
			},
			{
				field:'lz',
				title:'理智',
				width:100,
			},
			{
				field:'zj',
				title:'主见',
				width:100,
			},
			{
				field:'jc',
				title:'坚持',
				width:100,
			},
			{
				field:'yq',
				title:'勇气',
				width:100,
			},
			{
				field:'gn',
				title:'感恩',
				width:100,
			},
			{
				field:'kr',
				title:'宽容',
				width:100,
			},
			{
				field:'lg',
				title:'乐观',
				width:100,
			},
		]],
	});
	
	
});