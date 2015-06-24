'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:MainCtrl
 * @description # MainCtrl Controller of the webappApp
 */


webappApp.controller('SearchkbCtrl', function($scope, $routeParams, $http,
		$resource) {
		/*$scope.getKB = function() {
			$http.get("http://www.w3schools.com/angular/customers.php")
					.success(function(response) {
						$scope.names = response.records;
					});
		}*/
		$scope.getKB = function(){
		  $http.get('kbSearch/').success(function(data, status, headers, config){
			  console.log(JSON.stringify(data));
			  $scope.names = data;
		  }).error(function(data, status, headers, config){
			  alert("Inside Error in know ledge base form : " + data + " Header : " + headers + "Status : " + status + "config : " + config);
		  });
		};
});
