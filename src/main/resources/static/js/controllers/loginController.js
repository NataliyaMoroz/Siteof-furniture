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
        };

        $scope.signup = function () {
            return $http.post("be/user/registration",
                {
                    email:$scope.username,
                    hashPassword:$scope.password,
                    name:$scope.fullName ,
                    region:$scope.region
                }).then(function () {
                $window.location.href = '/';
            }).catch(function () {
                $scope.canProceed = false;
            })
        }
    }]);
