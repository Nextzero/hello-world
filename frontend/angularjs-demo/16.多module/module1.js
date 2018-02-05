var app = angular.module('module1', []);
app.controller('myController', function ($scope, $cookies, $http) {
    console.log("module1.myConftroler factory")
});

app.service('myService', function(){
    return {
        name: 'huangchao'
    }
})

app.directive('myHello', function($http){
    //自定义一个指令
    //该函数为工厂函数，需要返回一个对象，对象包含指令的描述信息
    //该函数支持注入(这里并不需要$http服务，只是用来展示'支持注入')
    return {
        restrict: 'EA',
        //可以在template中指定模板内容，也可以使用templateUrl引用一个外部的html文件
        template: '<a href="http://google.com">Click me to go to Google</a>'
    };
});
