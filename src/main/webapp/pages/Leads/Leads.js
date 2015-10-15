Application.$controller("LeadsPageController", ["$scope",
    function($scope) {
        "use strict";

        /* perform any action with the variables inside this block(on-page-load) */
        $scope.onPageVariablesReady = function() {
            /*
             * variables can be accessed through '$scope.Variables' service here
             * e.g. $scope.Variables.staticVariable1.getData()
             */

        };
        /* perform any action with widgets inside this block */
        $scope.onPageReady = function() {
            /*
             * widgets can be accessed through '$scope.Widgets' service here
             * e.g. $scope.Widgets.byId(), $scope.Widgets.byName()or access widgets by $scope.Widgets.widgetName
             */
            var _w = $scope.$watch('Widgets.salesForcePrefab.result', function(newVal) {
                newVal && newVal[0] && ($scope.Variables.selectedLead.dataSet = newVal[0]) && ($scope.Variables.mapLocations.dataSet = [{
                    "info": newVal[0].Name,
                    "coords": {
                        "lat": newVal[0].Latitude__c,
                        "lng": newVal[0].Longitude__c
                    }
                }]) && _w();
            });
        };
    }
]);

Application.$controller("liveform1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);