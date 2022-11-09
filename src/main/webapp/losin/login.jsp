<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv">
    <form action="/SinIn/sing" id="form" method="get">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div></div>
        <p>Username :<input id="username" name="username" value="${cookie.userid.value}" type="text"></p>

        <p>Password:<input id="password" name="password" value="${cookie.password.value}" type="password"></p>
        <p>Remember <input id="remember" name="remember" value="1" type="checkbox"></p>

        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="register.jsp">没有账户？注册账户</a>
        </div>
    </form>
</div>



</body>
</html>