<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>内容主页</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        .headDIV{
            height: 100px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row headDIV">
        <h5 class="text-right">
            <span class="glyphicon glyphicon-user"></span>
            ${sessionScope.user.userName}，欢迎登陆
            <a href="">注销登陆</a>
        </h5>
    </div>
    <div class="row">
        <div class="col-xs-3">
            <ul class="nav nav-pills nav-stacked" role="tablist">
                <li <c:if test="${sessionScope.servletName eq 'queryServlet'}">class="active"</c:if>>
                    <a href="/queryUser">查看用户</a>
                </li>
                <li ><a href="#">添加商品</a></li>
                <li ><a href="#">查看商品</a></li>
            </ul>
        </div>
        <div class="col-xs-9">
            <div>
                <ol class="breadcrumb">
                    <li><a href="#">内容主页</a></li>
                    <li class="active">查看用户</li>
                </ol>
            </div>
            <div>
                <table class="table table-hover">
                    <tr>
                        <th>编号</th>
                        <th>用户名</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>爱好</th>
                    </tr>
                    <%--一个user代表一个tr--%>
                    <c:forEach items="${requestScope.users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.userName}</td>
                        <td>${user.gender?'男':'女'}</td>
                        <td>${user.age}</td>
                        <td>
                        <c:forEach items="${user.hobbies}" var="hobby">
                        ${hobby}&nbsp;
                            </c:forEach>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
