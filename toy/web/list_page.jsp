<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap模板</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
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
        <c:forEach items="${pageBean.dataList}" var="linkman">
            <tr>
                <td>${linkman.id}</td>
                <td>${linkman.name}</td>
                <td>${linkman.sex}</td>
                <td>${linkman.age}</td>
                <td>${linkman.address}</td>
                <td>${linkman.qq}</td>
                <td>${linkman.email}</td>
                <td><a class="btn btn-default btn-sm" href="/linkMan?method=findPage&id=${linkman.id}">修改</a>&nbsp;<a class="btn btn-default btn-sm"  href="linkMan?method=pageQuery&pageNumber=${pageBean.pageNumber+1}&pageSize=${pageBean.pageSize}" onclick="return(confirm('确定要删除吗'))">删除</a></td>
            </tr>
        </c:forEach>


        <tr>
            <td colspan="8" align="center">

				<ul class="pagination success">

                    <%--
                    上一页按钮
                    如果当前页码>1：允许点击上一页按钮/显示“上一页”按钮
                    否则：不允许点击/不显示“上一页”按钮
                    --%>
                    <c:if test="${pageBean.pageNumber > 1}">
                        <li><a href="linkMan?method=pageQuery&pageNumber=${pageBean.pageNumber-1}&pageSize=${pageBean.pageSize}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                    </c:if>


                    <%--页码按钮：从1到最后一页--%>
                    <c:forEach var="i" begin="1" end="${pageBean.pageCount}" step="1">
                        <li class="${i==pageBean.pageNumber?'active':''}">
                            <a href="linkMan?method=pageQuery&pageNumber=${i}&pageSize=${pageBean.pageSize}">${i}</a>
                        </li>
                    </c:forEach>

                    <%--
                    下一页按钮
                    如果当前页码<总页数：显示“下一页”的按钮
                    否则：不显示
                    --%>
                    <c:if test="${pageBean.pageNumber<pageBean.pageCount}">
                        <li><a href="linkMan?method=pageQuery&pageNumber=${pageBean.pageNumber+1}&pageSize=${pageBean.pageSize}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
                    </c:if>

				</ul>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
