<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html> 
<head> 
<title>用户</title> 
<meta charset="UTF-8"/> 
<script type="text/javascript"src="<%=basePath%>easyui/jquery.min.js" charset="UTF-8"></script> 
<script type="text/javascript"src="<%=basePath%>easyui/jquery.easyui.min.js"  charset="UTF-8"></script> 
<script type="text/javascript"src="<%=basePath%>easyui/easyui-lang-zh_CN.js"  charset="UTF-8"></script> 
<script type="text/javascript"src="<%=basePath%>js/admin.js" charset="UTF-8"></script> 
<link rel="stylesheet"type="text/css"href="<%=basePath%>easyui/themes/default/easyui.css"/> 
<link rel="stylesheet"type="text/css"href="<%=basePath%>easyui/themes/icon.css"/> 
<style type="text/css">
.textbox{
	height:20px;
	margin:0;
	padding:0 2px;
	box-sizing:content-box;
}

</style>
</head>
<body> 
	<table id="tab" ></table>
		<div id="tool">
			<div style="margin:10px 10px 0 10px;">
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="obj.add();">add</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="obj.edit();">update</a>
				<a id="save" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="obj.save();" >save</a>
				<a id="redo" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="obj.redo();" >redo</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="obj.dele();">delete</a>
			</div>
		</div>
</body> 
</html>
