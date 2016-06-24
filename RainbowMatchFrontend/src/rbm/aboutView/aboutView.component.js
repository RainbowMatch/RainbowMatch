 (function() {

    function HomeViewController (){
        var vm = this;

        vm.logout = function() {
            localStorage.userName = undefined;
            jQuery.mobile.navigate("#login");
        };
    }


    angular.module("rbm").component("aboutView", {
	   templateUrl : "rbm/aboutView/aboutView.html",
	   controller : HomeViewController,
	   bindings : {}
    });

})();
