var app = angular.module("geektic", ['ngRoute']);


app.config(function($routeProvider){
    <!-- on indique quel controleur utiliser pour chaque chemin url-->
    $routeProvider
        .when('/', {
            templateUrl: '/views/accueil.html',
            controller: 'HelloCtrl'
        })

});



<!-- ON CREE UN CONTROLEUR PAR VUES-->

app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});
