<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/17
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${requestScope.error}
<form action="/info" method="post">
    姓名：<input name="name"></br>
    年龄：<input name="age"></br>
    爱好：<input name="hobby"></br>
    <button type="submit">提交</button>
</form>
</body>
</html>
