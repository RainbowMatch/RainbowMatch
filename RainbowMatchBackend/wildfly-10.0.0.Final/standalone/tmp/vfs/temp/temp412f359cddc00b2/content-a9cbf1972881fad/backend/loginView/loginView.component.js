(function(){
  function LoginViewController(HttpService){
    var vm = this;

    vm.loginUserName = "";
    vm.loginUserPassword = "";

    vm.loginUser = function() {
      HttpService.login({
        userName : vm.loginUserName,
        userPassword : vm.loginUserPassword
      });
    }
  }

  angular.module("backendApp").component("loginView", {
    templateUrl : 'backend/loginView/loginView.html',
    controller : LoginViewController,
    bindings : {}
  });
})();
