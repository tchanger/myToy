<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/6/18
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>玩具</title>
  </head>
  <style>
      .one{
          background-color: white;
      }
      .two{
          background-color: red;
      }
  </style>
  <body>
  <table width="100%" align="center">
      <c:forEach items="${list}" var="user" varStatus="vs">
          <tr>
              <td>${vs.count}</td>
              <td>${user.username}</td>
              <td>${user.birthday}</td>
              <td>${user.sex}</td>
              <td>${user.address}</td>
          </tr>
      </c:forEach>
  </table>
  </body>
<script>
    var tr = document.getElementsByTagName("tr");
    for (var i = 2; i < tr.length-1; i++) {
        //判断奇偶，设置不同的背景颜色
        if (i % 2) {
            tr[i-1].className = "two";
        }else{
            tr[i-1].className = "one";
        }
    }
    setInterval(function () {
        for (let l of tr) {
            if(l.className === "one"){
                l.className = "two";
            }else {
                l.className = "one";
            }
        }
    },50)
</script>
</html>
