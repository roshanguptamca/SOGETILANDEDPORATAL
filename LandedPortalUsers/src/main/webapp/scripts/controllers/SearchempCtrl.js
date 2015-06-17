'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:AboutCtrl
 * @description # AboutCtrl Controller of the webappApp
 */
webappApp.controller('SearchempCtrl', function($scope, $routeParams, $http,
		$resource) {

	$scope.getEmployee = function() {
		$http.get("http://www.w3schools.com/angular/customers.php").success(
				function(response) {
					$scope.names = response.records;
				});
	}

});
