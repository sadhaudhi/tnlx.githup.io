<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">

</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
    </div>
    <form id="reg-form" action="/SinIn/register" method="post">

        <table>

            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg" style="display: none">用户名不太受欢迎</span>
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>

            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="Vcode" type="text" id="Vcode" size="20">
                    <img id="checkCodeImg" src="/SinIn/CodeServlet">
                    <a href="#" id="changeImg" >看不清？</a>
                    <br>
                    <%
                        HttpSession session1 = request.getSession();
                        Object register_msg = session1.getAttribute("register_msg");
                    %>
                    <%=register_msg%>
                </td>
            </tr>


        </table>
        <script> document.getElementById("changeImg").onclick =
            function () { //路径后面添加时间戳的目的是避免浏览器进行缓存静态资源
                document.getElementById("checkCodeImg").src = "/SinIn/CodeServlet?" + new Date().getMilliseconds();
            }
        </script>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>



</body>
</html>