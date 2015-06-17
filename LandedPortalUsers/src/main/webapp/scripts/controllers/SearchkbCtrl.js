'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:MainCtrl
 * @description # MainCtrl Controller of the webappApp
 */


webappApp.controller('SearchkbCtrl', function($scope, $routeParams, $http,
		$resource) {
	
		$scope.getKB = function() {
			$http.get("http://www.w3schools.com/angular/customers.php")
					.success(function(response) {
						$scope.names = response.records;
					});
		}

});
