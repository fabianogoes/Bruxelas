appbruxelas.factory('SessionService', ['$http', function($http) {

    var _getSession = function() {
        //return $http.get('http/user-session.json');
    	return $http.get('/bruxelas/api/user/getsession');
    }

    return {

        getSession : _getSession

    }

}]);