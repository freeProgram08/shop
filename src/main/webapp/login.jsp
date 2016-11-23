<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <!--    导入外部样式文件-->
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <!--导入内部样式-->
    <style>
        #content {
            margin-top: 100px;
        }
        #content div {
            padding-left: 0px;
            padding-right: 0px;
        }
        .logImg{
            width: 100%;
            height: 100%;
            height: 423px;
        }
        body{
            background-image:url("img/bg.png") ;
            background-repeat: no-repeat;
        }
        #content  .login{
            background-color: white;
        }
        #content  .loginContent{
            padding-left: 30px;
            padding-right: 30px;
        }
        .M20{
            margin-top: 20px;
        }
        .btn-login:hover{
            background-color: #b43200;
        }
        .btn-login{
            background-color: #dc3c00;
        }
        #content .line {
            background: #eee;
            height: 1px;
            margin-top: 20px;
        }
        .loginContent .list-inline li{
            display: inline-block;
            background-image: url(img/mark.png);
            background-repeat: no-repeat;
            margin-right: 5px;
            width: 32px;
            height: 32px;
        }
        .linkin {
            background-position: -37px 0;
        }
        .baidu {
            background-position: -74px 0;
        }
        .qq {
            background-position: -112px 0;
        }
        .github {
            background-position: -186px 0;
        }
        .wechat {
            background-position: -224px 0;
        }
    </style>
</head>
<body>
<!--容器模板 container,container-fluid-->
<div class="container-fluid">
    <!--   行模板 row-->
    <div class="row" id="content">
        <div class="col-xs-offset-2 col-xs-8">
            <div class="col-xs-8">
                <img src="img/c.jpg" class="logImg" >
            </div>
            <div class="col-xs-4 login">
                <div class="loginContent">
                    <!--定义服务地址
                    服务地址必须以'/'开头
                    为了区别静态资源，所有的服务不带后缀名。
                    通过method 定义请求方式
                    -->
                    <form class="form-horizontal"
                          action="/login" method="post">
                        <div class="form-group M20">
                            <h5>账号登录</h5>
                            <h6 class="text-danger">
                               <%-- jsp标签--%>
                                <%--out可以输出html内容
                                   getAttribute 可以获取setAttribute存储内容--%>
                                ${requestScope.error}
                            </h6>
                        </div>
                        <div class="form-group M20">
                            <div class="input-group">
                           <span class="input-group-addon">
                               <span class="glyphicon glyphicon-user"></span>
                           </span>
                                <input type="text" class="form-control" name="userName"
                                       placeholder="Username">
                            </div>
                        </div>
                        <div class="form-group M20">
                            <div class="input-group">
                           <span class="input-group-addon">
                               <span class="glyphicon glyphicon-lock"></span>
                           </span>
                                <input type="text" class="form-control" name="pass"
                                       placeholder="password">
                            </div>
                        </div>
                        <div class="form-group M20">
                            <div class="checkbox">
                                <label class="col-xs-6">
                                    <input type="checkbox">下次自动登录
                                </label>
                                <label class="col-xs-6 text-right">忘记密码?</label>
                            </div>
                        </div>
                        <div class="form-group M20">
                            <button type="submit" class="btn btn-default col-xs-12 btn-login">登录</button>
                        </div>
                    </form>
                </div>
                <!--分割线-->
                <div class="col-xs-12 line"></div>
                <div class="loginContent">
                    <h6 class="text-left col-xs-12">第三方账号</h6>
                    <ul class="list-group list-inline">
                        <li class="list-group-item">
                        </li>
                        <li class="linkin"></li>
                        <li class="baidu"></li>
                        <li class="qq"></li>
                        <li class="github"></li>
                        <li class="wechat"></li>
                    </ul>
                    <div>
                        <h6 class="text-left col-xs-6" >还没有账号？</h6>
                        <h6 class="text-right col-xs-6" ><a href="/">立即注册</a></h6>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
