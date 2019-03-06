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
            <div class="app-container">
                <div class="address-layout">
                    <el-row :gutter="20">
                    </el-row>
                </div>
                <div class="total-layout">
                    <el-row :gutter="20">
                        <el-col :span="6">
                            <div class="total-frame">
                            <#--<svg-icon icon-class="order" class="total-icon">-->
                            <#--</svg-icon>-->
                            <#--<iframe class="total-icon" src="/res/svg/order.svg"></iframe>-->
                                <embed class="total-icon" src="/res/svg/order.svg" type="image/svg+xml"/>
                                <div class="total-title">今日订单总数</div>
                                <div class="total-value">{{todayNum}}</div>
                            </div>
                        </el-col>
                        <el-col :span="6">
                            <div class="total-frame">
                            <#--<svg-icon icon-class="total-today" class="total-icon">-->
                                <embed class="total-icon" src="/res/svg/total-today.svg" type="image/svg+xml"/>
                                </svg-icon>
                                <div class="total-title">今日销售总额</div>
                                <div class="total-value">￥{{todayMoney}}.00</div>
                            </div>
                        </el-col>
                        <el-col :span="6">
                            <div class="total-frame">
                            <#--<svg-icon icon-class="total-yesterday" class="total-icon">-->
                                <embed class="total-icon" src="/res/svg/total-yesterday.svg" type="image/svg+xml"/>
                                </svg-icon>
                                <div class="total-title">昨日销售总额</div>
                                <div class="total-value">￥{{yesterdayMoney}}.00</div>
                            </div>
                        </el-col>
                        <el-col :span="6">
                            <div class="total-frame">
                            <#--<svg-icon icon-class="total-week" class="total-icon">-->
                            <#---->
                            <#--</svg-icon>-->
                                <embed class="total-icon" src="/res/svg/total-week.svg" type="image/svg+xml"/>
                                <div class="total-title">近7天销售总额</div>
                                <div class="total-value">￥{{weekMoney}}.00</div>
                            </div>
                        </el-col>
                    </el-row>
                </div>


                <div class="overview-layout">
                    <el-row :gutter="20">
                        <el-col :span="12">
                            <div class="out-border">
                                <div class="layout-title">店面总览</div>
                                <div style="padding: 40px">
                                    <el-row>
                                        <el-col :span="8" class="color-danger overview-item-value">{{foodNum}}</el-col>
                                        <el-col :span="8" class="color-danger overview-item-value">{{rawNum}}</el-col>
                                        <el-col :span="8" class="color-danger overview-item-value">{{rawLackNum}}</el-col>
                                    </el-row>
                                    <el-row class="font-medium">
                                        <el-col :span="8" class="overview-item-title">全部菜品</el-col>
                                        <el-col :span="8" class="overview-item-title">材料数量</el-col>
                                        <el-col :span="8" class="overview-item-title">库存紧张</el-col>
                                    </el-row>
                                </div>
                            </div>
                        </el-col>
                        <el-col :span="12">
                            <div class="out-border">
                                <div class="layout-title">销售总览</div>
                                <div style="padding: 40px">
                                    <el-row>
                                        <el-col :span="8" class="color-danger overview-item-value">{{yesterdayOrder}}</el-col>
                                        <el-col :span="8" class="color-danger overview-item-value">{{weekOrder}}</el-col>
                                        <el-col :span="8" class="color-danger overview-item-value">{{monthOrder}}</el-col>
                                    </el-row>
                                    <el-row class="font-medium">
                                        <el-col :span="8" class="overview-item-title">昨日订单</el-col>
                                        <el-col :span="8" class="overview-item-title">本周订单</el-col>
                                        <el-col :span="8" class="overview-item-title">本月订单</el-col>
                                    </el-row>
                                </div>
                            </div>
                        </el-col>
                    </el-row>
                </div>
                <div class="overview-layout">
                    <el-row :gutter="20">
                        <el-col :span="12">
                            <div class="out-border">
                                <div class="layout-title">本周销量冠军</div>
                                <div style="padding: 40px">
                                    <el-row class="font-medium">
                                        <el-col :span="24" class="food-name">{{bestFood}}</el-col>
                                    </el-row>
                                </div>
                            </div>
                        </el-col>
                        <el-col :span="12">
                            <div class="out-border">
                                <div class="layout-title">本周弟弟菜品</div>
                                <div style="padding: 40px">
                                    <el-row class="font-medium">
                                        <el-col :span="24" class="food-name">{{badFood}}</el-col>
                                    </el-row>
                                </div>
                            </div>
                        </el-col>
                    </el-row>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            todayNum: 0,
            todayMoney: 0,
            yesterdayMoney: 0,
            weekMoney: 0,
            foodNum: 0,
            rawNum: 0,
            rawLackNum: 0,
            yesterdayOrder: 0,
            weekOrder: 0,
            monthOrder: 0,
            bestFood: "",
            badFood: "",
        },
        mounted() {
            var that = this
            axios.post('/res/home')
                    .then(function (response) {
                        that.todayNum = response.data.data.todayNum;
                        that.todayMoney = response.data.data.todayMoney;
                        that.yesterdayMoney = response.data.data.yesterdayMoney;
                        that.weekMoney = response.data.data.weekMoney;
                        that.foodNum = response.data.data.foodNum;
                        that.rawNum = response.data.data.rawNum;
                        that.rawLackNum = response.data.data.rawLackNum;
                        that.yesterdayOrder = response.data.data.yesterdayOrder;
                        that.weekOrder = response.data.data.weekOrder;
                        that.monthOrder = response.data.data.monthOrder;
                        that.bestFood = response.data.data.bestFood;
                        that.badFood = response.data.data.badFood;
                        console.log(that.$data)
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
        }
    })
</script>
<style scoped>
    .app-container {
        margin-top: 40px;
        margin-left: 120px;
        margin-right: 120px;
    }

    .address-layout {
    }

    .total-layout {
        margin-top: 20px;
    }

    .total-frame {
        border: 1px solid #DCDFE6;
        padding: 20px;
        height: 100px;
    }

    .total-icon {
        color: #409EFF;
        width: 60px;
        height: 60px;
    }

    .total-title {
        position: relative;
        font-size: 16px;
        color: #909399;
        left: 70px;
        top: -50px;
    }

    .total-value {
        position: relative;
        font-size: 18px;
        color: #606266;
        left: 70px;
        top: -40px;
    }

    .un-handle-layout {
        margin-top: 20px;
        border: 1px solid #DCDFE6;
    }

    .layout-title {
        color: #606266;
        padding: 15px 20px;
        background: #F2F6FC;
        font-weight: bold;
    }

    .un-handle-content {
        padding: 20px 40px;
    }

    .un-handle-item {
        border-bottom: 1px solid #EBEEF5;
        padding: 10px;
    }

    .food-name {
        color: #606266;
        padding: 15px 20px;
        font-size: 20px;
        font-weight: bold;
        text-align: center;
    }

    .overview-layout {
        margin-top: 20px;
    }

    .overview-item-value {
        font-size: 24px;
        text-align: center;
    }

    .overview-item-title {
        margin-top: 10px;
        text-align: center;
    }

    .color-danger {
        color: red;
    }

    .out-border {
        border: 1px solid #DCDFE6;
    }

    .statistics-layout {
        margin-top: 20px;
        border: 1px solid #DCDFE6;
    }
</style>
</html>
