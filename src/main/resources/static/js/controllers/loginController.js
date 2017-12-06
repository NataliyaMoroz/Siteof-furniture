app.controller('loginController', ["$http", "$scope", "$window",
    function ($http, $scope, $window) {
        $scope.username = undefined;
        $scope.password = undefined;
        $scope.canProceed = true;
        
        $scope.login = function () {
            return $http.post("be/user/login", {email:$scope.username, hashPassword:$scope.password}).then(function () {
                $window.location.href = '/';
            }).catch(function () {
                $scope.canProceed = false;
            })
        }
    }]);
