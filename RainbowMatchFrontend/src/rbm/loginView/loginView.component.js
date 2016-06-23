(function() {
    function LoginViewController (HttpService){
        var vm = this;
        vm.user = {
            userName : "",
            userPassword : ""
        };

        vm.login = function(){
            HttpService.post("http://localhost:20080/backend/users/login/",vm.user, function(event){
                console.log(event);//10.4.57.190
            });
        };
    }



    angular.module("rbm").component("loginView", {
        templateUrl : "rbm/loginView/loginView.html",
        controller : LoginViewController,
        bindings : {}
    });

})();