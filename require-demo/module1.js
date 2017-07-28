define(['module2'], function(module2, factory) {
    'use strict';
    console.log("这里是module1, 我依赖的模块名称是：" + module2.getName());
    return {
        getName:function(){
            return "module1";
        }
    }
});