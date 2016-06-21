(function() {

    function RequestViewController (){
        var vm = this;

        vm.userName = "User";
    }


    angular.module("rbm").component("requestView", {
	   templateUrl : "rbm/requestView/requestView.html",
	   controller : RequestViewController,
	   bindings : {}
    });

})();
