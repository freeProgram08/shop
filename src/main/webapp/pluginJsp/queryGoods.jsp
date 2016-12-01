<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-xs-9">
    <form class="form-inline" action="/queryGoods" method="post">
        <div class="form-group">
            <label class="sr-only">商品名</label>
            <input type="text" class="form-control" name="goodsName"
                   placeholder="商品名">
        </div>
        <div class="form-group">
            <label class="sr-only">商品类型</label>
            <div class="checkbox">
                <%--radio checkbox 类型的input默认传值是on，
                所以要用value属性指定有意义的值--%>
                <input type="radio" name="type" value="1">食品
                <input type="radio" name="type" value="2">服装
            </div>
        </div>
        <div class="form-group">
            <label class="sr-only">价格</label>
            <input type="text" class="form-control" name="price" placeholder="价格">
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
    </form>
    <hr/>
    <table class="table">
        <tr>
            <th>编号</th>
            <th>商品名</th>
            <th>类型</th>
            <th>价格</th>
        </tr>
       <%-- items 代表集合，var代表集合里的每一项--%>
        <c:forEach items="${requestScope.allGoods}" var="good">
        <tr>
        <td>${good.id}</td>
        <td>${good.goodsName}</td>
        <td>${good.type==1?"食品":good.type==2?"衣服":"其他"}</td>
        <td>${good.price}</td>
  <%--          ?后面代表超链接传值
            key=value这种值对进行传值的
            id=2;  id是key,value是2
            key就是表单里name的值 name="id"--%>
        <td><a href="/destroyGoodsById?id=${good.id}"><i class="delete_log"></i></a></td>
        </tr>
        </c:forEach>
    </table>
</div>