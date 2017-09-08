angular.module('App')

.factory('userFactory',['$http','$rootScope','$cookies', function ($http,$rootScope,$cookies,$location) {
	
	return {
		
	   signUp: function(user) {
		   
		   $http.post('/Forum/RegisterServlet', user)
		   .then(function (response) {
				alert(response.data);
				$('#regModal').modal('hide');
			}, function (error) {
				alert('error!');
			});
		},
		
		login: function(user){
			$http.post('/Forum/LoginServlet', user)
			   .then(function (response) {
			    if(response.data == "User not exist" || response.data == "User role not set"){
				    alert("User not exist or user role not set");
				}else{
					if(response.data == 'admin')
						$rootScope.isAdmin = 'true';
					if(response.data == 'moderator')
						$rootScope.isModerator = 'moderator';
					if(response.data == 'user')
						$rootScope.isUser = 'user';
					alert('Success login!');
					$('#logModal').modal('hide');
					$cookies.put('user', response.data)
				}
				}, function (error) {
					alert('error!');
				});
		},
		
		logout : function () {
			$rootScope.isAdmin = false;
			$rootScope.isModerator = false;
			$rootScope.isUser = false;
			$cookies.remove('user');
			alert('Successfully logout!');
			
		},
		
		getAllUsers : function () {
		  return $http.get('/Forum/GetAllUsersServlet');
		},
		
		changeRole: function (username, role) {
			var user = {
				'username' : username,
				'role' : role
			}
			return $http.post('/Forum/ChangeRoleServlet', user)
			
		}
		
		
		
				
		
	}
	
		
}]);