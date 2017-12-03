var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/test',{
            templateUrl: '../views/test.html',
            controller: 'testController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});