appbruxelas.controller('HomeController', ['$http', function($http) {

    var self = this;

    self.init = function() {
        self.findConnectionsByUser(1);
    }

    self.findConnectionsByUser = function(userId) {
        $http.get('http://127.0.0.1:8081/http/connections-by-user.json').then(function(resp) {
            self.connections = resp.data;
        }, function(error) {
            console.log(error);
        });
    }

    self.init();

}]);