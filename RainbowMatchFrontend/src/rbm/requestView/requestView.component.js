(function() {

    function RequestViewController (){
        var vm = this;

        vm.userName = "User";
        vm.users = ["Peter", "Patrick", "Zoe"];
        
    }


    angular.module("rbm").component("requestView", {
	   templateUrl : "rbm/requestView/requestView.html",
	   controller : RequestViewController,
	   bindings : {}
    });

})();
