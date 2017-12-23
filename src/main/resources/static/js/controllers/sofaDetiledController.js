app.controller('sofaDetailedController', ["$http", "$scope", "$window", "$location",
    function ($http, $scope, $window, $location) {
        $scope.sofaId = $location.path().split(/[\s/]+/).pop();
        $scope.path = "be/sofa/" + $scope.sofaId;
        $http.get($scope.path).then(function (response) {
            $scope.sofa =  response.data;
        });

        $scope.userAuthentificated = false;
        $scope.userAlreadyBoughtThisItem = false;



        $http.get("be/user/currentUser").then(function (response) {
            $scope.userAuthentificated = true;
            $http.get("be/user/review/sofa/"+$scope.sofaId).then(function (response) {
                $scope.userAlreadyBoughtThisItem = response.data;
                console.log($scope.userAlreadyBoughtThisItem);
            })
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

        $scope.submitRates = function () {
          console.log($scope.generalProductQuality);
          console.log($scope.expectedAndRealQuality);
          console.log($scope.recommendThisProduct);
          console.log($scope.deliverySpeed);
          $http.post("be/sofa/rate/submit",
              {
                  sofaId:$scope.sofaId,
                  generalProductQuality:$scope.generalProductQuality,
                  expectedAndRealQuality:$scope.expectedAndRealQuality,
                  recommendThisProduct:$scope.recommendThisProduct,
                  deliverySpeed:$scope.deliverySpeed

              }).then(function () {
              alert("Rate submitted!");
          })
        };

        $scope.feedbacks = [];

        $http.get("be/sofa/feedback/" + $scope.sofaId).then(function (response) {
            $scope.feedbacks = response.data;
        })

    }
]);