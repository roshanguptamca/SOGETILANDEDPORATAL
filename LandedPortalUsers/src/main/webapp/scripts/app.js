'use strict';

/**
 * @ngdoc overview
 * @name webappApp
 * @description # webappApp
 * 
 * Main module of the application.
 */

var webappApp = angular.module('webappApp', ['ngRoute', 'ngResource']);
webappApp.config([ '$routeProvider', function($routeProvider){
  	$routeProvider.when('/searchemp', {
		templateUrl : 'views/SearchEmployee.htm',
		controller : 'SearchempCtrl'
	}).when('/searchkb', {
		templateUrl : 'views/SearchKnowledgeBase.htm',
		controller : 'SearchkbCtrl'
	}).when('/login', {
		templateUrl : 'views/Login.htm',
		controller : 'loginCtrl'
	})
	.when('/userInputFrom', {
		templateUrl : 'views/userInputFrom.htm',
		controller : 'UserManagmentCtrl'
	})
	.when('/userImageUploadForm', {
		templateUrl : 'views/userImageUploadForm.htm',
		controller : 'UploadImageCtrl'
	})
	.when('/userResumeUploadForm', {
		templateUrl : 'views/userResumeUploadForm.htm',
		controller : 'UploadResumeCtrl'
	}).when('/addKnowledgeBase', {    	  
        templateUrl: 'views/KnowledgeBase.html',
        controller: 'addKnowledgeBaseController'
    })
	.otherwise({
		redirectTo : '/searchemp'
	});
} ]);



