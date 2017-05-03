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
//    	talker.birthDate = $filter('date')(talker.birthDate, "dd/MM/yyyy");
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