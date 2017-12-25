/**
 * Created by Наталия on 25.12.2017.
 */
app.controller('mattressController', ["$http", "$scope", "$window",
    function ($http, $scope, $window) {
        $scope.beds = $http.get("be/bed/all").then(function (response) {
            return response.data;
        });

        $http.get("be/user/currentUser").then(function (response) {
            $scope.userAuthentificated = true;
            $http.post("be/user/userSettings",
                {currentPage:"/home/mattress"})

        }).catch(function (response) {});
    }]);