/**
 * App Bruxelas 
 * v0.0.1
 */
var appbruxelas = angular.module('appbruxelas', []); 
appbruxelas.controller('SessionController', ['$http', function($http) {

    var self  = this;

    self.usuario = {};
    self.usuario.nome = 'Diego Lirio';


}]);