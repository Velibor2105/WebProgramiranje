angular.module('App')

.controller('NavBarCtrl', [ '$scope', '$route', function($scope, $route) {

			var currentLink = $route.current.$$route.activelink;
		
			if (currentLink == "forums") {
				$scope.homeClass = "active";
				$scope.userClass = "";
				$scope.newForumClass = "";
				$scope.newThemeClass = "";
				$scope.userPageClass = "";
			}
			if (currentLink == "users") {
				$scope.userClass = "active";
				$scope.homeClass = "";
				$scope.newForumClass = "";
				$scope.newThemeClass = "";
				$scope.userPageClass = "";
			}
			if (currentLink == "new-forum") {
				$scope.newForumClass = "active";
				$scope.userClass = "";
				$scope.homeClass = "";
				$scope.newThemeClass = "";
				$scope.userPageClass = "";
			}
			if (currentLink == "new-theme") {
				$scope.newThemeClass = "active";
				$scope.userClass = "";
				$scope.homeClass = "";
				$scope.newForumClass = "";
				$scope.userPageClass = "";
			}
			
			if (currentLink == "user-page") {
				$scope.userPageClass = "active";
				$scope.newThemeClass = "";
				$scope.userClass = "";
				$scope.homeClass = "";
				$scope.newForumClass = "";
		
			}
		
			$scope.changeState = function(activeLink) {
				if (activeLink == "forums") {
					$scope.homeClass = "active";
					$scope.userClass = "";
					$scope.newForumClass = "";
					$scope.newThemeClass = "";
					$scope.userPageClass = "";
				}
				if (activeLink == "users") {
					$scope.userClass = "active";
					$scope.homeClass = "";
					$scope.newForumClass = "";
					$scope.newThemeClass = "";
					$scope.userPageClass = "";
				}
				if (activeLink == "new-forum") {
					$scope.newForumClass = "active";
					$scope.userClass = "";
					$scope.homeClass = "";
					$scope.newThemeClass = "";
					$scope.userPageClass = "";
				}
				if (activeLink == "new-theme") {
					$scope.newThemeClass = "active";
					$scope.userClass = "";
					$scope.homeClass = "";
					$scope.newForumClass = "";
					$scope.userPageClass = "";
				}
				if (activeLink == "user-page") {
					$scope.userPageClass = "active";
					$scope.newThemeClass = "";
					$scope.userClass = "";
					$scope.homeClass = "";
					$scope.newForumClass = "";
			
				}
			}

} ]);