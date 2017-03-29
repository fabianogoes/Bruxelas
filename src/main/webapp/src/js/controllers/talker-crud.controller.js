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