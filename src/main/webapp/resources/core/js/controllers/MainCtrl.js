angular.module('MainCtrl', []).controller('MainController', function($scope, $http, $rootScope, $location) {
	
	$scope.formData = {};
		
	$scope.list = function(){
    	$http.get('/api/restaurant/list').success(function(res){
    		$rootScope.globalMessage = "";
			$rootScope.messageClass = "";
			
			$scope.restaurants = res;
		}).error(function(res, status, headers){
			if(status == 400){
				$location.path("result")
			}else{
				$rootScope.globalMessage = headers('message');
				$rootScope.messageClass = "alert-danger";
			}
 		});
	};
	  
 	$scope.vote = function(){
 		if(!$scope.formData.restaurantId){
			$rootScope.globalMessage = "Selecione um restaurante";
			$rootScope.messageClass = "alert-danger";
			return;
 		}
		$http.put('/api/restaurant/vote/' + $scope.formData.restaurantId).success(function(res, status, headers){
			$rootScope.globalMessage = headers('message');
			$rootScope.messageClass = "alert-success";
		}).error(function(res, status, headers){
			$rootScope.globalMessage = headers('message');
			$rootScope.messageClass = "alert-danger";
 		});
	};
	  
	$scope.list();
	  
});