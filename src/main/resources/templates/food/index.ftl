<html>
    <#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
<#--边栏-->
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <form role="form" method="post" action="/res/food/save">

                    <div class="form-group">
                        <label >名称</label><input name="name" type="text" class="form-control" value="${(food.name)!''}"/>
                    </div>

                    <div class="form-group">
                        <label >价格</label><input name="price" type="number" class="form-control" value="${(food.price)!''}"/>
                    </div>
                    <div class="form-group">
                        <label >描述</label><input name="introduction" type="text" class="form-control" value="${(food.introduction)!''}"/>
                    </div>
                    <input hidden type="text" name="id" value="${(food.id)!''}">
                    <button type="submit" class="btn btn-default" >提交</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>