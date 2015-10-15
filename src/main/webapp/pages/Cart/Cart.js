Application.$controller("CartPageController", ["$scope", "$rootScope", "$location",
    function($scope, $rootScope, $location) {
        "use strict";

        $scope.totalPrice = 0;

        /** This is a callback function, that is called after a page is rendered.*/
        $scope.onPageReady = function() {
            /*
             * widgets can be accessed through '$scope.Widgets' property here
             * e.g. to get value of text widget named 'username' use following script
             * '$scope.Widgets.username.datavalue'
             */
            $rootScope.pageLoading = false;
        };

        /**This is a callback function, that is called after the page variables are loaded. */
        $scope.onPageVariablesReady = function() {
            /*
             * variables can be accessed through '$scope.Variables' property here
             * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
             * $scope.Variables.loggedInUser.getData()
             */
        };

        function showHideCartMessage(data) {
            if (data.length > 0) {
                $scope.Widgets.cartPanel.show = true;
                $scope.Widgets.no_cart_items_text.show = false;
            } else {
                $scope.Widgets.no_cart_items_text.show = true;
                $scope.Widgets.cartPanel.show = false;
            }
        }


        /*handling cart checkout click. deleting cart data and adding items to orders.*/
        $scope.checkoutClick = function($event, $isolateScope) {
            $rootScope.pageLoading = true;
            var cartItems = $scope.Variables.cart.dataSet.data,
                item = {
                    "user": $scope.Variables.currentUser.dataSet,
                    "status": "Ordered"
                };
            /*inserting data to orders table*/
            $scope.Variables.ordersInsert.insertRecord({
                "row": item
            }, function(response) {
                WM.forEach(cartItems, function(cartItem) {
                    var item = {
                        "product": cartItem.product,
                        "quantity": cartItem.quantity,
                        "productorder": response
                    };
                    /*inserting data to orderdetails table*/
                    $scope.Variables.orderDetailsInsert.insertRecord({
                        "row": item
                    }, function(response) {});
                    /*deleting the cart items from cart table*/
                    $scope.Variables.cartDelete.deleteRecord({
                        "id": cartItem.id
                    }, function(response) {});
                });
                /*redirecting to orders page*/
                $location.path("Orders");
            });
        };


        $scope.cartonBeforeUpdate = function(variable, data) {
            $scope.totalPrice = 0;
            data.forEach(function(cartItem) {
                cartItem.product.imgUrl = "http://wmstudio-apps.s3.amazonaws.com/eshop/Products/Thumbnails" + cartItem.product.imgUrl;
                $scope.totalPrice += cartItem.product.price;
            });
            showHideCartMessage(data);
            return data;
        };


        $scope.cartRemoveClick = function($event, $isolateScope) {
            $scope.Variables.cartDelete.deleteRecord({
                "id": $isolateScope.itemid
            }, function(response) {
                $scope.Variables.cart.update({}, function(data) {
                    showHideCartMessage(data);
                });
            });
        };

    }
]);

Application.$controller("cart-itemsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);