angular.module('App')

.controller('NavBarCtrl',['$scope','$route', function($scope,$route) {
	
	    //$scope.homeClass = "active";
	
		var currentLink = $route.current.$$route.activelink;
		
			if(currentLink == "forums"){
				 $scope.homeClass = "active";
				  $scope.userClass = "";
			}
			if(currentLink == "users"){
				$scope.userClass = "active";
				 $scope.homeClass = "";
				  
			}
	
		$scope.changeState = function (activeLink) {
				if(activeLink == "forums"){
					 $scope.homeClass = "active";
					  $scope.userClass = "";
				}
				if(activeLink == "users"){
					$scope.userClass = "active";
					 $scope.homeClass = "";
					  
				}
		}
	
	  
		
	   
	   
	
		
}]);