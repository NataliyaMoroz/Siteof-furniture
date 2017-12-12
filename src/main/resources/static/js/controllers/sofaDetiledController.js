app.controller('sofaDetailedController', ["$http", "$scope", "$window", "$location",
    function ($http, $scope, $window, $location) {
        $scope.sofaId = $location.path().split(/[\s/]+/).pop();
        $scope.path = "be/sofa/" + $scope.sofaId;
        $http.get($scope.path).then(function (response) {
            $scope.sofa =  response.data;
        });
    }
]);