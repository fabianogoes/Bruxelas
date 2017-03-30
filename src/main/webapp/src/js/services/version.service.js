appbruxelas.factory('VersionService', ['$http', function($http) {

    var _findActualVersion = function(userId) {
        return $http.get('http://localhost:8080/bruxelas/api/version');
    }

    return {

    	findActualVersion : _findActualVersion 

    }

}]);