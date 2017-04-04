/**
 * App Bruxelas 
 * v0.0.1
 */
var appbruxelas = angular.module('appbruxelas', ['ngRoute']); 
  
appbruxelas.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {

			$routeProvider
				.when('/', { templateUrl:'home.html'})             
				.when('/profile', { templateUrl:'talker/form-talker.html'});              
 
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
appbruxelas.factory('VersionService', ['$http', function($http) {

    var _findActualVersion = function(userId) {
        return $http.get('/bruxelas/api/version');
    }

    return {
 
    	findActualVersion : _findActualVersion 

    }

}]);
appbruxelas.controller('HomeController', ['ConnectionService', 'VersionService', function(ConnectionService, VersionService) {

    var self = this;

    self.init = function() {
        self.findConnectionsByUser(1);        
        self.findActualVersion();
    }

    self.findConnectionsByUser = function(userId) {
        ConnectionService.findByUser(userId).then(function(resp) {
            self.connections = resp.data;
        }, function(error) {
            console.log(error);
        });
    }

    self.findActualVersion = function() {
    	VersionService.findActualVersion().then(function(resp) {
    		self.version = resp.data;
    		console.log(self.version);
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

    self.init = function() {
    	// Born
    	$http.get('/bruxelas/api/talker/countries').then(function(resp) {
    		self.countriesBorn = resp.data;
    		console.log(self.countriesBorn);
    	}, function(error) {
    		console.log(error);  
    	});
    	// Live in
    	$http.get('/bruxelas/api/talker/countries').then(function(resp) {
    		self.countriesLiving = resp.data;
    	}, function(error) {
    		console.log(error);  
    	});    	
    	// Languages
    	$http.get('/bruxelas/api/talker/languages').then(function(resp) {
    		self.languages = resp.data;
    	}, function(error) {
    		console.log(error);  
    	});    	

    }
    
//    self.languages = [{}];
//    
//    self.addLanguage = function(){ 
//    	if(self.languages.lenght >= 7){
//    		return;
//    	}
//    	self.languages.push(new Object()); 
//    }
//    
//    self.popLanguages = function(i){
//    	self.languages.splice(i, 1);
//    }
    
    self.save = function(talker) {
    	console.log(JSON.stringify(talker));
    	//var _t = {"name":"Diego", "birthDate": "19/12/1986"}; // {"name":"Diego", "birthDate": "19/12/1986", "nacionality": {"id": 1}, "livingIn": {"id": 1}, "nativeLanguage": {"id": 1}}
    	$http.post('/bruxelas/api/talker', talker).then(function(resp) {
    		self.talker = resp.data;
    		alert('Talker sucessfully saved');
    	}, function(error) {
    		alert(error.data);
    	});
    }
    
    self.init();
    
}]);