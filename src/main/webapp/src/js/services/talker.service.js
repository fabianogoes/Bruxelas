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