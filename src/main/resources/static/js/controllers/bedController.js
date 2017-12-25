app.controller('bedController', ["$http", "$scope", "$window",
    function ($http, $scope, $window) {
        $scope.beds = $http.get("be/bed/all").then(function (response) {
            return response.data;
        });

            $http.get("be/user/currentUser").then(function (response) {
                $scope.userAuthentificated = true;
                $http.post("be/user/userSettings",
                    {currentPage:"/home/bed"})

            }).catch(function (response) {});
    }]);
