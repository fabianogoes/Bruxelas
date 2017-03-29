/**
 * App Bruxelas 
 * v0.0.1
 */
var appbruxelas = angular.module('appbruxelas', ['ngRoute']); 
  
appbruxelas.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {

			$routeProvider
				.when('/', { templateUrl:'home.html'})             
				.when('/profile', { templateUrl:'form-talker.html'});             
 
}]);  	
appbruxelas.factory('ConnectionService', ['$http', function($http) {

    var _findByUser = function(userId) {
        return $http.get('http/connections-by-user.json');
    }

    return {

        findByUser : _findByUser 

    }

}]);
appbruxelas.factory('SessionService', ['$http', function($http) {

    var _getSession = function() {
        return $http.get('http/user-session.json');
    }

    return {

        getSession : _getSession

    }

}]);
appbruxelas.controller('HomeController', ['ConnectionService', function(ConnectionService) {

    var self = this;

    self.init = function() {
        self.findConnectionsByUser(1);
    }

    self.findConnectionsByUser = function(userId) {
        ConnectionService.findByUser(userId).then(function(resp) {
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
appbruxelas.controller('TalkerCRUDController', ['$http', function($http) {

    var self = this;

    self.languages = [{}];
    
    self.addLanguage = function(){
    	if(self.languages.lenght >= 7){
    		return;
    	}
    	self.languages.push(new Object());
    }
    
    self.popLanguages = function(i){
    	self.languages.splice(i, 1);
    }
}]);