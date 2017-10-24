angular.module('App')

.controller('UserInfoCtrl',['$scope','$cookies','$rootScope','userFactory','$http',function ($scope,$cookies,$rootScope,userFactory,$http) {
	
	
	
	
	if($cookies.get('role') != null)
		$rootScope.isLoged = true;
	else	
		$rootScope.isLoged = false;
	
	$rootScope.userUsername = $cookies.get('username');
	$rootScope.userRole = $cookies.get('role');
	
	$scope.getUsers = function () {
		userFactory.getAllUsers().success(function(response){
			 $scope.users = response;
		 });
	}

	$scope.getType = function (item) {
		$scope.reciver = item;
	}
	
	$scope.sendMessage = function (sender,message){
	     
		$http.post('/Forum/SendMessageServlet', {sender : sender, reciver : $scope.reciver.UserName, message : message})
		.then(function () {
			
		})
		
	}
	
}]);