(function() {

    function SignupViewController (){
        var vm = this;

        vm.userName = "User";
    }


    angular.module("rbm").component("signupView", {
	   templateUrl : "rbm/signupView/signupView.html",
	   controller : SignupViewController,
	   bindings : {}
    });

})();
