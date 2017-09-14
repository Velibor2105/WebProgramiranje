angular.module('App')

.controller('ThemeCtrl',['$scope','forumFactory','themeFactory','$cookies',function ($scope,forumFactory,themeFactory,$cookies) {
	
	
	$scope.types = [{Name : "Image"},{Name : "Link"},{Name : "Text"}];

	 $scope.i = null;
     $scope.t = null;
	
	forumFactory.getAllForums()
	.success(function (response) {
		$scope.forums = response;
	})
	.error(function () {
		alert('Error!');
	});
	
	$scope.getForum = function () {
		    $scope.i = $scope.item.Name;
			$scope.isChosed = true;
	}
	
	$scope.getType = function (item) {
		$scope.t = item.Name;
		$scope.typeIsSelected = true;
	}
	
	
	$scope.saveTheme = function (theme) {
		var newTheme = {
				forum : $scope.i,
				title : theme.title,
				bitArray : $scope.pngBitArray,
				content : theme.content,
				link : theme.link,
				type : $scope.t,
				author : $cookies.get('username'),
				positiveVotes : 0,
				negativeVotes : 0
		}
		themeFactory.addTheme(newTheme);
		
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