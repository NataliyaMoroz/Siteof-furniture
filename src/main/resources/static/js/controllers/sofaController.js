app.controller('sofaController', ["$http", "$scope", "$window",
    function ($http, $scope, $window) {
        $scope.sofas = [];
        $http.get("be/sofa/all").then(function (response) {
            $scope.sofas =  response.data;
        });
    }]);
