angular.module('App')

.controller('UserPageCtrl',['$scope','$cookies','$rootScope','userFactory','$http',function ($scope,$cookies,$rootScope,userFactory,$http) {
	
		
	var config = {
			params : {
				reciver : $cookies.get('username')
			}
	}
	
	$http.get('/Forum/GetMessagesServlet', config)
	.then(function (success) {
		$scope.messages = success.data;
	})
	
	

}]);