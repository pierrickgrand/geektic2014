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

        .when('/GeeksById/:id', {
            templateUrl: '/views/LeGeek.html',
            controller: 'LeGeek'
        })

        .when('/Geeks/:sexe', {
            templateUrl: '/views/GetLesGeeksBySex.html',
            controller: 'Geeks'
        })

        .when('/Interets/:interet', {
            templateUrl: '/views/getGeeksByInteret.html',
            controller: 'Interets'
        })

});




app.controller('SearchController', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

app.controller('LeGeek', function($scope, $http, $routeParams) {
    $http({
        url: '/Geeks/' +$routeParams.id,
        method: 'GET'
    }).success(function(geekToShow) {
        $scope.LeGeek = geekToShow;
    });
})

app.controller('AllGeeks', function($scope, $http) {
    $http.get('/Geeks').success(function(Geeks) {
        $scope.Geeks = Geeks;
    });
    $http.get('/Interets').success(function(Interets) {
        $scope.Interets = Interets;
    });
});



app.controller('Geeks', function($scope, $http, $routeParams) {
    $http.get('/Geeks' ,{params:{sexe:$routeParams.sexe}} ).success(function(Geeks) {
        $scope.Geeks = Geeks;
    });
    //$http.get('/Interets').success(function(Interets) {
    //    $scope.Interets = Interets;
    //});
});

app.controller('Interets', function($scope, $http, $routeParams) {
    $http.get('/Geeks' ,{params:{interet:$routeParams.interet}} ).success(function(Geeks) {
        $scope.Geeks = Geeks;
    });

});