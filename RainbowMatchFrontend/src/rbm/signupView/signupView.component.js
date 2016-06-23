(function() {

    function SignupViewController (HttpService){
        var vm = this;
        var repassword = false;
        vm.userRepassword = "";
        vm.user = {
            userName : "",
            userPassword : ""
        }
        vm.repassword = function(){
            repassword = vm.user.userPassword === vm.userRepassword;
        }
        vm.signup = function(){
           /* if(repassword){
                localStorage.username = vm.user.username;
                window.location.href = "#home";
            }else{
                alert("password not the same!");
            }
            */
            if(repassword){

                HttpService.post("http://k-keller.com:4080/Backend/api/users/user",vm.user,  function(event){
                    if(event.status==200){
                        localStorage.username = vm.user.username;
                        window.location.href = "#home";
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


    angular.module("rbm").component("signupView", {
	   templateUrl : "rbm/signupView/signupView.html",
	   controller : SignupViewController,
	   bindings : {}
    });

})();
