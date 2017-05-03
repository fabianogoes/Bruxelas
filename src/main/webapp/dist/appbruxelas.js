/**
 * App Bruxelas 
 * v0.0.1
 */
var appbruxelas = angular.module('appbruxelas', ['ngRoute','ui.bootstrap']); 
  
appbruxelas.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {

			$routeProvider
				.when('/', { templateUrl:'home.html'})             
				.when('/profile', { templateUrl:'talker/form-talker.html'})              
				.when('/page', { templateUrl:'talker/talker-page.html'});              
 
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
        //return $http.get('http/user-session.json');
    	return $http.get('/bruxelas/api/user/getsession');
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

    var _findLanguagesYouSpeakByTalkerId = function(talkerId) {
    	return $http.get('/bruxelas/api/talker/languagesyouspeak/'+talkerId);
    }
    
    var _addLanguageSpeak = function(languageSpeak) {
    	return $http.post('/bruxelas/api/talker/languagelearn', languageSpeak);
    }
    
    var _removeLanguageSpeak = function(langaugeSpeak) {
    	return $http.post('/bruxelas/api/talker/languagelearn/delete/' + langaugeSpeak.id);
    }
    
    var _save = function(talker) {
    	return $http.post('/bruxelas/api/talker', talker);
    }
    
    var _findByUser = function(user) {
    	return $http.get('/bruxelas/api/talker/findbyuser/'+user.id);
    }
    
    return {

        findCountries : _findCountries,

        findLanguages : _findLanguages,
        
        findLanguagesYouSpeakByTalkerId : _findLanguagesYouSpeakByTalkerId,
        
        addLanguageSpeak : _addLanguageSpeak,

        save : _save,

        removeLanguageSpeak : _removeLanguageSpeak,

        findByUser : _findByUser
        
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
appbruxelas.controller('SessionController', ['$scope', 'SessionService', function($scope, SessionService) {

    var self  = this;

    self.init = function() {
        SessionService.getSession().then(function(resp) {
        	console.log(resp); 
            self.userLogged = resp.data;
            $scope.userLogged = self.userLogged;
            if(!self.userLogged || self.userLogged == "null")
            	window.location.href = '/bruxelas/user/login';
        }, function(error) {
            alert(error.data);
        });
    }

    self.init();

}]);
appbruxelas.controller('TalkerCRUDController', ['SessionService', 'TalkerService','$filter', '$scope', function(SessionService, TalkerService, $filter, $scope) {

    var self = this;
    
    self.openedBirthDate = false;
    
	self.dateOptions = {
	    formatYear: 'yy',
	    maxDate: new Date(2000, 1, 1),
	    minDate: new Date(1920, 1, 1),
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
    	// Languages_you_speak
    	
        SessionService.getSession().then(function(resp) {
        	self.findTalkerByUser(resp.data);
        }, function(error) {
            alert(error.data);
        });    	
    	
    }
    
    self.findTalkerByUser = function(user) {
    	TalkerService.findByUser(user).then(function(resp) {
    		self.talker = resp.data;
    		self.talker.birthDate = Date.parse(self.talker.birthDate);
    		self.findLanguagesYouSpeak(self.talker);
    	}, function(error) {
    		alert(error.data);
    	});
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
	
	self.findLanguagesYouSpeak = function(talker) {
		TalkerService.findLanguagesYouSpeakByTalkerId(talker.id).then(function(resp) {
    		self.languagesSpeak = resp.data;
    	}, function(error) {
    		console.log(error);  
    	});    	
	}	

    self.languagesSpeak = [{}];
    
    self.saveLanguage = function(languageSpeak){ 
    	languageSpeak.talker = {};
    	languageSpeak.talker.id = self.talker.id;
    	TalkerService.addLanguageSpeak(languageSpeak).then(function(resp) {
    		self.findLanguagesYouSpeak(self.talker);    		
    	}, function(error) {
    		alert(error.data);
    	})
    }
    
    self.addLanguage = function(languageSpeak){ 
    	if(self.languagesSpeak.lenght >= 7){
    		return;
    	}
    	self.languagesSpeak.push(new Object());
    }
    
    self.popLanguages = function(i, lang){
    	if(lang.id){
        	TalkerService.removeLanguageSpeak(lang).then(function(resp) {
        		self.findLanguagesYouSpeak(self.talker);    		
        	}, function(error) {
        		console.log(error.data);
        	})   		
    	}else{
    		self.languagesSpeak.splice(i, 1);
    	}
    }
    
    self.save = function(talker) {
    	talker.birthDate = $filter('date')(talker.birthDate, "dd/MM/yyyy");
    	console.log(JSON.stringify(talker));
    	//var _t = {"name":"Diego", "birthDate": "19/12/1986"}; // {"name":"Diego", "birthDate": "19/12/1986", "nacionality": {"id": 1}, "livingIn": {"id": 1}, "nativeLanguage": {"id": 1}}
    	TalkerService.save(talker).then(function(resp) {
    		self.talker = resp.data;
    		console.log(self.talker.birthDate);
    		self.talker.birthDate = new Date(self.talker.birthDate);
    		alert('Talker sucessfully saved');
    		self.addLanguage();
    	}, function(error) {
    		alert(error.data);
    	});
    }
    
    self.init();
    
}]);