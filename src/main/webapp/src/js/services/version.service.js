appbruxelas.factory('VersionService', ['$http', function($http) {

    var _findActualVersion = function(userId) {
        return $http.get('http://bruxelas-fabianoggoes.rhcloud.com/api/version');
    }

    return {

    	findActualVersion : _findActualVersion 

    }

}]);