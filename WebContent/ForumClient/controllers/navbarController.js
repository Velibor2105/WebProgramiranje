angular.module('App')

.controller('NavBarCtrl', [ '$scope', '$route', function($scope, $route) {

			var currentLink = $route.current.$$route.activelink;
		
			if (currentLink == "forums") {
				$scope.homeClass = "active";
				$scope.userClass = "";
				$scope.newForumClass = "";
			}
			if (currentLink == "users") {
				$scope.userClass = "active";
				$scope.homeClass = "";
				$scope.newForumClass = "";
		
			}
			if (currentLink == "new-forum") {
				$scope.newForumClass = "active";
				$scope.userClass = "";
				$scope.homeClass = "";
		
			}
		
			$scope.changeState = function(activeLink) {
				if (activeLink == "forums") {
					$scope.homeClass = "active";
					$scope.userClass = "";
					$scope.newForumClass = "";
				}
				if (activeLink == "users") {
					$scope.userClass = "active";
					$scope.homeClass = "";
					$scope.newForumClass = "";
		
				}
				if (activeLink == "new-forum") {
					$scope.newForumClass = "active";
					$scope.userClass = "";
					$scope.homeClass = "";
		
				}
			}

} ]);