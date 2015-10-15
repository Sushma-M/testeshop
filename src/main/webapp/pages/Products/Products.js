Application.$controller("ProductsPageController", ["$rootScope", "$scope", "DialogService", "wmToaster", "$location",
    function($rootScope, $scope, DialogService, wmToaster, $location) {
        "use strict";

        function setActiveProduct(selectedProduct) {
            if (selectedProduct && $scope.Variables.selectedItem) {
                $scope.Variables.selectedItem.dataSet = selectedProduct;

                if (!$scope.Variables.selectedItem.dataSet) {
                    wmToaster.show('error', "Error", "No such product in catalog");
                    $location.path('Category');
                }
            }
        }

        /** This is a callback function, that is called after a page is rendered.*/
        $scope.onPageReady = function() {
            $rootScope.pageLoading = false;
        };

        /**This is a callback function, that is called after the page variables are loaded. */
        $scope.onPageVariablesReady = function() {
            $scope.Variables.selectedProductId.dataSet.dataValue = $scope.activeProductId;
            if ($scope.Variables.currentUser.dataSet) {
                delete $scope.Variables.currentUser.dataSet.dataValue;
            }
        };

        /**This is a callback function, when the page is loaded with the url route parameters. */
        $scope.handleRoute = function(productId) {
            $scope.activeProductId = +productId;
        };

        /*method to handle add to cart click and insert item to db*/
        $scope.addToCartClick = function() {
            $rootScope.Variables.currentProduct.dataSet = $scope.Variables.selectedItem.dataSet;
            if ($rootScope.isUserAuthenticated) {
                $rootScope.pageLoading = true;
                $rootScope.addItemToCart();
            } else {
                $rootScope.loginBeforeCart = true;
                DialogService.showDialog("CommonLoginDialog");
            }
        };


        $scope.selectedProductonSuccess = function(variable, data) {
            setActiveProduct(data[0]);
        };

    }
]);