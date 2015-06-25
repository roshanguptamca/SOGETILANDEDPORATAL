'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:AddKnowledgeBaseCtrl
 * @description # AddKnowledgeBaseCtrl Controller of the webappApp
 */
webappApp.controller('addKnowledgeBaseController', function($scope, $routeParams, $http,$resource,$filter) {
	/*	
	$scope.knowledgeBase = [
		              	  	  {customerName: 'ING', employeeName: 'Rushab Shah',question:'Sample Question A',answer:'Sample Answer A',interviewDate:'18/05/2015'},
		              	  	  {customerName: 'ING', employeeName: 'Rushab Shah',question:'Sample Question B',answer:'Sample Answer B',interviewDate:'18/05/2015'},
		              	  	  {customerName: 'ING', employeeName: 'Rushab Shah',question:'Sample Question C',answer:'Sample Answer C',interviewDate:'18/05/2015'},
		              	  	  {customerName: 'ING', employeeName: 'Rushab Shah',question:'Sample Question D',answer:'Sample Answer D',interviewDate:'18/05/2015'},
		              	  	  {customerName: 'ING', employeeName: 'Rushab Shah',question:'Sample Question E',answer:'Sample Answer E',interviewDate:'18/05/2015'}
	              	       ];
	*/              	       

	$http.get('getAllKnowledgeBase').success(function(data){		
		$scope.knowledgeBase=data;		
	});	
	
   /*	
   $scope.customers = [
	                    {lookupCode: "1", description: "ING"},
	                    {lookupCode: "2", description: "ABN AMRO"},
	                    {lookupCode: "3", description: "TRIODOS"},
	                    {lookupCode: "4", description: "ASML"}
	                  ];
   */	                  
   
   $http.get('getAllCustomers').success(function(data){		
	   $scope.customers=data;		
    });	
	
	              	  
   $scope.addQuestion = function addQuestion() {	    	    
		var interviewDateValue =$filter('date')($scope.interviewDate, 'dd/MM/yyyy');	    
		               /*
		               $scope.knowledgeBase.push(
	          			{
	              				  customerName:	$scope.inputCustomer.description,
	              				  employeeName: 'Rushab Shah',				  
	              				  question:$scope.inputQuestion,
	              				  answer:$scope.inputAnswer,
	              				  interviewDate:interviewDateValue			  
	           			});	              		  
	              		 */ 
	              		var tempKnowledgeBase = {
	             				"cid" : $scope.inputCustomer.cid,
	             				"uid" : "1",	
	             				"question" : $scope.inputQuestion,
	             				"answer"   : $scope.inputAnswer,
	             				"interviewDate" : $scope.interviewDate,	             				
	             		};	
	              		
	              		
	              		var response=$http.post('addKnowledgeBase',tempKnowledgeBase);
	                    response.success(function(data){	                    	
	                    	$scope.knowledgeBase=data;
	                    });
	                
	                    response.error(function(data, status, headers, config){
	                    	alert('EXCEPTION');
	                    	alert( "failure message: " + JSON.stringify({data: data}));
	                    });	              		
	              		
	             	    
   	  }
   
      //$scope.inputCustomer='Customer';
	  //$scope.inputQuestion='Question';
	  //$scope.inputAnswer='Answer';
        
	  
	
});