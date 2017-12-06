var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/login', {
            templateUrl: '../views/login.html',
            controller: 'loginController'
        })
        .when('/home/bed', {
            templateUrl: '../views/bed.html',
            controller: 'bedController'
        })
        .when('/home/sofa', {
            templateUrl: '../views/sofa.html',
            controller: 'sofaController'
        })
        .when('/home/mattress', {
            templateUrl: '../views/mattress.html',
            controller: 'mattressController'
        })
        .when('/home', {
            templateUrl: '../views/home.html',
            controller: 'homeController'
        })
        .otherwise(
            {
                redirectTo: '/'
            }
        );
}).controller("MainController", ['$scope','$http', '$window', function($scope, $http, $window){
    $scope.user = undefined;
    $scope.showUser = false;

    $http.get("be/user/currentUser").then(function (response) {
        $scope.user = response.data;
        $scope.showUser = true;
    }).catch(function (response) {})
}]);