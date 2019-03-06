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
                                <th>商品id</th>
                                <th>名称</th>
                                <th>单价</th>
                                <th>创建时间</th>
                                <th>修改时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                    <#list foodPage.content as food>
                    <tr>
                        <td>${food.id}</td>
                        <td>${food.name}</td>
                        <td>${food.price}</td>
                        <td>${food.createTime}</td>
                        <td>${food.updateTime}</td>
                        <td>
                            <a href="/res/food/index?foodId=${food.id}">
                                修改
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
                        <li><a href="/res/food/list?page=${currentPage-1}&size=${size}">上一页</a> </li>
                    </#if>

                    <#list 1..foodPage.getTotalPages() as index>
                        <#if currentPage==index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                          <li><a href="/res/food/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte foodPage.getTotalPages()>
                        <li class="disabled">    <a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/res/food/list?page=${currentPage+1}&size=${size}">下一页</a> </li>
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
