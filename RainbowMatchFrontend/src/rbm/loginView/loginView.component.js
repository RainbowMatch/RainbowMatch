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


            /**
             * sends login request yi server. if the http status is 200, the login name is stored
             * in the localStorage and the page redirects to the home view
             */
            HttpService.post(RainbowMatch.baseUrl+"api/users/login/",vm.user, function(event){


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
