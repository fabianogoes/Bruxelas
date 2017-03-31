appbruxelas.controller('HomeController', ['ConnectionService', 'VersionService', function(ConnectionService, VersionService) {

    var self = this;

    self.init = function() {
        self.findConnectionsByUser(1);        
        self.findActualVersion();
    }

    self.findConnectionsByUser = function(userId) {
        ConnectionService.findByUser(userId).then(function(resp) {
            self.connections = resp.data;
        }, function(error) {
            console.log(error);
        });
    }

    self.findActualVersion = function() {
    	VersionService.findActualVersion().then(function(resp) {
    		self.version = resp.data;
    		console.log(self.version);
    	}, function(error) {
    		console.log(error);
    	});
    }

    self.init();

}]);