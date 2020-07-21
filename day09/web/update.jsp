<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改联系人</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="/LinkManEdit" method="post">
        <input type="hidden" name="id" value="${linkman.id}">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" readonly="readonly" value="${linkman.name}"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <div class="form-group">
                <input type="radio" name="sex" value="男" ${linkman.sex=="男"?"checked":""}/>男
                <input type="radio" name="sex" value="女" ${linkman.sex=="女"?"checked":""}/>女
            </div>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" value="${linkman.age}"/>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control">
                <option value="广东" ${linkman.address == "广东" ? "selected" : ""}>广东</option>
                <option value="广西" ${linkman.address == "广西" ? "selected" : ""}>广西</option>
                <option value="湖南" ${linkman.address == "湖南" ? "selected" : ""}>湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" value= "${linkman.qq}" />
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" name="email" value = "${linkman.email}" />
        </div>
        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>