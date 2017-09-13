angular.module('App')

.controller('UserInfoCtrl',['$scope','$cookies','$rootScope',function ($scope,$cookies,$rootScope) {
	
	if($cookies.get('role') != null)
		$rootScope.isLoged = true;
	else	
		$rootScope.isLoged = false;
	
	$rootScope.userUsername = $cookies.get('username');
	$rootScope.userRole = $cookies.get('role');
}]);