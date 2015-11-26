angular.module('ResultCtrl', []).controller('ResultController', function($scope, $http, $rootScope) {
	
	$scope.result = function(){
		$http.get('/api/restaurant/result').success(function(res, status, headers){
			
			if(headers('message')){
			console.log('sim');
				$rootScope.globalMessage = headers('message');
				$rootScope.messageClass = "alert-success";
			}else {
			console.log(headers('message'));
				$rootScope.globalMessage = "";
				$rootScope.messageClass = "";
			}
			
			$scope.restaurants = res;
			
		}).error(function(res, status, headers){
			$rootScope.globalMessage = headers('message');
			$rootScope.messageClass = "alert-danger";
 		});
	};
	
	$scope.result();
});