<html>
    <#include "../common/header.ftl">
<body>
<div>
    <div id="wrapper" class="toggled">
    <#--边栏-->
                <#include "../common/nav.ftl">
    <#--主要内容区域-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-striped  table-hover">
                            <thead>
                            <tr>
                                <th>订单id</th>
                                <th>总价格</th>
                                <th>交易时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                    <#list orderPage.content as order>
                    <tr>
                        <td>${order.id}</td>
                        <td>${order.price}</td>
                        <td>${order.date}</td>
                        <td>
                            <a href="/res/order/index?orderId=${order.id}">
                                详细
                            </a>
                        </td>
                    </tr>
                    </#list>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">

                    <#if currentPage lte 1>
                        <li class="disabled"> <a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/res/order/list?page=${currentPage-1}&size=${size}">上一页</a> </li>
                    </#if>

                    <#list 1..orderPage.getTotalPages() as index>
                        <#if currentPage==index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                          <li><a href="/res/order/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte orderPage.getTotalPages()>
                        <li class="disabled">    <a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/res/order/list?page=${currentPage+1}&size=${size}">下一页</a> </li>
                    </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
