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
	    		moderators : selectedModerators,
	    		icon :  $scope.pngBitArray
	    };
	    
	    forumFactory.addNewForum(sendingData);
	}
	
	
	   $scope.getBase64 = function (nesto) {
			  
		    var file = document.querySelector('input[type=file]').files[0];
		    var reader = new FileReader();
		    
		    reader.addEventListener("load", function () {
		        $scope.pngBitArray = reader.result;
		    }, false);
		    if (file) {
		       reader.readAsDataURL(file);
		    }
	     }
	
}]);