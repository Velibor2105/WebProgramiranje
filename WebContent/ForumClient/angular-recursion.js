
angular.module('RecursionHelper', []).factory('RecursionHelper', ['$compile', function($compile){
	return {
		
		compile: function(element, link){
			if(angular.isFunction(link)){
				link = { post: link };
			}

			var contents = element.contents().remove();
			var compiledContents;
			return {
				pre: (link && link.pre) ? link.pre : null,
				
				post: function(scope, element){
					// Compile the contents
					if(!compiledContents){
						compiledContents = $compile(contents);
					}
					// Re-add the compiled contents to the element
					compiledContents(scope, function(clone){
						element.append(clone);
					});

					// Call the post-linking function, if any
					if(link && link.post){
						link.post.apply(null, arguments);
					}
				}
			};
		}
	};
}]);