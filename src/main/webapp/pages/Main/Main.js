Application.$controller("MainPageController", ['$rootScope', '$scope', '$timeout',
    function ($rootScope, $scope, $timeout) {
        "use strict";

        /** This is a callback function, that is called after a page is rendered.*/
        $scope.onPageReady = function () {
            $rootScope.pageLoading = false;
        };

        $scope.cameras_listonBeforeUpdate = function (variable, data) {
            WM.forEach(data, function (camera) {
                camera.imgUrl = "http://wmstudio-apps.s3.amazonaws.com/eshop/Products/Thumbnails" + camera.imgUrl;
            });
            return data;
        };

        $scope.smartphones_listonBeforeUpdate = function (variable, data) {
            WM.forEach(data, function (phone) {
                phone.imgUrl = "http://wmstudio-apps.s3.amazonaws.com/eshop/Products/Thumbnails" + phone.imgUrl;
            });
            return data;
        };

        $scope.laptops_listonBeforeUpdate = function (variable, data) {
            WM.forEach(data, function (laptop) {
                laptop.imgUrl = "http://wmstudio-apps.s3.amazonaws.com/eshop/Products/Thumbnails" + laptop.imgUrl;
            });
            return data;
        };
    }
    ]);


Application.$controller("smartphoneslistController", ["$scope",
    function ($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("cameraslistController", ["$scope",
    function ($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("laptopslistController", ["$scope",
    function ($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);