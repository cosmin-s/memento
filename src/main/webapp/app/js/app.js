var mementoApp = angular.module('mementoApp', [
   'ngRoute',
   'mementoControllers',   
 ]);

mementoApp.config(['$routeProvider',
	function($routeProvider) {
	  $routeProvider.
	    when('/notes', {
	      templateUrl: 'app/partials/note-list.html',
	      controller: 'NoteListCtrl'
	    }).
	    when('/notes/add', {
		      templateUrl: 'app/partials/note-create.html',
		      controller: 'NoteCreateCtrl'
		    }).
	    otherwise({
	      redirectTo: '/notes'
	    });
	}]);
