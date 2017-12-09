app.controller('bedController', ["$http", "$scope", "$window",
    function ($http, $scope, $window) {
        $scope.beds = $http.get("be/bed/all").then(function (response) {
            return response.data;
        });
    }]);
