Application.$controller("CommonPageController", ['$scope',
    function($scope) {
        "use strict";

        /* perform any action on the variables within this block(on-page-load) */
        $scope.onPageVariablesReady = function() {
            /*
             * variables can be accessed through '$scope.Variables' property here
             * e.g. to get data in a static variable named 'loggedInUser' use following script
             * $scope.Variables.loggedInUser.getData()
             */
        };

    }
]);

Application.$controller("CommonLoginDialogController", ["$scope", "DialogService", "$rootScope", "$location",
    function($scope, DialogService, $rootScope, $location) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.CommonLoginDialogError = function($event, $isolateScope) {
            /*
             * Error message can be accessed from the property $isolateScope.loginMessage.caption
             */
        };

        $scope.CommonLoginDialogSuccess = function($event, $isolateScope) {
            var match = false;
            $rootScope.userLoggedin = true;
            /** Check the live variable if the credentials are right*/
            if ($scope.Widgets.usernametext.datavalue === "admin@wavemaker.com") {
                $location.path("Admin");
                $rootScope.isAdminLoggedIn = true;
            } else {
                WM.forEach($scope.Variables.users.dataSet.data, function(userObj) {
                    if (userObj.email === $scope.Widgets.usernametext.datavalue) {
                        $scope.Variables.currentUser.dataSet = {};
                        $scope.Variables.currentUser.dataSet = userObj;
                        localStorage.setItem("activeEshopUser", JSON.stringify(userObj));

                        if ($rootScope.loginBeforeCart) {
                            $rootScope.addItemToCart();
                        }
                    }
                });
            }

            DialogService.hideDialog("CommonLoginDialog");
        };
    }
]);