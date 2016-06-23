(function(){
  function UsersViewController(HttpService){
    var vm = this;
    vm.users = [];

    HttpService.searchAllUsers(function(data){
      vm.users = data;
    });

    vm.newUserName = "";
    vm.newUserPassword = "";

    vm.createNewUser = function() {
      HttpService.createUser({
        userName : vm.newUserName,
        userPassword : vm.newUserPassword
      });
    }
  }

  angular.module("backendApp").component("usersView", {
    templateUrl : 'backend/usersView/usersView.html',
    controller : UsersViewController,
    bindings : {}
  });
})();
