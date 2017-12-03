app.controller('testController', ["$http"], function($scope) {
    $scope.headingTitle = "Test";
    console.log("TEST CONTROLLER");
    $scope.value = $http.get("http://localhost:8080/v1/test");
});