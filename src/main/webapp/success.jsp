<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/17
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--通过key来取值--%>
<%--jsp--%>
<%--姓名：<%Object name = request.getAttribute("name");
out.print(name);%>--%>
姓名：${requestScope.name}
年龄：${requestScope.age}
爱好：${requestScope.hobby}
</body>
</html>
