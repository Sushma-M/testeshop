Application.run(function ($rootScope, $location, $route) {
    "use strict";

    $rootScope.selectedItem = {};
    $rootScope.isAdminLoggedIn = false;

    $rootScope.pageLoading = false;

    /* perform any action on the variables within this block(on-page-load) */
    $rootScope.onAppVariablesReady = function () {
        /*
         * variables can be accessed through '$rootScope.Variables' service here
         * e.g. $rootScope.Variables.staticVariable1.getData()
         */
    };

    $rootScope.addItemToCart = function () {
        $rootScope.loginBeforeCart = false;
        var item = {
            "product": $rootScope.Variables.currentProduct.dataSet,
            "quantity": 1,
            "status": "In Cart",
            "user": $rootScope.Variables.currentUser.dataSet
        };
        $rootScope.Variables.cartInsert.insertRecord({
            "row": item
        }, function () {
            $location.path("Cart");
        });
    };

    $rootScope.logoutVariableonSuccess = function (variable, data) {
        $rootScope.isAdminLoggedIn = undefined;
        $route.current.params.name === "Main" ? $route.reload() : $location.path('Main');
    };

    $rootScope.currentUserIdonSuccess = function(variable, data){
        $rootScope.Variables.currentUser.dataSet = {};
        if($rootScope.Variables.users.dataSet.data && data) {
            $rootScope.Variables.currentUser.dataSet = $rootScope.Variables.users.dataSet.data.filter(function(user) {
                return user.id === +data.result;
            })[0];

            if ($rootScope.Variables.currentUser.dataSet && $rootScope.Variables.currentUser.dataSet.email === "admin@wavemaker.com") {
                $location.path('Admin');
                $rootScope.isAdminLoggedIn = true;
            }
        }
    };

});