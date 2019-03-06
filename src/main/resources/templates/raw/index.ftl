<html>
    <#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--边栏-->
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <form role="form" method="post" action="/res/raw/save">

                    <div class="form-group">
                        <label >名称</label><input name="name" type="text" class="form-control" value="${(raw.name)!''}"/>
                    </div>

                    <div class="form-group">
                    <label >数量</label><input name="number" type="number" class="form-control" value="${(raw.number)!''}"/>
                    </div>


                    <div class="form-group">
                        <label >库存上限</label><input name="max" type="text" class="form-control" value="${(raw.max)!''}"/>
                    </div><div class="form-group">
                        <label >库存下限</label><input name="min" type="text" class="form-control" value="${(raw.min)!''}"/>
                    </div><div class="form-group">
                        <label >单位</label><input name="unit" type="text" class="form-control" value="${(raw.unit)!''}"/>
                    </div>


                    <input hidden type="text" name="id" value="${(raw.id)!''}">
                    <button type="submit" class="btn btn-default" >提交</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>