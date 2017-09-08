angular.module('App')

.controller('LoginCtrl',['$scope','userFactory', function ($scope,userFactory) {
	
	$scope.login = function (user) {
		userFactory.login(user);
	}
	
}]);