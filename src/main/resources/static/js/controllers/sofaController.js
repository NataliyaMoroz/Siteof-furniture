app.controller('sofaController', ["$http", "$scope", "$window", "sofaService",
    function ($http, $scope, $window, sofaService) {
        $scope.sofas = [];
        $http.get("be/sofa/all").then(function (response) {
            $scope.sofas =  response.data;
        });

        $scope.saveSofaId = function ($sofaId) {
            sofaService.sofaId = $sofaId;
        }

    }]);
