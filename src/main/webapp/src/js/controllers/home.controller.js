appbruxelas.controller('HomeController', ['ConnectionService', function(ConnectionService) {

    var self = this;

    self.init = function() {
        self.findConnectionsByUser(1);
    }

    self.findConnectionsByUser = function(userId) {
        ConnectionService.findByUser(userId).then(function(resp) {
            self.connections = resp.data;
        }, function(error) {
            console.log(error);
        });
    }

    self.init();

}]);