    angular.module('appRoutes', []).config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {

    $routeProvider

        // home page
        .when('/', {
            templateUrl: 'resources/core/views/list.jsp',
            controller: 'MainController'
        });

    $locationProvider.html5Mode(true);

}]);