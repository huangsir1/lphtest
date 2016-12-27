<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>作者序号</th>
			<th>发帖日期</th>
			<th>帖名</th>
			<th>状态</th>
			<th>评论</th>
		</tr>
		<#list postList as post>
		<tr>
			<td>${post.id!''}</td>
			<td>${post.post_author!''}</td>
			<td>${post.post_date?string("yyyy-MM-dd HH:mm:ss")}</td>
			<td>${post.post_title}</td>
			<td>${post.post_status}</td>
			<td>${post.comment_status}</td>
		</tr>
		</#list>
	</table>
</body>
</html>