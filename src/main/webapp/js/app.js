var app = angular.module("geektic", ['ngRoute']);


app.config(function($routeProvider){

    $routeProvider
        .when('/', {                                //si on est à la racinedu site
            templateUrl: '/views/accueil.html',     // on affiche la vue du moteur de recherche
            controller: 'SearchController'          // on utilise le controleur pour effectuer une recherche
        })

        .when('/Geeks', {                           //si on se trouve à la page /Geeks
            templateUrl: '/views/GetLesGeeks.html', // on affiche la vue permetant de lister tous les geeks
            controller: 'AllGeeks'                  // on utilise le controleur pour afficher tous les geeks sans distinction
        })

        .when('/GeeksById/:id', {                   //si on se trouve à la page /GeeksById/ , on recupère l'id d'un geek
            templateUrl: '/views/LeGeek.html',      //on affiche la vue permetant d'afficher les infos d'un geek
            controller: 'LeGeek'                    //on utilise le controleur LeGeek pour recuperer les infos du geek
        })

        .when('/Geeks/:sexe', {                             //si on se trouve à la page /Geeks/ on recupère le parametre sexe
            templateUrl: '/views/GetLesGeeksBySex.html',    //on affiche la vue permetant de lister les geeks d'un même sexe
            controller: 'Geeks'                             //on utilise le controleur Geeks pour récuperer la liste de geeks
        })

        .when('/Interets/:interet', {                       //si on se trouve à la page /Interets/ on recupère le parametre :interet
            templateUrl: '/views/getGeeksByInteret.html',   //on affiche la vue permetant d'afficher une liste de geeks partageant un même interet
            controller: 'Interets'                          // on utilise le contrôleur interet pour recuperer la liste de geeks
        })

});


// controleur pour effectuer une recherche ( ne fait qu'afficher un message = EXEMPLE )

app.controller('SearchController', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

// controleur pour l'affichage d'un geek particulier

app.controller('LeGeek', function($scope, $http, $routeParams) {
    $http({
        url: '/Geeks/' +$routeParams.id,
        method: 'GET'
    }).success(function(geekToShow) {
        $scope.LeGeek = geekToShow;
    });
})

// controleur pour l'affichage de tous les geeks

app.controller('AllGeeks', function($scope, $http) {
    $http.get('/Geeks').success(function(Geeks) {
        $scope.Geeks = Geeks;
    });
});

// controleur pour l'affichage de geeks par sexe

app.controller('Geeks', function($scope, $http, $routeParams) {
    $http.get('/Geeks' ,{params:{sexe:$routeParams.sexe}} ).success(function(Geeks) {
        $scope.Geeks = Geeks;
    });
});

// controleur pour l'affichage de geeks par interet

app.controller('Interets', function($scope, $http, $routeParams) {
    $http.get('/Geeks' ,{params:{interet:$routeParams.interet}} ).success(function(Geeks) {
        $scope.Geeks = Geeks;
    });

});