app.controller('sofaDetailedController', ["$http", "$scope", "$window", "$location",
    function ($http, $scope, $window, $location) {
        $scope.sofaId = $location.path().split(/[\s/]+/).pop();
        $scope.path = "be/sofa/" + $scope.sofaId;
        $http.get($scope.path).then(function (response) {
            $scope.sofa =  response.data;
        });

        $scope.userAuthentificated = false;

        $http.get("be/user/currentUser").then(function (response) {
            $scope.userAuthentificated = true;
        }).catch(function (response) {});

        $scope.buy = function () {
            return $http.post("be/user/buy", {idFurniture:$scope.sofa.id, category:'sofa'}).then(function () {

                alert("OK");
            });
        }
    }
]);