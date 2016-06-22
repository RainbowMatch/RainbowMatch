(function() {

    function LoginViewController (HttpService){
        var vm = this;
        vm.user = {
            userName : "",
            userPassword : ""
        };
        
        vm.login = function(){
            HttpService.post("10.4.57.190:20080/backend/users/login",vm.user, function(event){
                alert(event);
            });
        }
    }
    


    angular.module("rbm").component("loginView", {
	   templateUrl : "rbm/loginView/loginView.html",
	   controller : LoginViewController,
	   bindings : {}
    });

})();
