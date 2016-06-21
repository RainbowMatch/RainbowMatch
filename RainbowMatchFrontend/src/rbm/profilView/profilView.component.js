(function() {

    function ProfilViewController (){
        var vm = this;

        vm.userName = "User";
    }


    angular.module("rbm").component("profilView", {
	   templateUrl : "rbm/profilView/profilView.html",
	   controller : ProfilViewController,
	   bindings : {}
    });

})();
