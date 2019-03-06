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
                                <th>材料id</th>
                                <th>名称</th>
                                <th>库存</th>
                                <th>库存上限</th>
                                <th>库存下限</th>
                                <th>单位</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                    <#list rawPage.content as raw>
                    <tr>
                        <td>${raw.id}</td>
                        <td>${raw.name}</td>
                        <td>${raw.number}</td>
                        <td>${raw.min!''}</td>
                        <td>${raw.max!''}</td>
                        <td>${raw.unit}</td>
                        <td>
                            <a href="/res/raw/index?rawId=${raw.id}">
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
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/res/raw/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..rawPage.getTotalPages() as index>
                        <#if currentPage==index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                          <li><a href="/res/raw/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte rawPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/res/raw/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                    </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<style>
     table th{
         text-align: center;
    }
    td{
        text-align: center;
    }

</style>
</html>
