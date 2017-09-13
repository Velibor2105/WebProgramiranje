angular.module('App')

.controller('ForumCtrl',['$scope','forumFactory', function ($scope,forumFactory) {
	
	forumFactory.getAllForums()
	.success(function (response) {
		$scope.forums = response;
	})
	.error(function () {
		alert('Error!');
	});
	                
}]);