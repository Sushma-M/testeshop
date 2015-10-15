Application.$controller("headerPageController", ["$scope", "$rootScope", "$location", function ($scope, $rootScope, $location) {
    "use strict";

    $scope.productSearchonBeforeUpdate = function (variable, data) {
        WM.forEach(data, function (product) {
            product.imgUrl = "http://wmstudio-apps.s3.amazonaws.com/eshop/Products/Thumbnails" + product.imgUrl;
        });
    };

    $scope.activateProductSearch = function ($event) {
        $event.currentTarget.style.width = "320px";
    };

    $scope.productSearchSubmit = function ($event) {
        /*Return if no "item" has been selected in the Search box.*/
        if (!$event.data.item) {
            return;
        }

        $rootScope.selectedItem = $event.data.item;
        $rootScope.selectedItem.imgUrl = $rootScope.selectedItem.imgUrl.replace("Thumbnails", "Images");
        $location.path("Products/" + $rootScope.selectedItem.id);
        $rootScope.pageLoading = true;
    };
}]);