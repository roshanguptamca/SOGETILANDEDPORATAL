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
	
});



