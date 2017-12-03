var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/fe/test',{
            templateUrl: '../views/test.html',
            controller: 'testController'
        })
        .otherwise(
            {
                redirectTo: '/'
            }
        );
}).controller("MainController", ['$scope','$http', function($scope, $http){

    $http.get("http://localhost:8080/be/test/unauthenticated").then(function (response) {
        console.log("Test response");
        console.log(response);
        $scope.value = response;
    })
}]);