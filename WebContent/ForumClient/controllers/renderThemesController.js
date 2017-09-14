angular.module('App')

.controller('RenderThemesCtrl',['$scope','forumFactory','themeFactory','$cookies','$location','$rootScope',function ($scope,forumFactory,themeFactory,$cookies,$location,$rootScope) {
 
	
	
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
	
}]);