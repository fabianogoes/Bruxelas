appbruxelas.factory('ConnectionService', ['$http', function($http) {

    var _findByUser = function(userId) {
        return $http.get('http/connections-by-user.json');
    }

    return {

        findByUser : _findByUser 

    }

}]);