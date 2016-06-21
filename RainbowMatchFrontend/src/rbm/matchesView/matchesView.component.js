(function() {

    function MatchesViewController (){
        var vm = this;

        vm.userName = "User";
    }


    angular.module("rbm").component("matchesView", {
	   templateUrl : "rbm/matchesView/matchesView.html",
	   controller : MatchesViewController,
	   bindings : {}
    });

})();
