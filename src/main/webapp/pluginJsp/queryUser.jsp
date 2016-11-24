<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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