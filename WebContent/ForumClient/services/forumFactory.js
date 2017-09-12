angular.module('App')

.factory('forumFactory',['$http','$rootScope','$cookies', function ($http,$rootScope,$cookies,$location) {
	
	return {
		
		getAllModerators: function() {
			   
			   $http.post('/Forum/RegisterServlet', user)
			   .then(function (response) {
					alert(response.data);
					$('#regModal').modal('hide');
				}, function (error) {
					alert('error!');
				});
			}
		
		
				
		
	}
	
		
}]);