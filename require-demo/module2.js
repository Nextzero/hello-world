define(['subdir/module3'], function(module3, factory) {
    'use strict';
    console.log("这里是module2, 我依赖的模块名称是：" + module3.getName());
    
    return {
        getName:function(){
            return "module2";
        }
    }
});