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
                alert("You did it!");
            });
        };

        $scope.submitFeedback = function () {
            $http.post("be/sofa/feedback/insert", {sofaId:$scope.sofaId, description:$scope.feedbackText}).then(function () {
                alert("Review submitted!");
            });
        };

        $scope.feedbacks = [];

        $http.get("be/sofa/feedback/" + $scope.sofaId).then(function (response) {
            $scope.feedbacks = response.data;
        })

    }
]);