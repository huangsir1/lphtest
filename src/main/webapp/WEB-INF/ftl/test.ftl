<html>
<body>
    <h1> ${name!""}</h1><br/>
    <#list userList as user>
       <span> ${user_index+1} === ${user.name}---${user.age}----${user.sex}</span><br/>
    </#list>
</body>
</html>