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
                    console.log(response.data.brands);
                    var brands = response.data.brands;
                    $scope.armrestOptions = response.data.armrest;
                    $scope.priceFrom = response.data.priceFrom;
                    $scope.priceTo = response.data.priceTo;
                    for (var i = 0; i < brands.length; i++) {
                        if(brands[i] == "IKEA") {
                            $scope.brandIKEA = true;
                        }
                        if(brands[i] == "SkySoft") {
                            $scope.brandSkySoft = true;
                        }
                        if(brands[i] == "Laretto") {
                            $scope.brandLaretto = true;
                        }
                        if(brands[i] == "DivanPlus") {
                            $scope.brandDivanPlus = true;
                        }
                        if(brands[i] == "Sofyno") {
                            $scope.brandSofyno = true;
                        }
                    }
                    $scope.siteFilter();
                }

            });

        }).catch(function (response) {});



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
            if($scope.armrestOptions != undefined) {
                if($scope.armrestOptions.toString() != "all") {
                    armrestPath = "armrest=" + $scope.armrestOptions;
                }
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
            $http.get("be/sofa/all?" + fullPath)
                .then(function (response) {
                    $scope.sofas =  response.data;
                });
        };

        $scope.saveUserSettings = function () {
            var brands = [];
            if($scope.brandIKEA == true)
                brands.push("IKEA");
            if($scope.brandSkySoft == true)
                brands.push("SkySoft");
            if($scope.brandLaretto == true)
                brands.push("Laretto");
            if($scope.brandDivanPlus == true)
                brands.push("DivanPlus");
            if($scope.brandSofyno == true)
                brands.push("Sofyno");
            console.log(brands);
            $http.get("be/user/currentUser").then(function (response) {
                $scope.userAuthentificated = true;
                $http.post("be/user/userSettings",
                    {armrest:$scope.armrestOptions,
                        priceFrom:$scope.priceFrom,
                        priceTo:$scope.priceTo,
                        furnitureCategory:"sofa",
                        brands:brands,
                        currentPage:"/home/sofa"})

            }).catch(function (response) {});
        }
    }]);