angular.module('App')

.controller('EditUsersCtrl',['$scope','userFactory',function ($scope,userFactory) {
	
	 userFactory.getAllUsers().success(function(response){
		 $scope.users = response;
	 });
	
    $scope.editRole = function (username, role) {
    	userFactory.changeRole(username, role)
    	.success(function (response) {
			alert(response);
			userFactory.getAllUsers().success(function(response){
				 $scope.users = response;
			 });
		})
		.error(function (error) {
			alert(error);
		});;
    }
	 
}]);