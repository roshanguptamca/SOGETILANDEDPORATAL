'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:UserManagmentCtrl
 * @description
 * # UserManagmentCtrl
 * Controller of the webappApp
 */
webappApp.controller('UserManagmentCtrl', function ($scope) {
   
    
	$scope.userProfileCompleation = 25;
	
    /**
     *  Defualt user model 
     */
    var user = {
    		name: "",
    		email: "",
    		empid: "",
    		landedDate:"",
    		address:{address:""},
    		phone:{phone:""}
    };
    
    
    
/**
 *  @ngdoc function
 * @name webappApp.controller.UserManagmentCtrl:addorupdate
 * @description this is added to update and add user information
 * @param User
 * */
    $scope.addorupdate = function(user) {
    	
    	user.address= [{address: $scope.address1},{address: $scope.address2}];
    	
    	user.phone= [{phone: $scope.phone1},{phone: $scope.phone2}];
    	
    	
    };

   
    
  });
