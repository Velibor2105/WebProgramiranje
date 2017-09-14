angular.module('App',['ngRoute','angAccordion','ngCookies'],function($httpProvider){
	// Use x-www-form-urlencoded Content-Type
	  $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';

	  /**
	   * The workhorse; converts an object to x-www-form-urlencoded serialization.
	   * @param {Object} obj
	   * @return {String}
	   */ 
	  var param = function(obj) {
	    var query = '', name, value, fullSubName, subName, subValue, innerObj, i;

	    for(name in obj) {
	      value = obj[name];

	      if(value instanceof Array) {
	        for(i=0; i<value.length; ++i) {
	          subValue = value[i];
	          fullSubName = name + '[' + i + ']';
	          innerObj = {};
	          innerObj[fullSubName] = subValue;
	          query += param(innerObj) + '&';
	        }
	      }
	      else if(value instanceof Object) {
	        for(subName in value) {
	          subValue = value[subName];
	          fullSubName = name + '[' + subName + ']';
	          innerObj = {};
	          innerObj[fullSubName] = subValue;
	          query += param(innerObj) + '&';
	        }
	      }
	      else if(value !== undefined && value !== null)
	        query += encodeURIComponent(name) + '=' + encodeURIComponent(value) + '&';
	    }

	    return query.length ? query.substr(0, query.length - 1) : query;
	  };

	  // Override $http service's default transformRequest
	  $httpProvider.defaults.transformRequest = [function(data) {
	    return angular.isObject(data) && String(data) !== '[object File]' ? param(data) : data;
	  }];
})
.config(function($routeProvider) {
	
    $routeProvider
    .when("/", {
        templateUrl : "ForumClient/views/forums.html",
        activelink: 'forums'
    })
    .when("/users", {
        templateUrl : "ForumClient/views/users.html",
        activelink: 'users'
    })
    .when("/new-forum", {
        templateUrl : "ForumClient/views/new-forum.html",
        activelink: 'new-forum'
    })
    .when("/new-theme", {
        templateUrl : "ForumClient/views/new-theme.html",
        activelink: 'new-theme'
    })
    .when("/themes", {
        templateUrl : "ForumClient/views/themes.html",
        activelink: 'themes'
    }).otherwise({ redirectTo: '/' });
    
    
  
})
.controller('AppCtrl',['$cookies',function($cookies){

}])
.run(function ($rootScope,$cookies,$location){
	
	var cookieData = $cookies.get('role');

	if(cookieData == 'admin')
		$rootScope.isAdmin = 'true';
	if(cookieData == 'moderator')
		$rootScope.isModerator = 'true';
	if(cookieData == 'user')
		$rootScope.isUser = 'true';
	
	 $rootScope.$on("$locationChangeStart", function(event, next, current) { 
	     //   if($cookies.get('role') == null)
	      //  	$location.path( "/" );
		 	if(next == "http://localhost:8080/Forum/#/themes")
	        	$location.path( "/themes" );
	        if(next == "http://localhost:8080/Forum/#/users" && $cookies.get('role') != 'admin')
	        	$location.path( "/" );
	        if(next == "http://localhost:8080/Forum/#/new-forum" && $cookies.get('role') != 'admin' && next == "http://localhost:8080/Forum/#/new-forum" && $cookies.get('role') != 'moderator')
	        	$location.path( "/" );
	        	
	        	
	    });

});