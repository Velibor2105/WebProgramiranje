angular.module('App')

.factory('forumFactory',['$http','$rootScope','$cookies','$location','$routeParams','$window', function ($http,$rootScope,$cookies,$location,$routeParams,$window) {
	
	return {
		
		addNewForum : function (data){
			
			$http.post('/Forum/AddNewForumServlet', {
				name : data.data.name,
				description : data.data.description,
				moderator : data.moderator,
				rules : data.data.rules,
				moderators : JSON.stringify(data.moderators)
	     	})
			.then(function (response) {
				if(response.data == "Forum alredy exist!")
					alert("Forum alredy exist!");
				else
					alert("Forum " + response.data + " successfully added!");
				
				$window.location.reload();
			},function (error) {
				alert(error);
			});
		},
		
		getAllForums : function () {
			
		   return $http.get('/Forum/GetAllForumsServlet');
		   
		},
		
		deleteForumByName : function (forumName) {
			$http.post('/Forum/DeleteForumServlet', {forum : forumName})
			.then(function (success) {
				$window.location.reload();
			})
		}
		
		
				
		
	}
	
		
}]);