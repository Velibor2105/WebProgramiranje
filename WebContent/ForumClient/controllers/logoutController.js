angular.module('App')

.controller('LogoutCtrl',['$scope','userFactory','$location',function ($scope,userFactory,$location) {
	$scope.logout = function () {
		userFactory.logout();
		$location.path( "/" );
	}
}])