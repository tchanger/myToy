<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>银行转账</title>
</head>
<body>
<%--使用mybatis实现银行转账--%>
<%--<form action="/MTransfer" method="post">--%>
<%--使用JDBC实现银行转账--%>
<%--<form action="/JTransfer" method="post">--%>
<%--使用Thread Local优化后实现银行转账--%>
<form action="/TTransfer" method="post">
    转账人：<input type="text" name="from"><br>
    收款人：<input type="text" name="to"><br>
    转账金额：<input type="text" name="money"><br>
    <input type="submit" value="转账">
</form>
</body>
</html>
