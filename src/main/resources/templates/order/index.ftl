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
                                <th>名称</th>
                                <th>价格</th>
                            </tr>
                            </thead>
                            <tbody>
                    <#list detailInfo as order>
                    <tr>
                        <td>${order.name}</td>
                        <td>${order.price}</td>
                    </tr>
                    </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
