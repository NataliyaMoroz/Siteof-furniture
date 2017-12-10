app.controller('sofaDetailedController', ["$http", "$scope", "$window", "sofaService",
    function ($http, $scope, $window, sofaService) {
        $scope.sofaId = sofaService.sofaId;
        $scope.path = "be/sofa/" + $scope.sofaId;
        $http.get($scope.path).then(function (response) {
            $scope.sofa =  response.data;
        });
    }
]);