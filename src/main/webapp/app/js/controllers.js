

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

mementoControllers.controller('NoteCreateCtrl', function ($scope, $http) {
	$scope.createNote = function() {
		tags = [];
		tags.push({"name":$scope.notetags});
		data = {"title":$scope.notetitle,
				"content":$scope.notecontent,
				"date":$scope.date,
				"tags":tags}
	    $http.put('rest/note', data).success(function(data) {
		   //$scope.notes = data;
		});
	}
  //$scope.orderProp = 'age';
});