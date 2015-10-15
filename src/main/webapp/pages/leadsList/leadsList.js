Application.$controller("leadsListPageController", ["$scope",
    function($scope) {
        "use strict";

        $scope.onLeadClick = function($event, $isolateScope) {
            $scope.Variables.selectedLead.dataSet = $isolateScope.item;
            $scope.Variables.mapLocations.dataSet = [{
                "info": $isolateScope.item.Name,
                "coords": {
                    "lat": $isolateScope.item.Latitude__c,
                    "lng": $isolateScope.item.Longitude__c
                }
            }];
        }


    }
]);

Application.$controller("livelist1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);