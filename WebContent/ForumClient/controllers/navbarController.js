angular.module('App')

.controller('NavBarCtrl', [ '$scope', '$route', function($scope, $route) {

			var currentLink = $route.current.$$route.activelink;
		
			if (currentLink == "forums") {
				$scope.homeClass = "active";
				$scope.userClass = "";
				$scope.newForumClass = "";
				$scope.newThemeClass = "";
			}
			if (currentLink == "users") {
				$scope.userClass = "active";
				$scope.homeClass = "";
				$scope.newForumClass = "";
				$scope.newThemeClass = "";
		
			}
			if (currentLink == "new-forum") {
				$scope.newForumClass = "active";
				$scope.userClass = "";
				$scope.homeClass = "";
				$scope.newThemeClass = "";
		
			}
			if (currentLink == "new-theme") {
				$scope.newThemeClass = "active";
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
				}
				if (activeLink == "users") {
					$scope.userClass = "active";
					$scope.homeClass = "";
					$scope.newForumClass = "";
					$scope.newThemeClass = "";
		
				}
				if (activeLink == "new-forum") {
					$scope.newForumClass = "active";
					$scope.userClass = "";
					$scope.homeClass = "";
					$scope.newThemeClass = "";
		
				}
				if (activeLink == "new-theme") {
					$scope.newThemeClass = "active";
					$scope.userClass = "";
					$scope.homeClass = "";
					$scope.newForumClass = "";
		
				}
			}

} ]);