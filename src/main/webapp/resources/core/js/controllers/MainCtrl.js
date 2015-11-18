angular.module('MainCtrl', []).controller('MainController', function($scope, $http, $rootScope) {
	
	  $scope.list = function(){
	    $http.get('/api/restaurant/list').success(function(res){
	      $scope.restaurants = res;
	    }).error(function(res){
	      console.log(res);
	    });
	  };
	  
	  $scope.list();
	  
});