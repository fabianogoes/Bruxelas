/**
 * App Bruxelas 
 * v0.0.1
 */
var appbruxelas = angular.module('appbruxelas', ['ngRoute']); 
  
appbruxelas.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {

			$routeProvider
				.when('/', { templateUrl:'home.html'});             
 
}]);  
appbruxelas.factory('SessionService', ['$http', function($http) {

    var _getSession = function() {
        return $http.get('http://127.0.0.1:8081/http/user-session.json');
    }

    return {

        getSession : _getSession

    }

}]);
appbruxelas.controller('HomeController', ['$http', function($http) {

    var self = this;

    self.init = function() {
        self.findConnectionsByUser(1);
    }

    self.findConnectionsByUser = function(userId) {
        $http.get('http://127.0.0.1:8081/http/connections-by-user.json').then(function(resp) {
            self.connections = resp.data;
        }, function(error) {
            console.log(error);
        });
    }

    self.init();

}]);
appbruxelas.controller('SessionController', ['SessionService', function(SessionService) {

    var self  = this;

    self.init = function() {
        SessionService.getSession().then(function(resp) {
            self.userLogged = resp.data;
        }, function(error) {
            alert(error.data);
        });
    }

    self.init();

}]);