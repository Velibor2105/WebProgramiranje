angular.module('App')

.controller('ThemeCtrl',['$scope','forumFactory',function ($scope,forumFactory) {
	

	forumFactory.getAllForums()
	.success(function (response) {
		$scope.forums = response;
	})
	.error(function () {
		alert('Error!');
	});
	
	$scope.getForum = function () {
			var i = $scope.item.Name;
	}
	
}]);