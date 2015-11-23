angular.module('MainCtrl', []).controller('MainController', function($scope, $http, $rootScope) {
	
	$scope.formData = {};

	$scope.list = function(){
    	$http.get('/api/restaurant/list').success(function(res){
			$scope.restaurants = res;
		}).error(function(res){
			console.log(res);
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
			console.log(headers('message'));
			$rootScope.globalMessage = headers('message');
			$rootScope.messageClass = "alert-danger";
 		});
	};
	  
	$scope.list();
	  
});