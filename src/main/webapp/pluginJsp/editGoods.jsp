<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-xs-9">
    <div>
        <ol class="breadcrumb">
            <li><a href="#">内容主页</a></li>
            <li class="active">修改商品</li>
        </ol>
    </div>
    <div>
        <form class="form-horizontal"
              action="/editGoodsById" method="post">
            <div class="form-group">
                <label class="col-xs-3">商品编号：</label>
                <div class="col-xs-9">
                    <input type="text" class="form-control "
                           value="${requestScope.goods.id}"
                           name="id" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3">商品名：</label>
                <div class="col-xs-9">
                    <input type="text" class="form-control "
                           value="${requestScope.goods.goodsName}"   name="goodsName">
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3">商品类型：</label>
                <div class="col-xs-9">
                    <div class="radio ">
                        <label>
                            <input type="radio" name="type" value="1"
<c:if test="${requestScope.goods.type==1}"> checked</c:if>>食品
                        </label>
                        <label>
                          <%--  radio 加上checked属性显示选中--%>
                            <input type="radio"
                            <c:if test="${requestScope.goods.type==2}"> checked</c:if>
                                   name="type" value="2">服装
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-3">价格：</label>
                <div class="col-xs-9">
                    <input type="text" class="form-control"
                           value="${requestScope.goods.price}"
                           name="price" >
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-9">
                    <button class="btn btn-primary " type="submit">修改商品</button>
                </div>
            </div>
        </form>
    </div>
</div>
