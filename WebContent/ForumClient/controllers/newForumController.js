angular.module('App')

.controller('NewForumCtrl',['$scope','userFactory','$cookies','forumFactory',function ($scope,userFactory,$cookies,forumFactory) {
	
	userFactory.getAllModerators()
	.success(function (response) {
		$scope.moderators = response;
	})
	.error(function (error) {
		
	});
	
	$scope.addForum = function (data) {
		
		var selectedModerators = [];
	    angular.forEach($scope.moderators, function (moderator) {
	        if (moderator.isSelected) {
	        	selectedModerators.push(moderator.UserName);
	        }
	    });
	    
	    var sendingData = {
	    		data : data,
	    		moderator : $cookies.get('username'),
	    		moderators : selectedModerators
	    };
	    
	    forumFactory.addNewForum(sendingData);
	}
	
}]);