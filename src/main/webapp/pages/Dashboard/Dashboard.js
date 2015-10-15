Application.$controller("DashboardPageController", ['$scope', '$timeout',

    function($scope, $timeout) {
        "use strict";

        /* perform any action with the variables inside this block(on-page-load) */
        $scope.onPageVariablesReady = function() {
            /*
             * variables can be accessed through '$scope.Variables' service here
             * e.g. $scope.Variables.staticVariable1.getData()
             */
            (function drawRegionsMap() {
                if (google) {
                    return;
                }
                var data = google.visualization.arrayToDataTable([
                    ['State', 'Sales Revenue'],
                    ['Illinois', 200],
                    ['California', 300],
                    ['New York', 20],
                    ['New Jersy', 150]
                ]);
                var geochart = new google.visualization.GeoChart(
                    WM.element('[name="revenueHeatMap"]')[0]);
                geochart.draw(data, {
                    region: "US",
                    resolution: "provinces"
                });
            })();
        };
        /* perform any action with widgets inside this block */
        $scope.onPageReady = function() {
            /*
             * widgets can be accessed through '$scope.Widgets' service here
             * e.g. $scope.Widgets.byId(), $scope.Widgets.byName()or access widgets by $scope.Widgets.widgetName
             */
            $scope.filter();
        };

        $scope.weeklySalesonBeforeUpdate = function(variable, data) {
            $scope.Widgets.weeklySales.dataset = data.length !== 0 ? data : [{
                "SALES": 0,
                "WEEK": 0
            }];
        };

        $scope.weeklyLeadsonBeforeUpdate = function(variable, data) {
            $scope.Widgets.weeklyLeads.dataset = data.length !== 0 ? data : [{
                "LEADS": 0,
                "WEEK": 0
            }];
        };

        $scope.weeklyFollowUpsonBeforeUpdate = function(variable, data) {
            $scope.Widgets.weeklyFollowUps.dataset = data.content.length !== 0 ? data.content : [{
                "FOLLOWUPS": 0,
                "WEEK": 0
            }];
        };


        $scope.weeklyQuotesonBeforeUpdate = function(variable, data) {
            $scope.Widgets.weeklyQuotes.dataset = data.content.length !== 0 ? data.content : [{
                "QUOTES": 0,
                "WEEK": 0
            }];
        };


        $scope.weeklyConvertedonBeforeUpdate = function(variable, data) {
            $scope.Widgets.weeklyConverted.dataset = data.content.length !== 0 ? data.content : [{
                "SALES": 0,
                "WEEK": 0
            }];
        };


        $scope.salesByChannelsonBeforeUpdate = function(variable, data) {
            $scope.Widgets.salesByChannels.dataset = data.content.length !== 0 ? data.content : [{
                "CHANNEL": "Self",
                "PERCENT": 0
            }, {
                "CHANNEL": "Brokers",
                "PERCENT": 0
            }, {
                "CHANNEL": "Agencies",
                "PERCENT": 0
            }, {
                "CHANNEL": "Partners",
                "PERCENT": 0
            }];
        };


        $scope.customersRatioonBeforeUpdate = function(variable, data) {
            $scope.Widgets.customersRatio.dataset = data.content.length !== 0 ? data.content : [{
                "TYPE": "New",
                "PERCENT": 0
            }, {
                "TYPE": "Renewal",
                "PERCENT": 0
            }];
        };

        var topProducts = [];
        $scope.topTrendingProductsonBeforeUpdate = function(variable, data) {
            topProducts = [];
            data.content.forEach(function(obj, i) {
                topProducts.push(obj.PRODUCT);
                obj.PRODUCT = i + 1;
            });
            reRenderText(750);
            $scope.Widgets.productsChart.dataset = data.content.length !== 0 ? data.content : [{
                "PRODUCT": 0,
                "SALES": 0
            }];
        };

        function reRenderText(timeOut) {
            $timeout(function() {
                $('[name="productsChart"]').find('rect').each(function(i) {
                    $(this).next().attr("x", 10).attr("y", 15).text(topProducts[i]);
                });
            }, timeOut, false);
        }

        $(window).resize(function() {
            reRenderText(100);
        });

        $scope.revenueHeatMaponBeforeUpdate = function(variable, data) {
            var dataTable = [],
                geochart,
                gData;
            dataTable.push(['State', 'Sales Revenue', 'Customers']);
            data.content.forEach(function(obj, i) {
                dataTable.push([obj.STATE, obj.SALES || 0, obj.CUSTOMERS])
            });
            if (dataTable.length === 1) {
                dataTable.push(['', 0, 0]);
            }
            gData = google.visualization.arrayToDataTable(dataTable);
            geochart = new google.visualization.GeoChart(WM.element('[name="revenueHeatMap"]')[0]);
            geochart.draw(gData, {
                region: "US",
                resolution: "provinces"
            });
        };

        function filter() {
            var dataBinding = {
                year: $scope.Widgets.yearFilter && +$scope.Widgets.yearFilter.datavalue || 2014,
                month: $scope.Widgets.monthFilter && +$scope.Widgets.monthFilter.datavalue || 7
            };

            $scope.Variables.weeklySales.dataBinding = $scope.Variables.weeklyLeads.dataBinding = $scope.Variables.weeklyQuotes.dataBinding = $scope.Variables.weeklyFollowUps.dataBinding = $scope.Variables.weeklyConverted.dataBinding = $scope.Variables.salesByChannels.dataBinding = $scope.Variables.customersRatio.dataBinding = $scope.Variables.topTrendingProducts.dataBinding = $scope.Variables.revenueHeatMap.dataBinding = dataBinding;

            $scope.Variables.weeklySales.update();
            $scope.Variables.weeklyLeads.update();
            $scope.Variables.weeklyQuotes.update();
            $scope.Variables.weeklyFollowUps.update();
            $scope.Variables.weeklyConverted.update();
            $scope.Variables.salesByChannels.update();
            $scope.Variables.customersRatio.update();
            $scope.Variables.topTrendingProducts.update();
            $scope.Variables.revenueHeatMap.update();
        }

        $scope.filter = function() {
            var dataBinding = {
                year: $scope.Widgets.yearFilter && +$scope.Widgets.yearFilter.datavalue || 2014,
                month: $scope.Widgets.monthFilter && +$scope.Widgets.monthFilter.datavalue || 7
            };

            $scope.Variables.weeklySales.dataBinding = $scope.Variables.weeklyLeads.dataBinding = $scope.Variables.weeklyQuotes.dataBinding = $scope.Variables.weeklyFollowUps.dataBinding = $scope.Variables.weeklyConverted.dataBinding = $scope.Variables.salesByChannels.dataBinding = $scope.Variables.customersRatio.dataBinding = $scope.Variables.topTrendingProducts.dataBinding = $scope.Variables.revenueHeatMap.dataBinding = dataBinding;

            $scope.Variables.weeklySales.update();
            $scope.Variables.weeklyLeads.update();
            $scope.Variables.weeklyQuotes.update();
            $scope.Variables.weeklyFollowUps.update();
            $scope.Variables.weeklyConverted.update();
            $scope.Variables.salesByChannels.update();
            $scope.Variables.customersRatio.update();
            $scope.Variables.topTrendingProducts.update();
            $scope.Variables.revenueHeatMap.update();
        };

        $scope.clear = function() {
            $scope.Widgets.yearFilter && ($scope.Widgets.yearFilter._model_ = "2014");
            $scope.Widgets.monthFilter && ($scope.Widgets.monthFilter._model_ = "07");
            $scope.filter();
        }

    }
]);