<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form method="post" action="/login">
    <%= request.getAttribute("message") == null ? "" : request.getAttribute("message") %><br/>
账号：<input type="text" name="username" value="${cookie.user.value}"/><br/>
密码：<input type="password" name="password"/><br/>
验证码：<input type="text" name="code"/> <img src="checkCode" onclick="f1(this)"/><br/>
记住用户名：<input name="remember" type="checkbox"/>
<input type="submit"/>
</form>
</body>
<script>
    function f1(obj) {
        obj.src = "checkCode?"+Math.random();
    }
</script>
</html>
