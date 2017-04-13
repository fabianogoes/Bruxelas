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
appbruxelas.factory('TalkerService', ['$http', function($http) {

    var _findCountries = function() {
        return $http.get('/bruxelas/api/talker/countries');
    }

    var _findLanguages = function() {
        return $http.get('/bruxelas/api/talker/languages');
    }

    var _addLanguageSpeak = function(languageSpeak) {
    	return $http.post('/bruxelas/api/talker/languagelearn', languageSpeak);
    }
    
    var _save = function(talker) {
    	return $http.post('/bruxelas/api/talker', talker);
    }
    
    return {

        findCountries : _findCountries,

        findLanguages : _findLanguages,
        
        addLanguageSpeak : _addLanguageSpeak,

        save : _save

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
appbruxelas.controller('TalkerCRUDController', ['TalkerService', function(TalkerService) {

    var self = this;
    
    self.openedBirthDate = true;
    
	self.dateOptions = {
	    formatYear: 'yy',
	    maxDate: new Date(2020, 5, 22),
	    minDate: new Date(),
	    startingDay: 1
	};	
	
	self.open = function() {
	   self.openedBirthDate = !self.openedBirthDate;
	   console.log(self.openedBirthDate);
	};
		
    self.init = function() {
    	// Born
		self.findCountiresBorn();
    	// Live in
		self.findCountriesLiving();
    	// Languages
    	self.findLanguages();
    }
    
	self.findCountiresBorn = function() {
    	TalkerService.findCountries().then(function(resp) {
    		self.countriesBorn = resp.data;
    		console.log(self.countriesBorn);
    	}, function(error) {
    		console.log(error);  
    	});
	}

	self.findCountriesLiving = function() {
    	TalkerService.findCountries().then(function(resp) {
    	// Live in
    		self.countriesLiving = resp.data;
    	}, function(error) {
    		console.log(error);  
    	});    	
	}

	self.findLanguages = function() {
		TalkerService.findLanguages().then(function(resp) {
    	// Languages
    		self.languages = resp.data;
    	}, function(error) {
    		console.log(error);  
    	});    	
	}

    self.languagesSpeak = [{}];
    
    self.addLanguage = function(languageSpeak){ 
    	if(self.languagesSpeak.lenght >= 7){
    		return;
    	}
    	languageSpeak.talker = self.talker;
    	console.log(languageSpeak);
    	TalkerService.addLanguageSpeak(languageSpeak).then(function(resp) {
    		self.languagesSpeak.push(resp.data); 
    	}, function(error) {
    		alert(error.data);
    	})
    }
    
    self.popLanguages = function(i){
    	self.languagesSpeak.splice(i, 1);
    }
    
    self.save = function(talker) {
    	console.log(JSON.stringify(talker));
    	//var _t = {"name":"Diego", "birthDate": "19/12/1986"}; // {"name":"Diego", "birthDate": "19/12/1986", "nacionality": {"id": 1}, "livingIn": {"id": 1}, "nativeLanguage": {"id": 1}}
    	TalkerService.save(talker).then(function(resp) {
    		self.talker = resp.data;
    		alert('Talker sucessfully saved');
    	}, function(error) {
    		alert(error.data);
    	});
    	
    }
    
    self.init();
    
}]);