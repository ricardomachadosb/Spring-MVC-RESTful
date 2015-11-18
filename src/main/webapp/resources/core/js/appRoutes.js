    angular.module('appRoutes', []).config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {

    $routeProvider

        // home page
        .when('/', {
            templateUrl: 'views/list.html',
            controller: 'MainController'
        });

    $locationProvider.html5Mode(true);

}]);