<html>
<head>
    <meta charset="utf-8">
    <title>卖家后端管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/res/css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
    <script src="https://code.highcharts.com.cn/highcharts/highcharts.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div>
    <div id="wrapper" class="toggled">
    <#--边栏-->
    <#include "../common/nav.ftl">
    <#--主要内容区域-->
        <div id="app">
            <el-table
                    :data="foods"
                    style="width: 100%"
                    :default-sort="{prop: 'number', order: 'descending'}"
            >
                <el-table-column prop="id" label="商品Id" width="180"></el-table-column>
                <el-table-column prop="name" label="名称" width="180"></el-table-column>
                <el-table-column prop="number" label="销量" sortable></el-table-column>
            </el-table>
        </div>
    </div>
</div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            message: 'Hello Vue!',
            foodList: ['咸菜', '米饭'],
            foods: [{name: '啊', number: 2}, {name: '哈', number: 3}]
        },
        mounted() {
            var that=this
            axios.post('/res/stream/food')
                    .then(function (response) {
                        that.foods=response.data.data;
                    })
                    .catch(function (error) {
                    });
        }
    })
</script>
</html>
