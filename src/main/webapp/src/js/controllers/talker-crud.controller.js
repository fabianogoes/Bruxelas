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
    	// Languages_you_speak
    	var talker = {};
    	talker.id = 4;
    	self.findLanguagesYouSpeak(talker);
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
			// Languages
    		self.languagesSpeak = resp.data;
    		console.log(self.languagesSpeak);
    		self.languagesSpeak.push(new Object());    		
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
    		//self.languagesSpeak.push(resp.data);
    		self.findLanguagesYouSpeak(self.talker);    		
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