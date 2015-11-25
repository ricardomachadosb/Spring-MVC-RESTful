    angular.module('appRoutes', []).config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {

    $routeProvider

        // home page
        .when('/', {
            templateUrl: 'resources/core/views/list.jsp',
            controller: 'MainController'
        }).when('/result', {
            templateUrl: 'resources/core/views/result.jsp',
            controller: 'ResultController'
        });

    $locationProvider.html5Mode(true);

}]);