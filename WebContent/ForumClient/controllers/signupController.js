angular.module('App')

.controller('SignUpCtrl',['$scope','userFactory', function ($scope,userFactory) {
	
	$scope.signUp = function (user) {
		userFactory.signUp(user);
	}
	
}]);