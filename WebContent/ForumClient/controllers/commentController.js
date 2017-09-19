angular.module('App')

.controller("TreeController",['$scope','themeFactory','$cookies', function($scope,themeFactory,$cookies) {
	

	
	$scope.test = themeFactory.getCommentsForForum($cookies.get('currentForum'))
	.then(function (success)  {
		$scope.treeFamily = success.data;
	},
    function (error) {
		
	});
	
	
   $scope.$on('comment-updated', function(event, profileObj) {
	   $scope.treeFamily = profileObj;
   });
   


	

	
/*$scope.treeFamily = {
  "Forum": "f1",
  "Theme": "t1",
  "Author": "ja",
  "CommentId": 1,
  "DateOfCreation": "Sep 15, 2017 3:49:12 PM",
  "ParentCommentId": 0,
  "Content": "test content",
  "PositiveVotes": 0,
  "NegativeVotes": 0,
  "Changed": false,
  "Contain": [
    {
      "Forum": "f1",
      "Theme": "t1",
      "Author": "ja",
      "CommentId": 2,
      "DateOfCreation": "Sep 15, 2017 3:49:12 PM",
      "ParentCommentId": 1,
      "Content": "test content",
      "PositiveVotes": 0,
      "NegativeVotes": 0,
      "Changed": false,
      "Contain": []
    },
    {
      "Forum": "f1",
      "Theme": "t1",
      "Author": "ja",
      "CommentId": 3,
      "DateOfCreation": "Sep 15, 2017 3:49:12 PM",
      "ParentCommentId": 1,
      "Content": "test content",
      "PositiveVotes": 0,
      "NegativeVotes": 0,
      "Changed": false,
      "Contain": []
    },
    {
      "Forum": "f1",
      "Theme": "t1",
      "Author": "ja",
      "CommentId": 4,
      "DateOfCreation": "Sep 15, 2017 3:49:12 PM",
      "ParentCommentId": 1,
      "Content": "test content",
      "PositiveVotes": 0,
      "NegativeVotes": 0,
      "Changed": false,
      "Contain": [
        {
          "Forum": "f1",
          "Theme": "t1",
          "Author": "ja",
          "CommentId": 5,
          "DateOfCreation": "Sep 15, 2017 3:49:12 PM",
          "ParentCommentId": 1,
          "Content": "test content",
          "PositiveVotes": 0,
          "NegativeVotes": 0,
          "Changed": false,
          "Contain": [
            {
              "Forum": "f1",
              "Theme": "t1",
              "Author": "ja",
              "CommentId": 6,
              "DateOfCreation": "Sep 15, 2017 3:49:12 PM",
              "ParentCommentId": 1,
              "Content": "test content",
              "PositiveVotes": 0,
              "NegativeVotes": 0,
              "Changed": false,
              "Contain": [{
                  "Forum": "f1",
                  "Theme": "t1",
                  "Author": "ja",
                  "CommentId": 4,
                  "DateOfCreation": "Sep 15, 2017 3:49:12 PM",
                  "ParentCommentId": 1,
                  "Content": "test content",
                  "PositiveVotes": 0,
                  "NegativeVotes": 0,
                  "Changed": false,
                  "Contain": [
                    {
                      "Forum": "f1",
                      "Theme": "t1",
                      "Author": "ja",
                      "CommentId": 5,
                      "DateOfCreation": "Sep 15, 2017 3:49:12 PM",
                      "ParentCommentId": 1,
                      "Content": "test content",
                      "PositiveVotes": 0,
                      "NegativeVotes": 0,
                      "Changed": false,
                      "Contain": [
                        {
                          "Forum": "f1",
                          "Theme": "t1",
                          "Author": "ja",
                          "CommentId": 6,
                          "DateOfCreation": "Sep 15, 2017 3:49:12 PM",
                          "ParentCommentId": 1,
                          "Content": "test content",
                          "PositiveVotes": 0,
                          "NegativeVotes": 0,
                          "Changed": false,
                          "Contain": []
                        }
                      ]
                    }
                  ]
                }]
            }
          ]
        }
      ]
    }
  ]
};*/

}]);