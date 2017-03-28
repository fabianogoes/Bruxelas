appbruxelas.factory('SessionService', ['$http', function($http) {

    var _getSession = function() {
        return $http.get('http://127.0.0.1:8081/http/user-session.json');
    }

    return {

        getSession : _getSession

    }

}]);