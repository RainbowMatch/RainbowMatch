(function() {

    function LoginViewController (){
        var vm = this;

        vm.userName = "User";
    }


    angular.module("rbm").component("loginView", {
	   templateUrl : "rbm/loginView/loginView.html",
	   controller : LoginViewController,
	   bindings : {}
    });

})();
