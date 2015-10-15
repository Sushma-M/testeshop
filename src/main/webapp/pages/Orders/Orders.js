Application.$controller("OrdersPageController", ["$scope", "$rootScope",
    function($scope, $rootScope) {
        "use strict";

        /* flag to determine if order details loaded before orders */
        $scope.orderDetailsLoaded = false;

        /* arrays storing the data from live-variables */
        $scope.ordersArray = [];
        $scope.orderDetailsArray = [];
        $scope.itemOrders = [];

        /** This is a callback function, that is called after a page is rendered.*/
        $scope.onPageReady = function() {
            /*
             * widgets can be accessed through '$scope.Widgets' property here
             * e.g. to get value of text widget named 'username' use following script
             * '$scope.Widgets.username.datavalue'
             */
            $rootScope.pageLoading = false;
            $scope.Widgets.no_orders_text.show = false;
        };

        /**This is a callback function, that is called after the page variables are loaded. */
        $scope.onPageVariablesReady = function() {
            /*
             * variables can be accessed through '$scope.Variables' property here
             * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
             * $scope.Variables.loggedInUser.getData()
             */
            $scope.Variables.currentUser.dataSet = JSON.parse(localStorage.getItem("activeEshopUser"));
        };

        $scope.orderDetailsonBeforeUpdate = function(variable, data) {
            $scope.orderDetailsArray = data;
            /* if orders not loaded yet, set this flag */
            if (!$scope.ordersArray.length) {
                $scope.orderDetailsLoaded = true;
            }
            /* orders are loaded before, prepare items for live-list */
            $scope.prepareItemOrders();
        };

        /* function to prepare items for live-list */
        $scope.prepareItemOrders = function() {
            $scope.Widgets.my_orders_text.show = $scope.Widgets.ordersList.show = $scope.ordersArray.length > 0;
            $scope.Widgets.no_orders_text.show = $scope.ordersArray.length === 0;

            WM.forEach($scope.ordersArray, function(order) {
                WM.forEach($scope.orderDetailsArray, function(orderDetails) {
                    if (order.id === orderDetails.productorder.id) {
                        $scope.itemOrders.push(orderDetails);
                    }
                });
            });
        };

        $scope.ordersonBeforeUpdate = function(variable, data) {
            $scope.ordersArray = data;
            /* if order-details loaded before, prepare items for live-list */
            if ($scope.orderDetailsLoaded) {
                $scope.prepareItemOrders();
            }
        };

        $scope.orderCancelClick = function($event, $isolateScope) {
            var item = {
                "id": $isolateScope.orderid,
                "user": $scope.Variables.currentUser.dataSet,
                "status": "Cancelled"
            };
            $scope.Variables.orderCancel.updateRecord({
                "row": item,
                "id": $isolateScope.orderid
            }, function(response) {
                $scope.itemOrders = [];
                $scope.Variables.orders.update({}, function() {
                    $scope.Variables.orderDetails.update();
                });
            })
        };

    }
]);
