(function() {

    function SignupViewController (HttpService){
        var vm = this;
        var repassword = false;
        vm.userRepassword = "";
        vm.user = {
            userName : "",
            userPassword : ""
        }

        // checks if passwords are equal
        vm.repassword = function(){
            repassword = vm.user.userPassword === vm.userRepassword;
        }

        /**
         * this method handles the sign up of users
         */
        vm.signup = function(){
            if(vm.user.userName.length < 2){
                alert("Username at least 2 characters long!");
            }else{
                if(repassword){

                    HttpService.post(RainbowMatch.baseUrl+"api/users/user",vm.user,  function(event){
                        if(event.status==200){
                            localStorage.username = vm.user.username;
                            jQuery.mobile.navigate("#home");
                            return false;
                        }else{
                            alert("error");
                        }
                    });
                }else{
                    alert("password not the same!");
                }
            }
        }

    }


    angular.module("rbm").component("signupView", {
	   templateUrl : "rbm/signupView/signupView.html",
	   controller : SignupViewController,
	   bindings : {}
    });

})();
