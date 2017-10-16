angular.module('App')

.controller('RenderThemesCtrl',['$scope','forumFactory','themeFactory','$cookies','$location','$rootScope','$http',function ($scope,forumFactory,themeFactory,$cookies,$location,$rootScope,$http) {
	
	$scope.log = $rootScope.isLoged;
	$scope.isEdit = false;
	$scope.crudAccess = false;
	$scope.username = $cookies.get('username');
	
	if($cookies.get('username') == $cookies.get('currentModerator') || $cookies.get('role') == 'admin')
		$scope.crudAccess = true;
	
	
	
	
	$scope.deleteForum = function(forum){
		forumFactory.deleteForumByName(forum);
	}
	
	$scope.edit = function () {
		$scope.isEdit = true;
	}
	
	$scope.save = function (theme, forum) {
		
		var content = $('*[data-theme="'+ theme +'"]').val();
		
		$http.post('/Forum/EditThemeTextServlet', {theme : theme, forum : forum, content : content})
			.then(function (success) {
				$scope.themes = success.data;
			});
		$scope.isEdit = false;
	}
	
	$scope.deleteTheme = function (theme, forum) {
		$http.post('/Forum/DeleteThemeServlet', {theme : theme, forum : forum})
		.then(function (success) {
			$scope.themes = success.data;
		});
	}
	
	
	
	$scope.refreshLikes = function (theme) {
	   themeFactory.getLikes(theme)
		   .then(function (success) {
			   $scope.like = success.data;
		   });
	   
	   themeFactory.getDisLikes(theme)
		   .then(function (success) {
			   $scope.dislike = success.data;
		   });
	}
	
	themeFactory.getThemeForForum($cookies.get('currentForum'))
		.then(function (response) {
				$scope.themes = response.data;
				$scope.moderator = $cookies.get('currentModerator');
		});
	
	
	
	$scope.getThemeForForums = function (name,moderator) {
			$cookies.put('currentModerator', moderator);
		    $cookies.remove('currentForum');
		    $cookies.put('currentForum', name);
			$location.path( "/themes" );
	};
	
	
	
	   
   $scope.leaveMainComment = function (comment,theme) {
	   if(comment != ""){
   		$http.post('/Forum/AddNewCommentServlet', { parentId : "0", theme : theme, forum : $cookies.get('currentForum'), author : $cookies.get('username'), content : comment})
   		.then(function (success) {
	   		if(success.data == 'Success'){
	   				var config = {params : {forum : $cookies.get('currentForum')}}
	   				$http.get('/Forum/GetCommentsForForumServlet', config)
		       			.then(function (success)  {
		       			    $scope.$broadcast('comment-updated', success.data);
		   				});
	   				
	   			}
	   		});
   	    }
    }

   
   $scope.addRemoveLikes = function (theme) {
	   themeFactory.addRemoveLikes($cookies.get('username'),theme)
		   .then(function (success) {
			   $scope.like = success.data;
			   $scope.refreshLikes(theme);
		   });
   }
   
   $scope.addRemoveDisLikes = function (theme) {
	   themeFactory.addRemoveDisLikes($cookies.get('username'),theme)
		   .then(function (success) {
			   $scope.dislike = success.data;
			   $scope.refreshLikes(theme);
		   });
   }
}]);