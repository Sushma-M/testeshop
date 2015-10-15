Application.$controller("CategoryPageController", ['$rootScope', '$scope',
    function($rootScope, $scope) {
        "use strict";

        /** This is a callback function, that is called after a page is rendered.*/
        $scope.onPageReady = function() {
            $rootScope.pageLoading = false;
        };

        /**This is a callback function, that is called after the page variables are loaded. */
        $scope.onPageVariablesReady = function() {
            filterVariable($scope.activeCategory);
            $scope.productsList = $scope.Variables.productCategories.dataSet;
        };

        /**This is a callback function, when the page is loaded with the url route parameters. */
        $scope.handleRoute = function(category) {
            $scope.activeCategory = category || "Smartphones";
        };

        function filterVariable(category) {
            $scope.Variables.selectedCategory.dataSet.dataValue = category;
        }


        $scope.productsonBeforeUpdate = function(variable, data) {
            WM.forEach(data, function(product) {
                product.imgUrl = "http://wmstudio-apps.s3.amazonaws.com/eshop/Products/Thumbnails" + product.imgUrl;
            });
            return data;
        };

    }
]);

Application.$controller("productListController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);