(function() {

    function AprovedViewController (){
        var vm = this;

        vm.userName = "User";
        vm.users = ["Peter", "Patrick", "Zoe"];
        
    }


    angular.module("rbm").component("aprovedView", {
	   templateUrl : "rbm/aprovedView/aprovedView.html",
	   controller : AprovedViewController,
	   bindings : {}
    });

})();
