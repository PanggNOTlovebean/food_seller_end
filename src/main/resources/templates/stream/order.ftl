<html>
<head>
    <meta charset="utf-8">
    <title>卖家后端管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link  rel="stylesheet" href="/res/css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
、
    <script src="https://code.highcharts.com.cn/highcharts/highcharts.js"></script>
</head>
<body>
<div>
    <div id="wrapper" class="toggled">
    <#--边栏-->
    <#include "../common/nav.ftl">
    <#--主要内容区域-->
        <div id="app">
            <div id="container" ></div>
        </div>
    </div>
</div>
</body>
<script>
    var rArray = new Array();
        <#list moneys as money>
            rArray.push("${money?js_string}");//必须这么写
        </#list>
    console.log(rArray)
    for(var  i=0;i<rArray.length;i++){
            rArray[i] = rArray[i].replace(/,/g, "");
    }
    Highcharts.chart('container', {
        chart: {
            style: {
                fontFamily: 'serif'
            }
        },
        title: {
            text: '营业额直线图'
        },
        xAxis: {
            title:{
                text:'月份'
            },
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        yAxis:{
            title:{
                text:'销量（单位：元）'
            }
        },
        series: [{
            data: [parseInt(rArray[0]), parseInt(rArray[1]),parseInt(rArray[2]), parseInt(rArray[3]), parseInt(rArray[4]), parseInt(rArray[5]), parseInt(rArray[6]), parseInt(rArray[7]), parseInt(rArray[8]),parseInt(rArray[9]),parseInt(rArray[10]),parseInt(rArray[11])],
            name: '月营业额'
        }],
    });
    // var app = new Vue({
    //     el: '#app',
    //     data: {
    //         message: 'Hello Vue!',
    //         foodList:['咸菜','米饭']
    //     }
    // })
</script>
</html>
