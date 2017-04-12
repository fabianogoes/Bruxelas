/**
 * App Bruxelas 
 * v0.0.1
 */
var appbruxelas = angular.module('appbruxelas', ['ngRoute','ui.bootstrap']); 
  
appbruxelas.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {

			$routeProvider
				.when('/', { templateUrl:'home.html'})             
				.when('/profile', { templateUrl:'talker/form-talker.html'});              
 
}]);  	

appbruxelas.config(['$locationProvider', function($locationProvider) {
	  $locationProvider.hashPrefix('');
}]);