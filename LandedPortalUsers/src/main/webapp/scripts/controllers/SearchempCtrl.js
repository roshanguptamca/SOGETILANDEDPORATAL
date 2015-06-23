'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:AboutCtrl
 * @description # AboutCtrl Controller of the webappApp
 */
webappApp.controller('SearchempCtrl', function($scope, $routeParams, $http,
		$resource) {
	
	
	$scope.getEmployee = function() {
		   
	    $http.get('employeeSearch/').success(function(data, status, headers, config) {
	    	console.log("response "+ JSON.stringify(data));    
	    	$scope.names = data;
	    }).error(function(data, status, headers, config) {
	     alert("inside Error " + data + " Header : " + headers + "Status : " + status + "config : " + config);
	   });

	};
	
	
	
	/*$scope.getEmployee = function() {
		$http.get("http://www.w3schools.com/angular/customers.php").success(
				function(response) {
					$scope.names = response.records;
				});
	}*/
	
	
/*
	$scope.getEmployee = function(searchParameter, searchValue) {
		
	   var userObject = [];
		$http.get('employeeSearch/' + searchParameter + '/' + searchValue).

		success(function(data) {

			console.log(JSON.stringify(data));
			
			 var temp = JSON.stringify(data);
			 
	
		});
	};*/
	
});



