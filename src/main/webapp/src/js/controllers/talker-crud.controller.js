appbruxelas.controller('TalkerCRUDController', ['TalkerService', function(TalkerService) {

    var self = this;

    self.init = function() {
    	// Born
<<<<<<< HEAD
		self.findCountiresBorn();
    	// Live in
		self.findCountriesLiving();
    	// Languages
    	self.findLanguages();

    }
    
	self.findCountiresBorn = function() {
    	TalkerService.findCountries().then(function(resp) {
=======
    	$http.get('/api/talker/countries').then(function(resp) {
>>>>>>> cc7ea8dc924da973ae1084d678292a5b0bdae746
    		self.countriesBorn = resp.data;
    		console.log(self.countriesBorn);
    	}, function(error) {
    		console.log(error);  
    	});
<<<<<<< HEAD
	}

	self.findCountriesLiving = function() {
    	TalkerService.findCountries().then(function(resp) {
=======
    	// Live in
    	$http.get('/api/talker/countries').then(function(resp) {
>>>>>>> cc7ea8dc924da973ae1084d678292a5b0bdae746
    		self.countriesLiving = resp.data;
    	}, function(error) {
    		console.log(error);  
    	});    	
<<<<<<< HEAD
	}

	self.findLanguages = function() {
		TalkerService.findLanguages().then(function(resp) {
=======
    	// Languages
    	$http.get('/api/talker/languages').then(function(resp) {
>>>>>>> cc7ea8dc924da973ae1084d678292a5b0bdae746
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