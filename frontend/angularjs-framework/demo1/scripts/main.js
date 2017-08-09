'use strict';
require.config({
    baseUrl: "scripts"
});

require([
    "app",
    "service/demo-service"
], function(){
    angular.bootstrap(document,["demoApp"])
});