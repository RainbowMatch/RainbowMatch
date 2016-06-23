 (function() {

    function HomeViewController (){
        var vm = this;
        
    }


    angular.module("rbm").component("homeView", {
	   templateUrl : "rbm/homeView/homeView.html",
	   controller : HomeViewController,
	   bindings : {}
    });

})();
