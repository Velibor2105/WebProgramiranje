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
		},
		
		getCommentsForForum : function (name) {
			var config = {
					params : {
						forum : name
					}
			}
			return	$http.get('/Forum/GetCommentsForForumServlet', config);
		},
		
		addRemoveLikes : function (userName, theme){
			
			var data = {
					userName : userName,
					theme : theme
			}
			
			return $http.post('/Forum/AddRemoveLikesServlet', data);
		},
		
		addRemoveDisLikes : function (userName, theme){
	
			var data = {
					userName : userName,
					theme : theme
			}
			
			return $http.post('/Forum/AddRemoveDisLikesServlet', data);
		},
		
		getLikes : function (theme) {
			var config = {
					params : {
						theme : theme
					}
			}
			
			return  $http.get('/Forum/GetLikesServlet', config);
		},
		
		
		getDisLikes : function (theme) {
			var config = {
					params : {
						theme : theme
					}
			}
			
			return  $http.get('/Forum/GetDisLikesServlet', config);
		}
		
		
		
		
		
		
		
	}
}]);