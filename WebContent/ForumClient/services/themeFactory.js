angular.module('App')

.factory('themeFactory',['$http','$rootScope','$cookies','$location','$routeParams','$window', function ($http,$rootScope,$cookies,$location,$routeParams,$window) {
	
	return {
		
		addTheme : function (theme) {
			
			$http.post('/Forum/AddNewThemeServlet', theme)
			.success(function (response) {
				alert(response);
				$window.location.reload();
			})
			.error(function (error) {
				alert(error);
			});
			
		},
		
		getThemeForForum : function (name) {
			var config = {
					params : {
						forum : name
					}
			}
		 return	$http.get('/Forum/GetThemeServlet', config);
		
		}
		
	}
	
		
}]);