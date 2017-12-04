app.controller('loginController', ["$http", "$scope", "$location",
    function ($http, $scope, $location) {
        $scope.username = undefined;
        $scope.password = undefined;
        $scope.canProceed = true;
        
        $scope.login = function () {
            return $http.post("be/user/login", {email:$scope.username, hashPassword:$scope.password}).then(function () {
                $location.path("/")
            }).catch(function () {
                $scope.canProceed = false;
            })
        }
    }]);
