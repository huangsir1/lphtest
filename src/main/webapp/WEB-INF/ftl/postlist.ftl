<html>
<body>
    <h1> ${name!""}</h1><br/>
    <#list postList as post>
       <span> ${post_index+1} === ${post.id}--- ${post.post_author}---${post.post_date?string("yyyy-MM-dd")}--- ${post.post_status}--- ${post.comment_status}--- ${post.post_title}</span><br/>
    </#list>
</body>
</html>