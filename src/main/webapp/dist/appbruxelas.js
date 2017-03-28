/**
 * App Bruxelas 
 * v0.0.1
 */
var appbruxelas = angular.module('appbruxelas', ['ngRoute']); 
  
appbruxelas.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {

			$routeProvider
				.when('/', { templateUrl:'home.html'});             
 
}]);  
appbruxelas.controller('HomeController', ['$http', function($http) {

    var self = this;

    self.init = function() {
        self.findConnectionsByUser(1);
    }

    self.findConnectionsByUser = function(userId) {
        $http.get('http/connections-by-user.json').then(function(resp) {
            self.connections = resp.data;
        }, function(error) {
            console.log(error);
        });
    }

    self.init();

}]);
appbruxelas.controller('SessionController', ['$http', function($http) {

    var self  = this;

    self.user = {};
    self.user.firstname = 'Diego';
    self.user.fullname = 'Diego Lirio Damacena Pereira';
    self.user.nacionality = 'Brazil';


}]);