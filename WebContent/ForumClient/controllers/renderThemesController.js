angular.module('App')

.controller('RenderThemesCtrl',['$scope','forumFactory','themeFactory','$cookies','$location','$rootScope','$http',function ($scope,forumFactory,themeFactory,$cookies,$location,$rootScope,$http) {
 
	
	
	$scope.log = $rootScope.isLoged;
	
	
	$scope.refreshLikes = function (theme) {
		
	   themeFactory.getLikes(theme)
	   .then(function (success) {
		   $scope.like = success.data;
	   },function (error) {
		   
	   });
	   
	   themeFactory.getDisLikes(theme)
	   .then(function (success) {
		   $scope.dislike = success.data;
	   },function (error) {
		   
	   })
	}
	

	
	themeFactory.getThemeForForum($cookies.get('currentForum'))
	.then(function (response) {
			$scope.themes = response.data;
			$scope.moderator = $cookies.get('currentModerator');
	}, function (error) {
		
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
   				var config = {
       					params : {
       						forum : $cookies.get('currentForum')
       					}
       			}
   				$http.get('/Forum/GetCommentsForForumServlet', config)
       			.then(function (success)  {
       			    $scope.$broadcast('comment-updated', success.data);
   				},
   			    function (error) {
   					
   				});
   				
   			}
   				
   		}, function () {
   			
   		});
   		
   	    }
    }

   
   $scope.addRemoveLikes = function (theme) {
	   
	   themeFactory.addRemoveLikes($cookies.get('username'),theme)
	   .then(function (success) {
		   $scope.like = success.data;
		   $scope.refreshLikes(theme);
	   },function (error) {
		   
	   })
   }
   
   $scope.addRemoveDisLikes = function (theme) {
	   
	   themeFactory.addRemoveDisLikes($cookies.get('username'),theme)
	   .then(function (success) {
		   $scope.dislike = success.data;
		   $scope.refreshLikes(theme);
	   },function (error) {
		   
	   })
   }
   
   
   
   
   
	
}]);