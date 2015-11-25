angular.module('ResultCtrl', []).controller('ResultController', function($scope, $http, $rootScope) {
	
	$scope.result = function(){
		$http.get('/api/restaurant/result').success(function(res){
    		$rootScope.globalMessage = "";
			$rootScope.messageClass = "";
			
			$scope.restaurantMaps = res;
			
			console.log(res);
		}).error(function(res, status, headers){
			$rootScope.globalMessage = headers('message');
			$rootScope.messageClass = "alert-danger";
 		});
	};
	
	$scope.result();
});