Application.$controller("ProfilePageController", ["$scope", "$rootScope",
    function ($scope, $rootScope) {
        "use strict";

        /** This is a callback function, that is called after a page is rendered.*/
        $scope.onPageReady = function() {
            /*
             * widgets can be accessed through '$scope.Widgets' property here
             * e.g. to get value of text widget named 'username' use following script
             * '$scope.Widgets.username.datavalue'
             */
            $rootScope.pageLoading = false;
            $rootScope.$safeApply($rootScope);
        };

        /**This is a callback function, that is called after the page variables are loaded. */
        $scope.onPageVariablesReady = function() {
            /*
             * variables can be accessed through '$scope.Variables' property here
             * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
             * $scope.Variables.loggedInUser.getData()
             */
        };

        /** On updating the profile data, we update the userObject with the modified data and display messages
         * based on the response*/
        $scope.saveClick = function ($event, $isolateScope) {
            $scope.Widgets.successSaveMsg.show = false;
            $scope.Widgets.failureSaveMsg.show = false;

            var data = $scope.Variables.currentUser.dataSet;
            data.name = $scope.Widgets.NameVal.datavalue;
            data.landmark = $scope.Widgets.LandmarkVal.datavalue;
            data.country = $scope.Widgets.CountryVal.datavalue;
            data.street = $scope.Widgets.StreetVal.datavalue;
            data.phone = $scope.Widgets.PhoneVal.datavalue;
            data.pin = $scope.Widgets.PinVal.datavalue;
            data.city = $scope.Widgets.CityVal.datavalue;
            $scope.Variables.currentUser.dataSet = data;

            $scope.Variables.users.updateRecord({
                "row": data,
                "id": data.id
            }, function (response) {
                /** Showing success or failure message*/
                if (response.error) {
                    $scope.Widgets.failureSaveMsg.show = true;
                } else {
                    $scope.Widgets.successSaveMsg.show = true;
                }
            });

        };

        $scope.PhoneValBlur = function($event, $isolateScope) {
            var phoneRegExp = /\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{4})/;
            if (phoneRegExp.test($scope.Widgets.PhoneVal.datavalue)) {
                $scope.Widgets.failureSaveMsg.show = false;
                $scope.Widgets.save.disabled = false;
            } else {
                $scope.Widgets.failureSaveMsg.show = true;
                $scope.Widgets.save.disabled = true;

            }
        };

    }
]);