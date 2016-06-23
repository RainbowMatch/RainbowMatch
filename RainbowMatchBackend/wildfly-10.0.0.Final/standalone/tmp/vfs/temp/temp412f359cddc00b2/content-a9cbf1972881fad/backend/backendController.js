angular.module("backendApp").controller("backendController",function($scope){
    $scope.pages = [
	{
	    "viewName" : "homeView",
	    "viewLabel" : "Home"
	},
	{
	    "viewName" : "usersView",
	    "viewLabel" : "Users"
	},
	{
	    "viewName" : "loginView",
	    "viewLabel" : "Login"
	}
    ];

    $scope.currentPage = $scope.pages[0].viewName;

    $scope.isView = function(view) {
	return $scope.currentPage === view;
    };

    $scope.setView = function(view) {
	$scope.currentPage = view;
    };
})
