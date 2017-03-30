appbruxelas.factory('VersionService', ['$http', function($http) {

    var _findActualVersion = function(userId) {
        return $http.get('/api/version');
    }

    return {

    	findActualVersion : _findActualVersion 

    }

}]);