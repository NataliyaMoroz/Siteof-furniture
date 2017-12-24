app.controller('sofaController', ["$http", "$scope", "$window",
    function ($http, $scope, $window) {
        $scope.sofas = [];
        $http.get("be/sofa/all")
            .then(function (response) {
                $scope.sofas =  response.data;
            });
        $scope.sofas = [];
        $http.get("be/user/currentUser").then(function (response) {
            $scope.userAuthentificated = true;
            $http.get("be/user/userSettings").then(function (response) {
                if(response!==null) {
                    if (response.data.currentPage !== "/home/sofa") {
                        $window.location.href = response.data.currentPage;
                    }
                    $scope.armrestOptions = response.data.armrest;
                    $scope.siteFilter()
                }

            });

        }).catch(function (response) {});



        $("input[type='checkbox']").click(function(){
            $scope.siteFilter();
        });

        $("input[type='text']").click(function(){
            $scope.siteFilter();
        });

        $scope.siteFilter = function () {

            $scope.saveUserSettings();
            console.log($scope.priceFrom);
            console.log($scope.priceTo);
            console.log($scope.armrestOptions);
            console.log($scope.brandIKEA);
            console.log($scope.brandSkySoft);
            console.log($scope.brandLaretto);
            console.log($scope.brandDivanPlus);
            console.log($scope.brandSofyno);

            $scope.sofas = [];
            var priceFromPath = "";
            var priceToPath = "";
            var brandPath = "";
            var armrestPath = "";
            var fullPath = "";
            if($scope.priceFrom != undefined) {
                priceFromPath = "priceFrom=" + $scope.priceFrom;
            }
            if($scope.priceTo != undefined) {
                priceToPath = "priceTo=" + $scope.priceTo;
            }
            if($scope.brandIKEA == true) {
                if(brandPath != "") {
                    brandPath += "," + "IKEA";
                }
                else {
                    brandPath = "brand=" + "IKEA";
                }
            }
            if($scope.brandSkySoft == true) {
                if(brandPath != "") {
                    brandPath += "," + "SkySoft";
                }
                else {
                    brandPath = "brand=" + "SkySoft";
                }
            }
            if($scope.brandLaretto == true) {
                if(brandPath != "") {
                    brandPath += "," + "Laretto";
                }
                else {
                    brandPath = "brand=" + "Laretto";
                }
            }
            if($scope.brandDivanPlus == true) {
                if(brandPath != "") {
                    brandPath += "," + "DivanPlus";
                }
                else {
                    brandPath = "brand=" + "DivanPlus";
                }
            }
            if($scope.brandSofyno == true) {
                if(brandPath != "") {
                    brandPath += "," + $scope.brandSofyno;
                }
                else {
                    brandPath = "brand=" + $scope.brandSofyno;
                }
            }
            if($scope.armrestOptions != undefined || $scope.armrestOptions != all) {
                armrestPath = "armrest=" + $scope.armrestOptions;
            }

            if (priceFromPath != "") {
                if (fullPath != "") {
                    fullPath += "&" + priceFromPath;
                }
                else {
                    fullPath = priceFromPath;
                }
            }
            if (priceToPath != "") {
                if (fullPath != "") {
                    fullPath += "&" + priceToPath;
                }
                else {
                    fullPath = priceToPath;
                }
            }
            if (brandPath != "") {
                if (fullPath != "") {
                    fullPath += "&" + brandPath;
                }
                else {
                    fullPath = brandPath;
                }
            }
            if (armrestPath != "") {
                if (fullPath != "") {
                    fullPath += "&" + armrestPath;
                }
                else {
                    fullPath = armrestPath;
                }
            }
            console.log(priceFromPath);
            console.log(priceToPath);
            console.log(armrestPath);
            console.log(brandPath);
            console.log(fullPath);
            $http.get("be/sofa/all?" + fullPath)
                .then(function (response) {
                    $scope.sofas =  response.data;
                });
        };


        $scope.loadUserSettings = function () {
            $http.get("be/user/currentUser").then(function (response) {
                $scope.userAuthentificated = true;
                $http.get("be/user/userSettings").then(function (response) {
                    if(response!==null)
                        $scope.armrestOptions = response.data.armrest;
                })
            }).catch(function (response) {});
        };

        $scope.saveUserSettings = function () {
            $http.get("be/user/currentUser").then(function (response) {
                $scope.userAuthentificated = true;
                $http.post("be/user/userSettings",
                    {armrest:$scope.armrestOptions, furnitureCategory:"sofa", currentPage:"/home/sofa"})

            }).catch(function (response) {});
        }
    }]);