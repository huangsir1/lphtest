<html>
<body>
    <h1> ${name!""}</h1><br/>
    <#list userList as user>
       ${user_index+1} === ${user.name}---${user.age}----${user.sex}<br/>
    </#list>
</body>
</html>