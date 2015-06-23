

/* Controllers */

var mementoControllers = angular.module('mementoControllers', []);

mementoControllers.controller('NoteListCtrl', function ($scope, $http) {
	$scope.searchNotes = function() {
	    $http.get('rest/note?tag='+$scope.tag).success(function(data) {
		   $scope.notes = data;
		});
	}
  //$scope.orderProp = 'age';
});