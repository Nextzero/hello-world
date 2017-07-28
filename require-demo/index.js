require(['module1'], function(module1) {
    'use strict';
    console.log("这里是index, 我依赖的模块名称是：" + module1.getName());
});