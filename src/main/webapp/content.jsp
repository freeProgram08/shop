<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <li class="active"><a href="#">查看用户</a></li>
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
                    <tr>
                        <td>1</td>
                        <td>wang</td>
                        <td>男</td>
                        <td>20</td>
                        <td>打篮球，打网球</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
