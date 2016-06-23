 (function() {

    function HomeViewController (){
        var vm = this;
        
        vm.userName = "User";
    }


    angular.module("rbm").component("homeView", {
	   templateUrl : "rbm/homeView/homeView.html",
	   controller : HomeViewController,
	   bindings : {}
    });

})();
