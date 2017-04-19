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
    
    return {

        findCountries : _findCountries,

        findLanguages : _findLanguages,
        
        findLanguagesYouSpeakByTalkerId : _findLanguagesYouSpeakByTalkerId,
        
        addLanguageSpeak : _addLanguageSpeak,

        removeLanguageSpeak : _removeLanguageSpeak,

        save : _save

    }

}]);