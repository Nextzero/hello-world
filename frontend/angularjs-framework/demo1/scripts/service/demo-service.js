require(['app'], function(app){
    var demoServiceFactory = function($http){
        
        return {

        }
    }

    app.factory('demoService', ['$http', demoServiceFactory]);
});