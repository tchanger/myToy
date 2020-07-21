<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap模板</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">显示所有联系人</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${list}" var="linkman" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${linkman.name}</td>
                <td>${linkman.sex}</td>
                <td>${linkman.age}</td>
                <td>${linkman.address}</td>
                <td>${linkman.qq}</td>
                <td>${linkman.email}</td>
                <td><a class="btn btn-default btn-sm" href="LinkManGetId?id=${linkman.id}">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="LinkManDelete?id=${linkman.id}" onclick="return(confirm('确定要删除吗'))">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="add.jsp">添加联系人</a></td>
        </tr>
    </table>
</div>
</body>
</html>
