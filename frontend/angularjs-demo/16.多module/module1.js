var app = angular.module('module1', []);
app.controller('myController', function ($scope, $cookies, $http) {
    console.log("module1.myConftroler factory")
});

app.service('myService', function(){
    return {
        name: 'huangchao'
    }
})
