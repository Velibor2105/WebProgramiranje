angular.module('App')

.controller('RenderThemesCtrl',['$scope','forumFactory','themeFactory','$cookies','$location','$rootScope','$http',function ($scope,forumFactory,themeFactory,$cookies,$location,$rootScope,$http) {
 
	
	
	$scope.like = 0;
	$scope.dislike = 120;
	
	themeFactory.getThemeForForum($cookies.get('currentForum'))
	.then(function (response) {
			$scope.themes = response.data;
	}, function (error) {
		
	});
	
	
	
	$scope.getThemeForForums = function (name) {
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

	
}]);