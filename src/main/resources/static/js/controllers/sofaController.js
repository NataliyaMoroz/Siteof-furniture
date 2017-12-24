app.controller('sofaController', ["$http", "$scope", "$window",
    function ($http, $scope, $window) {
        $scope.sofas = [];
        $http.get("be/sofa/all")
            .then(function (response) {
                $scope.sofas =  response.data;
            });
        $scope.sofas = [];

        $scope.siteFilter = function ($http, $scope, $window) {
            console.log($scope.priceFrom);
            console.log($scope.priceTo);
            console.log($scope.armrest);
            console.log($scope.brandIKEA);
            console.log($scope.brandSkySoft);
            console.log($scope.brandLaretto);
            console.log($scope.brandDivanPlus);
            console.log($scope.brandSofyno);

            $scope.sofas = [];
            $http.get("be/sofa/all?priceFrom" + $scope.priceFrom + "?priceTo" +$scope.priceTo
                + "?brand" + $scope.brandIKEA + "," + $scope.brandSkySoft + "," + $scope.brandLaretto + ","
                + $scope.brandDivanPlus + "," + $scope.brandSofyno + "?armrest" + $scope.armrest)
                .then(function (response) {
                    $scope.sofas =  response.data;
                });
        }

        $("input[type='checkbox']").click(function(){
            siteFilter();
        });

        $("input[type='text']").click(function(){
            siteFilter();
        });
    }]);