<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.Brand" %>

<%--
  Created by IntelliJ IDEA.
  User: lenovo
      Date: 2022/10/29
      Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> 欢迎<%=session.getAttribute("user")%>登录 </h1>


<%
    List<Brand> brands = new ArrayList<Brand>();
    brands.add(new Brand(1, "三只松鼠", "三只松鼠", 100, "三只松鼠，好吃不上火", 1));
    brands.add(new Brand(2, "优衣库", "优衣库", 200, "优衣库，服适人生", 0));
    brands.add(new Brand(3, "小米", "小米科技有限公司", 1000, "为发烧而生", 1));
%>
<input type="button" value="新增"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>

    <%
        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
    %>
    <tr align="center">
        <td><%=brand.getId()%></td>
        <td><%=brand.getBrandName()%></td>
        <td><%=brand.getCompanName()%></td>
        <td><%=brand.getOldered()%></td>
        <td><%=brand.getDescription()%></td>
        <td><%=brand.getStatus()%></td>

        <td><a href="#">修改</a> <a href="#">删除</a></td>
    </tr>
    <%
        }
    %>

</table>

</body>
</html>
