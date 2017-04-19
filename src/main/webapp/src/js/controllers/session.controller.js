appbruxelas.controller('SessionController', ['$scope', 'SessionService', function($scope, SessionService) {

    var self  = this;

    self.init = function() {
        SessionService.getSession().then(function(resp) {
        	console.log(resp); 
            self.userLogged = resp.data;
            $scope.userLogged = self.userLogged;
            if(!self.userLogged || self.userLogged == "null")
            	window.location.href = '/bruxelas/user/login';
        }, function(error) {
            alert(error.data);
        });
    }

    self.init();

}]);