appbruxelas.factory('VersionService', ['$http', function($http) {

    var _findActualVersion = function(userId) {
        return $http.get('/bruxelas/api/version');
    }

    return {
 
    	findActualVersion : _findActualVersion 

    }

}]);