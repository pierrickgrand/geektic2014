var app = angular.module("geektic", ['ngRoute']);


app.config(function($routeProvider){

    $routeProvider
        .when('/', {
            templateUrl: '/views/accueil.html',
            controller: 'SearchController'
        })

        .when('/Geeks', {
            templateUrl: '/views/GetLesGeeks.html',
            controller: 'AllGeeks'
        })

});




app.controller('SearchController', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

app.controller('AllGeeks', function($scope, $http) {
    $http.get('/Geeks').success(function(Geeks) {
        $scope.Geeks = Geeks;
    });
    $http.get('/Interets').success(function(Interets) {
        $scope.Interets = Interets;
    });
});
