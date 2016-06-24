(function() {
    function LoginViewController (HttpService) {
        var vm = this;
        vm.user = {
            userName : "",
            userPassword : ""
        };

        vm.login = function(){
            //##################################
            /*localStorage.userName = vm.user.userName;
            jQuery.mobile.navigate("#home");*/
            //##################################


            HttpService.post(string.concat(RainbowMatch.baseUrl, "/Backend/api/users/login/"), vm.user, function(event){


                console.log(event);//10.4.57.190
                if(event.status==200){
                    localStorage.userName = vm.user.userName;
                    jQuery.mobile.navigate("#home");
                }
            });
        };
    }



    angular.module("rbm").component("loginView", {
        templateUrl : "rbm/loginView/loginView.html",
        controller : LoginViewController,
        bindings : {}
    });

})();
