angular.module('App')

.controller('NewForumCtrl',['$scope','userFactory',function ($scope,userFactory) {
	

	
	
	userFactory.getAllModerators()
	.success(function (response) {
		$scope.moderators = response;
	})
	.error(function (error) {
		
	});
	
	$scope.addForum = function (data) {
		
		var selectedAgents = [];
	    angular.forEach($scope.moderators, function (moderator) {
	        if (moderator.isSelected) {
	            selectedAgents.push(moderator);
	        }
	    });
	}
	
}]);