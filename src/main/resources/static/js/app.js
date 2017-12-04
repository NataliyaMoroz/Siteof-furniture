var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/login', {
            templateUrl: '../views/login.html',
            controller: 'loginController'
        })
        .otherwise(
            {
                redirectTo: '/'
            }
        );
}).controller("MainController", ['$scope','$http', '$window', function($scope, $http, $window){
    $http.get("be/user/currentUser").then(function (response) {
        console.log(response);
    }).catch(function (response) {
        $window.location.href = '/#!/login';
    })
}]);